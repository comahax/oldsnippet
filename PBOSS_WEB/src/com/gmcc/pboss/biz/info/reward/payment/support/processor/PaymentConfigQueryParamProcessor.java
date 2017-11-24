package com.gmcc.pboss.biz.info.reward.payment.support.processor;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.payment.support.PaymentConfigQueryParameter;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class PaymentConfigQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		return null;
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		PaymentConfigQueryParameter param = (PaymentConfigQueryParameter) parameter;

		if (StringUtils.isNotEmpty(param.getKey())) {
			query.setString("key", param.getKey());
		}
	}

	public void process(Criteria criteria, QueryParameter parameter) {
		PaymentConfigQueryParameter param = (PaymentConfigQueryParameter) parameter;

		if (StringUtils.isNotEmpty(param.getKey())) {
			criteria.add(Restrictions.eq("key", param.getKey()));
		}
	}
}
