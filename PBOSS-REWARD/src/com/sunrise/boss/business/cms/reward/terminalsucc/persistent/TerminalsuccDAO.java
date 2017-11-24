/**
 * auto-generated code
 * Fri Apr 09 12:40:50 CST 2010
 */
package com.sunrise.boss.business.cms.reward.terminalsucc.persistent;

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
 * <p>
 * Title: TerminalsuccDAO
 * </p>
 * <p>
 * Description: Data Access Object for TerminalsuccVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
public class TerminalsuccDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public TerminalsuccDAO() {
		super(TerminalsuccVO.class);
	}

	public DataPackage doQueryTerminalsucc(TerminalsuccListVO params, User user)
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
				"select b.CITYID as CITYID,a.COMID as COMID,a.OPNID as OPNID, b.WAYID as WAYID, b.CALCMONTH as CALCMONTH, b.BUSIVALUE as BUSIVALUE from common.ch_adt_busitocom a,(select cityid CITYID,comid COMID, wayid WAYID, calcmonth CALCMONTH , COUNT(*) BUSIVALUE from common.CH_ADT_TERMINALSUCC where calcmonth='" + params.get_se_calcmonth()+ "' group by comid,wayid,calcmonth ,cityid) b where a.comid=b.comid");
		if (StringUtils.isNotEmpty(params.get_se_cityid())) {
			sqlHeadSel.append(" and b.cityid = '").append(
					params.get_se_cityid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and b.wayid = '").append(
					params.get_se_wayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comid())){
			sqlHeadSel.append(" and b.comid = '").append(
					params.get_se_comid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_chainhead())){
			sqlHeadSel.append(" and b.wayid in (select trim(b.wayid) wayid2 from common.ch_pw_way a,common.ch_pw_way b where a.wayid = b.chainhead and a.chainhead = '").append(
					params.get_se_chainhead()).append("') ");
		}
			sqlHeadSel.append(" order by b.comid");
		Session session = SessionUtil.currentSession(getDbFlag());
		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("CITYID", Hibernate.STRING).addScalar("COMID",
							Hibernate.STRING).addScalar("OPNID",
							Hibernate.STRING).addScalar("WAYID",
							Hibernate.STRING).addScalar("CALCMONTH", Hibernate.STRING).addScalar("BUSIVALUE", Hibernate.STRING);

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
				TerminalsuccComVO vo = new TerminalsuccComVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCityid(obj[0].toString());
				vo.setComid(obj[1].toString());
				vo.setOpnid(obj[2].toString());
				vo.setWayid(obj[3].toString());
				vo.setCalcmonth(obj[4].toString());
				vo.setBusivalue(new Long(obj[5].toString()));

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
