package com.gmcc.pboss.biz.info.registernewmagcnt.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

/**
 * 新业务销售明细-查询参数处理器CH_PW_REGISTERNEW
 * @author Administrator
 *
 */
public class RegisternewQueryParamProcessor 
			extends DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		RegisternewmagcntQueryParameter p = (RegisternewmagcntQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
//		hql.append("select new com.gmcc.pboss.biz.info.salesDetail.model.RegisternewDetail(");
		hql.append(" select r.wayid,w.wayname,w.countyid,to_char(w.starlevel),e.employeename,e.officetel,");
		hql.append(" r.mobile,to_char(r.brand),r.opnid,o.opnname,to_char(r.oprtime,'yyyy-mm-dd hh24:mi:ss') as oprtime");
		hql.append(" from CH_PW_REGISTERNEW r,");
		hql.append(" CH_PW_WAY w,");
		hql.append(" CH_PW_EMPLOYEE e,");
		hql.append(" (select opnid, opnname from CH_PW_OPERATIONSMS where opntype = 2 and smsno = '10086111' and cityid = :cityid) o");
		hql.append(" where r.wayid=w.wayid and r.oprcode=e.employeeid and r.opnid=o.opnid(+) ");
//		hql.append(" and o.id.cityid = :cityid ");
		hql.append(" and r.wayid = :wayid ");
		if(StringUtils.isNotEmpty(p.getEmployeename())){
			hql.append(" and e.employeename = :employeename ");
		}
		if(StringUtils.isNotEmpty(p.getOfficetel())){
			hql.append(" and e.officetel =:officetel ");
		}
		if(StringUtils.isNotEmpty(p.getOpnid())){
			hql.append(" and r.opnid =:opnid ");
		}
		if(StringUtils.isNotEmpty(p.getBrand())){
			hql.append(" and r.brand =:brand ");
		}
		if (StringUtils.isNotEmpty(p.getDateFrom())) {
			hql.append(" and r.oprtime >= to_date(:startoprtime, 'yyyy-MM-dd') ");
		}
		if (StringUtils.isNotEmpty(p.getDateTo())) {
			hql.append(" and r.oprtime <= to_date(:endoprtime, 'yyyy-MM-dd hh24:mi:ss') ");
		}
		hql.append(" order by r.seqid");
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
		if(StringUtils.isNotEmpty(p.getEmployeename())){
			query.setString("employeename", p.getEmployeename());
		}
		if(StringUtils.isNotEmpty(p.getOfficetel())){
			query.setString("officetel", p.getOfficetel());
		}
		if(StringUtils.isNotEmpty(p.getOpnid())){
			query.setString("opnid", p.getOpnid());
		}
		if(StringUtils.isNotEmpty(p.getBrand())){
			query.setString("brand", p.getBrand());
		}
		if(StringUtils.isNotEmpty(p.getDateFrom())){
			query.setString("startoprtime", p.getDateFrom());
		}
		if(StringUtils.isNotEmpty(p.getDateTo())){
			query.setString("endoprtime", p.getDateTo()+" 23:59:59");
		}
	}
}
