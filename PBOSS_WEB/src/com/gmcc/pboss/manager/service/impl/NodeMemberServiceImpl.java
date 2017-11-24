package com.gmcc.pboss.manager.service.impl;

import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.manager.service.NodeMemberService;
import com.gmcc.pboss.manager.support.NodeMemberQueryParamProcessor;
public class NodeMemberServiceImpl extends QueryBaseServiceImpl implements NodeMemberService {
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public NodeMemberServiceImpl(){
		super();
		this.setServiceName("经理人员-网点店员信息查询");
		this.serviceCode = ServiceCode.MANAGER_NODE_MEMBER;
		this.isNeedLogin = true;//需要登录
		this.setProcessor(new NodeMemberQueryParamProcessor());
	}
	
	
}
