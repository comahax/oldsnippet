package com.gmcc.pboss.common.dao.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.DynamicSessionFactoryProxyBean;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

/**
 * 通用DAO操作类（一般用于普通简单的查询）
 *
 */
public class BaseDaoHibernate extends HibernateDaoSupport implements BaseDao {
	
	private DynamicSessionFactoryProxyBean dynamicSessionFactory;
	/**
	 * 需要持久的对象Class
	 */
	private Class persistentClass;

	public BaseDaoHibernate(Class persistentClass) {
		this.persistentClass = persistentClass;
	}

	protected Class getPersistentClass() {
		return this.persistentClass;
	}

	public boolean exists(Serializable id) {
		Object object = getSession().get(persistentClass, id);
		return object != null;
	}

	public Object get(Serializable id) {
		Object object = getSession().get(persistentClass, id);
		if (object == null) {
			throw new ObjectRetrievalFailureException(persistentClass, id);
		}
		return object;
	}

	/**
	 * 使用条件查询对象:如果对象不是惟一,则抛出IllegalStateException,对象不存在则返回null
	 * @param propertyNames -- 参数设置数组(必须与values对象个数相同,否则抛出IllegalStateException)
	 * @param values -- 条件值数组
	 * @return 符合查询条件的惟一对象
	 */
	public Object getOne(String[] propertyNames, Object[] values) {
		// TODO Auto-generated method stub
		StringBuffer setWhere = new StringBuffer();
		boolean addAnd=false;
		if (propertyNames.length != values.length){
			String errMsg ="[BaseDaoHibernate.getOne]:参数设置错误：propertys:" + 
			propertyNames.length + "!=values:" + values.length; 
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
		}
		Criteria criteria = getSession().createCriteria(persistentClass);
		//组合查询条件
		for (int i=0;i<propertyNames.length;i++){
			if (StringUtils.isNotEmpty(propertyNames[i])){
				if (addAnd) setWhere.append(" and "); 
				setWhere.append("["+propertyNames[i] +"] = '"+ values[i] +"'");
				criteria.add(Restrictions.eq(propertyNames[i], values[i]));
				addAnd = true;
			}
		}
		//查询数据
		List datas = criteria.list();
		if (datas.size() == 0) {
			return null;
		} else if (datas.size() == 1) {
			return datas.get(0);
		} else {
			String errMsg ="BaseDaoHibernate.getOne]:结果不是惟一: " +setWhere.toString(); 
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
		}
	}//getOne
	
	public List getAll() {
		return getSession().createCriteria(persistentClass).list();
	}
	
	public int getAllRows(QueryParameterProcessor processor, QueryParameter parameter) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		
		processor.process(criteria, parameter);
		
		criteria.setProjection(Projections.rowCount());
		return ((Integer) criteria.uniqueResult()).intValue();
	}
	
	public QueryResult getAll(QueryParameterProcessor processor, QueryParameter parameter) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		Page page = null;
		if (parameter.getAction() == QueryAction.ALL) {
			int all_size = parameter.getAll_size();
			if(all_size > 0) {
				criteria.setFirstResult(0);
				criteria.setMaxResults(all_size);
			}
			page = Page.EMPTY;
		} else if (parameter.getAction() == QueryAction.SECTION) {
			page = new Page(getAllRows(processor, parameter), parameter.getSize(), parameter.getNo());
			criteria.setFirstResult(page.getFirstResult());
			criteria.setMaxResults(page.getSize());
		} else {
			throw new RuntimeException("非法查询");
		}
		
		processor.process(criteria, parameter);
		List datas = criteria.list();
		
		//@@add by ywj
		//对全部查询，把所有记录数也放在page中
		if (parameter.getAction() == QueryAction.ALL) {
			if (datas == null) 
				page.setRows(0);
			else 
				page.setRows(datas.size());
		}
		QueryResult result = new QueryResult(page, datas);
		return result;
	}
	

	public List getAllDistinct() {
		Collection result = new LinkedHashSet(getAll());
		return new ArrayList(result);
	}

	public void remove(Serializable id) {
		getSession().delete(get(id));
	}

	/**
	 * 通过删除对象
	 * 
	 * @param obj
	 */
	public void removeObject(Object obj) {
		getSession().delete(obj);
	}

	/**
	 * 通过删除一组对象
	 * 
	 * @param objs 
	 */
	public void removeAllObject(List objs) {
		this.getHibernateTemplate().deleteAll(objs);
	}
	/**
	 * save --插入的方法
		entity the transient instance to persist
		返回 Returns:自增后的ID
	 */
	public Object save(Object object) {
		return getHibernateTemplate().save(object);
	}
	
	/**
	 * 更新方法，不返回值
	 */
	public void update(Object object) {
		getHibernateTemplate().update(object);
	}

	/**
	 * 刷新SessionFactory
	 */
	public void reloadSessionFactory() {

		//切换SessionFactory
		this.setSessionFactory(dynamicSessionFactory.determineTargetSessionFactory());
	}

	/**
	 * @return the dynamicSessionFactory
	 */
	public DynamicSessionFactoryProxyBean getDynamicSessionFactory() {
		return dynamicSessionFactory;
	}

	/**
	 * @param dynamicSessionFactory the dynamicSessionFactory to set
	 */
	public void setDynamicSessionFactory(
			DynamicSessionFactoryProxyBean dynamicSessionFactory) {
		this.dynamicSessionFactory = dynamicSessionFactory;
	}

	/**
	 * @param persistentClass the persistentClass to set
	 */
	protected void setPersistentClass(Class persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	/**
	 * 使用SQL查询
	 * DAO继承此基类，不能使用下面的方法
	 * 只有继承BaseHqlQueryDao，才可以使用此方法
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter) {		
		throw new RuntimeException("此方法使用SQL查询，请继承BaseHqlQueryDao类，然后使用此方法。");
	}
	/**
	 * 使用SQL查询
	 * DAO继承此基类，不能使用下面的方法
	 * 只有继承BaseHqlQueryDao，才可以使用此方法
	 */
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter) {
		throw new RuntimeException("此方法使用SQL查询，请继承BaseHqlQueryDao类，然后使用此方法。");
	}


	
}
