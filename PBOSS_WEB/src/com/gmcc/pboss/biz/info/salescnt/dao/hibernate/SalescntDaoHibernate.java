package com.gmcc.pboss.biz.info.salescnt.dao.hibernate;

import java.math.BigDecimal;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.gmcc.pboss.biz.info.salescnt.dao.SalescntDao;
import com.gmcc.pboss.biz.info.salescnt.support.SalescntQueryParameter;
import com.gmcc.pboss.common.util.DateUtil;

public class SalescntDaoHibernate extends HibernateDaoSupport implements SalescntDao {

	/**
	 * 套卡销售数量
	 */
	public int getRegistersimCnt(SalescntQueryParameter parameter) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from CH_PW_REGISTERSIM r where r.wayid=:wayid");
		if (!"".equals(parameter.getEmployeeid()) && parameter.getEmployeeid() != null) {
			sql.append(" and r.oprcode=:employeeid ");
		} else if (parameter.getEmployeeid() == null) {
			if (parameter.getOpEmployeeid() != null && !"".equals(parameter.getOpEmployeeid())) {
				sql.append(" and r.oprcode=:employeeid ");
			}
		}
		if (!"".equals(parameter.getStartoprtime()) && parameter.getStartoprtime() != null
				&& !"".equals(parameter.getEndoprtime()) && parameter.getEndoprtime() != null) {
			sql.append(" and r.oprtime >= to_date(:oprtimeBegin, 'yyyy-MM-dd') and r.oprtime <= to_date(:oprtimeEnd, 'yyyy-MM-dd hh24:mi:ss')");
		}
		Query query = getSession().createSQLQuery(sql.toString());
		query.setString("wayid", parameter.getWayid());
		if (!"".equals(parameter.getEmployeeid()) && parameter.getEmployeeid() != null) {
			query.setString("employeeid", parameter.getEmployeeid());
		} else if (parameter.getEmployeeid() == null) {
			if (parameter.getOpEmployeeid() != null && !"".equals(parameter.getOpEmployeeid())) {
				query.setString("employeeid", parameter.getOpEmployeeid());
			}
		}
		if (!"".equals(parameter.getStartoprtime()) && parameter.getStartoprtime() != null
				&& !"".equals(parameter.getEndoprtime()) && parameter.getEndoprtime() != null) {
			query.setString("oprtimeBegin", DateUtil.convertDateToString(parameter.getStartoprtime()));
			query.setString("oprtimeEnd", DateUtil.convertDateToString(parameter.getEndoprtime())+" 23:59:59");
		}
		int quantity = ((BigDecimal) query.uniqueResult()).intValue();
		return quantity;
	}
	
	/**
	 * 新业务销售数量
	 */
	public int getRegisternewCnt(SalescntQueryParameter parameter) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from CH_PW_REGISTERNEW r where r.wayid=:wayid");
		if (!"".equals(parameter.getEmployeeid()) && parameter.getEmployeeid() != null) {
			sql.append(" and r.oprcode=:employeeid ");
		} else if (parameter.getEmployeeid() == null) {
			if (parameter.getOpEmployeeid() != null && !"".equals(parameter.getOpEmployeeid())) {
				sql.append(" and r.oprcode=:employeeid ");
			}
		}
		if (!"".equals(parameter.getStartoprtime()) && parameter.getStartoprtime() != null
				&& !"".equals(parameter.getEndoprtime()) && parameter.getEndoprtime() != null) {
			sql.append(" and r.oprtime >= to_date(:oprtimeBegin, 'yyyy-MM-dd') and r.oprtime <= to_date(:oprtimeEnd, 'yyyy-MM-dd hh24:mi:ss')");
		}
		Query query = getSession().createSQLQuery(sql.toString());
		query.setString("wayid", parameter.getWayid());
		if (!"".equals(parameter.getEmployeeid()) && parameter.getEmployeeid() != null) {
			query.setString("employeeid", parameter.getEmployeeid());
		} else if (parameter.getEmployeeid() == null) {
			if (parameter.getOpEmployeeid() != null && !"".equals(parameter.getOpEmployeeid())) {
				query.setString("employeeid", parameter.getOpEmployeeid());
			}
		}
		if (!"".equals(parameter.getStartoprtime()) && parameter.getStartoprtime() != null
				&& !"".equals(parameter.getEndoprtime()) && parameter.getEndoprtime() != null) {
			query.setString("oprtimeBegin", DateUtil.convertDateToString(parameter.getStartoprtime()));
			query.setString("oprtimeEnd", DateUtil.convertDateToString(parameter.getEndoprtime())+" 23:59:59");
		}
		int quantity = ((BigDecimal) query.uniqueResult()).intValue();
		return quantity;
	}
}
