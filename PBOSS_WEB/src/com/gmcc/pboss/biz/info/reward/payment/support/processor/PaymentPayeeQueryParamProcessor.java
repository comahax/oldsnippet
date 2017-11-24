package com.gmcc.pboss.biz.info.reward.payment.support.processor;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.payment.support.PaymentPayeeQueryParameter;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class PaymentPayeeQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		return null;
	}

	@Override
	public String[] getParamEncloseName() {
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		PaymentPayeeQueryParameter param = (PaymentPayeeQueryParameter) parameter;

		if (StringUtils.isNotEmpty(param.getCityid())) {
			query.setString("cityid", param.getCityid());
		}
	}

	/**
	 * dao 继承 BaseDaoHibernate，使用 Criteria 方式直接查对象类
	 */
	public void process(Criteria criteria, QueryParameter parameter) {
		PaymentPayeeQueryParameter param = (PaymentPayeeQueryParameter) parameter;

		String cityid = param.getCityid();
		if (StringUtils.isNotEmpty(cityid)) {
			criteria.add(Restrictions.eq("cityid", cityid));
	    }

		String payee = param.getPayee();
		if (StringUtils.isNotEmpty(payee)) {
			criteria.add(Restrictions.like("payee", "%" + payee + "%"));
		}

	}
}
