package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class MonthRemunerationQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		
		MonthRemunerationQueryParameter param = (MonthRemunerationQueryParameter)parameter;
		StringBuilder sb = new StringBuilder();
		String rwmon = param.getRwmon();
		String wayid = param.getWayid(); 
		sb.append(" select a.rwmon rwmon,a.custtype custtype,b.rwtypename rwtypename,b.chkitemname chkitemname,b.period period,b.rwstd rwstd "); 
		sb.append(" , max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=7 then nvl(busicnt,0) else 0 end) tbusicnt7 ,max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=7 then nvl(passcnt,0) else 0 end) tpasscnt7, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=7 then nvl(rwmoney,0) else 0 end) trwmoney7 "); 
		sb.append(" , max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=6 then nvl(busicnt,0) else 0 end) tbusicnt6 ,max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=6 then nvl(passcnt,0) else 0 end) tpasscnt6, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=6 then nvl(rwmoney,0) else 0 end) trwmoney6 "); 
		sb.append(" , max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=5 then nvl(busicnt,0) else 0 end) tbusicnt5, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=5 then nvl(passcnt,0) else 0 end) tpasscnt5, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=5 then nvl(rwmoney,0) else 0 end) trwmoney5 "); 
		sb.append(" , max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=4 then nvl(busicnt,0) else 0 end) tbusicnt4, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=4 then nvl(passcnt,0) else 0 end) tpasscnt4, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=4 then nvl(rwmoney,0) else 0 end) trwmoney4 "); 
		sb.append(" , max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=3 then nvl(busicnt,0) else 0 end) tbusicnt3 ,max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=3 then nvl(passcnt,0) else 0 end) tpasscnt3, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=3 then nvl(rwmoney,0) else 0 end) trwmoney3 "); 
		sb.append(" , max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=2 then nvl(busicnt,0) else 0 end) tbusicnt2, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=2 then nvl(passcnt,0) else 0 end) tpasscnt2, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=2 then nvl(rwmoney,0) else 0 end) trwmoney2 "); 
		sb.append(" , max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=1 then nvl(busicnt,0) else 0 end) tbusicnt1, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=1 then nvl(passcnt,0) else 0 end) tpasscnt1, max(case when months_between(to_date(rwmon, 'yyyymm'), to_date(oprmon, 'yyyymm'))=1 then nvl(rwmoney,0) else 0 end) trwmoney1 "); 
		sb.append(" ,sum(nvl(busicnt,0)) sumbusicnt,sum(nvl(passcnt,0)) sumpasscnt,sum(nvl(rwmoney,0)) sumrwmoney  "); 
		sb.append(" from ch_rp_wayreward a,ch_rp_rwiteminfo b where a.chkitemid=b.chkitemid and b.display=1 and a.period=b.period "); 
		
			if (StringUtils.isNotEmpty(wayid)) {// 渠道编码
				sb.append("	and  a.wayid = :wayid");
			}  

			if (StringUtils.isNotEmpty(rwmon)) {// 结算月份
				sb.append(" and a.rwmon = :rwmon ");
			}
			sb.append(" group by a.rwmon, a.custtype, b.rwtypename, b.chkitemname, b.period, b.rwstd "); 
			sb.append(" order by a.rwmon,a.custtype,b.rwtypename,b.chkitemname,b.period,b.rwstd "); 
	  
		return sb.toString();
	}

	

	
	 
	
	
	
	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		MonthRemunerationQueryParameter param = (MonthRemunerationQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
		if (StringUtils.isNotEmpty(param.getRwmon())){
			query.setString("rwmon", param.getRwmon());
		}
		
//		if(StringUtils.isNotEmpty(param.getRewardtype())){
//			query.setString("rewardtype", param.getRewardtype());
//		}
	}


}
