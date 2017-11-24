package com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class RewardBusinessQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		
		RewardBusinessQueryParameter param = (RewardBusinessQueryParameter)parameter;
		StringBuilder sb = new StringBuilder();
		String rwmon = param.getOprmon();
		String wayid = param.getWayid(); 
		sb.append(" select a.oprmon oprmon,a.custtype custtype,b.rwtypename rwtypename,b.chkitemname chkitemname,b.rwhlvl rwhlvl,a.busicnt busicnt, "); 
		sb.append(" sum(nvl(calcrwmoney,0)) maxrwmoney, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=1 then RWSTD else '--' end) t1rwstd, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=1 then (case when RWMONEY>0  then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) t1money, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=2 then RWSTD else '--' end) t2rwstd, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=2 then (case when RWMONEY>0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) t2money, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=3 then RWSTD else '--' end) t3rwstd, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=3 then (case when RWMONEY>0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) t3money, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=4 then RWSTD else '--' end) t4rwstd, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=4 then (case when RWMONEY>0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) t4money, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=5 then RWSTD else '--' end) t5rwstd, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=5 then (case when RWMONEY>0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) t5money, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=6 then RWSTD else '--' end) t6rwstd, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=6then (case when RWMONEY>0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) t6money, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=7 then RWSTD else '--' end) t7rwstd, "); 
		sb.append(" max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=7 then (case when RWMONEY>0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) t7money "); 
		

		sb.append(" from CH_RP_WAYREWARD a,CH_RP_RWITEMINFO b  "); 
		sb.append(" where a.CHKITEMID=b.CHKITEMID and b.DISPLAY=1 and a.PERIOD=b.PERIOD "); 
		
			if (StringUtils.isNotEmpty(wayid)) {// 渠道编码
				sb.append("	and  a.wayid = :wayid");
			}  

			if (StringUtils.isNotEmpty(rwmon)) {// 结算月份
				sb.append(" and a.oprmon = :oprmon ");
			}
			sb.append(" group by a.OPRMON, a.CUSTTYPE, b.RWTYPENAME, b.CHKITEMNAME, b.RWHLVL, a.BUSICNT "); 
			sb.append(" order by a.OPRMON,a.CUSTTYPE,b.RWTYPENAME,b.CHKITEMNAME,b.RWHLVL,a.BUSICNT "); 
	  
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
		RewardBusinessQueryParameter param = (RewardBusinessQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
		if (StringUtils.isNotEmpty(param.getOprmon())){
			query.setString("oprmon", param.getOprmon());
		}
		
//		if(StringUtils.isNotEmpty(param.getRewardtype())){
//			query.setString("rewardtype", param.getRewardtype());
//		}
	}


}
