package com.gmcc.pboss.biz.info.registernewmagcnt.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.DateUtil;

public class RegisternewmagQueryParamProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		RegisternewmagcntQueryParameter p = (RegisternewmagcntQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
//		hql.append("select new com.gmcc.pboss.biz.info.registernewmagcnt.support.Registernewmagcnt(");
		hql.append(" select e.employeename,e.officetel,");
		hql.append(" to_char(r.brand) as brand,r.opnid,o.opnname,to_char(count(*)) as cnt ");
		hql.append(" from CH_PW_REGISTERNEW r,");
		hql.append(" CH_PW_WAY w,");
		hql.append(" CH_PW_EMPLOYEE e,");
		hql.append(" (select opnid, opnname from CH_PW_OPERATIONSMS where opntype = 2 and smsno = '10086111' and cityid = :cityid) o");
		hql.append(" where r.wayid=w.wayid and r.oprcode=e.employeeid and r.opnid=o.opnid(+) ");
//		hql.append(" and o.cityid = :cityid ");
		hql.append(" and r.wayid = :wayid ");
		if (StringUtils.isNotEmpty(p.getEmployeename())) {
			hql.append(" and e.employeename=:employeename ");
		}
		if (StringUtils.isNotEmpty(p.getOpnid())) {
			hql.append(" and r.opnid=:opnid ");
		}
		// 登记起始时间
		if (!"".equals(p.getStartoprtime()) && p.getStartoprtime() != null) {
			hql.append(" and r.oprtime >= to_date(:startoprtime, 'yyyy-MM-dd') ");
		}
		// 登记结束时间
		if (!"".equals(p.getEndoprtime()) && p.getEndoprtime() != null) {
			hql.append(" and r.oprtime <= to_date(:endoprtime, 'yyyy-MM-dd hh24:mi:ss') ");
		}
		// 品牌
		if (StringUtils.isNotEmpty(p.getBrand())) {
			hql.append(" and r.brand=:brand ");
		}
		hql.append(" group by e.employeename,e.officetel,r.brand,r.opnid,o.opnname  order by e.employeename,e.officetel,r.brand,r.opnid,o.opnname ");
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		RegisternewmagcntQueryParameter p = (RegisternewmagcntQueryParameter)parameter;
		query.setString("cityid", p.getCityid());
		query.setString("wayid", p.getWayid());
		if (StringUtils.isNotEmpty(p.getEmployeename())) {
			query.setString("employeename", p.getEmployeename());
		}
		if (StringUtils.isNotEmpty(p.getOpnid())) {
			query.setString("opnid", p.getOpnid());
		}
		if (!"".equals(p.getStartoprtime()) && p.getStartoprtime() != null) {
			query.setString("startoprtime", DateUtil.convertDateToString(p.getStartoprtime()));
		}
		if (!"".equals(p.getEndoprtime()) && p.getEndoprtime() != null) {
			query.setString("endoprtime", DateUtil.convertDateToString(p.getEndoprtime())+" 23:59:59");
		}
		if (StringUtils.isNotEmpty(p.getBrand())) {
			query.setString("brand", p.getBrand());
		}
	}
}
