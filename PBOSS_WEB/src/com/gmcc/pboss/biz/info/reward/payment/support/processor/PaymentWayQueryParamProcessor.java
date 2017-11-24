package com.gmcc.pboss.biz.info.reward.payment.support.processor;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.payment.support.PaymentWayQueryParameter;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class PaymentWayQueryParamProcessor extends DefaultHqlQueryProcessor
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
		PaymentWayQueryParameter param = (PaymentWayQueryParameter) parameter;

		if (StringUtils.isNotEmpty(param.getCityid())) {
			query.setString("cityid", param.getCityid());
		}
	}

	public void process(Criteria criteria, QueryParameter parameter) {
		PaymentWayQueryParameter param = (PaymentWayQueryParameter) parameter;

		String cityid = param.getCityid();
		if (StringUtils.isNotEmpty(cityid)) {
			if (cityid.equals("GD")) {
				criteria.add(Restrictions.eq("cityid", "GD"));
			} else {
				criteria.add(Restrictions.or(Restrictions.eq("cityid", "GD"),
						Restrictions.eq("cityid", cityid)));
			}
		}

		String wayid = param.getWayid();
		if (StringUtils.isNotEmpty(wayid)) {
			criteria.add(Restrictions.eq("wayid", wayid));
		}

		String wayname = param.getWayname();
		if (StringUtils.isNotEmpty(wayname)) {
			criteria.add(Restrictions.like("wayname", "%" + wayname + "%"));
		}
	}
}
