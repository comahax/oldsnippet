package com.gmcc.pboss.biz.info.reward.support;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Property;

import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class RewardTotalQueryParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {

		RewardQueryParameter param = (RewardQueryParameter) parameter;

		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");

		criteria.add(Property.forName("wayid").eq(param.getWayid()));
		criteria.add(Property.forName("paymonth").eq(param.getMonth()));
		criteria.add(Property.forName("chagmonth").eq(param.getMonth()));

		if (StringUtils.isNotBlank(param.getRewardtype())) {
			criteria.add(Property.forName("rewardtype").in((Short[]) ConvertUtils.convert(param.getRewardtype().split(","), Short.class)));
		}

	}
}
