package com.gmcc.pboss.biz.info.registernewcnt.support;

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
		RegisternewcntQueryParameter p = (RegisternewcntQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
//		hql.append("select new com.gmcc.pboss.biz.info.salesDetail.model.RegisternewDetail(");
		hql.append(" select r.wayid,w.wayname,w.countyid,to_char(w.starlevel),e.employeename,e.officetel,");
		hql.append(" r.mobile,to_char(r.brand),r.opnid,o.opnname,to_char(r.oprtime,'yyyy-mm-dd hh24:mi:ss') as oprtime");//r.oprtime
		hql.append(" from CH_PW_REGISTERNEW r,");
		hql.append(" CH_PW_WAY w,");
		hql.append(" CH_PW_EMPLOYEE e,");
		hql.append(" (select opnid, opnname from CH_PW_OPERATIONSMS where opntype = 2 and smsno = '10086111' and cityid = :cityid) o");
		hql.append(" where r.wayid=w.wayid and r.oprcode=e.employeeid and r.opnid=o.opnid(+) ");
//		hql.append(" and o.id.cityid = :cityid ");and o.id.opntype='2' and o.id.smsno='10086111'
		if(StringUtils.isNotEmpty(p.getWayid())){
			hql.append(" and r.wayid = :wayid ");
		} else {
			hql.append(" and r.wayid in ( select  wayid from ch_pw_way where waymagcode=:employeeid) ");
		}
		if(StringUtils.isNotEmpty(p.getCountyid())){
			hql.append(" and w.countyid =:countyid ");
		}
		if(StringUtils.isNotEmpty(p.getSvccode())){
			hql.append(" and w.svccode =:svccode ");
		}
		if(StringUtils.isNotEmpty(p.getBrand())){
			hql.append(" and r.brand =:brand ");
		}
		if(StringUtils.isNotEmpty(p.getStarlevel())){
			hql.append(" and w.starlevel =:starlevel ");
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
		RegisternewcntQueryParameter p = (RegisternewcntQueryParameter)parameter;
		query.setString("cityid", p.getCityid());
		if(StringUtils.isNotEmpty(p.getWayid())){
			query.setString("wayid", p.getWayid());
		} else {
			query.setString("employeeid", p.getEmployeeid());
		}
		if(StringUtils.isNotEmpty(p.getCountyid())){
			query.setString("countyid", p.getCountyid());
		}
		if(StringUtils.isNotEmpty(p.getSvccode())){
			query.setString("svccode", p.getSvccode());
		}
		if(StringUtils.isNotEmpty(p.getBrand())){
			query.setString("brand", p.getBrand());
		}
		if(StringUtils.isNotEmpty(p.getStarlevel())){
			query.setString("starlevel", p.getStarlevel());
		}
		if(StringUtils.isNotEmpty(p.getDateFrom())){
			query.setString("startoprtime", p.getDateFrom());
		}
		if(StringUtils.isNotEmpty(p.getDateTo())){
			query.setString("endoprtime", p.getDateTo()+" 23:59:59");
		}
	}
}
