package com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.dao.RewardBusinessDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support.RewardBusiness;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class RewardBusinessDaoHibernate extends BaseHqlQueryDao  implements RewardBusinessDao{
	
	public RewardBusinessDaoHibernate() {
		super(RewardBusiness.class);
	}
	
	/**
	 * ³ê½ðºÏ¼Æ
	 * @param wayid
	 * @param month
	 * @return
	 */
	public List getBusistat(String wayid,String oprmon){
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.OPRMON,sum(trwmoney1) trwmoney1,sum(trwmoney2) trwmoney2,sum(trwmoney3) trwmoney3,sum(trwmoney4) trwmoney4,sum(trwmoney5) trwmoney5,sum(trwmoney6) trwmoney6,sum(trwmoney7) trwmoney7 ");
		sb.append(" from (select a.OPRMON,a.CUSTTYPE,b.RWTYPENAME,b.CHKITEMNAME,b.RWHLVL,a.BUSICNT,sum(nvl(CALCRWMONEY,0)) MAXRWMONEY, ");
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=1 then (case when RWMONEY>0 then RWMONEY else CALCRWMONEY end) else 0 end) trwmoney1, ");
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=2 then (case when RWMONEY>0 then RWMONEY else CALCRWMONEY end) else 0 end) trwmoney2, ");
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=3 then (case when RWMONEY>0 then RWMONEY else CALCRWMONEY end) else 0 end) trwmoney3, ");
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=4 then (case when RWMONEY>0 then RWMONEY else CALCRWMONEY end) else 0 end) trwmoney4, ");
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=5 then (case when RWMONEY>0 then RWMONEY else CALCRWMONEY end) else 0 end) trwmoney5, ");
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=6 then (case when RWMONEY>0 then RWMONEY else CALCRWMONEY end) else 0 end) trwmoney6, ");
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=7 then (case when RWMONEY>0 then RWMONEY else CALCRWMONEY end) else 0 end) trwmoney7 ");
		sb.append(" from CH_RP_WAYREWARD a,CH_RP_RWITEMINFO b  ");			
		sb.append(" where  a.CHKITEMID=b.CHKITEMID and b.DISPLAY=1 and a.PERIOD=b.PERIOD ");			

		if(wayid!=null && !"".equals(wayid.trim())){
			sb.append("   and a.wayid=:wayid ");	
		}
		if(oprmon!=null && !"".equals(oprmon.trim())){
			sb.append("   and a.oprmon=:oprmon ");	
		}
		sb.append(" group by a.OPRMON, a.CUSTTYPE, b.RWTYPENAME, b.CHKITEMNAME, b.RWHLVL, a.BUSICNT) c ");
		sb.append(" group by c.OPRMON ");
		Query sqlQuery = this.getSession().createSQLQuery(sb.toString());
		if(wayid!=null && !"".equals(wayid.trim())){
		sqlQuery.setString("wayid", wayid);			
		}
		if(oprmon!=null && !"".equals(oprmon.trim())){
			sqlQuery.setString("oprmon", oprmon);		
		}
		return sqlQuery.list();
	}

}
