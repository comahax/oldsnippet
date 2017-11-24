package com.gmcc.pboss.biz.info.rewardtd.salemonth.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class SaleMonthQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		
		SaleMonthQueryParameter param = (SaleMonthQueryParameter)parameter;
		 Calendar calender = Calendar.getInstance(); 
		StringBuilder sb = new StringBuilder();
		String oprmon = param.getOprmon();
		String wayid = param.getWayid(); 
		sb.append(" select a.oprmon oprmon,a.imei imei,a.comname comname,a.mainno mainno,a.rwtypename rwtypename "); 
//		for(int i = 0;i<maxcount;i++){ 
		
				sb.append(", max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=1 then (case when RWMONEY>=0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) tmoney1 " ); 
				sb.append(", max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=2 then (case when RWMONEY>=0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) tmoney2 " ); 
				sb.append(", max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=3 then (case when RWMONEY>=0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) tmoney3 " ); 
				sb.append(", max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=4 then (case when RWMONEY>=0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) tmoney4 " ); 
				sb.append(", max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=5 then (case when RWMONEY>=0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) tmoney5 " ); 
				sb.append(", max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=6 then (case when RWMONEY>=0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) tmoney6 " ); 
				sb.append(", max(case when months_between(to_date(RWMON, 'yyyymm'), to_date(OPRMON, 'yyyymm'))=7 then (case when RWMONEY>=0 then to_char(RWMONEY) else to_char(CALCRWMONEY) end) else '--' end) tmoney7 " ); 

//		}
		sb.append(" from CH_RP_WAYREWARDDETAIL a where  a.wayid = :wayid and a.oprmon = :oprmon "); 
		
			sb.append(" group by a.WAYID, a.OPRMON, a.IMEI, a.COMNAME, a.MAINNO, a.RWTYPENAME "); 
			sb.append(" order by a.OPRMON,a.IMEI,a.COMNAME,a.MAINNO,a.RWTYPENAME ");  
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
		SaleMonthQueryParameter param = (SaleMonthQueryParameter)parameter;
		
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
