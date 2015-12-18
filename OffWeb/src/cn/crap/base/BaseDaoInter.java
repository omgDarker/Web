package cn.crap.base;

import java.util.List;
import java.util.Map;

public interface BaseDaoInter<T> {
   //����һ��ʵ���������ɹ��ķ���һ����־
   public boolean save(T model);
   public boolean update(T model);
   public boolean saveOrUpdate(T model);
   public T get(Integer id);
   public T load(Integer id);
   
   //ɾ��һ��ʵ��
   public boolean delete(Integer id);
   /**
    * hql�����еĲ���
    * 
    **/
   
   //����hql����ѯ��һ������
   public List<T> findByHql(String hql, Map<String, Object> map, PageBean pageBean,String order);
   public List<T> findBySql(String sql, Map<String, Object> map, PageBean pageBean,String order);
   public List<Object[]> findObjsBySql(String sql,Map<String,Object> map);//��ѯʵ�����е�ĳЩ����
   public T findUniqueByHql(String hql, Map<String, Object> map);
   //����ܵļ�¼��
   public int getCount(Map<String, Object> map);
   public int getCount(String conditions, Map<String, Object> map);
   public int getCountBySql(String sql,Map<String,Object> map);//ԭ��sql����ܵļ�¼��
   
 //ִ�е�hql���
   public int executeByHql(String hql,Map<String,Object> map);
   //ԭ���Ŀ�ִ�е�sql���
   public int executeBySql(String sql,Map<String,Object> map);
T get(Integer id, Integer flag);
}
