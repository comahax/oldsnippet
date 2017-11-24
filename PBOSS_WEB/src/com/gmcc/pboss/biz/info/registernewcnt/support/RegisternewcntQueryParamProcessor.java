package com.gmcc.pboss.biz.info.registernewcnt.support;

import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.DateUtil;

public class RegisternewcntQueryParamProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		RegisternewcntQueryParameter p = (RegisternewcntQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
//		hql.append("select new com.gmcc.pboss.biz.info.registernewcnt.support.Registernewcnt(");
		hql.append(" select r.wayid,w.wayname,");
		hql.append(" w.countyid,to_char(w.starlevel) as starlevel,to_char(count(*)) as cnt ");
		hql.append(" from CH_PW_REGISTERNEW r,");
		hql.append(" CH_PW_WAY w,");
		hql.append(" CH_PW_EMPLOYEE e,");
		hql.append(" (select opnid, opnname from CH_PW_OPERATIONSMS where opntype = 2 and smsno = '10086111' and cityid = :cityid) o");
		hql.append(" where r.wayid=w.wayid and r.oprcode=e.employeeid and r.opnid=o.opnid(+) ");
//		hql.append(" and o.cityid = :cityid ");and o.opntype='2' and o.smsno='10086111' 
		// 渠道编码
		if (!"".equals(p.getWayid()) && p.getWayid() != null) {
			hql.append(" and r.wayid=:wayid ");
		} else {
			hql.append(" and r.wayid in ( select  wayid from ch_pw_way where waymagcode=:employeeid) ");
		}
		// 分公司
		if (!"".equals(p.getCountyid()) && p.getCountyid() != null) {
			hql.append(" and w.countyid=:countyid ");
		}
		// 销售服务中心
		if (!"".equals(p.getSvccode()) && p.getSvccode() != null) {
			hql.append(" and w.svccode=:svccode ");
		}
		// 品牌
		if (!"".equals(p.getBrand()) && p.getBrand() != null) {
			hql.append(" and r.brand=:brand ");
		}
		// 登记起始时间
		if (!"".equals(p.getStartoprtime()) && p.getStartoprtime() != null) {
			hql.append(" and r.oprtime >= to_date(:startoprtime, 'yyyy-MM-dd') ");
		}
		// 登记结束时间
		if (!"".equals(p.getEndoprtime()) && p.getEndoprtime() != null) {
			hql.append(" and r.oprtime <= to_date(:endoprtime, 'yyyy-MM-dd hh24:mi:ss') ");
		}
		hql.append(" group by r.wayid,w.wayname,w.countyid,w.starlevel order by r.wayid,w.wayname,w.countyid,w.starlevel ");
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		
		RegisternewcntQueryParameter p = (RegisternewcntQueryParameter)parameter;
		query.setString("cityid", p.getCityid());
		
		if (!"".equals(p.getWayid()) && p.getWayid() != null) {
			query.setString("wayid", p.getWayid());
		} else {
			query.setString("employeeid", p.getEmployeeid());
		}
		if (!"".equals(p.getCountyid()) && p.getCountyid() != null) {
			query.setString("countyid", p.getCountyid());
		}
		if (!"".equals(p.getSvccode()) && p.getSvccode() != null) {
			query.setString("svccode", p.getSvccode());
		}
		if (!"".equals(p.getBrand()) && p.getBrand() != null) {
			query.setString("brand", p.getBrand());
		}
		if (!"".equals(p.getStartoprtime()) && p.getStartoprtime() != null) {
			query.setString("startoprtime", DateUtil.convertDateToString(p.getStartoprtime()));
		}
		if (!"".equals(p.getEndoprtime()) && p.getEndoprtime() != null) {
			query.setString("endoprtime", DateUtil.convertDateToString(p.getEndoprtime())+" 23:59:59");
		}
	}
}
