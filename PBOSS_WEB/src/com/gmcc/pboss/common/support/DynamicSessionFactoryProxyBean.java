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
 * SessionFactory 代理类,管理一个缺省的 {@link SessionFactory} 实例(公共库),和其他地市库的 {@link SessionFactory} 的 Map 集合(key 是 cityid)
 * {@link targetSessionFactorys} 和 {@link defaultSessionFactory} 是必须要配置的 {@link SessionFactory} 集合和对象。
 * {@link resolvedSessionFactorys} 是 {@link targetSessionFactorys} 验证合法性过后的 {@link SessionFactory} 集合
 */
public class DynamicSessionFactoryProxyBean implements SessionFactory, InitializingBean {
	/**
	 * log4j 变量
	 */
	protected static final Log logger = LogFactory.getLog(ActionFilter.class);//log4j
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * SessionFactory 集合(必须)
	 */
	private Map targetSessionFactorys;

	/**
	 * 默认的 SessionFactory (必须)
	 */
	private SessionFactory defaultSessionFactory;

	/**
	 * 验证合法性后的 SessionFactory 集合
	 */
	private Map resolvedSessionFactorys;

	/**
	 * 通过 Spring 来配置 SessionFactory 集合
	 */
	public void setTargetSessionFactorys(Map targetSessionFactorys) {
		this.targetSessionFactorys = targetSessionFactorys;
	}

	/**
	 * 通过 Spring 来配置缺省的 SessionFactory
	 */
	public void setDefaultSessionFactory(SessionFactory defaultSessionFactory) {
		this.defaultSessionFactory = defaultSessionFactory;
	}

	/**
	 * 配置值的条件检验
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
	 * 根据当前的 key 取  {@link org.hibernate.SessionFactory} 实例, 未找到则返回 {@link #defaultSessionFactory}
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
		logger.info("Get db session(提取数据库) : ["+ lookupKey +"]");
		return sessionFactory;
	}

	/**
	 * {@link #targetSessionFactorys} 的 keys 类型合法性验证
	 */
	protected String resolveSpecifiedLookupKey(Object lookupKey) {
		if (lookupKey instanceof String) {
			return (String) lookupKey;
		} else {
			throw new IllegalArgumentException("Illegal key value - only java.lang.String supported");
		}
	}

	/**
	 * {@link #targetSessionFactorys} 的 values 类型合法性验证
	 */
	protected SessionFactory resolveSpecifiedSessionFactory(Object sessionFactory) throws IllegalArgumentException {
		if (sessionFactory instanceof SessionFactory) {
			return (SessionFactory) sessionFactory;
		} else {
			throw new IllegalArgumentException("Illegal SessionFactory value - only org.hibernate.SessionFactory supported");
		}
	}

	/**
	 * 取当前用户设置的 SessionFactory key
	 */
	protected String determineCurrentLookupKey() {
		return SessionFactoryContextHolder.getSessionFactoryContext();
	}

	/*
	 * 以下是  org.hibernate.SessionFactory 的实现
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
