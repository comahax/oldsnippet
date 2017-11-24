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
 * ͨ��DAO�����ࣨһ��������ͨ�򵥵Ĳ�ѯ��
 *
 */
public class BaseDaoHibernate extends HibernateDaoSupport implements BaseDao {
	
	private DynamicSessionFactoryProxyBean dynamicSessionFactory;
	/**
	 * ��Ҫ�־õĶ���Class
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
	 * ʹ��������ѯ����:���������Ωһ,���׳�IllegalStateException,���󲻴����򷵻�null
	 * @param propertyNames -- ������������(������values���������ͬ,�����׳�IllegalStateException)
	 * @param values -- ����ֵ����
	 * @return ���ϲ�ѯ������Ωһ����
	 */
	public Object getOne(String[] propertyNames, Object[] values) {
		// TODO Auto-generated method stub
		StringBuffer setWhere = new StringBuffer();
		boolean addAnd=false;
		if (propertyNames.length != values.length){
			String errMsg ="[BaseDaoHibernate.getOne]:�������ô���propertys:" + 
			propertyNames.length + "!=values:" + values.length; 
			logger.error(errMsg);
			throw new IllegalStateException(errMsg);
		}
		Criteria criteria = getSession().createCriteria(persistentClass);
		//��ϲ�ѯ����
		for (int i=0;i<propertyNames.length;i++){
			if (StringUtils.isNotEmpty(propertyNames[i])){
				if (addAnd) setWhere.append(" and "); 
				setWhere.append("["+propertyNames[i] +"] = '"+ values[i] +"'");
				criteria.add(Restrictions.eq(propertyNames[i], values[i]));
				addAnd = true;
			}
		}
		//��ѯ����
		List datas = criteria.list();
		if (datas.size() == 0) {
			return null;
		} else if (datas.size() == 1) {
			return datas.get(0);
		} else {
			String errMsg ="BaseDaoHibernate.getOne]:�������Ωһ: " +setWhere.toString(); 
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
			throw new RuntimeException("�Ƿ���ѯ");
		}
		
		processor.process(criteria, parameter);
		List datas = criteria.list();
		
		//@@add by ywj
		//��ȫ����ѯ�������м�¼��Ҳ����page��
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
	 * ͨ��ɾ������
	 * 
	 * @param obj
	 */
	public void removeObject(Object obj) {
		getSession().delete(obj);
	}

	/**
	 * ͨ��ɾ��һ�����
	 * 
	 * @param objs 
	 */
	public void removeAllObject(List objs) {
		this.getHibernateTemplate().deleteAll(objs);
	}
	/**
	 * save --����ķ���
		entity the transient instance to persist
		���� Returns:�������ID
	 */
	public Object save(Object object) {
		return getHibernateTemplate().save(object);
	}
	
	/**
	 * ���·�����������ֵ
	 */
	public void update(Object object) {
		getHibernateTemplate().update(object);
	}

	/**
	 * ˢ��SessionFactory
	 */
	public void reloadSessionFactory() {

		//�л�SessionFactory
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
	 * ʹ��SQL��ѯ
	 * DAO�̳д˻��࣬����ʹ������ķ���
	 * ֻ�м̳�BaseHqlQueryDao���ſ���ʹ�ô˷���
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter) {		
		throw new RuntimeException("�˷���ʹ��SQL��ѯ����̳�BaseHqlQueryDao�࣬Ȼ��ʹ�ô˷�����");
	}
	/**
	 * ʹ��SQL��ѯ
	 * DAO�̳д˻��࣬����ʹ������ķ���
	 * ֻ�м̳�BaseHqlQueryDao���ſ���ʹ�ô˷���
	 */
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter) {
		throw new RuntimeException("�˷���ʹ��SQL��ѯ����̳�BaseHqlQueryDao�࣬Ȼ��ʹ�ô˷�����");
	}


	
}
