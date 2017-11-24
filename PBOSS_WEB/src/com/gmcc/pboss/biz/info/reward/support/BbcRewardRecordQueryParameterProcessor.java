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

		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "�������벻��Ϊ�գ�");
		//Assert.notBlank(param.getOpnid(), ServiceConditionCode.REWARD_OPN, "ҵ����벻��Ϊ�գ�");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "��ѯ�·ݲ���Ϊ�գ�");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "��ѯ�·ݸ�ʽ����ȷ��");

		criteria.add(Restrictions.eq("wayid", param.getWayid()));
		criteria.add(Restrictions.eq("rewardmonth", param.getMonth()));
		
		if(StringUtils.isNotBlank(param.getOpnid())){
			criteria.add(Restrictions.eq("opnid", param.getOpnid()));
		}
		//��ϸ��ѯ-���վ��������Ͳ�ѯ
		if (StringUtils.isNotBlank(param.getRewardtype())) {
//			criteria.add(Restrictions.eq("rewardtype", Short.valueOf(param.getRewardtype())));
			criteria.add(Restrictions.in("rewardtype", (Short[]) ConvertUtils.convert(param.getRewardtype().split(","), Short.class)));
		}
		
		//�������
		if(StringUtils.isNotEmpty(param.getRewardKind())){
			if(param.getRewardKind().equals(RewardKind.B2M)){
				//B2M��վ
				criteria.add(Restrictions.in("ossrc", new Byte[]{0,1,2}));
			}
			else{//UNPB��������
				criteria.add(Restrictions.in("ossrc", new Byte[]{3,4,5}));
			}
		}
		
		//�����ȡ���ܵ�ֵ
//		����Group by ����
		if(param.isGroup()){
			criteria.setProjection(Projections.projectionList()
					.add(Projections.sum("paysum").as("paysum"))
					.add(Projections.groupProperty("rewardtype"))
					);
		}
		else{//��ϸ��ѯʱ���򣬷����ҳ��ѯ������ʾ�����������ظ���ʾ���������ݲ���ʾ
			criteria.addOrder(Order.asc("rewardlistid"));
		}
	}

}
