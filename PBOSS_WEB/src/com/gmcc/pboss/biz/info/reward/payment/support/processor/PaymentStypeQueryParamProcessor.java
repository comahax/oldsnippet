package com.gmcc.pboss.biz.info.reward.payment.support.processor;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.payment.support.PaymentStypeQueryParameter;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class PaymentStypeQueryParamProcessor extends DefaultHqlQueryProcessor
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
		PaymentStypeQueryParameter param = (PaymentStypeQueryParameter) parameter;

		if (StringUtils.isNotEmpty(param.getCityid())) {
			query.setString("cityid", param.getCityid());
		}
	}

	public void process(Criteria criteria, QueryParameter parameter) {
		PaymentStypeQueryParameter param = (PaymentStypeQueryParameter) parameter;

		String cityid = param.getCityid();
		if (StringUtils.isNotEmpty(cityid)) {
			if (cityid.equals("GD")) {
				criteria.add(Restrictions.eq("cityid", "GD"));
			} else {
				criteria.add(Restrictions.or(Restrictions.eq("cityid", "GD"),
						Restrictions.eq("cityid", cityid)));
			}
		}

		String stype = param.getStype();
		if (StringUtils.isNotEmpty(stype)) {
			criteria.add(Restrictions.like("stype", "%" + stype + "%"));
		}

		String ltype = param.getLtype();
		if (StringUtils.isNotEmpty(ltype)) {
			criteria.add(Restrictions.like("ltype", "%" + ltype + "%"));
		}
	}
}
