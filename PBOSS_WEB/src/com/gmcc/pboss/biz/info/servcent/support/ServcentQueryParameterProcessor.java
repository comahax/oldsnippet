package com.gmcc.pboss.biz.info.servcent.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class ServcentQueryParameterProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		ServcentQueryParameter p = (ServcentQueryParameter)parameter;
		StringBuffer hql = new StringBuffer();
		hql.append(" select s ");
		hql.append(" from com.gmcc.pboss.model.servcent.Servcent s ");
		
		if(StringUtils.isNotEmpty(p.getCountyid())){
			hql.append(" where s.countyid=:countyid ");
		}
		if(StringUtils.isNotEmpty(p.getSvccode().trim())){
			hql.append(" and s.svccode = :svccode ");
		}
		if(StringUtils.isNotEmpty(p.getSvcname().trim())){
			hql.append(" and s.svcname = :svcname ");
		}
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		ServcentQueryParameter p = (ServcentQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(p.getCountyid())){
			query.setString("countyid", p.getCountyid());
		}
		if(StringUtils.isNotEmpty(p.getSvccode().trim())){
			query.setString("svccode",p.getSvccode().trim());
		}
		if(StringUtils.isNotEmpty(p.getSvcname().trim())){
			query.setString("svcname",p.getSvcname().trim());
		}
	}

}
