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
		// Ĭ������£�����ҳ��������
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
	 * ��ѯ������ʹ��ԭ��SQL���
	 * 
	 * @param queryHQL
	 * @param countSQL
	 * @param entityName--ʵ��������
	 * @param entityClass---ʵ�������
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage query(String queryHQL, String countSQL,
			String entityName, Class entityClass, HashMap param)
			throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		// ������������
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

		// ���
		DataPackage result = new DataPackage();

		// ��ѯ����
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
		// ������������
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

		// ���
		DataPackage result = new DataPackage();

		// ��ѯ����
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
	 * ����һ��Ĳ�ѯ�����纬��group by�Ӿ�Ĳ�ѯ
	 * @param queryHQL
	 * @param countSQL
	 * @param alias---sql��������õ��ı���
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryWithSpecial(String queryHQL, String countSQL, String alias, HashMap param)
			throws Exception {
		Session session = SessionUtil.currentSession(dbFlag);
		// ������������
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

		// ���
		DataPackage result = new DataPackage();

		// ��ѯ����
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

	// ʾ������
	static void main(int pageno, Object param) {
		String queryHQL = "FROM XxxxVO as xxxx ";
		String countHQL = "SELECT count(*) FROM XxxxVO as xxxx ";
		QueryUtil qt = new QueryUtil("GZ-DB"); // ����һ����user.getCityid();
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
