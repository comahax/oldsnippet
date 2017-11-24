/**
 * auto-generated code
 * Wed Sep 02 15:01:47 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: UnvRewardrecordDAO</p>
 * <p>Description: Data Access Object for UnvRewardrecordVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvRewardrecordDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public UnvRewardrecordDAO() {
		super(UnvRewardrecordVO.class);
	}

	public DataPackage doQueryWayIdName(UnvRewardrecordListVO params, User user)
			throws Exception {

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if (_pagesize > MAX_QUERY_COUNT) {
			_pagesize = MAX_QUERY_COUNT;
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		StringBuffer sqlHeadSel = new StringBuffer(
				"select r.employeeid as employeeid,r.employeename as employeename from ch_pw_employee r, common.ch_pw_way w where r.wayid = w.wayid and w.waysubtype='UNPB'");
		if (StringUtils.isNotEmpty(params.get_sk_wayoprcode())) {
			sqlHeadSel.append(" and r.employeeid like '%").append(
					params.get_sk_wayoprcode()).append("%' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_employeename())) {
			sqlHeadSel.append(" and r.employeename like '%").append(
					params.get_sk_employeename()).append("%' ");
		}

		Session session = SessionUtil.currentSession(getDbFlag());
		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("employeeid", Hibernate.STRING).addScalar(
							"employeename", Hibernate.STRING);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(_pagesize);
			querySel.setFirstResult(_pagesize * (_pageno - 1));
			List list = querySel.list();

			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				UnvRewardrecordEmployeeVO vo = new UnvRewardrecordEmployeeVO();
				Object[] obj = (Object[]) itt.next();
				vo.setEmployeeid(obj[0].toString());

				if (obj[1] == null) {
					vo.setEmployeename("");
				} else {
					vo.setEmployeename(obj[1].toString());
				}
				
				list2.add(vo);
			}

			result.setDatas(list2);
			list.clear();

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
