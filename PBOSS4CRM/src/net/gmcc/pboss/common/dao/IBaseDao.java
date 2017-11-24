package net.gmcc.pboss.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * DAO接口, 定义底层CRUD等"原子"操作
 */

public interface IBaseDao{
	/**
	 * 保存实体
	 * @param entity 需要保存的实习
	 * @throws DataAccessException 保存出错时抛出的异常
	 */
	public void save(final Object entity) throws DataAccessException;
	
	/**
	 * 批量保存实体
	 * @param entitys 需要批量保存的实体
	 * @throws DataAccessException 保存出错时抛出的异常
	 */
	public void saveAll(final Collection<?> entities) throws DataAccessException;
	
	
	/**
	 * 保存或者更新实体
	 * @param entity 需要保存或者更新的实体
	 * @throws DataAccessException 保存出错时抛出的异常
	 */
	public void saveOrUpdate(final Object entity) throws DataAccessException;
	
	/**
	 * 保存或者更新多个实体
	 * @param entities 需要保存或者更新的实体,可以是多个相同类型的实体.
	 * @throws DataAccessException 保存出错时抛出的异常
	 */
	public void saveOrUpdateAll(final Collection<?> entities) throws DataAccessException;
	
	/**
	 * 更新实体
	 * @param entity 需要更新的实体
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public void update(Object entity) throws DataAccessException;
	
	/**
	 * 实体实例删除实体
	 * @param o 需要删除的实体
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public void delete(Object o)throws DataAccessException;
	
	/**
	 * 通过id删除实体
	 * @param <T> 需要删除的实体的类型
	 * @param entityClass 实体的类类型
	 * @param id 实体的id值
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public <T> void delete(Class<T> entityClass, Serializable id) throws DataAccessException;
	
	/**
	 * 实体实例删除多个实体
	 * @param entity  需要删除的实体
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public void deleteAll(final Collection<?> entities)throws DataAccessException;
	
	/**
	 * 通过id查找实体
	 * @param <T> 需要查找的实体的类型
	 * @param entityClass 实体的类类型
	 * @param id 实体的id值
	 * @return 需要查找的实体实例
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public <T> T find(Class<T> entityClass, Serializable id)throws DataAccessException;
	
	/**
	 * 通过hql来查找实体
	 * @param hql hql语句
	 * @param values hql需要填充的值
	 * @return 查找到的符合hql的所有实体实例
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public List<?> find(String hql, Object... values) throws DataAccessException;
	
	/**
	 * 查找某个类型的所有实例
	 * @param <T> 用户指定的类型
	 * @param entityClass 实体的类类型
	 * @return 查找到的符合entityClass的所有实体实例
	 * @throws DataAccessException
	 */
	public <T> List<T> findAll(Class<T> entityClass) throws DataAccessException;
	
	/**
	 * 通过id查找实体(与find相同)
	 * @param <T> 需要查找的实体的类型
	 * @param entityClass 实体的类类型
	 * @param id 实体的id值
	 * @return 需要查找的实体实例
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public <T> T get(Class<T> entityClass, Serializable id) throws DataAccessException;
	public <T> T getElse(Class<T> entityClass, Serializable id, T t) throws DataAccessException;
	
	
	/**
	 * 把数据提交, 并清除缓冲区.
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public void flush()throws DataAccessException;
	
	/**
	 * 清除缓冲区
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public void clear()throws DataAccessException;
	
	/**
	 * 通过hql来创建Query
	 * @param hql hql语句
	 * @param values hql语句需要的值
	 * @return Query类型的实例
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public Query createQuery(String hql, Object... values) throws DataAccessException;
	
	/**
	 * 通过sql来创建Query
	 * @param sql sql语句
	 * @param values sql语句需要的参数值
	 * @return SQLQuery类型的实例
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public SQLQuery createSQLQuery(String sql, Object... values) throws DataAccessException;
	
	/**
	 * 获得一个SimpleJdbcTemplate类型的实例, 通过这个实例来执行原生SQL语句
	 * @return 返回一个SimpleJdbcTemplate类型的实例
	 */
	public SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	/**
	 * 通过原生SQL语句来返回一个Single(单一的)的用户指定类型的Object
	 * @param <T> 用户指定类型
	 * @param sql 原生SQL语句
	 * @param resultClass 用户指定的结果类型
	 * @param values 填充SQL语句的值
	 * @return 一个用户指定类型的Obejct
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public <T> T findSingleBySQL(final String sql, final Class<T> resultClass, final Object... values) throws DataAccessException;
	
	/**
	 * 获得一个SessionFactory的实例
	 * @return 返回一个SessionFactory的实例
	 */
	public SessionFactory getSessionFactory();
	
	/**
	 * 获得当前Session的实例
	 * @return 返回当前Session的实例
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public Session getCurrentSession() throws DataAccessException;
	
	/**
	 * 关闭当前SessionFactory管理的Session
	 * @throws DataAccessException 执行出错时抛出的异常
	 */
	public void closeCurrentSession() throws DataAccessException;
	
	public <T> T queryForObject(String sql, Class<T> clazz, T defValue, Object... args);
	public Long queryForLong(String sql, Long defValue, Object... args);
	public Integer queryForInt(String sql, int defValue, Object... args);
	public String queryForString(String sql, String defValue, Object... args);
	
}
