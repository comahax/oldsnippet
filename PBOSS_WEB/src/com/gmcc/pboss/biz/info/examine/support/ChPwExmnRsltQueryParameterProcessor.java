package com.gmcc.pboss.biz.info.examine.support;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class ChPwExmnRsltQueryParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {
		ChPwExmnRsltQueryParameter param = (ChPwExmnRsltQueryParameter) parameter;

		Assert.notBlank(param.getWayid(), ServiceConditionCode.EXAMINE_WAY, "渠道编码不能为空！");

		criteria.add(Restrictions.eq("wayid", param.getWayid()));

		if (StringUtils.isBlank(param.getMonth())) {
			criteria.add(Restrictions.eq("exmnperiod", DateFormatUtils.format(new Date(), "yyyyMM")));
		} else {
			criteria.add(Restrictions.eq("exmnperiod", param.getMonth()));
		}
	}

}
