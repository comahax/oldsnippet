package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.support;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class RealtimesuccQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		RealtimesuccQueryParameter param = (RealtimesuccQueryParameter)parameter;
		StringBuilder sb = new StringBuilder();
		sb.append("select s.seq,s.oprcode,s.wayid,s.mobile,o.name,s.opnid,to_char(s.oprtime,'yyyy-MM-dd')");
		sb.append(" from ch_bbc_operation o,ch_bbc_realtimesucc s");
		sb.append(" where s.opnid=o.opnid");
		if(StringUtils.isNotEmpty(param.getOprcode())){
			sb.append("  and s.oprcode=:oprcode ");
		}
		if(StringUtils.isNotEmpty(param.getWayid())){
			sb.append("  and s.wayid=:wayid ");
		}
		if(StringUtils.isNotEmpty(param.getOpnname())){
			sb.append("  and o.name like :opnname ");
		}
		if(param.getOprtimeFrom() != null){
			sb.append("  and s.oprtime >= to_date(:oprtimeFrom,'yyyy-MM-dd hh24miss') ");
		}
		if(param.getOprtimeTo() != null){
			sb.append("  and s.oprtime <= to_date(:oprtimeTo,'yyyy-MM-dd hh24miss') ");
		}
		sb.append(" order by s.seq");
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
		RealtimesuccQueryParameter param = (RealtimesuccQueryParameter)parameter;
		if(StringUtils.isNotEmpty(param.getOprcode())){
			query.setString("oprcode", param.getOprcode());
		}
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
		if(StringUtils.isNotEmpty(param.getOpnname())){
			query.setString("opnname","%"+param.getOpnname()+"%");
		}
		if(param.getOprtimeFrom() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String  time = sdf.format(param.getOprtimeFrom())+" 000000";
			query.setString("oprtimeFrom", time);
		}
		if(param.getOprtimeTo() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String  time = sdf.format(param.getOprtimeTo())+" 235959";
			query.setString("oprtimeTo", time);
		}
	}

}
