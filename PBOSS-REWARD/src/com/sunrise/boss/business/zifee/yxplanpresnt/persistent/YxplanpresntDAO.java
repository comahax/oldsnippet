/**
 * auto-generated code
 * Tue Sep 18 15:52:13 CST 2007
 */
package com.sunrise.boss.business.zifee.yxplanpresnt.persistent;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>
 * Title: YxplanpresntDAO
 * </p>
 * <p>
 * Description: Data Access Object for YxplanpresntVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class YxplanpresntDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public YxplanpresntDAO() {
		super(YxplanpresntVO.class);
	}

	public DataPackage query(Object params, int type, LockMode lockMode)
			throws Exception {
		StringBuffer countHQL = new StringBuffer("SELECT count(*) FROM ")
				.append(voClass.getName()).append(" this ");

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		String orderby[] = null, desc[] = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if (_pagesize > MAX_QUERY_COUNT) {
			_pagesize = MAX_QUERY_COUNT;
			/** @todo 做一个查询量的限制，以后需要修改 */
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

		Session session = SessionUtil.currentSession(getDbFlag());
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
				StringBuffer selectHQL = new StringBuffer("");
				selectHQL.append(" FROM ").append(voClass.getName()).append(
						" this ");
				if (whereClause.toString().trim().length() > 0) {
					selectHQL = selectHQL.append(" WHERE ").append(whereClause);
				}

				if (_orderby != null && _orderby.trim().length() > 0
						&& _desc != null) {
					String sp = " ";
					if (StringUtils.indexOf(_desc, ",") != -1
							&& StringUtils.indexOf(_orderby, ",") != -1) {
						orderby = StringUtils.splitPreserveAllTokens(_orderby,
								",");
						desc = StringUtils.splitPreserveAllTokens(_desc, ",");
						selectHQL = selectHQL.append(" order by this. ")
								.append(orderby[0]).append(sp).append(desc[0])
								.append(",").append("this.").append(orderby[1])
								.append(sp).append(desc[1]).append(sp);
					} else if (_desc.equals("1")) {
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
				if (lockMode != null) {
					query.setLockMode("this", lockMode);
				}
				if (_pagesize != 0) {
					/**
					 * @todo 待改进,可能要改hibernate3的源码(hibernate3.22还有这个bug)
					 *       因为hibernate的bug,分页和锁同时使用会导致出错,所以要做下面限制
					 */
					if (lockMode == null) {
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

}
