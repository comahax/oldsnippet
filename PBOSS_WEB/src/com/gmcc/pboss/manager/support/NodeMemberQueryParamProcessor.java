package com.gmcc.pboss.manager.support;

import org.hibernate.Query;

import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class NodeMemberQueryParamProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		NodeMemberQueryParameter p = (NodeMemberQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from com.gmcc.pboss.member.model.Employee e where e.wayid = :wayid ");
		hql.append(" and e.isnet in(")    //只需要查询渠道下的店员和店主
		   .append(Role.SHOP_ASSISTANT).append(',')
		   .append(Role.SHOP_MASTER)
		   .append(')');
		
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
		NodeMemberQueryParameter p = (NodeMemberQueryParameter)parameter;
		query.setString("wayid", p.getWayid());

	}

}
