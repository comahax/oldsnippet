package com.sunrise.boss.common.base.db;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.AbstractComponentType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;

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
 * @version 1.4 HuangBaiming 2007-4-3 ���������¼�Ĳ�ѯ����,������xxxForUpdate()
 * @version 1.5 He Kun 2007-12-12 ���� queryUniqueByNamedSqlQuery ��֧�ְ�listvo ��̬������bug
 * 
 */
public class BaseDAO {
	/**
	 * ��ѯ����,��ѯ��������
	 */
	public static final int QUERY_TYPE_ALL = 0;

	public static final int QUERY_TYPE_COUNT = 10;

	public static final int QUERY_TYPE_DATA = 20;

	public static final int MAX_QUERY_COUNT = 10000;/** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�Ľ� */

	protected Class voClass;
	
	public Class getVoClass(){
		return voClass;
	}

	public void setVoClass(Class voClass){
		this.voClass = voClass;
	}
	
	/**
	 * ���ø÷��������DAO��������setDbFlag���������ܵ��÷�����
	 *
	 * @param voClass
	 */
	protected BaseDAO(Class voClass) {
		this.voClass = voClass;
	}

	private String dbFlag;

	public String getDbFlag() {
		return dbFlag;
	}
	public void setDbFlag(String dbFlag,boolean isCommon) {
		if(isCommon)
			this.dbFlag = SessionFactoryRouter.checkIsCommonDB(voClass, dbFlag);
		else
			this.dbFlag = dbFlag;
	}
	public void setDbFlag(String dbFlag) {
		this.dbFlag = SessionFactoryRouter.checkIsCommonDB(voClass, dbFlag);
	}

	public BaseDAO(Class voClass, String dbFlag) {
		this.voClass = voClass;
		this.dbFlag = SessionFactoryRouter.checkIsCommonDB(voClass, dbFlag);
	}

	/**
	 * ��������е�����
	 *
	 * @throws Exception
	 */
	public void evict() throws Exception {
		try {
			SessionFactory sessionFactory = SessionUtil.obtainSessionFactory(dbFlag);
			sessionFactory.evict(voClass);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}

	public void evict(Serializable id) throws Exception {
		try {
			SessionFactory sessionFactory = SessionUtil.obtainSessionFactory(dbFlag);
			sessionFactory.evict(voClass, id);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}

	public void clearSession() {
		Session session = SessionUtil.currentSession(dbFlag);
		session.clear();
	}

	public Object create(Object vo) throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		try {
			session.save(vo);
			session.flush();
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

	public void removeByPk(Serializable pk) throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		try {
			Object entity = session.get(voClass, pk);
			if (entity != null) {
				session.delete(entity);
				session.flush();
			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}

	/**
	 * ɾ����¼
	 *
	 * @param vo
	 *            Ҫɾ����VO
	 * @throws Exception
	 *             ɾ��ʧ��
	 */
	public void remove(Object vo) throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		try {
			if (vo != null) {
				session.delete(vo);
				session.flush();
			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
	}

	public Object update(Object vo) throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		try {
			session.update(vo);
			session.flush();
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return vo;
	}

	public Object findByPk(Serializable pk) throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
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

	/**
	 * ����������ѯ������¼������
	 */
	public Object findByPkForUpdate(Serializable pk) throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		Object vo = null;
		try {
			vo = (Object) session.get(voClass, pk, LockMode.UPGRADE);
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return vo;
	}

	public Object findByUniqueKey(String uniqueKeyPropertyName, Serializable id)
			throws Exception {
		return findByProperty(uniqueKeyPropertyName, id);
	}

	/**
	 * ����������ѯ������¼������
	 */
	public Object findByUniqueKeyForUpdate(String uniqueKeyPropertyName, Serializable id)
			throws Exception {
		return findByPropertyForUpdate(uniqueKeyPropertyName, id);
	}
	
	public Collection findAll() throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
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

	/**
	 * ȡ�ñ���ĳһ���ֶε����ֵ��������޼�¼�򷵻�null
	 */
	public Object getMaxValue(String prop) throws Exception {
		if (prop != null && prop.trim().length() > 0) {
			StringBuffer sql = new StringBuffer("SELECT max(this.")
					.append(prop).append(") FROM ").append(voClass.getName())
					.append(" this");

			Session session = null;
			try {
				session = SessionUtil.currentSession(dbFlag);
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

	/**
	 * ȡ�ñ���ĳһ���ֶε����ֵ��������޼�¼�򷵻�null
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
				session = SessionUtil.currentSession(dbFlag);
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

	/**
	 * ���ݱ��е�һ���ֶΣ��� prop = value����ѯ���������ĵ�һ����¼ ��ע�⣬�����prop�����������еļ������ԣ�����
	 * many-to-one ��Щ ������Щ������PK������
	 */
	public Object findByProperty(String prop, Object value) throws Exception {
		if (prop != null && prop.trim().length() > 0 && value != null) {
			StringBuffer selectHQL = new StringBuffer("FROM ").append(
					voClass.getName()).append(" this ").append(
					"where this." + prop + " = '" + value.toString() + "'");
			Session session = SessionUtil.currentSession(dbFlag);
			try {
				Query query = session.createQuery(selectHQL.toString());
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
	
	/**
	 * ����������ѯ������¼������
	 */
	public Object findByPropertyForUpdate(String prop, Object value) throws Exception {
		if (prop != null && prop.trim().length() > 0 && value != null) {
			StringBuffer selectHQL = new StringBuffer("FROM ").append(
					voClass.getName()).append(" this ").append(
					"where this." + prop + " = '" + value.toString() + "'");
			Session session = SessionUtil.currentSession(dbFlag);
			try {
				Query query = session.createQuery(selectHQL.toString());
				query.setLockMode("this", LockMode.UPGRADE);
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
	
	
	/**
	 * ���ݱ��е�һ���ֶΣ��� prop = value����ѯ���������ļ�¼�� ��ע�⣬�����prop�����������еļ������ԣ����� many-to-one
	 * ��Щ ������Щ������PK������
	 */
	public int countByProperty(String prop, Object value) throws Exception {
		int count = 0;
		if (prop != null && prop.trim().length() > 0 && value != null) {
			StringBuffer countSQL = new StringBuffer("SELECT count(*) FROM ")
					.append(voClass.getName()).append(" this WHERE this.")
					.append(prop).append(" = :prop ");

			Session session = null;
			try {
				session = SessionUtil.currentSession(dbFlag);
				Query query = session.createQuery(countSQL.toString());
				query.setParameter("prop", value);

				Iterator iter = query.iterate();
				if (iter != null && iter.hasNext()) {
					return ((Integer) iter.next()).intValue();
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
	 * ������ҳ������������Ӧ��ѯ��������where���Ӿ䡣������ҳ���ֶ� _se_name ��ֵΪ gaven�������ɵ������Ӿ�Ϊ��name =
	 * 'gaven'���ж���ֶεģ����������ɵ�������AND��ϵ�� ���һ���ֶ��ж��ֵ�ģ�������ֶ����ɵ�����ΪOR��ϵ�������ﻹδʵ��OR�Ĺ�ϵ��
	 * ��ҳ�ϵ��ֶ�Ҫ��һ�������������ֶ�����ǰ׺ + '_' + �ֶ�����ǰ׺��'_' + ���� + ����
	 *
	 * <pre>
	 *   ǰ׺�б�
	 *   ���� ��  �ǿ�  &lt;   &lt;=   =   &gt;=   &gt;   &lt;&gt;   in   not in
	 *   �ִ� _sn _snn _sl _snm _se _snl _sm _sne _sin _snin
	 *   ���� _nn _nnn _nl _nnm _ne _nnl _nm _nne _nin _nnin
	 *   ���� _dn _dnn _dl _dnm _de _dnl _dm _dne _din _dnin
	 *   �ַ������������㣺
	 *   (like) (not like) (= ���Դ�Сд) (&lt;&gt; ���Դ�Сд) (like ���Դ�Сд) (not like ���Դ�Сд) (start with) (end with)
	 *   _sk    _snk       _sei          _snei         _ski             _snki                _ssw				_sew
	 *   ֱ�ӵ�SQL������
	 *   _sql_
	 * </pre>
	 */
	public DataPackage query(Object params) throws Exception {
		return query(params, QUERY_TYPE_ALL);
	}
	/**
	 *
	 * @param params
	 * @param getRcdCount if set getRcdCount is true then record total will be display
	 * @return
	 * @throws Exception
	 */
	public DataPackage query(Object params,boolean getRcdCount) throws Exception {
		if(getRcdCount){
			return query(params, QUERY_TYPE_ALL);
		}else{
			return queryOnlyRcd(params);
		}

	}

	public int count(Object params) throws Exception {
		DataPackage dp = query(params, QUERY_TYPE_COUNT);
		if (dp != null) {
			return dp.getRowCount();
		} else {
			return -1;
		}
	}
	
	
	/**
	 * ��ѯ����typeΪ10ʱ��ֻ���¼���������������� ��typeΪ0ʱ������������
	 */
	public DataPackage query(Object params, int type) throws Exception {
		return query(params,type,null); //null��ʾ��Ĭ�ϵ���ģʽ
	}
	
	/**
	 * ����������ѯ������¼������
	 * ע��!! �ò�ѯû�з�ҳ����,������з��������ļ�¼��lockס,Ҫ����ʹ��.
	 */
	public DataPackage queryForUpdate(Object params) throws Exception {
		return query(params,QUERY_TYPE_ALL,LockMode.UPGRADE); 
	}
	
	public DataPackage query(Object params, int type, LockMode lockMode) throws Exception {
		StringBuffer countHQL = new StringBuffer("SELECT count(*) FROM ")
				.append(voClass.getName()).append(" this ");

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if(_pagesize>MAX_QUERY_COUNT){
			_pagesize = MAX_QUERY_COUNT; /** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�޸� */
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		try {
			_orderby = (String) BeanUtils.getProperty(params, "_orderby");
		} catch (Exception ex) {
			_orderby = "";
		}

		try {
			_desc = (String) BeanUtils.getProperty(params, "_desc");
		} catch (Exception ex) {
			_desc = "";
		}
		if (_desc == null) {
			_desc = "0"; // Ĭ�ϵ���
		}

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(params, "this",
				placeholders, dateParamList));
		if (whereClause.length() > 4) {
			countHQL = countHQL.append(" WHERE ").append(whereClause);
		}

		// ��ѯ���
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		Session session = SessionUtil.currentSession(dbFlag);
		try {
			// ȡ�ܼ�¼��
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {

				Query query = session.createQuery(countHQL.toString());
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
					result.setRowCount(((Integer) iter.next()).intValue());
				} else {
					result.setRowCount(0);
				}
			}

			// ȡָ��ҳ������
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_DATA) {
				StringBuffer selectHQL = new StringBuffer(buildSelectFileds(params));
                selectHQL.append(" FROM ").append(
						voClass.getName()).append(" this ");
				if (whereClause.toString().trim().length() > 0) {
					selectHQL = selectHQL.append(" WHERE ").append(whereClause);
				}

				if (_orderby != null && _orderby.trim().length() > 0
						&& _desc != null) {
					if (_desc.equals("1")) {
						selectHQL = selectHQL.append(" order by this.").append(
								_orderby).append(" desc ");
					} else {
						selectHQL = selectHQL.append(" order by this.").append(
								_orderby).append(" asc ");
					}
				}

				Query query = session.createQuery(selectHQL.toString());
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
				if(lockMode!=null){
					query.setLockMode("this", lockMode);
				}
				if (_pagesize != 0) {
					/**@todo ���Ľ�,����Ҫ��hibernate3��Դ��(hibernate3.22�������bug)
 					 *  ��Ϊhibernate��bug,��ҳ����ͬʱʹ�ûᵼ�³���,����Ҫ����������*/
					if(lockMode==null){
						query.setMaxResults(_pagesize);
						query.setFirstResult(_pagesize * (_pageno - 1));
					}
				}
				result.setDatas(query.list());
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
     * ��BaseListVO��SelectFieldsָ�����ֶΣ������ѯ���ֶΣ������ѯȫ��
     * @param params BaseListVO
     */
    private String buildSelectFileds(Object params) {
        StringBuffer selectHQL = new StringBuffer("");
        try {
            BaseListVO param = (BaseListVO) params;
            if (params != null && param.getSelectFields() != null){
                Iterator itr = param.getSelectFields().iterator();
                while(itr.hasNext()){
                    if (selectHQL.length() > 0) selectHQL.append(",");
                    selectHQL.append(" this.").append(itr.next());
                }
            }
            String head = "SELECT NEW " + voClass.getName() + "(";
            if (selectHQL.length() > 0) selectHQL.insert(0,head).append(")");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectHQL.toString();
    }

    /**
     * ��ѯ��ֻ����������
     */
    private DataPackage queryOnlyRcd(Object params) throws Exception {

        int _pagesize = 20, _pageno = 1;
        String _orderby = null, _desc = null;
        try {
            _pagesize = Integer.parseInt((String) BeanUtils.getProperty(params,
                    "_pagesize"));
        } catch (Exception ex) {
            _pagesize = Integer.MAX_VALUE;
        }
        if(_pagesize>MAX_QUERY_COUNT){
            _pagesize = MAX_QUERY_COUNT; /** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�޸� */
        }

        try {
            _pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
                    "_pageno"));
        } catch (Exception ex) {
            _pageno = 1;
        }

        try {
            _orderby = (String) BeanUtils.getProperty(params, "_orderby");
        } catch (Exception ex) {
            _orderby = "";
        }

        try {
            _desc = (String) BeanUtils.getProperty(params, "_desc");
        } catch (Exception ex) {
            _desc = "";
        }
        if (_desc == null) {
            _desc = "0"; // Ĭ�ϵ���
        }

        Map placeholders = new HashMap();
        List dateParamList = new ArrayList();
        StringBuffer whereClause = new StringBuffer(buildHQL(params, "this",
                placeholders, dateParamList));

        // ��ѯ���
        DataPackage result = new DataPackage();
        result.setPageNo(_pageno);
        result.setPageSize(_pagesize);

        Session session = SessionUtil.currentSession(dbFlag);
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
                    selectHQL = selectHQL.append(" order by this.").append(
                            _orderby).append(" desc ");
                } else {
                    selectHQL = selectHQL.append(" order by this.").append(
                            _orderby).append(" asc ");
                }
            }

            Query query = session.createQuery(selectHQL.toString());
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

            result.setDatas(query.list());
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
     * ����ѯ����
     */
    public DataPackage query2(Object params[], Class vo[], String joins[][])
			throws Exception {
		return query2(params, vo, joins, QUERY_TYPE_ALL);
	}

	public DataPackage query2(Object params[], Class vo[], String joins[][],
			int type) throws Exception {

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;

		if (params == null || vo == null || joins == null) {
			throw new Exception("error paramters !");
		}
		if (params.length != vo.length || joins[0].length != vo.length) {
			throw new Exception("error paramters num!");
		}

		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(
					params[0], "_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if(_pagesize>MAX_QUERY_COUNT){
			_pagesize = MAX_QUERY_COUNT; /** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�޸� */
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(
					params[0], "_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		try {
			_orderby = (String) BeanUtils.getProperty(params[0], "_orderby");
		} catch (Exception ex) {
			_orderby = "";
		}
		try {
		} catch (Exception ex) {
			_desc = "";
		}

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer condition = new StringBuffer();
		StringBuffer strjoins = new StringBuffer();
		StringBuffer fromClause = new StringBuffer("FROM ");
		for (int i = 0; i < vo.length; i++) {
			fromClause.append(vo[i].getName()).append(" t").append(i).append(
					",");
			if (params[i] != null && !"".equals(params[i])) {
				String where = buildHQL(params[i], "t" + i, placeholders,
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
					strjoins.append("t").append(j).append(".").append(
							joins[i][j]).append("=");
				}
			}
			if (strjoins.length() > 1) {
				strjoins.deleteCharAt(strjoins.length() - 1);
				strjoins.append(" ");
			}
		}
		fromClause.append(" where 1=1 ").append(strjoins).append(condition);
		// System.out.println(fromClause.toString());

		if (_desc == null) {
			_desc = "0"; // Ĭ�ϵ���
		}

		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		Session session = SessionUtil.currentSession(dbFlag);
		try {
			// ȡ�ܼ�¼��
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {
				String countHQL = "select count(*) " + fromClause;
				Query query = session.createQuery(countHQL.toString());
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
					result.setRowCount(((Integer) iter.next()).intValue());
				} else {
					result.setRowCount(0);
				}
			}

			// ȡָ��ҳ������
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_DATA) {

				if (_orderby != null && _orderby.trim().length() > 0
						&& _desc != null) {
					if (_desc.equals("1")) {
						fromClause = fromClause.append(" order by t0.").append(
								_orderby).append(" desc ");
					} else {
						fromClause = fromClause.append(" order by t0.").append(
								_orderby).append(" asc ");
					}
				}

				Query query = session.createQuery(fromClause.toString());
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
				result.setDatas(query.list());
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return result;
	}

	public String buildHQL(Object params, String prefix, Map placeholders,
			List dateParamList) throws Exception {
		return buildHQL(params, prefix, placeholders, dateParamList, 1);
	}

	public String buildHQL(Object params, String prefix, Map placeholders,
			List dateParamList, int ph) throws Exception {
		
		//He Kun 2008-1-28 �жϣ����ֻʹ�� queryConditions �еĹ̶�����������Զ�̬���������Ҳ�����where�־䡣
		if(params instanceof BaseListVO) {
			BaseListVO listVO = (BaseListVO)params;
			if(listVO.isUseFixedParamOnly())
				return "";
		}
		
		StringBuffer whereClause = new StringBuffer();
		// int ph = 1;

		if (prefix == null) {
			prefix = "";
		}

		if (prefix.trim().length() > 0) {
			prefix = prefix + ".";
		}

		

		String key, field;
		Object value;

		Map props = getConditions(params);

		// Ϊ��ѯ��������ʹ�÷���������ListVO��_firstitems���ԣ�����
		// listVO.set_firstitems("_ne_xxx,_se_yyy");
		// ��ô���ɵ�sql����й���_ne_xxx��_se_yyy�������������У��ͻ�����ǰ��λ��
		// ----add by lwl
		List orderedKeys = getOrderedKeyset(props.keySet(), params);
		
		for (Iterator iter = orderedKeys.iterator(); iter.hasNext();) {
			key = (String) iter.next();
			// value = props.get(key)!=null ? String.valueOf( props.get(key) ) :
			// null;
			if (props.get(key) != null && props.get(key) instanceof Collection) {
				value = props.get(key);
			} else {
				value = props.get(key) != null ? String.valueOf(props.get(key))
						: null;
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
				}else if (key.startsWith("_sew_")) {
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
		}

		if (whereClause.length() > 4) {
			whereClause = whereClause.delete(whereClause.length() - 4,
					whereClause.length() - 1);
		}

		return whereClause.toString();
	}

	protected Map getConditions(Object params) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		// ��̬��������
		Map props = com.sunrise.boss.common.utils.bean.BeanUtils
				.describe(params);

		// new ��̬�������� add by hekun
		if (params instanceof BaseListVO) {
			BaseListVO listVO = (BaseListVO) params;
			
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

	public java.util.Date getCurrentTime() throws Exception {
		String sql = "select sysdate from dual";
		Session session = SessionUtil.currentSession(dbFlag);
		SQLQuery query = session.createSQLQuery(sql);
		query.addScalar("sysdate", Hibernate.TIMESTAMP);
		// Hibernate.
		List ret = query.list();
		if (ret.size() > 0) {
			return (Date) ret.get(0);
		}
		return null;
	}

	protected List getOrderedKeyset(Set keys, Object params) throws Exception {
		List orderedKeyset = new ArrayList();
		if (keys.size() > 0) {
			String firstitems = (String) BeanUtils.getProperty(params,
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

//	public static void main(String[] args) throws Exception {
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
//	}
	

	public Object queryUniqueByNamedSqlQuery(String name,Object params) throws Exception {
		return queryUniqueByNamedSqlQuery(name, params, Integer.class);
	}
	/**
	 * �����õ�named Sql Query ���в�ѯ����ѯΨһ���
	 * @param name  hbm.xml �����õ� Sql Query ������
	 * @return
	 * @throws Exception
	 */
	public Object queryUniqueByNamedSqlQuery(String name,Object params,Class returnType) throws Exception {
		Session session = SessionUtil.currentSession( getDbFlag() );
		
		SQLQuery query = (SQLQuery)session.getNamedQuery(name);
		String queryString = query.getQueryString();	
		
		return queryUniqueBySql(queryString,params,returnType);
	}
	
	/**
	 * �����õ�named Sql Query ���в�ѯ, ֻ��ѯ��¼��������ȡ���� DataPackage.getRowCount()
	 * @param name
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryCountByNamedSqlQuery(String name,Object params) throws Exception {
		return queryByNamedSqlQuery(name, params,QUERY_TYPE_COUNT);
	}
	
	/**
	 * �����õ�named Sql Query ���в�ѯ�� ��¼������¼���϶���ѯ, �޸��Ӳ�ѯ��������¼���ϲ���ҳ��ȫ���鴦��
	 * @param name  hbm.xml �����õ� Sql Query ������
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByNamedSqlQuery(String name) throws Exception {
		return queryByNamedSqlQuery(name, new BaseListVO());
	}
	
	/**
	 * �����õ�named Sql Query ���в�ѯ�� ��¼������¼���϶���ѯ����params�е��������з�ҳ������
	 * @param name  hbm.xml �����õ� Sql Query ������
	 * @param params ����ListVO�淶�Ĳ�ѯ��������
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByNamedSqlQuery(String name,Object params) throws Exception {
		return queryByNamedSqlQuery(name, params,QUERY_TYPE_ALL);
	}
	
	/**
	 * �����õ�named Sql Query ���в�ѯ��
	 * @param name hbm.xml �����õ� Sql Query ������
	 * @param params ����ListVO�淶�Ĳ�ѯ��������
	 * @param type ��ѯ���ͣ���ѯ��¼��(QUERY_TYPE_COUNT),��ѯ��¼(QUERY_TYPE_DATA),���߶���ѯ(QUERY_TYPE_ALL)
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByNamedSqlQuery(String name,Object params, int type) throws Exception {
		Session session = SessionUtil.currentSession( getDbFlag() );
		
		SQLQuery query = (SQLQuery)session.getNamedQuery(name);
		String queryString = query.getQueryString();
		
		return queryBySql(queryString, params, type);
	}
	
	/**
	 * ����sql���в�ѯ. ��ѯΨһ�����
	 * @param sql Ҫ��ѯ��sql���
	 * @return
	 * @throws Exception
	 */
	public Object queryUniqueBySql(String queryString, Object params,Class returnType) throws Exception {
		
		Session session = SessionUtil.currentSession( getDbFlag() );
			
		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(params, " ",placeholders, dateParamList));
		
		StringBuffer queryStringBuffer = new StringBuffer(queryString);
		if (queryString.toLowerCase().indexOf("where ") < 0 && whereClause.length() > 4) {
			queryStringBuffer.append(" where ").append(whereClause);
		}else if(queryString.toLowerCase().indexOf("where ") >= 0 && whereClause.length() > 0 ){ //��ѯ����Ѿ�����where
			queryStringBuffer.append(" and ").append(whereClause);
		}
		
		Type hibernateType = toHibernateType(returnType);
		SQLQuery query = session.createSQLQuery(queryStringBuffer.toString()).addScalar("val", hibernateType);
		
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
	
		if(params instanceof BaseListVO) {
			BaseListVO listVO = (BaseListVO)params;
			listVO.set_pagesize("0");
			listVO.set_orderby(null);
		}
		setQueryNamedParameters(query, params);
		
		List list = (List)query.list();
		if(list.size()> 1)
			throw new NonUniqueResultException(list.size());
		if(list.size() > 0 )
			return list.get(0);
		else
			throw new NonUniqueResultException(0);
	}
	
	private void setQueryNamedParameters(Query query,Object params) throws Exception {

		String[] parameters = query.getNamedParameters();
		Map parametersMap = new HashMap();
		for (int i = 0; i < parameters.length; i++) {
			parametersMap.put(parameters[i],null);
		}
		
		Map props = null;
		if(params instanceof BaseListVO) {
			props = getConditions(params);
		}else if(params instanceof Map) {
			props = (Map)params;
		}
		
		if(props == null) return;
		
		Set orderedKeys = props.keySet();
		String key = null;
		Object value = null;
		for (Iterator iter = orderedKeys.iterator(); iter.hasNext();) {
			key = (String) iter.next();

			if(!parametersMap.containsKey(key))
				continue;
			
			value = props.get(key);				
			if (value == null) continue;	
			
			if(parametersMap.containsKey(key)){
				if(value instanceof Collection){
					query.setParameterList(key, (Collection)value);
				}else{
					query.setParameter(key, value);
				}				
			}
		}
	}
	
	private Type toHibernateType(Class returnType) {
		
		if		(returnType.equals(String.class)) {
			return Hibernate.STRING;
		}else if(returnType.equals(Long.class)) {
			return Hibernate.LONG;
		}else if(returnType.equals(Integer.class)) {
			return Hibernate.INTEGER;
		}else if(returnType.equals(Short.class)) {
			return Hibernate.SHORT;
		}else if(returnType.equals(Byte.class)) {
			return Hibernate.BYTE;
		}else if(returnType.isAssignableFrom(Date.class)) {
			return Hibernate.DATE;
		}else {
			throw new UnsupportedOperationException("Unsupported type " + returnType.getName());
		}
	}

	/**
	 * ����sql���в�ѯ. ��¼������¼�������߶���ѯ
	 * @param sql Ҫ��ѯ��sql���
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryBySql(String queryString) throws Exception {
		return queryBySql(queryString, new BaseListVO());

	}
	/**
	 * ����sql���в�ѯ. ��¼������¼�������߶���ѯ
	 * @param sql Ҫ��ѯ��sql���
	 * @param params  ����ListVO�淶�Ĳ�ѯ�������� 
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryBySql(String queryString,Object params) throws Exception {
		return queryBySql(queryString, params, QUERY_TYPE_ALL);

	}

	/**
	 * ����sql���в�ѯ
	 * @param sql Ҫ��ѯ��sql���
	 * @param params  ����ListVO�淶�Ĳ�ѯ��������
	 * @param type ��ѯ���ͣ���ѯ��¼��(QUERY_TYPE_COUNT),��ѯ��¼(QUERY_TYPE_DATA),���߶���ѯ(QUERY_TYPE_ALL)
	 * @return
	 * @throws Exception
	 */
	protected DataPackage queryBySql(String queryString,Object params, int type) throws Exception {				
		Session session = SessionUtil.currentSession( getDbFlag() );
		StringBuffer countSQL = new StringBuffer("SELECT count(*) total FROM (").append( queryString ).append(") this ");
		
		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(params,"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if(_pagesize>MAX_QUERY_COUNT){
			_pagesize = MAX_QUERY_COUNT; /** @todo ��һ����ѯ�������ƣ��Ժ���Ҫ�޸� */
		}
		
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}
		
		try {
			_orderby = (String) BeanUtils.getProperty(params, "_orderby");
		} catch (Exception ex) {
			_orderby = "";
		}
		
		try {
			_desc = (String) BeanUtils.getProperty(params, "_desc");
		} catch (Exception ex) {
			_desc = "";
		}
		if (_desc == null) {
			_desc = "0"; // Ĭ�ϵ���
		}
		
		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(params, "this",
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
		
				SQLQuery countQuery = session.createSQLQuery(countSQL.toString());
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
				
				setQueryNamedParameters(countQuery, params);
				
				countQuery.addScalar("total", new IntegerType());			
				result.setRowCount(((Integer)countQuery.uniqueResult()).intValue());			
			}
		
			// ȡָ��ҳ������
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_DATA) {
//				StringBuffer selectSQL = new StringBuffer("select * from ( ").append( queryString).append(") this ");
				
				StringBuffer selectSQL = new StringBuffer(300);
				Query sqlQuery = null;
				
				selectSQL.append("select ");
					
				ClassMetadata class1 = session.getSessionFactory().getClassMetadata( voClass.getName());
				String[] pks = getPKs();
				String[] names = class1.getPropertyNames();
				
				for(int i=0;i<pks.length; i++) {
					selectSQL.append(" this.").append(pks[i].toUpperCase()).append(" as ").append(" {ttt.").append(pks[i]).append("}");					
					if(i < pks.length -1)	selectSQL.append(",");
				}
				
				if(names.length > 0) selectSQL.append(", ");
				
				for (int i = 0; i < names.length; i++) {
					String colName = names[i];
					
					selectSQL.append(" this.").append(colName.toUpperCase()).append(" as ").append(" {ttt.").append(colName).append("}");
					if(i < (names.length - 1))
						selectSQL.append(", ");
				}
				
				selectSQL.append(" from (").append( queryString ).append(" ) this  ");
				
				if (whereClause.toString().trim().length() > 0) {
					selectSQL = selectSQL.append(" WHERE ").append(whereClause);
				}
		
				if (_orderby != null && _orderby.trim().length() > 0 && _desc != null) {
					if (_desc.equals("1")) {
						selectSQL = selectSQL.append(" order by this.").append(	_orderby).append(" desc ");
					} else {
						selectSQL = selectSQL.append(" order by this.").append(	_orderby).append(" asc ");
					}
				}
				
				sqlQuery = session.createSQLQuery( selectSQL.toString() ).addEntity("ttt", voClass);
				
				setQueryNamedParameters(sqlQuery, params);
				
				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								sqlQuery.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								sqlQuery.setTimestamp(key, ts);
							}
						} else {
							sqlQuery.setParameter(key, value);
						}
					}
				}
		
				if (_pagesize != 0) {
					sqlQuery.setMaxResults(_pagesize);
					sqlQuery.setFirstResult(_pagesize * (_pageno - 1));
				}
				
				List list = new ArrayList(0);
				list = sqlQuery.list();
				
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
	 * ��ȡʵ������������ƣ�֧�ֶ�����
	 * @param params
	 * @return
	 * @throws Exception
	 */
	 protected String[] getPKs() throws Exception {	    	
	    	Session session = SessionUtil.currentSession(getDbFlag());
	    	
	    	ClassMetadata metadata = session.getSessionFactory().getClassMetadata(this.voClass);
	    	
	    	Type type =  metadata.getIdentifierType();    	
	    	
	    	String[] pkNames = null;
	    	if( !(type instanceof AbstractComponentType)) {
	    		String pkName = metadata.getIdentifierPropertyName();	
	    		pkNames = new String[1];
	    		pkNames[0] = pkName;
	    		
	    	}else {
	    		AbstractComponentType aType = (AbstractComponentType)type;        	
	        	pkNames = aType.getPropertyNames();
	    	}
	    	return pkNames;
	}
	  
	/**
     * ����SEQUENCE����ȡ��seq nextval��ֵ
     * @param seq
     */
    public Object getSequence(String seqname) throws Exception {    	
    	if(StringUtils.isBlank(seqname)) return null;        
        StringBuffer sql = new StringBuffer("SELECT ").append(seqname).append(".NEXTVAL val FROM dual");        
        Long seq = (Long)queryUniqueBySql(sql.toString(), null, Long.class);
        return seq;        
    }
}
