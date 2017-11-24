package com.gmcc.pboss.manager.service.impl;

import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.manager.service.NodeMemberService;
import com.gmcc.pboss.manager.support.NodeMemberQueryParamProcessor;
public class NodeMemberServiceImpl extends QueryBaseServiceImpl implements NodeMemberService {
	
	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public NodeMemberServiceImpl(){
		super();
		this.setServiceName("������Ա-�����Ա��Ϣ��ѯ");
		this.serviceCode = ServiceCode.MANAGER_NODE_MEMBER;
		this.isNeedLogin = true;//��Ҫ��¼
		this.setProcessor(new NodeMemberQueryParamProcessor());
	}
	
	
}
