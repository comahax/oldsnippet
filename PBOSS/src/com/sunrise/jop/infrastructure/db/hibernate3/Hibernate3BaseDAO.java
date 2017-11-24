package com.sunrise.jop.infrastructure.db.hibernate3;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.AbstractComponentType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.db.BaseDAO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.SessionGetter;
import com.sunrise.jop.infrastructure.db.SessionManager;

/**
 * <p>
 * Title: BaseDAO for Hibernate, Hibernate���DAO����
 * </p>
 * <p>
 * Description: ��װ���ݿ�Ĳ������ṩ����������ɾ���ġ���ķ���
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Gaven
 * @version 1.0
 * @version 1.1 HuangBaiming 2005-11-17 hibernate2 �ĵ� hibernate3
 * @version 1.2 HuangBaiming 2006-8-17 ɾ������ע�ͣ���Date���������⴦��ɾ�����������ѯ���������ʵ�֣�
 * @version 1.3 hekun 2007-1-10 ��װ���Ӳ�ѯ�ӿ�,�򻯸��Ӳ�ѯ����.
 * @version 1.4 He Kun, 2007-11 ,���������� count() �־䡣 ���Ӷ԰󶨼��ϲ�����֧�֡� in (:param)
 * @version 1.5 He Kun 2008-1-30
 *          ���Ӳ�ѯ�������ƣ������ֶβ�ѯ���ܼ򻯡��޶�Ӧ���ϲ�ѯ������Ҫ����ӳ����½�VO����������ΪMap����.
 * 
 */
public class Hibernate3BaseDAO implements BaseDAO {
	private SessionManager sessionManager; // ��static
	private static Log log = LogFactory.getLog(Hibernate3BaseDAO.class);

	// ȱʡ�� Hibernate ��ѯ�����������в�ѯʹ��һ������region ��ͬ���Ļ������
	private static final String DEFAULT_HIBERNATE_QUERY_CACHE = "QUERY_DEFAULT_HIBERNATE_QUERY_CACHE";
	/**
	 * java���ͺ�Hibernate����ӳ���ϵ��queryBySql(),��ѯ�����ֶ�ʱ��Ҫ
	 */
	private static final Map javaTypeHibernateTypeMapping = new HashMap(12);

	static {
		javaTypeHibernateTypeMapping.put(String.class, Hibernate.STRING);
		javaTypeHibernateTypeMapping.put(Character.class, Hibernate.CHARACTER);

		javaTypeHibernateTypeMapping.put(Integer.class, Hibernate.INTEGER);
		javaTypeHibernateTypeMapping.put(Long.class, Hibernate.LONG);
		javaTypeHibernateTypeMapping.put(Double.class, Hibernate.DOUBLE);
		javaTypeHibernateTypeMapping.put(Float.class, Hibernate.FLOAT);
		javaTypeHibernateTypeMapping.put(Short.class, Hibernate.SHORT);
		javaTypeHibernateTypeMapping.put(Byte.class, Hibernate.BYTE);
		javaTypeHibernateTypeMapping.put(java.util.Date.class, Hibernate.DATE);
		javaTypeHibernateTypeMapping.put(java.sql.Timestamp.class,
				Hibernate.TIMESTAMP);
		// ����������Ҫʱ�����
	}

	public Hibernate3BaseDAO() {
	}

	/** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�Ľ� */

	protected Class voClass;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#getVoClass()
	 */
	public Class getVoClass() {
		return voClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#setVoClass(java.
	 * lang.Class)
	 */
	public void setVoClass(Class voClass) {
		this.voClass = voClass;
	}

	/**
	 * ���ø÷��������DAO��������setDbFlag���������ܵ��÷�����
	 * 
	 * @param voClass
	 */
	protected Hibernate3BaseDAO(Class voClass) {
		this.voClass = voClass;
	}

	private String dbFlag;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#getDbFlag()
	 */
	public String getDbFlag() {
		return dbFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#setDbFlag(java.lang
	 * .String)
	 */
	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public Hibernate3BaseDAO(Class voClass, String dbFlag) {
		this.voClass = voClass;
		this.dbFlag = dbFlag;
	}

	/**
	 * ʹ��Hibernate3�� SessionManagerʵ��, ��������DAO��ӿڿ�ܵ������
	 * 
	 */
	public SessionManager getSessionManager() {
		return sessionManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	/**
	 * ��ȡHibernate SessionFactory , ����ӿ��޴˷�����Hibernate�ض���
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = ((Hibernate3SessionManager) getSessionManager())
				.getSessionFactory();
		return sessionFactory;
	}

	/**
	 * ��ȡHibernate ��ǰ SessionFactory��Session , ����ӿ��޴˷�����Hibernate�ض���
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object getCurrentSession() {
		if (!(sessionManager instanceof SessionGetter)) {
			throw new JOPException(
					"BaseDAO impl class must implement interface SessionGetter, or session can't be gotten."
							+ this.getClass().getName());
		} else {
			SessionGetter getter = (SessionGetter) sessionManager;
			return getter.getCurrentSession();
		}
	}

	private Session currentSession() {
		return (Session) getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#evict()
	 */
	public void evict() throws Exception {
		try {
			SessionFactory sessionFactory = getSessionFactory();
			sessionFactory.evict(voClass);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#evict(java.io.
	 * Serializable)
	 */
	public void evict(Serializable id) throws Exception {
		try {
			SessionFactory sessionFactory = getSessionFactory();
			sessionFactory.evict(voClass, id);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#clearSession()
	 */
	public void clearSession() throws Exception {
		Session session = currentSession();
		session.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#create(java.lang
	 * .Object)
	 */
	public Object create(Object vo) throws Exception {
		Session session = currentSession();
		try {
			session.save(vo);

		} catch (HibernateException ex) {
			/**
			 * һ����˵��Hibernate�����쳣ʱ����HibernateException��װ֮���׳���
			 * ���ﳢ�Խ⿪HibernateException�İ�װ����ʾ�����Ĵ���ԭ��
			 */
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#removeByPk(java.
	 * io.Serializable)
	 */
	public void removeByPk(Serializable pk) throws Exception {
		Session session = currentSession();
		;
		try {
			Object entity = session.get(voClass, pk);
			if (entity != null) {
				session.delete(entity);

			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#remove(java.lang
	 * .Object)
	 */
	public void remove(Object vo) throws Exception {
		Session session = currentSession();
		;
		try {
			if (vo != null) {
				session.delete(vo);

			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#update(java.lang
	 * .Object)
	 */
	public Object update(Object vo) throws Exception {
		Session session = currentSession();
		try {
			session.update(vo);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#saveOrUpdate(java
	 * .lang.Object)
	 */
	public Object saveOrUpdate(Object vo) throws Exception {
		Session session = currentSession();
		try {
			session.saveOrUpdate(vo);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#findByPk(java.io
	 * .Serializable)
	 */
	public Object findByPk(Serializable pk) throws Exception {
		if (pk == null)
			throw new NullPointerException("findByPk method: Pk is null.");
		Session session = currentSession();
		Object vo = null;
		try {
			vo = (Object) session.get(voClass, pk);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return vo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#findByUniqueKey(
	 * java.lang.String, java.io.Serializable)
	 */
	public Object findByUniqueKey(String uniqueKeyPropertyName, Serializable id)
			throws Exception {
		return findByProperty(uniqueKeyPropertyName, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#findAll()
	 */
	public Collection findAll() throws Exception {
		Session session = currentSession();
		
		Collection result = null;
		try {
			result = session.createCriteria(voClass).list();
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#getMaxValue(java
	 * .lang.String)
	 */
	public Object getMaxValue(String prop) throws Exception {
		if (prop != null && prop.trim().length() > 0) {
			StringBuffer sql = new StringBuffer("SELECT max(this.")
					.append(prop).append(") FROM ").append(voClass.getName())
					.append(" this");

			Session session = null;
			try {
				session = currentSession();
				;
				Query query = session.createQuery(sql.toString());
				Iterator iter = query.iterate();
				if (iter != null && iter.hasNext()) {
					return iter.next();
				}
			} catch (HibernateException ex) {
				if (ex.getCause() != null) {
					throw new Exception(ex.getCause());
				} else {
					throw ex;
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#getMaxid(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	public Object getMaxid(String id, String value, String prop)
			throws Exception {
		if (prop != null && prop.trim().length() > 0) {
			StringBuffer sql = new StringBuffer("SELECT max(this.")
					.append(prop).append(") FROM ").append(voClass.getName())
					.append(" this where this.").append(id).append("='")
					.append(value).append("'");

			Session session = null;
			try {
				session = currentSession();
				
				Query query = session.createQuery(sql.toString());
				Iterator iter = query.iterate();
				if (iter != null && iter.hasNext()) {
					return iter.next();
				}
			} catch (HibernateException ex) {
				if (ex.getCause() != null) {
					throw new Exception(ex.getCause());
				} else {
					throw ex;
				}
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#findByProperty(java
	 * .lang.String, java.lang.Object)
	 */
	public Object findByProperty(String prop, Object value) throws Exception {
		if (prop != null && prop.trim().length() > 0 && value != null) {
			StringBuffer selectHQL = new StringBuffer("FROM ")
					.append(voClass.getName())
					.append(" this ")
					.append("where this." + prop + " = '" + value.toString()
							+ "'");
			Session session = currentSession();
			
			try {
				Query query = session.createQuery(selectHQL.toString());

				queryCacheSet(query); // ���û�������

				List list = query.list();
				if (list != null && list.size() > 0) {
					return list.get(0);
				}
			} catch (Exception ex) {
				throw ex;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#countByProperty(
	 * java.lang.String, java.lang.Object)
	 */
	public int countByProperty(String prop, Object value) throws Exception {
		int count = 0;
		if (prop != null && prop.trim().length() > 0 && value != null) {
			StringBuffer countSQL = new StringBuffer("SELECT  ");
			countSQL.append(buildCountClause(true));
			countSQL.append(" FROM ").append(voClass.getName())
					.append(" this WHERE this.").append(prop)
					.append(" = :prop ");

			Session session = null;
			try {
				session = currentSession();

				Query query = session.createQuery(countSQL.toString());
				query.setParameter("prop", value);

				Iterator iter = query.iterate();
				if (iter != null && iter.hasNext()) {
					return ((Number) iter.next()).intValue();
				}
			} catch (HibernateException ex) {
				if (ex.getCause() != null) {
					throw new Exception(ex.getCause());
				} else {
					throw ex;
				}
			}
		}
		return count;
	}

	/**
	 * ���ݲ�����ѯ
	 */
	public DataPackage query(Object param) throws Exception {
		// String _queryexpress = (String)BeanUtils.getProperty(param,
		// "_queryexpress");
		// if (_queryexpress!=null &&
		// _queryexpress.toLowerCase().equals("true")){
		DBQueryParam dbparam = (DBQueryParam) param; // ֻ����
		if (dbparam.isCountOnly()) {
			return query(param, QUERY_TYPE_COUNT);
		} else if (dbparam.isDataOnly()) {
			return query(param, QUERY_TYPE_DATA);
		} else {
			return query(param, QUERY_TYPE_ALL);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#count(java.lang.
	 * Object)
	 */
	public int count(Object param) throws Exception {
		DataPackage dp = query(param, QUERY_TYPE_COUNT);
		if (dp != null) {
			return dp.getRowCount();
		} else {
			return -1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#query(java.lang.
	 * Object, int)
	 */
	public DataPackage query(Object param, int type) throws Exception {
		StringBuffer countHQL = new StringBuffer("SELECT ");
		countHQL.append(buildCountClause(true));
		countHQL.append(" FROM ").append(voClass.getName()).append(" this ");

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(param,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if (_pagesize > MAX_QUERY_COUNT) {
			_pagesize = MAX_QUERY_COUNT;
			/** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�޸� */
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(param,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		try {
			_orderby = (String) BeanUtils.getProperty(param, "_orderby");
		} catch (Exception ex) {
			_orderby = "";
		}

		try {
			_desc = (String) BeanUtils.getProperty(param, "_desc");
		} catch (Exception ex) {
			_desc = "";
		}
		if (_desc == null) {
			_desc = "0"; // Ĭ�ϵ���
		}

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(param, "this",
				placeholders, dateParamList));
		if (whereClause.length() > 4) {
			countHQL = countHQL.append("WHERE ").append(whereClause);
		}

		// ��ѯ���
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		Session session = currentSession();
		try {
			// ȡ�ܼ�¼��
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {

				Query countQuery = session.createQuery(countHQL.toString());
				// ����
				queryCacheSet("QUERY_COUNT_" + voClass.getName(), countQuery); // ���û�������

				if (log.isDebugEnabled())
					log.debug("count HQL:" + countHQL.toString());
				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								countQuery.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								countQuery.setTimestamp(key, ts);
							}
						} else {
							countQuery.setParameter(key, value);
						}
					}
				}

				List resultList = countQuery.list();

				// use Number type compatible with Integer and Long, because
				// hibernate 3.3.0 use long.
				Number countInteger = (Number) resultList.get(0);
				result.setRowCount(countInteger != null ? countInteger
						.intValue() : 0);
				// �жϵ�ǰҳ��Ϊ��ҳʱ��ҳ�������������ҳ��ʱ��Ĭ�ϲ�ѯ���һҳ��---LJX
				if (_pageno > 1
						&& countInteger.intValue() <= _pagesize * (_pageno - 1)) {
					if (countInteger.intValue() / _pagesize == 0) {
						_pageno = 1;
					} else {
						_pageno = countInteger.intValue() / _pagesize;
					}
					result.setPageNo(_pageno);
				}
			}

			// ȡָ��ҳ������
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_DATA) {
				StringBuffer selectHQL = new StringBuffer(
						buildSelectFileds(param));
				selectHQL.append(" FROM ").append(voClass.getName())
						.append(" this ");
				if (whereClause.toString().trim().length() > 0) {
					selectHQL = selectHQL.append("WHERE ").append(whereClause);
				}

				if (_orderby != null && _orderby.trim().length() > 0
						&& _desc != null) {
					if (_desc.equals("1")) {
						selectHQL = selectHQL.append("order by ")
								.append(getNewOrderby(_orderby, "this."))
								.append(" desc ");
					} else {
						selectHQL = selectHQL.append("order by ")
								.append(getNewOrderby(_orderby, "this."))
								.append(" asc ");
					}
				}

				Query query = session.createQuery(selectHQL.toString());
				// ����
				queryCacheSet("QUERY_" + voClass.getName(), query); // ���û�������

				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								query.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								query.setTimestamp(key, ts);
							}
						} else {
							query.setParameter(key, value);
						}
					}
				}

				if (_pagesize != 0) {
					query.setMaxResults(_pagesize);
					query.setFirstResult(_pagesize * (_pageno - 1));
				}

				List list = query.list();
				if (list == null) {
					list = new ArrayList();
				}
				result.setDatas(list);
				result.setPageSize(_pagesize);
			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return result;
	}

	/**
	 * ��DBQueryParam��SelectFieldsָ�����ֶΣ������ѯ���ֶΣ������ѯȫ��
	 * 
	 * @param param
	 *            DBQueryParam
	 */
	private String buildSelectFileds(Object param) {
		StringBuffer selectHQL = new StringBuffer("");
		try {
			DBQueryParam dpparam = (DBQueryParam) param;
			if (param != null && dpparam.getSelectFields() != null) {
				Iterator itr = dpparam.getSelectFields().iterator();
				while (itr.hasNext()) {
					if (selectHQL.length() > 0)
						selectHQL.append(",");
					selectHQL.append(" this.").append(itr.next());
				}
			}
			String head = "SELECT NEW " + voClass.getName() + "(";
			if (selectHQL.length() > 0)
				selectHQL.insert(0, head).append(")");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return selectHQL.toString();
	}

	/**
	 * ��ѯ��ֻ����������
	 */
	private DataPackage queryOnlyRcd(Object param) throws Exception {

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(param,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if (_pagesize > MAX_QUERY_COUNT) {
			_pagesize = MAX_QUERY_COUNT;
			/** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�޸� */
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(param,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		try {
			_orderby = (String) BeanUtils.getProperty(param, "_orderby");
		} catch (Exception ex) {
			_orderby = "";
		}

		try {
			_desc = (String) BeanUtils.getProperty(param, "_desc");
		} catch (Exception ex) {
			_desc = "";
		}
		if (_desc == null) {
			_desc = "0"; // Ĭ�ϵ���
		}

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(param, "this",
				placeholders, dateParamList));

		// ��ѯ���
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		Session session = currentSession();
		;
		try {
			// ��ȡ�ܼ�¼��
			// modifyed by Ge Aiping on 25-Oct-2006
			result.setRowCount(0);
			// ȡָ��ҳ������
			StringBuffer selectHQL = new StringBuffer("FROM ").append(
					voClass.getName()).append(" this ");
			if (whereClause.toString().trim().length() > 0) {
				selectHQL = selectHQL.append(" WHERE ").append(whereClause);
			}

			if (_orderby != null && _orderby.trim().length() > 0
					&& _desc != null) {
				if (_desc.equals("1")) {
					selectHQL = selectHQL.append(" order by ")
							.append(getNewOrderby(_orderby, "this."))
							.append(" desc ");
				} else {
					selectHQL = selectHQL.append(" order by ")
							.append(getNewOrderby(_orderby, "this."))
							.append(" asc ");
				}
			}

			Query query = session.createQuery(selectHQL.toString());
			// ��������
			queryCacheSet(query); // ���û�������

			if (placeholders != null && placeholders.size() > 0) {
				Set keyset = placeholders.keySet();
				for (Iterator it = keyset.iterator(); it.hasNext();) {
					String key = (String) it.next();
					Object value = placeholders.get(key);
					// ��������������ж�
					if (dateParamList.indexOf(key) != -1) {
						if (value.toString().length() == 10) {// yyyy-MM-dd
							query.setDate(key, (new SimpleDateFormat(
									"yyyy-MM-dd")).parse(value.toString()));
						} else {// yyyy-MM-dd HH:mm:ss
							java.util.Date date = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss").parse(value
									.toString());
							Timestamp ts = new Timestamp(date.getTime());
							query.setTimestamp(key, ts);
						}
					} else {
						query.setParameter(key, value);
					}
				}
			}

			if (_pagesize != 0) {
				query.setMaxResults(_pagesize);
				query.setFirstResult(_pagesize * (_pageno - 1));
			}

			List list = query.list();
			if (list == null) {
				list = new ArrayList();
			}

			result.setDatas(list);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#query2(java.lang
	 * .Object[], java.lang.Class[], java.lang.String[][])
	 */
	public DataPackage unionQuery(Object param[], Class vo[], String joins[][])
			throws Exception {
		return unionQuery(param, vo, joins, QUERY_TYPE_ALL);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#query2(java.lang
	 * .Object[], java.lang.Class[], java.lang.String[][], int)
	 */
	public DataPackage unionQuery(Object param[], Class vos[],
			String joins[][], int type) throws Exception {

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;

		if (param == null || vos == null || joins == null) {
			throw new Exception("error paramters !");
		}
		if (param.length != vos.length || joins[0].length != vos.length) {
			throw new Exception("error paramters num!");
		}

		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(
					param[0], "_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if (_pagesize > MAX_QUERY_COUNT) {
			_pagesize = MAX_QUERY_COUNT;
			/** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�޸� */
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(param[0],
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// ��orderby���ֶβ�����param[0],�ƹ㵽����param����������
		try {
			StringBuffer sb_orderby = new StringBuffer(" ");
			for (int i = 0; i < param.length; i++) {
				String orderby = (String) BeanUtils.getProperty(param[i],
						"_orderby");
				if (StringUtils.isEmpty(orderby))
					continue;
				String[] _orderbys = StringUtils.split(orderby, ",");
				for (int j = 0; j < _orderbys.length; j++) {
					sb_orderby.append("t").append(i).append(".")
							.append(_orderbys[j]).append(",");
				}
			}
			_orderby = sb_orderby.substring(0, sb_orderby.length() - 1);
		} catch (Exception ex) {
			_orderby = "";
		}
		try {
			for (int i = 0; i < param.length; i++) {
				_desc = (String) BeanUtils.getProperty(param[i], "_desc");
				if (!StringUtils.isEmpty(_desc)) {
					break;
				}
			}
		} catch (Exception ex) {
			_desc = "";
		}

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer condition = new StringBuffer();
		StringBuffer strjoins = new StringBuffer();
		StringBuffer fromClause = new StringBuffer("FROM ");
		for (int i = 0; i < vos.length; i++) {
			fromClause.append(vos[i].getName()).append(" t").append(i)
					.append(",");
			if (param[i] != null && !"".equals(param[i])) {
				String where = buildHQL(param[i], "t" + i, placeholders,
						dateParamList, placeholders.size() + 1);
				if (where != null && !"".equals(where)) {
					condition.append(" and ").append(where).append(" ");
				}
			}
		}
		if (fromClause.length() > 1) {
			fromClause.deleteCharAt(fromClause.length() - 1);
		}
		if (condition.length() > 1) {
			condition.deleteCharAt(condition.length() - 1);
		}
		for (int i = 0; i < joins.length; i++) {
			strjoins.append(" and ");
			for (int j = 0; j < joins[i].length; j++) {
				if (joins[i][j] != null) {
					strjoins.append("t").append(j).append(".")
							.append(joins[i][j]).append("=");
				}
			}
			if (strjoins.length() > 1) {
				strjoins.deleteCharAt(strjoins.length() - 1);
				strjoins.append(" ");
			}
		}
		fromClause.append(" where 1=1 ").append(strjoins).append(condition);
		
		if (_desc == null) {
			_desc = "0"; // Ĭ�ϵ���
		}

		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		Session session = currentSession();
		;
		try {
			// ȡ�ܼ�¼��
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {
				String countHQL = "select " + buildCountClause(true)
						+ fromClause;
				Query query = session.createQuery(countHQL.toString());
				// ��������
				queryCacheSet(query); // ���û�������

				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								query.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								query.setTimestamp(key, ts);
							}
						} else {
							query.setParameter(key, value);
						}
					}
				}

				Iterator iter = query.iterate(); // hibernate3��д��
				if (iter != null && iter.hasNext()) {
					result.setRowCount(((Number) iter.next()).intValue());
				} else {
					result.setRowCount(0);
				}
			}

			// ȡָ��ҳ������
			// ��orderby���ֶβ�����param[0],�ƹ㵽����param����������
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_DATA) {

				if (_orderby != null && _orderby.trim().length() > 0
						&& _desc != null) {
					if (_desc.equals("1")) {
						fromClause = fromClause.append(" order by ")
								.append(getNewOrderby(_orderby, null))
								.append(" desc ");
					} else {
						fromClause = fromClause.append(" order by ")
								.append(getNewOrderby(_orderby, null))
								.append(" asc ");
					}
				}

				Query query = session.createQuery(fromClause.toString());
				// hekun 2008-9-23, ���ò�ѯ���湦��
				queryCacheSet(query); // ���û�������

				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								query.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								query.setTimestamp(key, ts);
							}
						} else {
							query.setParameter(key, value);
						}
					}
				}

				if (_pagesize != 0) {
					query.setMaxResults(_pagesize);
					query.setFirstResult(_pagesize * (_pageno - 1));
				}

				List list = query.list();
				if (list == null) {
					list = new ArrayList();
				}

				result.setDatas(list);
			}
		} catch (HibernateException ex) {
			log.error(ex.getMessage());
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#buildHQL(java.lang
	 * .Object, java.lang.String, java.util.Map, java.util.List)
	 */
	public String buildHQL(Object param, String prefix, Map placeholders,
			List dateParamList) throws Exception {
		return buildHQL(param, prefix, placeholders, dateParamList, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#buildHQL(java.lang
	 * .Object, java.lang.String, java.util.Map, java.util.List, int)
	 */
	public String buildHQL(Object param, String prefix, Map placeholders,
			List dateParamList, int ph) throws Exception {

		// He Kun 2008-1-28 �жϣ����ֻʹ�� queryConditions
		// �еĹ̶�����������Զ�̬���������Ҳ�����where�־䡣
		if (param instanceof DBQueryParam) {
			DBQueryParam queryParam = (DBQueryParam) param;
			if (queryParam.isUseFixedParamOnly())
				return "";
		}

		if (prefix == null) {
			prefix = "";
		}

		if (prefix.trim().length() > 0) {
			prefix = prefix + ".";
		}

		StringBuffer whereClause = new StringBuffer();

		String key, field;
		Object value;

		Map props = getConditions(param);

		// Ϊ��ѯ��������ʹ�÷���������ListVO��_firstitems���ԣ�����
		// listVO.set_firstitems("_ne_xxx,_se_yyy");
		// ��ô���ɵ�sql����й���_ne_xxx��_se_yyy�������������У��ͻ�����ǰ��λ��
		// ----add by lwl
		List orderedKeys = getOrderedKeyset(props.keySet(), param);

		// use to check property type
		BaseVO voIns = (BaseVO) voClass.newInstance();

		for (Iterator iter = orderedKeys.iterator(); iter.hasNext();) {
			key = (String) iter.next();

			// value = props.get(key)!=null ? String.valueOf( props.get(key) ) :
			// null;
			if (props.get(key) != null && props.get(key) instanceof Collection) {
				value = props.get(key);
			} else {
				value = props.get(key) != null ? props.get(key) : null;
			}

			// ������ֵ�Ĳ���
			if (value == null) {
				continue;
			}

			// �������µļ���Ƿ���Ϲ���
			try {
				field = key.substring(key.indexOf('_', 1) + 1);
			} catch (Exception ex) {
				continue;
			}

			// null�����Ĵ���
			if (key.startsWith("_sn_") || key.startsWith("_dn_")
					|| key.startsWith("_nn_")) {
				whereClause = whereClause.append("(" + prefix + field
						+ " is null) and ");
			} else if (key.startsWith("_snn_") || key.startsWith("_dnn_")
					|| key.startsWith("_nnn_")) {
				whereClause = whereClause.append("(" + prefix + field
						+ " is not null) and ");
			} else {
				// �� null�����ģ�����������ֵ
				if (value instanceof Collection) {
					if (((Collection) value).size() <= 0) {
						continue;
					}
				} else {
					if (value.toString().trim().length() <= 0) {
						continue;
					}
				}
				// ���������������⴦�������ȱ����¶�Ӧ�Ĳ�����������k1��k2��
				// _dn _dnn _dl _dnm _de _dnl _dm _dne _din _dnin
				if (key.startsWith("_d")) {
					if (key.startsWith("_dnl_") || key.startsWith("_dnm_")
							|| key.startsWith("_de_")
							|| key.startsWith("_dnn_")
							|| key.startsWith("_dl_") || key.startsWith("_dn_")
							|| key.startsWith("_dm_")
							|| key.startsWith("_dne_")
							|| key.startsWith("_din_")
							|| key.startsWith("_dnin_")) {
						dateParamList.add("k" + ph);
					}
				}
				// ֻ����placeholders���Ԫ�أ����ۼ�ph;
				// ----- modified by zhangsiwei
				if (key.startsWith("_sql_")) {
					whereClause = whereClause.append("(" + value + ") and ");
				} else if (key.startsWith("_sl_") || key.startsWith("_dl_")
						|| key.startsWith("_nl_")) {
					whereClause = whereClause.append("(" + prefix + field
							+ " < :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_snm_") || key.startsWith("_dnm_")
						|| key.startsWith("_nnm_")) {
					whereClause = whereClause.append("(" + prefix + field
							+ " <= :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_se_") || key.startsWith("_de_")
						|| key.startsWith("_ne_")) {
					whereClause = whereClause.append("(" + prefix + field
							+ " = :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_snl_") || key.startsWith("_dnl_")
						|| key.startsWith("_nnl_")) {
					whereClause = whereClause.append("(" + prefix + field
							+ " >= :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_sm_") || key.startsWith("_dm_")
						|| key.startsWith("_nm_")) {
					whereClause = whereClause.append("(" + prefix + field
							+ " > :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_sne_") || key.startsWith("_dne_")
						|| key.startsWith("_nne_")) {
					whereClause = whereClause.append("(" + prefix + field
							+ " <> :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_sin_") || key.startsWith("_din_")
						|| key.startsWith("_nin_")) {
					ph = buildSQLInOrNotInCondition(value, whereClause, prefix,
							field, ph, placeholders, true);
				} else if (key.startsWith("_snin_") || key.startsWith("_dnin_")
						|| key.startsWith("_nnin_")) {
					ph = buildSQLInOrNotInCondition(value, whereClause, prefix,
							field, ph, placeholders, false);
				} else if (key.startsWith("_sei_")) {
					whereClause = whereClause.append("( lower(" + prefix
							+ field + ") = lower( :k" + ph + ")) and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_snei_")) {
					whereClause = whereClause.append("( lower(" + prefix
							+ field + ") <> lower( :k" + ph + ")) and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_sk_")) {
					value = "%" + value + "%";
					whereClause = whereClause.append("(" + prefix + field
							+ " like :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_ssw_")) {
					value = value + "%";
					whereClause = whereClause.append("(" + prefix + field
							+ " like :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_sew_")) {
					value = "%" + value;
					whereClause = whereClause.append("(" + prefix + field
							+ " like :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_snk_")) {
					value = "%" + value + "%";
					whereClause = whereClause.append("(" + prefix + field
							+ " not like :k" + ph + ") and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_ski_")) {
					value = "%" + value + "%";
					whereClause = whereClause.append("( lower(" + prefix
							+ field + ") like lower( :k" + ph + ")) and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				} else if (key.startsWith("_snki_")) {
					value = "%" + value + "%";
					whereClause = whereClause.append("( lower(" + prefix
							+ field + ") not like lower( :k" + ph + ")) and ");
					placeholders.put(String.valueOf("k" + ph++), value);
				}
			}

			if (value != null && value.getClass() == String.class) { // ֻ��string���������ͼ������жϣ��������ֵ�ֶδ���string��ֵ
			// for this key
				PropertyDescriptor pd = PropertyUtils.getPropertyDescriptor(
						voIns, field);
				// ������ֵ���͡�
				Object ovalue = null;
				try {
					if (pd != null && pd.getPropertyType() != String.class) {
						ph--;
						ovalue = placeholders.get(String.valueOf("k" + ph));
						if (ovalue != null)
							if (pd.getPropertyType() == Long.class) {

								Long lvalue = Long.valueOf((String) ovalue);
								placeholders.put(String.valueOf("k" + ph),
										lvalue);
							} else if (pd.getPropertyType() == Integer.class) {

								Integer lvalue = Integer
										.valueOf((String) ovalue);
								placeholders.put(String.valueOf("k" + ph),
										lvalue);

							} else if (pd.getPropertyType() == Short.class) {

								Short lvalue = Short.valueOf((String) ovalue);
								placeholders.put(String.valueOf("k" + ph),
										lvalue);

							} else if (pd.getPropertyType() == Byte.class) {

								Byte lvalue = Byte.valueOf((String) ovalue);
								placeholders.put(String.valueOf("k" + ph),
										lvalue);
							}
						ph++;
					}
				} catch (NumberFormatException t) {
					throw new NumberFormatException(
							"Field type not match��field type "
									+ pd.getPropertyType() + ", field value:"
									+ ovalue);
				}
			}
			// ph++; //��һ��
		}

		if (whereClause.length() > 4) {
			whereClause = whereClause.delete(whereClause.length() - 4,
					whereClause.length() - 1);
		}

		return whereClause.toString();
	}

	protected Map getConditions(Object param) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		// ��̬��������
		Map props = com.sunrise.jop.common.utils.bean.BeanUtils.describe(param);

		// new ��̬�������� add by hekun
		if (param instanceof DBQueryParam) {
			DBQueryParam listVO = (DBQueryParam) param;
			Map queryConditions = listVO.getQueryConditions();

			if (queryConditions != null && queryConditions.size() > 0) {
				// ����̬�������붯̬�����У��ظ��Ķ�̬��������ֵ�������ǡ�
				for (Iterator keys = props.keySet().iterator(); keys.hasNext();) {
					String key = (String) keys.next();
					Object value = props.get(key);
					if (key.startsWith("_") && value != null)
						queryConditions.put(key, value);
				}
				props = queryConditions;
			}
		}
		return props;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#getCurrentTime()
	 */
	public java.util.Date getCurrentTime() throws Exception {
		String sql = "select sysdate from dual";
		Session session = currentSession();
		;
		SQLQuery query = session.createSQLQuery(sql);
		query.addScalar("sysdate", Hibernate.TIMESTAMP);
		// Hibernate.
		List ret = query.list();
		if (ret.size() > 0) {
			return (java.util.Date) ret.get(0);
		}
		return null;
	}

	protected List getOrderedKeyset(Set keys, Object param) throws Exception {
		List orderedKeyset = new ArrayList();
		if (keys.size() > 0) {
			String firstitems = (String) BeanUtils.getProperty(param,
					"_firstitems");
			String firstitemname = null;
			if (firstitems != null) {
				for (StringTokenizer st = new StringTokenizer(firstitems, ","); st
						.hasMoreTokens();) {
					firstitemname = st.nextToken();
					if (keys.contains(firstitemname)) {
						orderedKeyset.add(firstitemname);
					}
				}
			}
			for (Iterator it = keys.iterator(); it.hasNext();) {
				String key = (String) it.next();
				if (!orderedKeyset.contains(key))
					orderedKeyset.add(key);
			}
		}
		return orderedKeyset;
	}

	/**
	 * add by Hanny Yeung
	 * 
	 * @param value
	 * @param whereClause
	 * @param prefix
	 * @param field
	 * @param ph
	 * @param placeholders
	 * @param inOrNotIn
	 *            true����SQL�е�in��false����SQL�е�not in
	 * @return
	 */
	private int buildSQLInOrNotInCondition(Object value,
			StringBuffer whereClause, String prefix, String field, int ph,
			Map placeholders, boolean inOrNotIn) {
		Collection tmpList = (Collection) value;
		int tmpSize = tmpList.size();
		if (inOrNotIn) {
			whereClause = whereClause.append("( " + prefix + field + " in ( ");
		} else {
			whereClause = whereClause.append("( " + prefix + field
					+ " not in ( ");
		}
		Iterator iter = tmpList.iterator();
		int i = 0;
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (i == tmpSize - 1) {
				whereClause.append(" :k" + ph + ")) and ");
			} else {
				whereClause.append(" :k" + ph + ",");
			}
			placeholders.put(String.valueOf("k" + ph++), obj);
			i++;
		}
		return ph;
	}

	// public static void main(String[] args) throws Exception {
	// ����keys��������
	// com.sunrise.boss.business.fee.billing.fixfee.persistent.FixFeeListVO
	// listvo = new
	// com.sunrise.boss.business.fee.billing.fixfee.persistent.FixFeeListVO();
	// listvo.set_datasize("datasize");
	// listvo.set_desc("desc");
	// listvo.set_ne_acctid("_ne_acctid");
	// listvo.set_ne_subsid("_ne_subsid");
	// listvo.set_ne_validbillcyc("_ne_validbillcyc");
	// listvo.set_orderby("_orderby");
	// listvo.set_pageno("_pageno");
	// listvo.set_pagesize("_pagesize");
	// listvo.set_sk_mobileno("_sk_mobileno");
	// listvo.setAscending(true);
	// listvo.setDatas("datas");
	// listvo.setMobileno("mobileno");
	// listvo.setQueryConditions(null);
	// listvo.set_firstitems("_orderby,_ne_validbillcyc,class");
	// Map props = getConditions(listvo);
	// Set keys = props.keySet();
	// System.out.println("======Before Order " + keys.size() +"======");
	// for(Iterator it = keys.iterator();it.hasNext();){
	// String key = (String)it.next();
	// System.out.println(key);
	// }
	// List orderedKeys = getOrderedKeyset(keys,listvo);
	// System.out.println("======After Order " + orderedKeys.size()
	// +"======");
	// for(Iterator it = orderedKeys.iterator();it.hasNext();){
	// String key = (String)it.next();
	// System.out.println(key);
	// }
	// System.out.println("====== End ========");
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#
	 * queryUniqueByNamedSqlQuery(java.lang.String, java.lang.Object)
	 */
	public Object queryUniqueByNamedSqlQuery(String name, Object param)
			throws Exception {
		return queryUniqueByNamedSqlQuery(name, param, Integer.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#
	 * queryUniqueByNamedSqlQuery(java.lang.String, java.lang.Object,
	 * java.lang.Class)
	 */
	public Object queryUniqueByNamedSqlQuery(String name, Object param,
			Class returnType) throws Exception {
		Session session = currentSession();
		SQLQuery query = (SQLQuery) session.getNamedQuery(name);
		String queryString = query.getQueryString();

		return queryUniqueBySql(queryString, param, returnType, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#
	 * queryCountByNamedSqlQuery(java.lang.String, java.lang.Object)
	 */
	public DataPackage queryCountByNamedSqlQuery(String name, Object param)
			throws Exception {
		return queryByNamedSqlQuery(name, param, QUERY_TYPE_COUNT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#queryByNamedSqlQuery
	 * (java.lang.String)
	 */
	public DataPackage queryByNamedSqlQuery(String name) throws Exception {
		return queryByNamedSqlQuery(name, new DBQueryParam());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#queryByNamedSqlQuery
	 * (java.lang.String, java.lang.Object)
	 */
	public DataPackage queryByNamedSqlQuery(String name, Object param)
			throws Exception {
		if (param instanceof DBQueryParam) {

			DBQueryParam queryParam = (DBQueryParam) param;
			if (queryParam.isCountOnly())
				return queryByNamedSqlQuery(name, param, QUERY_TYPE_COUNT);
			else if (queryParam.isDataOnly())
				return queryByNamedSqlQuery(name, param, QUERY_TYPE_DATA);
		}
		// else
		return queryByNamedSqlQuery(name, param, QUERY_TYPE_ALL);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#queryByNamedSqlQuery
	 * (java.lang.String, java.lang.Object, int)
	 */
	public DataPackage queryByNamedSqlQuery(String name, Object param, int type)
			throws Exception {
		Session session = currentSession();

		SQLQuery query = (SQLQuery) session.getNamedQuery(name);

		String queryString = query.getQueryString();

		return queryBySql(queryString, param, type, name);
	}

	public Object queryUniqueBySql(String queryString, Object param,
			Class returnType) throws Exception {
		return queryUniqueBySql(queryString, param, returnType,
				"QUERY_NoNameUniqueQuery");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#queryUniqueBySql
	 * (java.lang.String, java.lang.Object, java.lang.Class)
	 */
	public Object queryUniqueBySql(String queryString, Object param,
			Class returnType, String queryName) throws Exception {

		Session session = currentSession();

		Type hibernateType = toHibernateType(returnType);
		SQLQuery query = session.createSQLQuery(queryString).addScalar("val",
				hibernateType);
		// ����
		queryCacheSet(queryName, query); // ���û�������

		if (param instanceof DBQueryParam) {
			DBQueryParam listVO = (DBQueryParam) param;
			listVO.set_pagesize("0");
			listVO.set_orderby(null);
		}
		setQueryNamedParameters(query, param);

		List list = (List) query.list();
		if (list.size() > 1)
			throw new NonUniqueResultException(list.size());
		if (list.size() > 0)
			return list.get(0);
		else
			throw new NonUniqueResultException(0);
	}

	private void setQueryNamedParameters(Query query, Object param)
			throws Exception {

		String[] parameters = query.getNamedParameters();
		Map parametersMap = new HashMap();
		for (int i = 0; i < parameters.length; i++) {
			parametersMap.put(parameters[i], null);
		}

		Map props = null;
		if (param instanceof DBQueryParam) {
			props = getConditions(param);
		} else if (param instanceof Map) {
			props = (Map) param;
		}

		if (props == null)
			return;

		Set orderedKeys = props.keySet();
		String key = null;
		Object value = null;
		for (Iterator iter = orderedKeys.iterator(); iter.hasNext();) {
			key = (String) iter.next();

			if (!parametersMap.containsKey(key))
				continue;

			value = props.get(key);
			if (value == null)
				continue;
			// added by He Kun, 2007-11-28 , ���Ӷ԰󶨼��ϲ�����֧��
			if (value instanceof Collection) {
				query.setParameterList(key, (Collection) value);
			} else if (value.getClass().isArray()) {
				query.setParameterList(key, (Object[]) value);
			} else {
				query.setParameter(key, value);
			}

		}
	}

	private Type toHibernateType(Class returnType) {

		if (returnType.equals(String.class)) {
			return Hibernate.STRING;
		} else if (returnType.equals(Long.class)) {
			return Hibernate.LONG;
		} else if (returnType.equals(Integer.class)) {
			return Hibernate.INTEGER;
		} else if (returnType.equals(Short.class)) {
			return Hibernate.SHORT;
		} else if (returnType.equals(Byte.class)) {
			return Hibernate.BYTE;
		} else if (returnType.equals(java.sql.Timestamp.class)) {
			return Hibernate.TIMESTAMP;
		} else if (returnType.isAssignableFrom(java.util.Date.class)) {
			return Hibernate.DATE;
		} else {
			throw new UnsupportedOperationException("Unsupported type "
					+ returnType.getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#queryBySql(java.
	 * lang.String)
	 */
	public DataPackage queryBySql(String queryString) throws Exception {
		return queryBySql(queryString, new DBQueryParam());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#queryBySql(java.
	 * lang.String, java.lang.Object)
	 */
	public DataPackage queryBySql(String queryString, Object param)
			throws Exception {
		return queryBySql(queryString, param, QUERY_TYPE_ALL);
	}

	public DataPackage queryBySql(String queryString, Object param, int type)
			throws Exception {
		return queryBySql(queryString, param, type, "QUERY_NoNameQuery");
	}

	/**
	 * ����sql���в�ѯ
	 * 
	 * @param sql
	 *            Ҫ��ѯ��sql���
	 * @param param
	 *            ����ListVO�淶�Ĳ�ѯ��������
	 * @param type
	 *            ��ѯ���ͣ���ѯ��¼��(QUERY_TYPE_COUNT),��ѯ��¼(QUERY_TYPE_DATA),���߶���ѯ(
	 *            QUERY_TYPE_ALL)
	 * @return
	 * @throws Exception
	 */
	protected DataPackage queryBySql(String queryString, Object param,
			int type, String queryName) throws Exception {
		Session session = currentSession();
		StringBuffer countSQL = new StringBuffer("SELECT ");
		countSQL.append(buildCountClause());
		countSQL.append(" total FROM (").append(queryString).append(") this ");

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(param,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if (_pagesize > MAX_QUERY_COUNT) {
			_pagesize = MAX_QUERY_COUNT;
			/** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�޸� */
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(param,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		try {
			_orderby = (String) BeanUtils.getProperty(param, "_orderby");
		} catch (Exception ex) {
			_orderby = "";
		}

		try {
			_desc = (String) BeanUtils.getProperty(param, "_desc");
		} catch (Exception ex) {
			_desc = "";
		}
		if (_desc == null) {
			_desc = "0"; // Ĭ�ϵ���
		}

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(param, "this",
				placeholders, dateParamList));
		if (whereClause.length() > 4) {
			countSQL = countSQL.append(" WHERE ").append(whereClause);
		}

		// ��ѯ���
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		try {
			// ȡ�ܼ�¼��
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {

				SQLQuery countQuery = session.createSQLQuery(countSQL
						.toString());
				// ���ò�ѯ����
				queryCacheSet("QUERY_COUNT_" + queryName, countQuery); // ���û�������

				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								countQuery.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								countQuery.setTimestamp(key, ts);
							}
						} else {
							countQuery.setParameter(key, value);
						}
					}
				}

				setQueryNamedParameters(countQuery, param);

				countQuery.addScalar("total", new IntegerType());
				result.setRowCount(((Number) countQuery.uniqueResult())
						.intValue());
			}

			// ȡָ��ҳ������
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_DATA) {
				// StringBuffer selectSQL = new
				// StringBuffer("select * from ( ").append(
				// queryString).append(") this ");

				StringBuffer selectSQL = new StringBuffer(300);
				SQLQuery query = null;

				selectSQL.append("select ");

				ClassMetadata class1 = session.getSessionFactory()
						.getClassMetadata(voClass.getName());
				String[] pks = getPKs();
				List selectFields = null;
				Map selectFieldsClass = null;
				boolean selectPartFiels = false;
				boolean isSelectFieldsUseVOType = false;
				// �����������ѡ���ѯ�������õ��ֶμ��Ͻ��в�ѯ�����������ֶβ�ѯ��
				if (param instanceof DBQueryParam) {
					DBQueryParam dbparam = (DBQueryParam) param;
					if (dbparam.getSelectFields() != null) {
						selectFields = dbparam.getSelectFields();

						if (dbparam.getSelectFieldsClass() != null) {
							selectFieldsClass = dbparam.getSelectFieldsClass();
						}
					}

					if (selectFields != null && selectFields.size() > 0)
						selectPartFiels = true;

					isSelectFieldsUseVOType = dbparam.isSelectFieldsUseVOType();
				}

				if (!selectPartFiels) {
					// ����������ֶΣ����ȹ�������
					for (int i = 0; i < pks.length; i++) {
						selectSQL.append(" this.").append(pks[i].toUpperCase())
								.append(" as ").append(" {ttt.").append(pks[i])
								.append("}");
						if (i < pks.length - 1)
							selectSQL.append(",");
					}
					selectFields = Arrays.asList(class1.getPropertyNames()); // ��������������ֶ�
					if (selectFields.size() > 0)
						selectSQL.append(", ");
				}

				for (int i = 0; i < selectFields.size(); i++) {
					String colName = (String) selectFields.get(i);

					selectSQL.append(" this.").append(colName.toUpperCase());
					if (!selectPartFiels) // ���ֻ��ѯ�����ֶΣ�����Ҫ���ñ�����������Ҫ���ñ���
						selectSQL.append(" as ").append(" {ttt.")
								.append(colName).append("}");

					if (i < (selectFields.size() - 1))
						selectSQL.append(", ");
				}

				selectSQL.append(" from (").append(queryString)
						.append(" ) this  ");

				if (whereClause.toString().trim().length() > 0) {
					selectSQL = selectSQL.append(" WHERE ").append(whereClause);
				}

				if (_orderby != null && _orderby.trim().length() > 0
						&& _desc != null) {
					if (_desc.equals("1")) {
						selectSQL = selectSQL.append(" order by ")
								.append(getNewOrderby(_orderby, "this."))
								.append(" desc ");
					} else {
						selectSQL = selectSQL.append(" order by ")
								.append(getNewOrderby(_orderby, "this."))
								.append(" asc ");
					}
				}

				query = session.createSQLQuery(selectSQL.toString());
				// .addScalar("companyname", Hibernate.STRING);
				// .addEntity("ttt", voClass);
				queryCacheSet("QUERY_" + queryName, query); // ���û�������

				/**
				 * �����ֶ�ӳ�� 1) ���ֻ��1���ֶΣ����ֶ����ͷ������ݣ����磺capital, ��vo���������� Long
				 * ���ؼ��ϣ�����ֶβ���vo�����ԣ���string���ͷ��� 2) ����ж���ֶΣ������ֶζ���vo�����ԣ��򷵻�
				 * vo�ļ��� 3) ����ж���ֶΣ����ֶβ�ȫ��vo�����ԣ��򷵻� HashMap �ļ���
				 */
				if (!selectPartFiels) { // ��ʵ���ѯ
					query.addEntity("ttt", voClass);

				} else { // �����ֶ�ӳ�䣬�����ֶ�ӳ������

					for (int i = 0; i < selectFields.size(); i++) {
						// ���ò�ѯ������еĶ�ӦHibernate����
						Type hibernateType = Hibernate.STRING;
						String fieldName = (String) selectFields.get(i);
						Class clazz = null;

						if (selectFieldsClass != null)
							clazz = (Class) selectFieldsClass.get(fieldName);

						hibernateType = convert2HibernateType(fieldName, clazz);
						// ��vo��Ӧ���Ի�ȡ��Ӧ������
						query.addScalar((String) selectFields.get(i),
								hibernateType);
					}
				}

				setQueryNamedParameters(query, param);

				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								query.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								query.setTimestamp(key, ts);
							}
						} else {
							query.setParameter(key, value);
						}
					}
				}

				if (_pagesize != 0) {
					query.setMaxResults(_pagesize);
					query.setFirstResult(_pagesize * (_pageno - 1));
				}

				List list = new ArrayList(0);
				list = query.list();

				// 2008-1-9,He Kun: �����ֻ�鲿���ֶΣ�����Ҫ�Խ����û�е� Object[] ��װΪ Map�����������
				if (selectPartFiels)
					list = wrapDataList(list, selectFields,
							isSelectFieldsUseVOType);

				if (list == null) {
					list = new ArrayList();
				}

				result.setDatas(list);
			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return result;
	}

	/**
	 * ͨ�������ļ���SQL�����ֲ�ѯ�õ�ʵ��SQL��ѯSUM����
	 * 
	 * @param queryString
	 * @param param
	 * @param queryName
	 * @return
	 * @throws Exception
	 */
	public String querySumByNamedSql(String name, Object param)
			throws Exception {
		Session session = currentSession();

		SQLQuery query = (SQLQuery) session.getNamedQuery(name);

		String queryString = query.getQueryString();

		return querySumBySql(queryString, param);
	}

	/**
	 * ��ѯSUM����
	 * 
	 * @param queryString
	 * @param param
	 * @param queryName
	 * @return
	 * @throws Exception
	 */
	public String querySumBySql(String queryString, Object param)
			throws Exception {
		String amounts = "-1.0";

		String selectFields = "";
		DBQueryParam dbparam = (DBQueryParam) param;
		if (dbparam.getSelectFieldsString() != null) {
			selectFields = dbparam.getSelectFieldsString();
		}

		Session session = currentSession();
		StringBuffer countSQL = new StringBuffer("SELECT NVL(TO_CHAR(SUM(");
		countSQL.append(selectFields);
		countSQL.append(")), '0') AMOUNTS FROM (").append(queryString)
				.append(") this ");

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(param, "this",
				placeholders, dateParamList));
		if (whereClause.length() > 4) {
			countSQL = countSQL.append(" WHERE ").append(whereClause);
		}

		try {
			SQLQuery sumQuery = session.createSQLQuery(countSQL.toString());

			if (placeholders != null && placeholders.size() > 0) {
				Set keyset = placeholders.keySet();
				for (Iterator it = keyset.iterator(); it.hasNext();) {
					String key = (String) it.next();
					Object value = placeholders.get(key);
					// ��������������ж�
					if (dateParamList.indexOf(key) != -1) {
						if (value.toString().length() == 10) {
							sumQuery.setDate(key, (new SimpleDateFormat(
									"yyyy-MM-dd")).parse(value.toString()));
						} else {
							java.util.Date date = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss").parse(value
									.toString());
							Timestamp ts = new Timestamp(date.getTime());
							sumQuery.setTimestamp(key, ts);
						}
					} else {
						sumQuery.setParameter(key, value);
					}
				}
			}

			setQueryNamedParameters(sumQuery, param);

			sumQuery.addScalar("amounts", new StringType());
			// amounts = ((Number)sumQuery.uniqueResult()).doubleValue();
			amounts = (String) sumQuery.uniqueResult();
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}

		return amounts;
	}

	/**
	 * ���ƶ��ֶε����͵�ָ������ת��ΪHibernate����
	 * 
	 * @param fieldName
	 * @param fieldClass
	 *            �����ָ��ʱ������ vo�ж�Ӧ���Ե������жϡ�
	 * @return
	 */
	private Type convert2HibernateType(String fieldName, Class fieldClass) {
		Class fClass = fieldClass;
		Type type = null;

		if (fClass == null) {
			try {
				Object object = voClass.newInstance();
				PropertyDescriptor pd = PropertyUtils.getPropertyDescriptor(
						object, fieldName);
				if (pd != null)
					fClass = pd.getPropertyType();
			} catch (Exception e) {
				if (log.isErrorEnabled())
					log.error("�޷�����vo ʵ����" + e.getMessage(), e);
			}
		}
		// return Hibernate.STRING;
		if (fClass != null)
			type = (Type) javaTypeHibernateTypeMapping.get(fClass);

		if (type == null || fClass == null) {
			type = Hibernate.STRING;
		}

		return type;
	}

	/**
	 * �������ֶβ�ѯ������ݽṹת��Ϊ���õ����ݽṹ�� VO���� Map 1) ���ֻ��1���ֶΣ����ֶ����ͷ������ݣ����磺capital,
	 * ��vo���������� Long ���ؼ��ϣ�����ֶβ���vo�����ԣ���string���ͷ��� 2) ����ж���ֶΣ��򷵻� HashMap �ļ���
	 * 3) ����ж���ֶΣ������ֶζ���vo�����ԣ�������selectFieldsUseVOType ����Ϊtrue�� �򷵻�VO�ļ��ϡ�
	 * 
	 * @param list
	 * @param selectFields
	 * @return
	 */
	private List wrapDataList(List list, List selectFields,
			boolean isSelectFieldsUseVOType) {
		List list0 = new ArrayList(list.size());

		for (int i = 0; i < list.size(); i++) {

			if (selectFields.size() == 1) { // ֻ��1��
				list0.add(list.get(i));

			} else if (isSelectFieldsUseVOType && isAllVOFields(selectFields)) { // ����,�����ֶ�ȫ����vo���ֶ�

				Object[] objects = (Object[]) list.get(i);
				BaseVO vo = convert2VO(objects, selectFields);
				list0.add(vo);

			} else { // ���е��ֶβ�ȫ����vo���ֶΣ� ת��ΪMap
				Object[] objects = (Object[]) list.get(i);
				list0.add(convert2Map(objects, selectFields));
			}

		}
		return list0;
	}

	/**
	 * ���selectFields �е��ֶ��Ƿ���vo������
	 * 
	 * @param selectFields
	 * @return
	 */
	private boolean isAllVOFields(List selectFields) {

		Map pd;
		try {
			pd = (Map) PropertyUtils.describe(voClass.newInstance());
			for (int i = 0; i < selectFields.size(); i++) {
				if (!pd.containsKey(selectFields.get(i)))
					return false;
				// ������vo�ֶ�
			}
		} catch (Exception e) {
			if (log.isErrorEnabled())
				log.error("�޷�����vo ʵ��, " + e.getMessage(), e);
			return false;
		}
		return true;
	}

	/**
	 * ��object[]����ת��ΪVO
	 * 
	 * @param objects
	 * @param selectFields
	 * @return
	 */
	private BaseVO convert2VO(Object[] objects, List selectFields) {
		try {
			if (objects.length > selectFields.size())
				log.warn("���棺��������ֶ����� selectFields ���趨���ֶ�����" + objects.length
						+ "> " + selectFields.size() + " ����ܻ���������˷ѣ��뱣�����ǵ�һ���ԡ�");

			BaseVO vo = (BaseVO) voClass.newInstance();
			for (int i = 0; i < selectFields.size(); i++) {
				BeanUtils.setProperty(vo, (String) selectFields.get(i),
						objects[i]);
			}
			return vo;
		} catch (Exception e) {
			if (log.isErrorEnabled())
				log.error("�޷���������ϰ��ֶ��б� " + selectFields + " ת��Ϊ��Ӧ��VO "
						+ voClass.getName() + ", " + e.getMessage(), e);
			return null;
		}
	}

	/**
	 * ��һ�� Object[] �͵ļ�¼ת��ΪMap
	 * 
	 * @param objects
	 * @param selectFields
	 * @return
	 */
	private Map convert2Map(Object[] objects, List selectFields) {
		Map map = new HashMap((int) (objects.length * 1.34));
		for (int i = 0; i < objects.length; i++) {
			map.put((String) selectFields.get(i), objects[i]);
		}
		return map;
	}

	private String buildCountClause() {
		return buildCountClause(false);
	}

	private String buildCountClause(boolean isHQL) {
		// return " count(*) ";

		// ��������Ŀ������ company_name ʽ�������֣���������Ϊ companyName�����߲�һ�£�
		// ���� hql���޷�֧��,��ʱ���� count(*).
		// ��������� ��ȡvoClass��Ӧ�ı����� Ȼ�����count(1) �־���м�����
		String pks[] = null;
		StringBuffer buffer = null;
		try {
			buffer = new StringBuffer(16);
			buffer.append("count(");
			pks = getPKs();

			if (pks.length > 1 || isHQL)
				buffer.append(" * ");
			else {
				if (pks.length == 1) {
					// if(isHQL )
					// buffer.append( pks[0] ); // pks[0]);
					// else
					buffer.append("*"); // Ϊ��������ݿ����⣬��count(1)Ϊ��ʹ��count(*)
				} else {
					buffer.append("*");
				}
			}

			buffer.append(")");

		} catch (Exception e) {
			return " count(*)";
		}
		return buffer.toString();
	}

	/**
	 * ��ȡʵ������������ƣ�֧�ֶ�����
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	protected String[] getPKs() throws Exception {
		Session session = currentSession();

		ClassMetadata metadata = session.getSessionFactory().getClassMetadata(
				this.voClass);

		if (metadata == null) {
			throw new NullPointerException("voClass " + voClass.getName()
					+ " not configed in hibernate config!");
		}
		Type type = metadata.getIdentifierType();

		String[] pkNames = null;
		if (!(type instanceof AbstractComponentType)) {
			String pkName = metadata.getIdentifierPropertyName();
			pkNames = new String[1];
			pkNames[0] = pkName;

		} else {
			AbstractComponentType aType = (AbstractComponentType) type;
			pkNames = aType.getPropertyNames();
		}
		return pkNames;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#getSequence(java
	 * .lang.String)
	 */
	public Object getSequence(String seqname) throws Exception {
		if (StringUtils.isBlank(seqname))
			return null;
		StringBuffer sql = new StringBuffer("SELECT ").append(seqname).append(
				".NEXTVAL val FROM dual");
		Long seq = (Long) queryUniqueBySql(sql.toString(), null, Long.class);
		return seq;
	}

	protected void queryCacheSet(Query squery) {
		queryCacheSet(DEFAULT_HIBERNATE_QUERY_CACHE, squery);
	}

	/**
	 * Ϊ��ѯ���û������ԡ�<br/>
	 * Ĭ�����û��棬<br/>
	 * ������������HIBERNATE_QUERY_CACHE��<br/>
	 * 
	 * �Ժ���Ը�������Ϊ��ͬ��query���ò�ͬ��cache region���Ա�ʹ�ò�ͬ�Ļ�����ԡ�<br/>
	 * 
	 * @param query
	 */
	protected void queryCacheSet(String queryCacheRegion, Query squery) {
		squery.setCacheable(true);
		squery.setCacheRegion(queryCacheRegion);

		if (log.isDebugEnabled())
			log.debug("query cache region:" + queryCacheRegion);
	}

	/**
	 * �������orderby�ֶε�bug
	 * 
	 * @param _orderby
	 * @param prefix
	 */
	private String getNewOrderby(String _orderby, String prefix) {
		if (prefix == null) {
			return _orderby;
		}
		String[] columns = StringUtils.split(_orderby, ",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < columns.length; i++) {
			sb.append(prefix).append(columns[i]);
			if (i != columns.length - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
}
