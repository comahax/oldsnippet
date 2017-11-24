package com.gmcc.pboss.common.nosect.support.processor;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.Assert;

/**
 * ���˹�˾Ӫ���з���
 * @author yuwenjun
 * @date 2010-3-1
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������ֻ���������ز�ѯ
 */
public class NosectParameterProcessor extends DefaultQueryParameterProcessor implements QueryParameterProcessor {

	public void process(Criteria criteria, QueryParameter parameter) {
//		NosectQueryParameter param = (NosectQueryParameter) parameter;
//		
//		Assert.notBlank(param.getMobileNo(), ServiceConditionCode.REWARD_MOBILE, "�ֻ����벻��Ϊ�գ�");
		return;
	}//process
	
	//ͨ���ֻ������ѯ�������߼�
	public void processCityQuery(Criteria criteria, String mobileNo){
		Assert.notBlank(mobileNo, ServiceConditionCode.REWARD_MOBILE, "�ֻ����벻��Ϊ�գ�");
//		criteria.
		criteria.add(Restrictions.ge("endno", mobileNo));
		criteria.add(Restrictions.le("beginno", mobileNo));
	}
}
