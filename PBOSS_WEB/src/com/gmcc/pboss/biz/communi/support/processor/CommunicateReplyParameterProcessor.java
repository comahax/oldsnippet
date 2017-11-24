package com.gmcc.pboss.biz.communi.support.processor;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.communi.support.CommunicateReplyParameter;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class CommunicateReplyParameterProcessor extends
		DefaultQueryParameterProcessor implements QueryParameterProcessor {

	@Override
	public void process(Criteria criteria, QueryParameter parameter) {
		CommunicateReplyParameter param = (CommunicateReplyParameter)parameter;
		criteria.add(Restrictions.eq("advinfoid", param.getAdvinfoid()));
		if(param.getType()!=null&&param.getType()==3){
			criteria.add(Restrictions.eq("oid", param.getOid()));
		}else {
			criteria.add(Restrictions.or(
					Restrictions.eq("oid", param.getOid()),
					Restrictions.eq("oid", "0")));
		}
		criteria.addOrder(Order.desc("replytime"));
	}

	
}
