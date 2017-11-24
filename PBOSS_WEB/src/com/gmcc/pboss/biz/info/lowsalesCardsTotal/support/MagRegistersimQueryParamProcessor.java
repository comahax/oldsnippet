package com.gmcc.pboss.biz.info.lowsalesCardsTotal.support;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class MagRegistersimQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		SalesCardsTotalQueryParameter p = (SalesCardsTotalQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();	
		hql.append("select r.wayid,w.wayname,w.countyid,to_char(w.starlevel),e.employeename,e.officetel,");//r.opnid,o.opnname,
		hql.append(" r.mobile,to_char(r.brand),r.comname,to_char(r.comtype),to_char(r.comclassid),to_char(r.comprice/100),to_char(r.oprtime,'yyyy-MM-dd hh24:mi:ss') as oprtime,to_char(n.activedate,'yyyy-MM-dd hh24:mi:ss') as activedate,to_char(r.mendfalg)");
//		hql.append(" from ch_pw_registersim r,ch_pw_way w,ch_pw_employee e,ch_pw_operationsms o,fx_sn_noactinfo n");
		hql.append(" from ch_pw_registersim r,ch_pw_way w,ch_pw_employee e,");//fx_sn_noactinfo n
		
		hql.append(" (select mobileno, activedate from fx_sn_noactinfo ");
		hql.append(" where activedate>=to_date(:active3month,'yyyy-mm-dd hh24:mi:ss')");//使用命名参数更高效
		if (StringUtils.isNotEmpty(p.getStartactivedates())) {
			hql.append(" and activedate >= to_date(:startactivedate, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (StringUtils.isNotEmpty(p.getEndactivedates())) {
			hql.append(" and activedate <= to_date(:endactivedate, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		hql.append(" ) n");
		
		hql.append(" where r.wayid=w.wayid and r.oprcode=e.employeeid and r.mobile=n.mobileno(+)");
		
		//对sms表中的联合主键做查询
		if(StringUtils.isNotEmpty(p.getCityid())){
			hql.append(" and r.cityid = :cityid ");
		}
		if(StringUtils.isNotEmpty(p.getWayid())){
			hql.append(" and r.wayid = :wayid ");
		}
		if(StringUtils.isNotEmpty(p.getCountyid())){
			hql.append(" and w.countyid =:countyid ");
		}
		if(StringUtils.isNotEmpty(p.getSvccode())){
			hql.append(" and w.svccode =:svccode ");
		}
		if(StringUtils.isNotEmpty(p.getBranddtl())){
			hql.append(" and r.brand =:brand ");
		}
		if (StringUtils.isNotEmpty(p.getStartoprtimes())) {
			hql.append(" and r.oprtime >= to_date(:startoprtime, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (StringUtils.isNotEmpty(p.getEndoprtimes())) {
			hql.append(" and r.oprtime <= to_date(:endoprtime, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (StringUtils.isNotEmpty(p.getStartactivedates())) {
			hql.append(" and n.activedate >= to_date(:startactivedate, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (StringUtils.isNotEmpty(p.getEndactivedates())) {
			hql.append(" and n.activedate <= to_date(:endactivedate, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (StringUtils.isNotEmpty(p.getEmployeeid())) {
			hql.append(" and e.employeeid =:employeeid ");
		}
		if (StringUtils.isNotEmpty(p.getOfficetel())) {
			hql.append(" and e.officetel =:officetel ");
		}
		hql.append(" order by r.seqid");
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		SalesCardsTotalQueryParameter p = (SalesCardsTotalQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(p.getCityid())){
			query.setString("cityid", p.getCityid());
		}		
		if(StringUtils.isNotEmpty(p.getWayid())){
			query.setString("wayid", p.getWayid());
		}
		if(StringUtils.isNotEmpty(p.getCountyid())){
			query.setString("countyid", p.getCountyid());
		}
		if(StringUtils.isNotEmpty(p.getSvccode())){
			query.setString("svccode", p.getSvccode());
		}
		if(StringUtils.isNotEmpty(p.getBranddtl())){
			query.setString("brand", p.getBranddtl());
		}
		if(StringUtils.isNotEmpty(p.getStartoprtimes())){
			query.setString("startoprtime", p.getStartoprtimes()+" 00:00:00 ");
		}
		if(StringUtils.isNotEmpty(p.getEndoprtimes())){
			query.setString("endoprtime", p.getEndoprtimes()+" 23:59:59 ");
		}
		
		//激活时间不早于当前时间按3个月
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date(System.currentTimeMillis());		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)-3);
		query.setString("active3month", sdf.format(c.getTime()));
		
		if (StringUtils.isNotEmpty(p.getStartactivedates())) {
			query.setString("startactivedate", p.getStartactivedates()+" 00:00:00 ");
		}
		if (StringUtils.isNotEmpty(p.getEndactivedates())) {
			query.setString("endactivedate", p.getEndactivedates()+" 23:59:59 ");
		}
		if (StringUtils.isNotEmpty(p.getOfficetel())) {
			query.setString("officetel", p.getOfficetel());
		}
		if (StringUtils.isNotEmpty(p.getEmployeeid())) {
			query.setString("employeeid", p.getEmployeeid());
		}
	}

}
