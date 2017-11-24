package com.gmcc.pboss.common.support;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.naming.NamingException;
import javax.naming.Reference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.classic.Session;
import org.hibernate.engine.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.gmcc.pboss.common.filter.ActionFilter;

/**
 * SessionFactory ������,����һ��ȱʡ�� {@link SessionFactory} ʵ��(������),���������п�� {@link SessionFactory} �� Map ����(key �� cityid)
 * {@link targetSessionFactorys} �� {@link defaultSessionFactory} �Ǳ���Ҫ���õ� {@link SessionFactory} ���ϺͶ���
 * {@link resolvedSessionFactorys} �� {@link targetSessionFactorys} ��֤�Ϸ��Թ���� {@link SessionFactory} ����
 */
public class DynamicSessionFactoryProxyBean implements SessionFactory, InitializingBean {
	/**
	 * log4j ����
	 */
	protected static final Log logger = LogFactory.getLog(ActionFilter.class);//log4j
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * SessionFactory ����(����)
	 */
	private Map targetSessionFactorys;

	/**
	 * Ĭ�ϵ� SessionFactory (����)
	 */
	private SessionFactory defaultSessionFactory;

	/**
	 * ��֤�Ϸ��Ժ�� SessionFactory ����
	 */
	private Map resolvedSessionFactorys;

	/**
	 * ͨ�� Spring ������ SessionFactory ����
	 */
	public void setTargetSessionFactorys(Map targetSessionFactorys) {
		this.targetSessionFactorys = targetSessionFactorys;
	}

	/**
	 * ͨ�� Spring ������ȱʡ�� SessionFactory
	 */
	public void setDefaultSessionFactory(SessionFactory defaultSessionFactory) {
		this.defaultSessionFactory = defaultSessionFactory;
	}

	/**
	 * ����ֵ����������
	 */
	public void afterPropertiesSet() throws Exception {

		Assert.notNull(this.defaultSessionFactory, "defaultSessionFactory is required");
		Assert.notNull(this.targetSessionFactorys, "targetSessionFactorys is required");

		resolvedSessionFactorys = new HashMap(targetSessionFactorys.size());
		for (Iterator it = targetSessionFactorys.entrySet().iterator(); it.hasNext();) {
			Entry entry = (Entry) it.next();
			String lookupKey = resolveSpecifiedLookupKey(entry.getKey());
			SessionFactory sessionFactory = resolveSpecifiedSessionFactory(entry.getValue());
			resolvedSessionFactorys.put(lookupKey, sessionFactory);
		}
	}

	/**
	 * ���ݵ�ǰ�� key ȡ  {@link org.hibernate.SessionFactory} ʵ��, δ�ҵ��򷵻� {@link #defaultSessionFactory}
	 */
	public SessionFactory determineTargetSessionFactory() {
		Assert.notNull(this.resolvedSessionFactorys, "SessionFactory router not initialized");
		String lookupKey = determineCurrentLookupKey();
		SessionFactory sessionFactory = (SessionFactory) resolvedSessionFactorys.get(lookupKey);
		if (sessionFactory == null) {
			sessionFactory = defaultSessionFactory;
		}
		if (sessionFactory == null) {
			throw new IllegalStateException("Cannot determine target SessionFactory for lookup key [" + lookupKey + "]");
		}
		logger.info("Get db session(��ȡ���ݿ�) : ["+ lookupKey +"]");
		return sessionFactory;
	}

	/**
	 * {@link #targetSessionFactorys} �� keys ���ͺϷ�����֤
	 */
	protected String resolveSpecifiedLookupKey(Object lookupKey) {
		if (lookupKey instanceof String) {
			return (String) lookupKey;
		} else {
			throw new IllegalArgumentException("Illegal key value - only java.lang.String supported");
		}
	}

	/**
	 * {@link #targetSessionFactorys} �� values ���ͺϷ�����֤
	 */
	protected SessionFactory resolveSpecifiedSessionFactory(Object sessionFactory) throws IllegalArgumentException {
		if (sessionFactory instanceof SessionFactory) {
			return (SessionFactory) sessionFactory;
		} else {
			throw new IllegalArgumentException("Illegal SessionFactory value - only org.hibernate.SessionFactory supported");
		}
	}

	/**
	 * ȡ��ǰ�û����õ� SessionFactory key
	 */
	protected String determineCurrentLookupKey() {
		return SessionFactoryContextHolder.getSessionFactoryContext();
	}

	/*
	 * ������  org.hibernate.SessionFactory ��ʵ��
	 */

	public void close() throws HibernateException {
		determineTargetSessionFactory().close();
	}

	public void evict(Class persistentClass) throws HibernateException {
		determineTargetSessionFactory().evict(persistentClass);
	}

	public void evict(Class persistentClass, Serializable id) throws HibernateException {
		determineTargetSessionFactory().evict(persistentClass, id);
	}

	public void evictCollection(String roleName) throws HibernateException {
		determineTargetSessionFactory().evictCollection(roleName);
	}

	public void evictCollection(String roleName, Serializable id) throws HibernateException {
		determineTargetSessionFactory().evictCollection(roleName, id);
	}

	public void evictEntity(String entityName) throws HibernateException {
		determineTargetSessionFactory().evictEntity(entityName);
	}

	public void evictEntity(String entityName, Serializable id) throws HibernateException {
		determineTargetSessionFactory().evictEntity(entityName, id);
	}

	public void evictQueries() throws HibernateException {
		determineTargetSessionFactory().evictQueries();
	}

	public void evictQueries(String cacheRegion) throws HibernateException {
		determineTargetSessionFactory().evictQueries(cacheRegion);
	}

	public Map getAllClassMetadata() throws HibernateException {
		return determineTargetSessionFactory().getAllClassMetadata();
	}

	public Map getAllCollectionMetadata() throws HibernateException {
		return determineTargetSessionFactory().getAllCollectionMetadata();
	}

	public ClassMetadata getClassMetadata(Class persistentClass) throws HibernateException {
		return determineTargetSessionFactory().getClassMetadata(persistentClass);
	}

	public ClassMetadata getClassMetadata(String entityName) throws HibernateException {
		return determineTargetSessionFactory().getClassMetadata(entityName);
	}

	public CollectionMetadata getCollectionMetadata(String roleName) throws HibernateException {
		return determineTargetSessionFactory().getCollectionMetadata(roleName);
	}

	public Session getCurrentSession() throws HibernateException {
		return determineTargetSessionFactory().getCurrentSession();
	}

	public Set getDefinedFilterNames() {
		return determineTargetSessionFactory().getDefinedFilterNames();
	}

	public FilterDefinition getFilterDefinition(String filterName) throws HibernateException {
		return determineTargetSessionFactory().getFilterDefinition(filterName);
	}

	public Statistics getStatistics() {
		return determineTargetSessionFactory().getStatistics();
	}

	public boolean isClosed() {
		return determineTargetSessionFactory().isClosed();
	}

	public Session openSession() throws HibernateException {
		return determineTargetSessionFactory().openSession();
	}

	public Session openSession(Connection connection) {
		return determineTargetSessionFactory().openSession(connection);
	}

	public Session openSession(Interceptor interceptor) throws HibernateException {
		return determineTargetSessionFactory().openSession(interceptor);
	}

	public Session openSession(Connection connection, Interceptor interceptor) {
		return determineTargetSessionFactory().openSession(connection, interceptor);
	}

	public StatelessSession openStatelessSession() {
		return determineTargetSessionFactory().openStatelessSession();
	}

	public StatelessSession openStatelessSession(Connection connection) {
		return determineTargetSessionFactory().openStatelessSession(connection);
	}

	public Reference getReference() throws NamingException {
		return determineTargetSessionFactory().getReference();
	}
}
