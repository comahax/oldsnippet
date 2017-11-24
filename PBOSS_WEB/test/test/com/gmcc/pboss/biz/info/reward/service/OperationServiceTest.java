package test.com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.support.OperationQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;

import test.com.gmcc.pboss.common.BaseTest;

public class OperationServiceTest extends BaseTest {

	private OperationService operationService;

	public OperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

	public void testQuery() {
		// SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		OperationQueryParameter parameter = new OperationQueryParameter();
		parameter.setQuery("²Ê");
		// parameter.setLimit(15);
		ServiceResult result = operationService.query(new LoginMember(), parameter);
		System.out.println(result);
	}
}
