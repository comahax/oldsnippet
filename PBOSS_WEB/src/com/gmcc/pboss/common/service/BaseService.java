package com.gmcc.pboss.common.service;

import java.io.Serializable;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public interface BaseService {

	/**
	 * 提取列表
	 * 
	 * @param parameter
	 * @return
	 */
	QueryResult getAll(QueryParameter parameter);

	/**
	 * 提主键提取对象
	 * 
	 * @param id
	 * @return
	 */
	Object get(Serializable id);

	/**
	 * 使用条件查询对象:如果对象不是惟一,则抛出IllegalStateException,对象不存在则返回null
	 * @param propertyNames -- 参数设置数组(必须与values对象个数相同,否则抛出IllegalStateException)
	 * @param values -- 条件值数组
	 * @return 符合查询条件的惟一对象
	 */
	Object getOne(String[] propertyNames, String[] values);
	
	/**
	 * 保存对象
	 * 
	 * @param object
	 * @return
	 */
	Object save(Object object);

	/**
	 * 按主键删除对象
	 * 
	 * @param id
	 */
	void remove(Serializable id);

	/**
	 * 删除对象
	 * 
	 * @param id
	 */
	void removeObject(Object id);
	
	
	/**
	 * 没有事务控制业务入口，serviceType为：INITIATE(登录时用)，QUERY
	 * 在这些方法中没有对数据库进行增，删，改操作
	 * @param member 用户登录Session 
	 * @param parameter 业务所需参数
	 * @param serviceType 业务类型
	 * @return
	 */
	public ServiceResult transact(LoginMember member,QueryParameter parameter, short serviceType);
	
	/**
	 * 具有事务控制业务入口，serviceType为：INITIATE，MODIFY，CANCEL
	 * 在这些方法中对数据库进行增，删，改操作，在action中捕获该方法抛出的异常，
	 * 异常返回码为: ServiceRetCode.EXCEPTION = 4
	 * @param member
	 * @param parameter
	 * @param serviceType
	 * @return
	 * @throws TransactionProcessionException 事务处理异常
	 */
	public ServiceResult transactionProcessing(LoginMember member,QueryParameter parameter, short serviceType)
						throws TransactionProcessionException;
	
	/**
	 * 查询业务，如果一个业务有查询集合又有查询单个对象，该方法用于集合查询
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter);
	
	/**
	 * 查询业务，如果一个业务有查询集合又有查询单个对象，该方法用于单个对象查询
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult queryForOne(LoginMember member, QueryParameter parameter);
	
	/**
	 * 开通业务
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter);
	
	/** 
	 * 修改业务
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult modify(LoginMember member, QueryParameter parameter);
	
	/**
	 * 取消业务
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult cancel(LoginMember member, QueryParameter parameter);
	
	/**
	 * 其他业务，通过parameter中的operation参选来调用自定义接口
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult other(LoginMember member, QueryParameter parameter);
}
