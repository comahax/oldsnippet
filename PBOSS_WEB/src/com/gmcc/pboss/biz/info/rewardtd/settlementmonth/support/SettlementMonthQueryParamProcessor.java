package com.gmcc.pboss.biz.info.rewardtd.settlementmonth.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class SettlementMonthQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		
		SettlementMonthQueryParameter param = (SettlementMonthQueryParameter)parameter;
		StringBuilder sb = new StringBuilder();
		String rwmon = param.getRwmon();
		String wayid = param.getWayid(); 
		sb.append(" select a.oprmon oprmon,a.rwmon rwmon,a.rwtypename rwtypename,a.imei imei,a.comname comname,a.mainno mainno,a.bchksucc bchksucc,a.rwmoney rwmoney,a.failrsn failrsn from CH_RP_WAYREWARDDETAIL a "); 
		sb.append("	where  a.wayid = :wayid and a.rwmon = :rwmon ");
		sb.append(" order by a.oprmon,a.rwtypename,a.imei "); 
	  
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
		SettlementMonthQueryParameter param = (SettlementMonthQueryParameter)parameter;
		
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
