package test.com.gmcc.pboss.operationService;

import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.support.OperationQueryParameter;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class OperationServiceTest extends BaseTest {

	private OperationQueryParameter parameter;
	private OperationService operationService;

	public QueryParameter getParameter() {
		parameter = new OperationQueryParameter();
		parameter.setQuery("²ÊÐÅ");

		return parameter;
	}
	
	public void testQuery() {

		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		
		ServiceResult result = operationService.query(null, getParameter());
		System.out.println(result.isSuccess());
	}


	/**
	 * @return the operationService
	 */
	public OperationService getOperationService() {
		return operationService;
	}


	/**
	 * @param operationService the operationService to set
	 */
	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

}
