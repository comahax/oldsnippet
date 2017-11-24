package com.gmcc.pboss.biz.info.reward.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class BbcRewardTotalQueryParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {

		BbcRewardQueryParameter param = (BbcRewardQueryParameter) parameter;

		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");
		
		criteria.add(Restrictions.eq("wayid", param.getWayid()));
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));
		
		if (StringUtils.isNotBlank(param.getRewardtype())) {
			criteria.add(Restrictions.eq("rewardtype", Short.valueOf(param.getRewardtype())));
		}
		
		//酬金种类
		if(StringUtils.isNotEmpty(param.getRewardKind())){
			if(param.getRewardKind().equals(RewardKind.B2M)){
				//B2M网站
				criteria.add(Restrictions.in("ossrc", new Byte[]{0,1,2}));
			}
			else{//UNPB创新联盟
				criteria.add(Restrictions.in("ossrc", new Byte[]{3,4,5}));
			}
		}
		
		if(param.isGroup()){//统计汇总
			criteria.setProjection(Projections.projectionList().
					add(Projections.sum("paymoney").as("paymoney")).
					add(Projections.groupProperty("rewardtype")));
		}
		else{//预留给明细查询扩展
			
		}
	}

}
