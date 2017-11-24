package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.dao.MonthRemunerationDao;
import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.MonthRemuneration;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class MonthRemunerationDaoHibernate extends BaseHqlQueryDao  implements MonthRemunerationDao{
	
	public MonthRemunerationDaoHibernate() {
		super(MonthRemuneration.class);
	}
	
	/**
	 * 酬金合计
	 * @param wayid
	 * @param month
	 * @return
	 */
	public List getBusistat(String wayid,String rwmon){
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.rwmon rwmon,'酬金合计' custtype,sum(trwmoney7) trwmoney7,sum(trwmoney6) trwmoney6,sum(trwmoney5) trwmoney5, ");
		sb.append("  sum(trwmoney4) trwmoney4,sum(trwmoney3) trwmoney3,sum(trwmoney2) trwmoney2,sum(trwmoney1) trwmoney1,sum(sumrwmoney) sumrwmoney  ");
		sb.append("   from (select a.rwmon,a.custtype, ");
		sb.append("   max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=7 then nvl(rwmoney,0) else 0 end) trwmoney7, ");
		sb.append("  max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=6 then nvl(rwmoney,0) else 0 end) trwmoney6, ");
		sb.append("	max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=5 then nvl(rwmoney,0) else 0 end) trwmoney5, ");
		sb.append("	max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=4 then nvl(rwmoney,0) else 0 end) trwmoney4, ");
		sb.append("	max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=3 then nvl(rwmoney,0) else 0 end) trwmoney3, ");
		sb.append(" max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=2 then nvl(rwmoney,0) else 0 end) trwmoney2, ");
		sb.append(" max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=1 then nvl(rwmoney,0) else 0 end) trwmoney1, ");			
		sb.append(" sum(nvl(rwmoney,0)) sumrwmoney  ");			
		sb.append(" from ch_rp_wayreward a,ch_rp_rwiteminfo b  ");		
		sb.append(" where a.chkitemid=b.chkitemid and b.display=1 and a.period=b.period  ");
		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and a.wayid=:wayid ");	
		}
		if(rwmon!=null && !"".equals(rwmon.trim())){
			sb.append("   and a.rwmon=:rwmon ");	
		}
		sb.append("  group by a.rwmon, a.custtype, b.rwtypename, b.chkitemname, b.period, b.rwstd) c  ");
		sb.append(" group by c.rwmon, custtype ");
		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
		if(wayid!=null && !"".equals(wayid.trim())){
		sqlQuery.setString("wayid", wayid);			
		}
		if(rwmon!=null && !"".equals(rwmon.trim())){
			sqlQuery.setString("rwmon", rwmon);		
		}
		return sqlQuery.list();
	}

	/**
	 * 其它酬金合计
	 * @param wayid
	 * @param month
	 * @return
	 */
	public List getOtherList(String wayid,String rwmon){
		StringBuilder sb = new StringBuilder();
		sb.append(" select b.RWMON,(a.SUMPAYMONEY1-b.SUMRWMONEY) OTHERRWMONEY  ");
		sb.append(" from (select nvl(sum(PAYMONEY1),0) SUMPAYMONEY1 from CH_ZD_REWARDRECORD where  wayid=:wayid  and PAYMONTH1=:rwmon ) a, ");
		sb.append("   (select RWMON,nvl(sum(RWMONEY),0) SUMRWMONEY from CH_RP_WAYREWARD c where  c.wayid=:wayid  and  c.RWMON=:rwmon ");
		sb.append(" and exists (select 1 from CH_RP_RWITEMINFO where CHKITEMID=c.CHKITEMID and DISPLAY=1) group by RWMON) b ");
		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
		if(wayid!=null && !"".equals(wayid.trim())){
		sqlQuery.setString("wayid", wayid);			
		}
		if(rwmon!=null && !"".equals(rwmon.trim())){
			sqlQuery.setString("rwmon", rwmon);		
		}
		return sqlQuery.list();
	}
	
	/**
	 * 合计
	 * @param wayid
	 * @param month
	 * @return
	 */
	public List getCountList(String wayid,String rwmon){
		StringBuilder sb = new StringBuilder();
		sb.append(" select paymonth1,nvl(sum(paymoney1),0) sumpaymoney1 from ch_zd_rewardrecord where wayid=:wayid and paymonth1=:rwmon  ");
		sb.append(" group by paymonth1 ");
		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
		if(wayid!=null && !"".equals(wayid.trim())){
		sqlQuery.setString("wayid", wayid);			
		}
		if(rwmon!=null && !"".equals(rwmon.trim())){
			sqlQuery.setString("rwmon", rwmon);		
		}
		return sqlQuery.list();
	}
}
