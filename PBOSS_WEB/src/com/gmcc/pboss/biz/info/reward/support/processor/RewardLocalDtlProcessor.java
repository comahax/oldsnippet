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
		//�������ж�		
		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "�������벻��Ϊ�գ�");
//		Assert.notBlank(param.getRewardtype(), ServiceConditionCode.REWARD_TYPE, "�������Ͳ���Ϊ�գ�");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "��ѯ�·ݲ���Ϊ�գ�");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "��ѯ�·ݸ�ʽ����ȷ��");
		

		//������ѯ����
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));///�·�����
		criteria.add(Restrictions.eq("wayid", param.getWayid()));//��������
		
		criteria.addOrder(Order.asc("id"));
		
		//�ֻ���������
		if (StringUtils.isNotBlank(param.getOpermobile())){
			criteria.add(Restrictions.like("mobleno", "%"+ param.getOpermobile() +"%"));			
		}
		if (StringUtils.isNotBlank(param.getType())){
			criteria.add(Restrictions.eq("type", param.getType() ));			
		}
	}//process
}
