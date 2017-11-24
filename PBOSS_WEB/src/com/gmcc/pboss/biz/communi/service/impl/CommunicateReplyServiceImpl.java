package com.gmcc.pboss.biz.communi.service.impl;

import java.util.Date;

import com.gmcc.pboss.biz.communi.service.CommunicateReplyService;
import com.gmcc.pboss.biz.communi.support.CommunicateReplyParameter;
import com.gmcc.pboss.biz.communi.support.processor.CommunicateReplyParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.communi.ChPwReply;

public class CommunicateReplyServiceImpl extends QueryBaseServiceImpl implements
		CommunicateReplyService {

	public CommunicateReplyServiceImpl() {
		this.serviceCode = ServiceCode.COMMUNICATE;
		this.serviceName = "沟通平台";
		this.isNeedLogin = true;
		this.setProcessor(new CommunicateReplyParameterProcessor());
	}
	
	/**
	 * 获取公告回复信息
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		return super.query(member, parameter);
	}

	/**
	 * 调查问卷上传附件使用
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		
		ServiceResult result = new ServiceResult();
		boolean isSuccess = false;
		int retCode = ServiceRetCode.FAIL;
		
		CommunicateReplyParameter p = (CommunicateReplyParameter)parameter;
		ChPwReply reply = new ChPwReply();
		reply.setAdvinfoid(p.getAdvinfoid());
		reply.setAffix(p.getAffix());
		reply.setReplytime(new Date());
		reply.setOid(p.getOid());
		
		save(reply);
		isSuccess = true;
		retCode = ServiceRetCode.SUCCESS;
		
		result.setSuccess(isSuccess);
		result.setRetCode(retCode);
		return result;
	}
	
}
