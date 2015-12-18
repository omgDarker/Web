package cn.crap.base;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public abstract class BaseService<T extends BasePo> implements
		BaseServiceInter<T> {
	private BaseDaoInter<T> baseDao;
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseService() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override@Transactional
	public boolean save(T model) {
		return baseDao.save(model);
	}

	@Override@Transactional
	public boolean update(T model) {
		return baseDao.update(model);
	}

	@Override@Transactional
	public boolean saveOrUpdate(T model) {
		return baseDao.saveOrUpdate(model);
	}

	@Override@Transactional
	public boolean delete(T model) {
		return delete(model.getId());
	}

	@Override@Transactional
	public boolean delete(Integer id) {
		return baseDao.delete(id);
	}

	@Override@Transactional
	public T get(T model) {
		if (model == null || model.getId() == null)
			return null;
		return get(model.getId());
	}

	@Override@Transactional
	public T get(Integer id) {
		return baseDao.get(id);
	}
	@Override@Transactional
	public T get(Integer id, Integer flag) {
		return baseDao.get(id, flag);
	}

	@Override@Transactional
	public T load(Integer id) {
		return baseDao.load(id);
	}

	@Override@Transactional
	public T load(T model) {
		return baseDao.load(model.getId());
	}

	/***************************** 查询数据集合 **********************************/
	/*
	 * 根据hql语句查询list集合中的model数据s(non-Javadoc)
	 */
	@Override@Transactional
	public List<T> findByHql(String hql) {
		return this.findByHql(hql, null, null);
	}

	@Override@Transactional
	public List<T> findByHql(String hql, Map<String, Object> map) {
		return this.findByHql(hql, map, null);
	}

	@Override@Transactional
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean) {
		return this.findByHql(hql, map, pageBean, null);
	}

	@Override@Transactional
	public List<T> findByHql(String hql, Map<String, Object> map,
			PageBean pageBean, String order) {
		return baseDao.findByHql(hql, map, pageBean, order);
	}

	@Override@Transactional
	public T findUniqueByHql(String hql, Map<String, Object> map) {
		return baseDao.findUniqueByHql(hql, map);
	}

	// 获取实体对象的list集合
	@Override@Transactional
	public List<T> getList(PageBean pageBean, Map<String, Object> map) {
		return getList(pageBean, map, null);
	}

	// 获取排序的实体对象的list集合
	@Override@Transactional
	public List<T> getList(PageBean pageBean, Map<String, Object> map,
			String order) {
		String conditions = DataUtils.getHql(map);
		if (pageBean != null && pageBean.getTotalPage() == 0)
			pageBean.setAllRow(baseDao.getCount(conditions, map));
		return baseDao.findByHql("from " + clazz.getSimpleName() + conditions,
				map, pageBean, order);
	}

	/*
	 * 返回json格式的数据
	 * 
	 * @see
	 * com.wegoteam.shop.service.BaseService#getJsonList(com.wegoteam.shop.util
	 * .PageBean, java.util.Map, java.lang.String)
	 */
	@Override@Transactional
	public String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order) {
		return getJsonList(pageBean, map, order, null);
	}
	@Override@Transactional
	public String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order, HttpServletRequest requset) {
		return getJsonList(pageBean, map, order, requset, null);
	}
	@Override@Transactional
	public String getJsonList(PageBean pageBean, Map<String, Object> map,
			String order, HttpServletRequest requset,Map<String, Object> otherParams) {
		if (order == null && requset != null) {
			order = " ";
			order += MyString.isEmpty(requset.getParameter("sortname")) ? " id"
					: " " + requset.getParameter("sortname");
			order += MyString.isEmpty(requset.getParameter("sortorder")) ? " desc"
					: " " + requset.getParameter("sortorder");
		}
		List<T> list = new ArrayList<T>();
		list = getList(pageBean, map, order);
		HashMap<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put(Const.Page, pageBean);
		tempMap.put(Const.Rows, list);
		//ligerui分页
		tempMap.put("Total", pageBean.getAllRow());
		if(otherParams != null){
			Iterator<Entry<String, Object>> iter = otherParams.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String, Object> entry = iter.next();
				tempMap.put(entry.getKey(), entry.getValue());
			}
		}

		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "phoneUser", "user", "agent",
				"operUser","addTime"});// 除去dept属性

		JSONObject json = JSONObject.fromObject(tempMap, config);
		return json.toString();
	}

	/*************************** End:查询数据集合 **********************************/

	/*************************** 查询总数量 **********************************/
	@Override@Transactional
	public int getCount(Map<String, Object> map) {
		return baseDao.getCount(map);
	}

	@Override@Transactional
	public int getCountBySql(String sql, Map<String, Object> map) {
		return baseDao.getCountBySql(sql, map);
	}

	@Override@Transactional
	public int getCount(String consditions, Map<String, Object> map) {
		return baseDao.getCount(consditions, map);
	}

	/*************************** End:查询总数量 **********************************/

	@Override@Transactional
	public List<T> findBySql(String sql, Map<String, Object> map) {
		return baseDao.findBySql(sql, map, null, null);
	}

	@Override@Transactional
	public List<Object[]> findObjsBySql(String sql, Map<String, Object> map) {
		return baseDao.findObjsBySql(sql, map);
	}

	@Override@Transactional
	public int executeBySql(String sql, Map<String, Object> map) {
		return baseDao.executeBySql(sql, map);
	}

	@Override@Transactional
	public int executeByHql(String hql, Map<String, Object> map) {
		return baseDao.executeByHql(hql, map);
	}

	/**************************************/
	public BaseDaoInter<T> getBaseDao() {
		return baseDao;
	}

	@Resource
	public void setBaseDao(BaseDaoInter<T> baseDao) {
		this.baseDao = baseDao;
	}

}
