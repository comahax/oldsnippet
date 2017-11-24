package com.gmcc.pboss.biz.info.reward.service.impl;

import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.member.service.MemberServiceRetCode;

public class RewardBalanceServiceImpl extends RewardRecordServiceImpl {

	public RewardBalanceServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDBALANC;
		this.serviceName = "酬金余额查询";
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.BaseServiceImpl#other(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	/**
	 * 社会渠道网点酬金池余额业务
	 */
	@Override
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		//构造业务返回值
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);
		result.setRetObject(member);
		
		//查询2期
		RewardQueryParameter para = (RewardQueryParameter)parameter;
		para.setWayid(member.getWayid());
		//返回值
		Long rtnObj[] = new Long[2];		
		para.setTerm("2");
		rtnObj[0] = statRewardBalance(para);//二期结算金额总额
		
		para.setTerm("3");
		rtnObj[1] = statRewardBalance(para);//三期结算金额总额
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		result.setRetObject(rtnObj);
		
		return result;
	}
}
