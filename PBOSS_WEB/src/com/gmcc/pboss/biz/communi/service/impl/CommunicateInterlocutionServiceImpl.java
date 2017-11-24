package com.gmcc.pboss.biz.communi.service.impl;

import com.gmcc.pboss.biz.communi.service.CommunicateInterlocutionService;
import com.gmcc.pboss.biz.communi.support.processor.CommunicateInterlocutionParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;

public class CommunicateInterlocutionServiceImpl extends QueryBaseServiceImpl
		implements CommunicateInterlocutionService {

	public CommunicateInterlocutionServiceImpl() {
		this.serviceCode = ServiceCode.COMMUNICATE;
		this.serviceName = "¹µÍ¨Æ½Ì¨";
		this.isNeedLogin = true;
		this.setProcessor(new CommunicateInterlocutionParameterProcessor());
	}

	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		return super.query(member, parameter);
	}
}
