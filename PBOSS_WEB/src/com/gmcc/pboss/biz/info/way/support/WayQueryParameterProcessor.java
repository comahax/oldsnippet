package com.gmcc.pboss.biz.info.way.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class WayQueryParameterProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		WayQueryParameter p = (WayQueryParameter)parameter;
		StringBuffer hql = new StringBuffer();
		hql.append(" select w ");
		hql.append(" from com.gmcc.pboss.biz.info.node.model.Way w ");
		hql.append(" where w.cityid=:cityid and w.waymagcode=:waymagcode ");//w.upperwayid=:upperwayid and 
//		hql.append(" start with w.wayid = :upperwayid ");
		if(StringUtils.isNotEmpty(p.getWayid().trim())){
			hql.append(" and w.wayid = :wayid ");
		}
		if(StringUtils.isNotEmpty(p.getWayname().trim())){
			hql.append(" and w.wayname = :wayname ");
		}
		
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		WayQueryParameter p = (WayQueryParameter)parameter;
		query.setString("cityid", p.getCityid());
		query.setString("waymagcode", p.getWaymagcode());
		
		if(StringUtils.isNotEmpty(p.getWayid().trim())){
			query.setString("wayid", p.getWayid().trim());
		}
		if(StringUtils.isNotEmpty(p.getWayname().trim())){
			query.setString("wayname", p.getWayname().trim());
		}
		
	}

}
