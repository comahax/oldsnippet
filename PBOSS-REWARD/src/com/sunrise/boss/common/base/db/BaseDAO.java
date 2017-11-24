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
 * Title: BaseDAO for Hibernate, Hibernate版的DAO基类
 * </p>
 * <p>
 * Description: 封装数据库的操作，提供基本的增、删、改、查的方法
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
 * @version 1.1 HuangBaiming 2005-11-17 hibernate2 改到 hibernate3
 * @version 1.2 HuangBaiming 2006-8-17 删除多余注释，对Date类型作特殊处理，删除两表关联查询（不成熟的实现）
 * @version 1.3 hekun 2007-1-10 封装复杂查询接口,简化复杂查询开发.
 * @version 1.4 HuangBaiming 2007-4-3 添加锁定记录的查询方法,方法名xxxForUpdate()
 * @version 1.5 He Kun 2007-12-12 修正 queryUniqueByNamedSqlQuery 不支持绑定listvo 动态参数的bug
 * 
 */
public class BaseDAO {
	/**
	 * 查询类型,查询所有内容
	 */
	public static final int QUERY_TYPE_ALL = 0;

	public static final int QUERY_TYPE_COUNT = 10;

	public static final int QUERY_TYPE_DATA = 20;

	public static final int MAX_QUERY_COUNT = 10000;/** @todo 做一个查询量的限制，以后需要改进 */

	protected Class voClass;
	
	public Class getVoClass(){
		return voClass;
	}

	public void setVoClass(Class voClass){
		this.voClass = voClass;
	}
	
	/**
	 * 调用该方法构造的DAO，必需先setDbFlag（），才能调用方法。
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
	 * 清除缓存中的内容
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
			 * 一般来说，Hibernate处理异常时都用HibernateException包装之后抛出，
			 * 这里尝试解开HibernateException的包装，出示真正的错误原因。
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
	 * 删除记录
	 *
	 * @param vo
	 *            要删除的VO
	 * @throws Exception
	 *             删除失败
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
	 * 具有锁定查询出来记录的能力
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
	 * 具有锁定查询出来记录的能力
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
	 * 取得表中某一个字段的最大值，如表中无记录则返回null
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
	 * 取得表中某一个字段的最大值，如表中无记录则返回null
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
	 * 根据表中的一个字段，按 prop = value，查询符合条件的第一条记录 但注意，这里的prop不适用于所有的集合属性，例如
	 * many-to-one 那些 除非这些属性用PK关联。
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
	 * 具有锁定查询出来记录的能力
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
	 * 根据表中的一个字段，按 prop = value，查询符合条件的记录数 但注意，这里的prop不适用于所有的集合属性，例如 many-to-one
	 * 那些 除非这些属性用PK关联。
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
	 * 根据网页的请求，生成相应查询的条件（where）子句。例如网页上字段 _se_name 的值为 gaven，则生成的条件子句为：name =
	 * 'gaven'。有多个字段的，则它们生成的条件是AND关系， 如果一个字段有多个值的，则这个字段生成的条件为OR关系。（这里还未实现OR的关系）
	 * 网页上的字段要求一定的命名规则，字段名：前缀 + '_' + 字段名，前缀：'_' + 类型 + 运算
	 *
	 * <pre>
	 *   前缀列表：
	 *   类型 空  非空  &lt;   &lt;=   =   &gt;=   &gt;   &lt;&gt;   in   not in
	 *   字串 _sn _snn _sl _snm _se _snl _sm _sne _sin _snin
	 *   数字 _nn _nnn _nl _nnm _ne _nnl _nm _nne _nin _nnin
	 *   日期 _dn _dnn _dl _dnm _de _dnl _dm _dne _din _dnin
	 *   字符串的特殊运算：
	 *   (like) (not like) (= 忽略大小写) (&lt;&gt; 忽略大小写) (like 忽略大小写) (not like 忽略大小写) (start with) (end with)
	 *   _sk    _snk       _sei          _snei         _ski             _snki                _ssw				_sew
	 *   直接的SQL条件：
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
	 * 查询，当type为10时，只查记录数，不查具体的数据 而type为0时，则两样都查
	 */
	public DataPackage query(Object params, int type) throws Exception {
		return query(params,type,null); //null表示用默认的锁模式
	}
	
	/**
	 * 具有锁定查询出来记录的能力
	 * 注意!! 该查询没有分页功能,会把所有符合条件的记录都lock住,要谨慎使用.
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
			_pagesize = MAX_QUERY_COUNT; /** @todo 做一个查询量的限制，以后需要修改 */
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
			_desc = "0"; // 默认递增
		}

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(params, "this",
				placeholders, dateParamList));
		if (whereClause.length() > 4) {
			countHQL = countHQL.append(" WHERE ").append(whereClause);
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		Session session = SessionUtil.currentSession(dbFlag);
		try {
			// 取总记录数
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {

				Query query = session.createQuery(countHQL.toString());
				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// 针对日期做特殊判断
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

				Iterator iter = query.iterate(); // hibernate3的写法
				if (iter != null && iter.hasNext()) {
					result.setRowCount(((Integer) iter.next()).intValue());
				} else {
					result.setRowCount(0);
				}
			}

			// 取指定页的数据
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
						// 针对日期做特殊判断
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
					/**@todo 待改进,可能要改hibernate3的源码(hibernate3.22还有这个bug)
 					 *  因为hibernate的bug,分页和锁同时使用会导致出错,所以要做下面限制*/
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
     * 以BaseListVO中SelectFields指定的字段，构造查询的字段，空则查询全部
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
     * 查询，只查具体的数据
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
            _pagesize = MAX_QUERY_COUNT; /** @todo 做一个查询量的限制，以后需要修改 */
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
            _desc = "0"; // 默认递增
        }

        Map placeholders = new HashMap();
        List dateParamList = new ArrayList();
        StringBuffer whereClause = new StringBuffer(buildHQL(params, "this",
                placeholders, dateParamList));

        // 查询结果
        DataPackage result = new DataPackage();
        result.setPageNo(_pageno);
        result.setPageSize(_pagesize);

        Session session = SessionUtil.currentSession(dbFlag);
        try {
            // 不取总记录数
            // modifyed by Ge Aiping on 25-Oct-2006
            result.setRowCount(0);
            // 取指定页的数据
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
                    // 针对日期做特殊判断
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
     * 多表查询方法
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
			_pagesize = MAX_QUERY_COUNT; /** @todo 做一个查询量的限制，以后需要修改 */
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
			_desc = "0"; // 默认递增
		}

		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		Session session = SessionUtil.currentSession(dbFlag);
		try {
			// 取总记录数
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {
				String countHQL = "select count(*) " + fromClause;
				Query query = session.createQuery(countHQL.toString());
				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// 针对日期做特殊判断
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

				Iterator iter = query.iterate(); // hibernate3的写法
				if (iter != null && iter.hasNext()) {
					result.setRowCount(((Integer) iter.next()).intValue());
				} else {
					result.setRowCount(0);
				}
			}

			// 取指定页的数据
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
						// 针对日期做特殊判断
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
		
		//He Kun 2008-1-28 判断，如果只使用 queryConditions 中的固定参数，则忽略动态参数，并且不生成where字句。
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

		// 为查询条件排序，使用方法是设置ListVO的_firstitems属性，比如
		// listVO.set_firstitems("_ne_xxx,_se_yyy");
		// 那么生成的sql语句中关于_ne_xxx、_se_yyy的条件（假如有）就会排在前两位。
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

			// 忽略无值的参数
			if (value == null) {
				continue;
			}

			// 对于余下的检查是否符合规则
			try {
				field = key.substring(key.indexOf('_', 1) + 1);
			} catch (Exception ex) {
				continue;
			}

			// null条件的处理
			if (key.startsWith("_sn_") || key.startsWith("_dn_")
					|| key.startsWith("_nn_")) {
				whereClause = whereClause.append("(" + prefix + field
						+ " is null) and ");
			} else if (key.startsWith("_snn_") || key.startsWith("_dnn_")
					|| key.startsWith("_nnn_")) {
				whereClause = whereClause.append("(" + prefix + field
						+ " is not null) and ");
			} else {
				// 非 null条件的，参数必须有值
				if (value instanceof Collection) {
					if (((Collection) value).size() <= 0) {
						continue;
					}
				} else {
					if (value.toString().trim().length() <= 0) {
						continue;
					}
				}
				// 对日期类型做特殊处理，所以先保存下对应的参数名，例如k1，k2等
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

		// 静态条件部分
		Map props = com.sunrise.boss.common.utils.bean.BeanUtils
				.describe(params);

		// new 动态条件部分 add by hekun
		if (params instanceof BaseListVO) {
			BaseListVO listVO = (BaseListVO) params;
			
			Map queryConditions = listVO.getQueryConditions();

			if (queryConditions != null && queryConditions.size() > 0) {
				// 将静态条件加入动态条件中，重复的动态条件及其值将被覆盖。
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
	 *            true代表SQL中的in，false代表SQL中的not in
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
		// 测试keys的排序用
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
	 * 按配置的named Sql Query 进行查询，查询唯一结果
	 * @param name  hbm.xml 中配置的 Sql Query 的名称
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
	 * 按配置的named Sql Query 进行查询, 只查询记录总数。获取方法 DataPackage.getRowCount()
	 * @param name
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryCountByNamedSqlQuery(String name,Object params) throws Exception {
		return queryByNamedSqlQuery(name, params,QUERY_TYPE_COUNT);
	}
	
	/**
	 * 按配置的named Sql Query 进行查询。 记录数，记录集合都查询, 无附加查询条件，记录集合不分页，全部查处。
	 * @param name  hbm.xml 中配置的 Sql Query 的名称
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByNamedSqlQuery(String name) throws Exception {
		return queryByNamedSqlQuery(name, new BaseListVO());
	}
	
	/**
	 * 按配置的named Sql Query 进行查询。 记录数，记录集合都查询。按params中的条件进行分页，排序。
	 * @param name  hbm.xml 中配置的 Sql Query 的名称
	 * @param params 符合ListVO规范的查询参数对象。
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByNamedSqlQuery(String name,Object params) throws Exception {
		return queryByNamedSqlQuery(name, params,QUERY_TYPE_ALL);
	}
	
	/**
	 * 按配置的named Sql Query 进行查询。
	 * @param name hbm.xml 中配置的 Sql Query 的名称
	 * @param params 符合ListVO规范的查询参数对象。
	 * @param type 查询类型：查询记录数(QUERY_TYPE_COUNT),查询记录(QUERY_TYPE_DATA),两者都查询(QUERY_TYPE_ALL)
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
	 * 根据sql进行查询. 查询唯一结果。
	 * @param sql 要查询的sql语句
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
		}else if(queryString.toLowerCase().indexOf("where ") >= 0 && whereClause.length() > 0 ){ //查询语句已经包含where
			queryStringBuffer.append(" and ").append(whereClause);
		}
		
		Type hibernateType = toHibernateType(returnType);
		SQLQuery query = session.createSQLQuery(queryStringBuffer.toString()).addScalar("val", hibernateType);
		
		if (placeholders != null && placeholders.size() > 0) {
			Set keyset = placeholders.keySet();
			for (Iterator it = keyset.iterator(); it.hasNext();) {
				String key = (String) it.next();
				Object value = placeholders.get(key);
				// 针对日期做特殊判断
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
	 * 根据sql进行查询. 记录数，记录集合两者都查询
	 * @param sql 要查询的sql语句
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryBySql(String queryString) throws Exception {
		return queryBySql(queryString, new BaseListVO());

	}
	/**
	 * 根据sql进行查询. 记录数，记录集合两者都查询
	 * @param sql 要查询的sql语句
	 * @param params  符合ListVO规范的查询参数对象。 
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryBySql(String queryString,Object params) throws Exception {
		return queryBySql(queryString, params, QUERY_TYPE_ALL);

	}

	/**
	 * 根据sql进行查询
	 * @param sql 要查询的sql语句
	 * @param params  符合ListVO规范的查询参数对象。
	 * @param type 查询类型：查询记录数(QUERY_TYPE_COUNT),查询记录(QUERY_TYPE_DATA),两者都查询(QUERY_TYPE_ALL)
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
			_pagesize = MAX_QUERY_COUNT; /** @todo 做一个查询量的限制，以后需要修改 */
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
			_desc = "0"; // 默认递增
		}
		
		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(params, "this",
				placeholders, dateParamList));
		if (whereClause.length() > 4) {
			countSQL = countSQL.append(" WHERE ").append(whereClause);
		}
		
		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);
	
		try {
			// 取总记录数
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {
		
				SQLQuery countQuery = session.createSQLQuery(countSQL.toString());
				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// 针对日期做特殊判断
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
		
			// 取指定页的数据
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
						// 针对日期做特殊判断
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
	 * 获取实体类的主键名称，支持多主键
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
     * 根据SEQUENCE名称取得seq nextval的值
     * @param seq
     */
    public Object getSequence(String seqname) throws Exception {    	
    	if(StringUtils.isBlank(seqname)) return null;        
        StringBuffer sql = new StringBuffer("SELECT ").append(seqname).append(".NEXTVAL val FROM dual");        
        Long seq = (Long)queryUniqueBySql(sql.toString(), null, Long.class);
        return seq;        
    }
}
