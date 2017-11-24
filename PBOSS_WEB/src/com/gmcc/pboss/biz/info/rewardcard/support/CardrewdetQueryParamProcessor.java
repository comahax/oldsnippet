package com.gmcc.pboss.biz.info.rewardcard.support;

import java.text.SimpleDateFormat;

import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.biz.info.rewardcard.support.CardrewdetQueryParameter;

public class CardrewdetQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		CardrewdetQueryParameter p = (CardrewdetQueryParameter)parameter;
		
		StringBuffer sql = new StringBuffer();
		sql.append("select c.wayid,w.wayname,c.mobile,to_char(c.activetime,'yyyy-MM-dd hh24:mi:ss'),to_char(c.rechargenum),to_char(c.rechargetime,'yyyy-MM-dd hh24:mi:ss'),to_char(c.rewardnum),c.cmonth");
		sql.append(" from CH_ADT_CARDREWDET c,ch_pw_way w");
		sql.append(" where c.wayid=w.wayid");
		
		if(p.getActiveFrom()!=null){
			sql.append(" and c.activetime>=to_date(:activeFrom,'yyyy-MM-dd hh24:mi:ss')");
		}
		if(p.getActiveTo()!=null){
			sql.append(" and c.activetime<=to_date(:activeTo,'yyyy-MM-dd hh24:mi:ss')");
		}		
		if(p.getRechargeFrom()!=null){
			sql.append(" and c.rechargetime>=to_date(:rechargeFrom,'yyyy-MM-dd hh24:mi:ss')");
		}
		if(p.getRechargeTo()!=null){
			sql.append(" and c.rechargetime<=to_date(:rechargeTo,'yyyy-MM-dd hh24:mi:ss')");
		}
		if(p.getWayid()!=null && !"".equals(p.getWayid())){//店主默认使用
			sql.append(" and c.wayid=:wayid");
		}
		//else{//经理默认使用，界面上没有选定渠道查询条件
		//	sql.append(" c.wayid in (select wayid from ch_pw_way where waymagcode=:waymagcode)");
		//}
		if(p.getMobile()!=null && !"".equals(p.getMobile())){
			sql.append(" and c.mobile=:mobile");
		}		
		
		sql.append(" order by c.seqid");
		return sql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		CardrewdetQueryParameter p = (CardrewdetQueryParameter)parameter;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		if(p.getActiveFrom()!=null){
			String start = sdf.format(p.getActiveFrom())+" 00:00:00";
			query.setString("activeFrom", start);			
		}
		if(p.getActiveTo()!=null){
			String end = sdf.format(p.getActiveTo())+" 23:59:59";
			query.setString("activeTo", end);
		}		
		if(p.getRechargeFrom()!=null){
			String start = sdf.format(p.getRechargeFrom())+" 00:00:00";
			query.setString("rechargeFrom", start);
		}
		if(p.getRechargeTo()!=null){
			String end = sdf.format(p.getRechargeTo())+" 23:59:59";
			query.setString("rechargeTo", end);
		}
		if(p.getWayid()!=null && !"".equals(p.getWayid())){//店主默认使用，经理在选定渠道条件下使用
			query.setString("wayid", p.getWayid());
		}
		//else{//经理默认使用，界面上没有选定渠道查询条件
		//	query.setString("waymagcode", p.getWaymagcode());
		//}
		if(p.getMobile()!=null && !"".equals(p.getMobile())){
			query.setString("mobile", p.getMobile().trim());
		}
	}

}
