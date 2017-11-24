package com.sunrise.boss.business.cms.common;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * @author baiming
 * 
 */
public class QueryUtil {

	private String dbFlag;

	public QueryUtil(String dbFlag) {
		this.dbFlag = dbFlag;
		// 默认情况下，不分页，不排序
		_pagesize = 0;
		_pageno = 1;
		_orderby = null;
		_desc = null;
	}

	private int _pagesize;

	private int _pageno;

	private String _orderby;

	private String _desc;

	public String get_desc() {
		return this._desc;
	}

	public void set_desc(String _desc) {
		this._desc = _desc;
	}

	public String get_orderby() {
		return this._orderby;
	}

	public void set_orderby(String _orderby) {
		this._orderby = _orderby;
	}

	public int get_pageno() {
		return this._pageno;
	}

	public void set_pageno(int _pageno) {
		this._pageno = _pageno;
	}

	public int get_pagesize() {
		return this._pagesize;
	}

	public void set_pagesize(int _pagesize) {
		this._pagesize = _pagesize;
	}

	public DataPackage query(String queryHQL) throws Exception {
		return query(queryHQL, null, null);
	}

	public DataPackage query(String queryHQL, HashMap param) throws Exception {
		return query(queryHQL, null, param);
	}

	/**
	 * 查询总条数使用原生SQL语句
	 * 
	 * @param queryHQL
	 * @param countSQL
	 * @param entityName--实体对象别名
	 * @param entityClass---实体对象类
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage query(String queryHQL, String countSQL,
			String entityName, Class entityClass, HashMap param)
			throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		// 设置排序条件
		if (_orderby != null && _orderby.trim().length() > 0) {
			StringBuffer strBuffer = new StringBuffer(queryHQL);
			if ("1".equals(_desc)) {
				queryHQL = strBuffer.append(" order by ").append(_orderby)
						.append(" desc ").toString();
			} else {
				queryHQL = strBuffer.append(" order by ").append(_orderby)
						.append(" asc ").toString();
			}
		}

		// 结果
		DataPackage result = new DataPackage();

		// 查询总数
		if (countSQL != null) {
			SQLQuery countQuery = session.createSQLQuery(countSQL).addEntity(entityName, entityClass);

			if (param != null) {
				Iterator iter2 = param.keySet().iterator();
				while (iter2.hasNext()) {
					String key = (String) iter2.next();
					Object value = param.get(key);
					countQuery.setParameter(key, value);
				}
			}
			Iterator iter = countQuery.list().iterator();
			if (iter != null && iter.hasNext()) {
				result.setRowCount(((Integer) iter.next()).intValue());
			} else {
				result.setRowCount(0);
			}
		}

		Query query = session.createQuery(queryHQL);
		if (param != null) {
			Iterator iter2 = param.keySet().iterator();
			while (iter2.hasNext()) {
				String key = (String) iter2.next();
				Object value = param.get(key);
				query.setParameter(key, value);
			}
		}

		if (_pagesize > 0 && _pageno >= 1) {
			result.setPageNo(_pageno);
			result.setPageSize(_pagesize);

			query.setMaxResults(_pagesize);
			query.setFirstResult(_pagesize * (_pageno - 1));
		}

		result.setDatas(query.list());
		return result;
	}

	/**
	 * 
	 * @param queryHQL
	 *            example: FROM XxxxVO as xxxx
	 * @param countHQL
	 *            example: SELECT count(*) FROM XxxxVO as xxxx
	 * @return
	 * @throws Exception
	 */
	public DataPackage query(String queryHQL, String countHQL, HashMap param)
			throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		// 设置排序条件
		if (_orderby != null && _orderby.trim().length() > 0) {
			StringBuffer strBuffer = new StringBuffer(queryHQL);
			if ("1".equals(_desc)) {
				queryHQL = strBuffer.append(" order by ").append(_orderby)
						.append(" desc ").toString();
			} else {
				queryHQL = strBuffer.append(" order by ").append(_orderby)
						.append(" asc ").toString();
			}
		}

		// 结果
		DataPackage result = new DataPackage();

		// 查询总数
		if (countHQL != null) {
			Query countQuery = session.createQuery(countHQL);
			if (param != null) {
				Iterator iter2 = param.keySet().iterator();
				while (iter2.hasNext()) {
					String key = (String) iter2.next();
					Object value = param.get(key);
					countQuery.setParameter(key, value);
				}
			}
			Iterator iter = countQuery.iterate();
			if (iter != null && iter.hasNext()) {
				result.setRowCount(((Integer) iter.next()).intValue());
			} else {
				result.setRowCount(0);
			}
		}

		Query query = session.createQuery(queryHQL);
		if (param != null) {
			Iterator iter2 = param.keySet().iterator();
			while (iter2.hasNext()) {
				String key = (String) iter2.next();
				Object value = param.get(key);
				query.setParameter(key, value);
			}
		}

		if (_pagesize > 0 && _pageno >= 1) {
			result.setPageNo(_pageno);
			result.setPageSize(_pagesize);

			query.setMaxResults(_pagesize);
			query.setFirstResult(_pagesize * (_pageno - 1));
		}

		result.setDatas(query.list());
		return result;
	}

	/**
	 * 特殊一点的查询，比如含有group by子句的查询
	 * @param queryHQL
	 * @param countSQL
	 * @param alias---sql语句里面用到的别名
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryWithSpecial(String queryHQL, String countSQL, String alias, HashMap param)
			throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		// 设置排序条件
		if (_orderby != null && _orderby.trim().length() > 0) {
			StringBuffer strBuffer = new StringBuffer(queryHQL);
			if ("1".equals(_desc)) {
				queryHQL = strBuffer.append(" order by ").append(_orderby)
						.append(" desc ").toString();
			} else {
				queryHQL = strBuffer.append(" order by ").append(_orderby)
						.append(" asc ").toString();
			}
		}

		// 结果
		DataPackage result = new DataPackage();

		// 查询总数
		if (countSQL != null) {
			SQLQuery countQuery = session.createSQLQuery(countSQL);
			
			if (param != null) {
				Iterator iter2 = param.keySet().iterator();
				while (iter2.hasNext()) {
					String key = (String) iter2.next();
					Object value = param.get(key);
					countQuery.setParameter(key, value);
				}
			}
			
			Integer size = (Integer) countQuery.addScalar(alias, Hibernate.INTEGER).uniqueResult();
			result.setRowCount(size.intValue());
		}

		Query query = session.createQuery(queryHQL);
		if (param != null) {
			Iterator iter2 = param.keySet().iterator();
			while (iter2.hasNext()) {
				String key = (String) iter2.next();
				Object value = param.get(key);
				query.setParameter(key, value);
			}
		}

		if (_pagesize > 0 && _pageno >= 1) {
			result.setPageNo(_pageno);
			result.setPageSize(_pagesize);

			query.setMaxResults(_pagesize);
			query.setFirstResult(_pagesize * (_pageno - 1));
		}

		result.setDatas(query.list());
		return result;
	}

	// 示例代码
	static void main(int pageno, Object param) {
		String queryHQL = "FROM XxxxVO as xxxx ";
		String countHQL = "SELECT count(*) FROM XxxxVO as xxxx ";
		QueryUtil qt = new QueryUtil("GZ-DB"); // 这里一般用user.getCityid();
		qt.set_pageno(2);
		qt.set_pagesize(20);
		qt.set_desc("1");
		qt.set_orderby("abc");
		try {
			DataPackage dp = qt.query(queryHQL, countHQL, null);
			if (dp != null && dp.getDatas() != null
					&& dp.getDatas().size() != 0) {
				System.out.println(dp.getDatas().size());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public DataPackage queryByName(String name, HashMap params) {
		Session session = SessionUtil.currentSession(dbFlag);
		Query query = session.getNamedQuery("getRolesByWay");
		String querystring = query.getQueryString();
		String countSql = "select count(role) from ( " + querystring + ") role";
		countSql  = StringUtils.replace(querystring, "distinct r" , "count(r)");
		try {
			return query(querystring,countSql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
