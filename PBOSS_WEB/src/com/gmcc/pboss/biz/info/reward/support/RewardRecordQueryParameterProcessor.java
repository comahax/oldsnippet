package com.gmcc.pboss.biz.info.reward.support;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

public class RewardRecordQueryParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {

		RewardQueryParameter param = (RewardQueryParameter) parameter;

		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "�������벻��Ϊ�գ�");
		//Assert.notBlank(param.getOpnid(), ServiceConditionCode.REWARD_OPN, "ҵ����벻��Ϊ�գ�");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "��ѯ�·ݲ���Ϊ�գ�");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "��ѯ�·ݸ�ʽ����ȷ��");

		criteria.add(Restrictions.eq("wayid", param.getWayid()));
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));
		
		//ҵ�����
		if(StringUtils.isNotBlank(param.getOpnid())){
			criteria.add(Restrictions.eq("opnid", param.getOpnid()));
		}
		//�������
		if (StringUtils.isNotBlank(param.getRewardtype())) {
			criteria.add(Restrictions.in("rewardtype", (Short[]) ConvertUtils.convert(param.getRewardtype().split(","), Short.class)));
		}
		
		//�����ȡ���ܵ�ֵ
//		����Group by ����
		if (param.isGroup()){
			criteria.setProjection(Projections.projectionList().
					add(Projections.sum("paysum").as("paysum")).
					add(Projections.sum("paymoney1").as("paymoney1")).
					add(Projections.sum("paymoney2").as("paymoney2")).
					add(Projections.sum("paymoney3").as("paymoney3")).
					add(Projections.groupProperty("rewardtype")).
					add(Projections.groupProperty("paymonth1")).
					add(Projections.groupProperty("paymonth2")).
					add(Projections.groupProperty("paymonth3")).
					add(Projections.groupProperty("acctype"))
					);
		}
		//
//		if (StringUtils.isNotBlank(param.getOpermobile())) {
//			Assert.isMobile(param.getOpermobile(), ServiceConditionCode.REWARD_MOBILE, "��ǰ���벻���й��ƶ�����");
//			criteria.add(Restrictions.eq("opermobile", param.getOpermobile()));
//		}
	}

}
