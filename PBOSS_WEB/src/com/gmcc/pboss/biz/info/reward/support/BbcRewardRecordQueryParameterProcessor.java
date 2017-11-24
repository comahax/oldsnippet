package com.gmcc.pboss.biz.info.reward.support;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class BbcRewardRecordQueryParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {

		BbcRewardQueryParameter param = (BbcRewardQueryParameter) parameter;

		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "渠道编码不能为空！");
		//Assert.notBlank(param.getOpnid(), ServiceConditionCode.REWARD_OPN, "业务代码不能为空！");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "查询月份不能为空！");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "查询月份格式不正确！");

		criteria.add(Restrictions.eq("wayid", param.getWayid()));
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));
		
		if(StringUtils.isNotBlank(param.getOpnid())){
			criteria.add(Restrictions.eq("opnid", param.getOpnid()));
		}
		//明细查询-按照具体酬金类型查询
		if (StringUtils.isNotBlank(param.getRewardtype())) {
//			criteria.add(Restrictions.eq("rewardtype", Short.valueOf(param.getRewardtype())));
			criteria.add(Restrictions.in("rewardtype", (Short[]) ConvertUtils.convert(param.getRewardtype().split(","), Short.class)));
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
		
		//如果是取汇总的值
//		加上Group by 条件
		if(param.isGroup()){
			criteria.setProjection(Projections.projectionList()
					.add(Projections.sum("paysum").as("paysum"))
					.add(Projections.groupProperty("rewardtype"))
					);
		}
		else{//明细查询时排序，否则分页查询数据显示：部分数据重复显示，部分数据不显示
			criteria.addOrder(Order.asc("rewardlistid"));
		}
	}

}
