package com.gmcc.pboss.biz.info.reward.service.impl;

import org.springframework.beans.factory.InitializingBean;

import com.gmcc.pboss.biz.info.reward.service.FailService;
import com.gmcc.pboss.biz.info.reward.support.FailModelSetParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;

public class BbcFailServiceImpl extends FailServiceImpl implements FailService, InitializingBean {
	
	
	public BbcFailServiceImpl() {
		this.setServiceCode(ServiceCode.REWARD_BBC);
		this.setServiceName("酬金明细查询_网站渠道");
	}

	protected void setParameter(FailModelSetParameter remark, RewardFailQueryParameter parameter) {
		
		
		remark.setRemark(getAdtService().getRemark(remark.getAdtcode()));
		remark.setOpnname(getOperationService().getOperationName(remark.getOpnid()));
		remark.setRewardtypeName(Constant.getConstantName(ConstantsType.BBC_REWARD_TPYPE, parameter.getType()));
	}

}
