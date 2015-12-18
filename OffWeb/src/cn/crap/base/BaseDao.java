package cn.crap.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class BaseDao<T extends BasePo> implements BaseDaoInter<T> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	// 注入SessionFactory,用sessionFactory工厂来执行一般的操作
	// 注入hibernateTemplate模板

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		// 得到超类的泛型化的方法
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	/*
	 * 保存一个实体对象保存成功的话就返回"success"否则返回"error"(non-Javadoc)
	 * 
	 * @see com.wegoteam.shop.dao.BaseDao#sava(java.lang.Object)
	 */
	@Override
	public boolean save(T model) {
		// 用当前的sessionFactory工厂获取当前的线程
		hibernateTemplate.save(model);
		return true;
	}

	/*
	 * 更新一个对象传入一个model实体调用update方法更新一个实体，更新成功返回"success"否则返回"error"(non-Javadoc)
	 * 
	 * @see com.wegoteam.shop.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public boolean update(T model) {
		hibernateTemplate.update(model);
		return true;
	}

	/*
	 * 保存或者更新一个对象成功的话返回"success"否则的话返回"error"(non-Javadoc)
	 * 
	 * @see com.wegoteam.shop.dao.BaseDao#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public boolean saveOrUpdate(T model) {
		hibernateTemplate.saveOrUpdate(model);
		return true;
	}

	/*
	 * 删除一个model实体删除成功的话返回success否则返回error(non-Javadoc)
	 * 
	 * @see com.wegoteam.shop.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Integer id) {
		int result = executeByHql("update " + clazz.getName()
				+ " set flag=-100 where id=" + id, null);
		if (result > 0)
			return true;
		else
			return false;
	}

	/*
	 * 使用get方法先从session缓存中查找，然后在二级缓存中查找，还没有的话就查询数据库，如果数据库也没有的话就返回null值,根据id查询一个实体对象
	 * (non-Javadoc)
	 * 
	 * @see com.wegoteam.shop.dao.BaseDao#get(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T get(Integer id,Integer flag) {
		T t = (T) hibernateTemplate.get(clazz, id);
		if (t != null){
			if(flag == null && t.getFlag() != -100){
				return t;
			}else if(flag != null && t.getFlag().equals(flag)){
				return t;
			}else{
				return null;
			}
		}
		else
			return null;
	}
	@Override
	public T get(Integer id) {
		return get(id,null);
	}

	/*
	 * 使用load方式先从session缓存中查找，看看该id对应的对象是否存在，不存在则使用延迟加载
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T load(Integer id) {
		T t = (T) hibernateTemplate.load(clazz, id);
		if (t != null && t.getFlag() != -100)
			return t;
		else
			return null;
	}

	/********************* 查询数据集合 ***********************/
	@SuppressWarnings("unchecked")
	@Override
	@Transient
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean, String order) {
		hql = filter(hql, map);
		hql += (MyString.isEmpty(order) ? "" : " order by " + order);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setPage(query, pageBean);
		setQuery(map, query);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findUniqueByHql(String hql, Map<String, Object> map) {
		hql = filter(hql, map);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setQuery(map, query);
		return (T) query.uniqueResult();
	}

	// 根据一个sql语句查询
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findBySql(String sql, Map<String, Object> map,
			PageBean pageBean, String order) {
		sql = filter(sql, map);
		sql += (MyString.isEmpty(order) ? "" : " order by " + order);
		SQLQuery query = hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		setPage(query, pageBean);
		setQuery(map, query);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findObjsBySql(String sql, Map<String, Object> map) {
		sql = filter(sql, map);
		SQLQuery query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		setQuery(map, query);
		return query.list();
	}

	/******************* End:查询数据集合 ***********************/

	/********************* 查询总数量 *************/
	@Override
	public int getCount(Map<String, Object> map) {
		return getCount(DataUtils.getHql(map), map);
	}

	
	@Override
	public int getCount(String conditions, Map<String, Object> map) {
		String hql = "select count(*) from " + clazz.getName() + conditions;
		hql = filter(hql, map);
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	
	@Override
	public int getCountBySql(String sql, Map<String, Object> map) {
		sql = filter(sql, map);
		SQLQuery query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		setQuery(map, query);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	/******************* End:查询总数量 *************/

	@Override
	public int executeByHql(String hql, Map<String, Object> map) {
		hql = filter(hql, map);
		// 根据一个hql语句创建一个Query对象
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		setQuery(map, query);
		return query.executeUpdate();
	}

	@Override
	public int executeBySql(String sql, Map<String, Object> map) {
		sql = filter(sql, map);
		SQLQuery query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);
		if (map != null)
			setQuery(map, query);
		return query.executeUpdate();
	}

	// 根据map设置参数
	private void setQuery(Map<String, Object> map, Query query) {
		if (map == null)
			return;
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			if (key.indexOf("|") > 0) {
				key = key.split("\\|")[0];
			}
			Object value = entry.getValue();
			key = key.replaceAll("\\.", "_");
			if (value instanceof Integer) {
				query.setInteger(key, Integer.parseInt(value.toString()));
			} else if (value instanceof String) {
				query.setString(key, value.toString());
			} else {
				query.setParameter(key, value);
			}
		}
	}

	// 设置系统过滤
	private static String filter(String str, Map<String, Object> map) {
		//查询条件包括flag=，则不添加flag过滤，如：flag=-1，flag>依然会添加flag
		if(map!=null && map.get("flag") != null && !map.get("flag").toString().equals("")){
			return str;
		}
		String order = "";
		if (str.toUpperCase().indexOf(" ORDER ") > 0) {
			order = str.substring(str.toUpperCase().indexOf(" ORDER "),
					str.length());
			str = str.substring(0, str.toUpperCase().indexOf(" ORDER "));
		}
		if (str.toUpperCase().indexOf(" WHERE ") > 0)
			str += " and flag!=-100 " + order;
		else
			str += " where flag!=-100 " + order;
		return str;
	}

	// 设置分页
	private void setPage(Query query, PageBean pageBean) {
		if (pageBean != null) {
			query.setFirstResult(pageBean.countOffSet()).setMaxResults(
					pageBean.getSize());
		}
	}
}
