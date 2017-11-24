package com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.support;

import java.text.SimpleDateFormat;

import org.hibernate.Query;
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;

public class UnvrcfaildayParamProcessor extends DefaultHqlQueryProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		UnvrcfaildayParameter param = (UnvrcfaildayParameter) parameter;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from (");
		sb.append("(select u.failid,u.rcno,u.mobileno,u.opnid,o.name as opnname,u.rcmonth,to_char(u.rcdate,'yyyy-MM-dd hh24:mi:ss') rcdate,");
		sb.append("        u.reason,u.ossrc,u.wayid,w.wayname,e.empattr2                           ");
		sb.append("  from CH_BBC_UNVRCFAIL_VIEW u,ch_pw_way w, ch_pw_employee e, ch_bbc_operation o");
		sb.append(" where u.wayid=w.wayid and u.rcno=e.telephone and u.opnid=o.opnid               ");
		if (StringUtils.isNotEmpty(param.getRcno())) {
			sb.append(" and u.rcno=:rcno");
		} if(StringUtils.isNotEmpty(param.getWayid())){
			sb.append(" and u.wayid=:wayid");
		}
		if (StringUtils.isNotEmpty(param.getWayname())) {
			sb.append(" and w.wayname=:wayname");
		}
		if (StringUtils.isNotEmpty(param.getOpnid())) {
			sb.append(" and u.opnid=:opnid");
		}
		if (StringUtils.isNotEmpty(param.getOpnname())) {
			sb.append(" and o.name=:opnname");
		}
		if (StringUtils.isNotEmpty(param.getEmpattr2())) {
			sb.append(" and e.empattr2=:empattr2");
		}
		if (param.getOprtimeFrom() != null) {
			sb.append(" and u.rcdate>=to_date(:rcdateFrom,'yyyy-MM-dd hh24miss')");
		}
		if (param.getOprtimeTo() != null) {
			sb.append(" and u.rcdate<=to_date(:rcdateTo,'yyyy-MM-dd hh24miss')");
		}
		sb.append(")union");
		sb.append("(select u.failid,u.rcno,u.mobileno,u.opnid,o.name as opnname,u.rcmonth,to_char(u.rcdate,'yyyy-MM-dd hh24:mi:ss') rcdate,");
		sb.append("        u.reason,u.ossrc,u.wayid,w.wayname,e.empattr2                           ");
		sb.append("  from CH_BBC_UNVRCFAILDAY u,ch_pw_way w, ch_pw_employee e, ch_bbc_operation o  ");
		sb.append(" where u.wayid=w.wayid and u.rcno=e.telephone and u.opnid=o.opnid               ");
		if (StringUtils.isNotEmpty(param.getRcno())) {
			sb.append(" and u.rcno=:rcno");
		}if(StringUtils.isNotEmpty(param.getWayid())){
			sb.append(" and u.wayid=:wayid");
		}
		if (StringUtils.isNotEmpty(param.getWayname())) {
			sb.append(" and w.wayname=:wayname");
		}
		if (StringUtils.isNotEmpty(param.getOpnid())) {
			sb.append(" and u.opnid=:opnid");
		}
		if (StringUtils.isNotEmpty(param.getOpnname())) {
			sb.append(" and o.name=:opnname");
		}
		if (StringUtils.isNotEmpty(param.getEmpattr2())) {
			sb.append(" and e.empattr2=:empattr2");
		}
		if (param.getOprtimeFrom() != null) {
			sb.append(" and u.rcdate>=to_date(:rcdateFrom,'yyyy-MM-dd hh24miss')");
		}
		if (param.getOprtimeTo() != null) {
			sb.append(" and u.rcdate<=to_date(:rcdateTo,'yyyy-MM-dd hh24miss')");
		}
		sb.append("))");
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
		UnvrcfaildayParameter param = (UnvrcfaildayParameter) parameter;
		if (StringUtils.isNotEmpty(param.getRcno())) {
			query.setString("rcno", param.getRcno());
		}
		if(StringUtils.isNotEmpty(param.getWayid())){
			query.setString("wayid", param.getWayid());
		}
		if (StringUtils.isNotEmpty(param.getWayname())) {
			query.setString("wayname",param.getWayname());
		}
		if (StringUtils.isNotEmpty(param.getOpnid())) {
			query.setString("opnid", param.getOpnid());
		}
		if (StringUtils.isNotEmpty(param.getOpnname())) {
			query.setString("opnname", param.getOpnname());
		}
		if (StringUtils.isNotEmpty(param.getEmpattr2())) {
			query.setShort("empattr2", Short.parseShort(param.getEmpattr2()));
		}
		if (param.getOprtimeFrom() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String  time = sdf.format(param.getOprtimeFrom())+" 000000";
			query.setString("rcdateFrom", time);
		}
		if (param.getOprtimeTo() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String  time = sdf.format(param.getOprtimeTo())+" 235959";
			query.setString("rcdateTo", time);
		}
	}

}
