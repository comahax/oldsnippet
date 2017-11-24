package com.gmcc.pboss.biz.info.regactInfo.dao.hibernate;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gmcc.pboss.biz.info.regactInfo.dao.RegactStatisticsDao;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactStatisticsQueryParameter;
import com.gmcc.pboss.common.util.DateUtil;

public class RegactStatisticsDaoHibernate extends HibernateDaoSupport implements RegactStatisticsDao {
	/**
	 * 实际激活量
	 */
	public int getActualActivedQuantity(RegactStatisticsQueryParameter parameter) {
		final String sql = "select count(*) from FX_SW_PARTNERRES r where r.WAYID = :wayid and r.ISACTIVE =1 and r.acttime >= to_date(:oprtimeBegin, 'yyyymmdd') and r.acttime < to_date(:oprtimeEnd, 'yyyymmdd')";
		Query query = getSession().createSQLQuery(sql);
		query.setString("wayid", parameter.getWayid());
		query.setString("oprtimeBegin", DateUtil.getCurrentMonthBegin(parameter.getMonth()));
		query.setString("oprtimeEnd", DateUtil.getNextMonthBegin(parameter.getMonth()));
		int quantity = ((BigDecimal) query.uniqueResult()).intValue();
		return quantity;
//		return 0;
	}
	/**
	 * 符合计酬激活量
	 */
	public int getRewardActivedQuantity(RegactStatisticsQueryParameter parameter) {
		final String sql = "select count(count(*)) from V_CH_ADT_SIMSUCC where wayid = :wayid and oprtime >= to_date(:oprtimeBegin, 'yyyymmdd') and oprtime < to_date(:oprtimeEnd, 'yyyymmdd') group by mobile, oprtime";
		Query query = getSession().createSQLQuery(sql);
		query.setString("wayid", parameter.getWayid());
		query.setString("oprtimeBegin", DateUtil.getCurrentMonthBegin(parameter.getMonth()));
		query.setString("oprtimeEnd", DateUtil.getNextMonthBegin(parameter.getMonth()));
		int quantity = ((BigDecimal) query.uniqueResult()).intValue();
		return quantity;
	}
	/**
	 * 有效激活量
	 */
	public int getValidActivedQuantity(RegactStatisticsQueryParameter parameter) {
//		//yuwenjun旧的查询，现不使用
//		return getEnregisterQuantity(parameter.getWayid(), parameter.getMonth()) - getInvalidActivedQuantity(parameter.getWayid(), parameter.getMonth());
		
//		select count(*) from FX_SN_NOACTINFO s,CH_PW_REGISTEDSMP r
//		where to_char(s.activedate,'yyyymm') = to_char(r.oprtime,'yyyymm') and s.mobileno = r.mobile
//		and r.wayid = 'TDZS1211002' and  to_char(s.activedate,'yyyymm') = '201002';
		final String sql = "select count(*) from FX_SN_NOACTINFO s,CH_PW_REGISTEDSMP r where to_char(s.activedate,'yyyymm') = to_char(r.oprtime,'yyyymm') and s.mobileno = r.mobile and r.wayid = :wayid and  to_char(s.activedate,'yyyymm') = :oprtime"; 
		
		Query query = getSession().createSQLQuery(sql);
		query.setString("wayid", parameter.getWayid());
		query.setString("oprtime", parameter.getMonth());
		int quantity = ((BigDecimal) query.uniqueResult()).intValue();
		return quantity;
	}
//
//	/**
//	 * 查询总登记量
//	 * 
//	 * @param wayid
//	 * @param oprtimeBegin
//	 * @param oprtimeEnd
//	 * @return
//	 */
//	private int getEnregisterQuantity(String wayid, String oprtime) {
//		String sql = "select count(*) from CH_PW_REGISTEDSMP where " +
//				"wayid = :wayid and oprtime >= to_date(:oprtimeBegin, 'yyyymmdd') and oprtime < to_date(:oprtimeEnd, 'yyyymmdd')";
//		Query query = getSession().createSQLQuery(sql);
//		query.setString("wayid", wayid);
//		query.setString("oprtimeBegin", DateUtil.getCurrentMonthBegin(oprtime));
//		query.setString("oprtimeEnd", DateUtil.getNowMonthEnd(oprtime));
//		int quantity = ((BigDecimal) query.uniqueResult()).intValue();
//		return quantity;
//	}
//
//	/**
//	 * 查询无效的激活量
//	 * 
//	 * @param wayid
//	 * @param oprtimeBegin
//	 * @param oprtimeEnd
//	 * @return
//	 */
//	private int getInvalidActivedQuantity(String wayid, String oprtime) {
//		String sql = "select count(count(*)) from V_CH_ADT_SIMFAIL where " +
//				"wayid = :wayid and oprtime >= to_date(:oprtimeBegin, 'yyyymmdd') and oprtime < to_date(:oprtimeEnd, 'yyyymmdd') " +
//				"group by mobile, oprtime";
//		Query query = getSession().createSQLQuery(sql);
//		query.setString("wayid", wayid);
//		query.setString("oprtimeBegin", DateUtil.getCurrentMonthBegin(oprtime));
//		query.setString("oprtimeEnd", DateUtil.getNowMonthEnd(oprtime));
//		int quantity = ((BigDecimal) query.uniqueResult()).intValue();
//		return quantity;
//	}

}
