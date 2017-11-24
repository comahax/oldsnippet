package com.gmcc.pboss.biz.info.reward.support.processor;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class RewardLocalDtlProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {

		RewardQueryParameter param = (RewardQueryParameter) parameter;
		//必填项判断		
		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
//		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "报表类型不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");
		

		//建立查询对象
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));///月分条件
		criteria.add(Restrictions.eq("wayid", param.getWayid()));//渠道编码
		
		criteria.addOrder(Order.asc("id"));
		
		//手机号码条件
		if (StringUtils.isNotBlank(param.getOpermobile())){
			criteria.add(Restrictions.like("mobleno", "%"+ param.getOpermobile() +"%"));			
		}
		if (StringUtils.isNotBlank(param.getType())){
			criteria.add(Restrictions.eq("type", param.getType() ));			
		}
	}//process
}
