package com.gmcc.pboss.biz.info.node.support;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class NodeInfoQueryParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {
		NodeInfoQueryParameter param = (NodeInfoQueryParameter) parameter;
		criteria.add(Restrictions.eq("employeeid", param.getEmployeeId()));
	}

}
