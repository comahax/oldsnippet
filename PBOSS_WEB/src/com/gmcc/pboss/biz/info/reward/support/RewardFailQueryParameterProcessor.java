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

		Assert.notBlank(param.getWayid(), ServiceConditionCode.REWARD_WAY, "�������벻��Ϊ�գ�");
		Assert.notBlank(param.getMonth(), ServiceConditionCode.REWARD_MONTH, "��ѯ�·ݲ���Ϊ�գ�");
		Assert.isTrue(param.getMonth().matches("^\\d{6}$"), ServiceConditionCode.REWARD_MONTH_FORMAT, "��ѯ�·ݸ�ʽ����ȷ��");

//		query.setByte("adtflag", param.getFlag());//״̬λֱ�Ӽ���������,��ʹ��Parameter
		query.setInteger("adtflag", -1);//״̬λֱ�Ӽ���������
		query.setInteger("adtflag2", -2);//״̬λֱ�Ӽ���������
//		query.setBinary(arg0, arg1)
		
		query.setString("calcmonth", param.getMonth());
		query.setString("wayid", param.getWayid());

		if (StringUtils.isNotBlank(param.getOpnid())) {
			query.setString("opnid", param.getOpnid());
		}

	}

}
