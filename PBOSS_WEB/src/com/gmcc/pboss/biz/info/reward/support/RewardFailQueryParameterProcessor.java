package com.gmcc.pboss.biz.info.reward.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class RewardFailQueryParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Query query, QueryParameter parameter) {

		RewardFailQueryParameter param = (RewardFailQueryParameter) parameter;

		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");

//		query.setByte("adtflag", param.getFlag());//状态位直接加在条件中,不使用Parameter
		query.setInteger("adtflag", -1);//状态位直接加在条件中
		query.setInteger("adtflag2", -2);//状态位直接加在条件中
//		query.setBinary(arg0, arg1)
		
		query.setString("calcmonth", param.getMonth());
		query.setString("wayid", param.getWayid());

		if (StringUtils.isNotBlank(param.getOpnid())) {
			query.setString("opnid", param.getOpnid());
		}

	}

}
