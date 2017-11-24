package com.gmcc.pboss.common.dao;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;

public interface BaseDao {

	/**
	 * 取所有对象
	 */
	public List getAll();

	/**
	 * 用主键取对象
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	public Object get(Serializable id);
	
	/**
	 * 使用条件查询对象:如果对象不是惟一,则抛出IllegalStateException,对象不存在则返回null
	 * @param propertyNames -- 参数设置数组(必须与values对象个数相同,否则抛出IllegalStateException)
	 * @param values -- 条件值数组
	 * @return 符合查询条件的惟一对象
	 */
	public Object getOne(String[] propertyNames, Object[] values);

	/**
	 * 检测主键是否存在
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	boolean exists(Serializable id);

	/**
	 * 保存
	 * 
	 * @param object
	 * @return
	 */
	public Object save(Object object);
	
	/**
	 * 更新
	 * @param object
	 * @return
	 */
	public void update(Object object);

	/**
	 * 用主键删除
	 * 
	 * @param id
	 */
	public void remove(Serializable id);

	/**
	 * 直接删除对象
	 * 
	 * @param obj
	 */
	public void removeObject(Object obj);

	/**
	 * 通过删除一组对象
	 * 
	 * @param objss
	 */
	public void removeAllObject(List objs);
	

	/**
	 * 去掉重复值
	 * 
	 * @return
	 */
	public List getAllDistinct();

	/**
	 * 根据参数查询
	 */
	public QueryResult getAll(QueryParameterProcessor processor, QueryParameter parameter);

	/**
	 * 根据参数查询记录总数,子类应根据不同的查询参数而重写此方法
	 */
	public int getAllRows(QueryParameterProcessor processor, QueryParameter parameter);
	
	/**
	 * 使用SQLQuery
	 * 根据参数查询
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter);
	/**
	 * 使用SQLQuery
	 * 根据参数查询记录总数,子类应根据不同的查询参数而重写此方法
	 */
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter);
	
	/**
	 * 刷新SessionFactory
	 */
	public void reloadSessionFactory();

	

}
