package test.com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.support.OperationQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;

import test.com.gmcc.pboss.common.BaseTest;

public class BbcOperationServiceTest extends BaseTest {

	private OperationService bbcOperationService;

	public OperationService getBbcOperationService() {
		return bbcOperationService;
	}

	public void setBbcOperationService(OperationService bbcOperationService) {
		this.bbcOperationService = bbcOperationService;
	}

	public void testQuery() {
		// SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		OperationQueryParameter parameter = new OperationQueryParameter();
		parameter.setQuery("test");
		// parameter.setLimit(15);
		ServiceResult result = bbcOperationService.query(new LoginMember(), parameter);
		System.out.println(result);
		System.out.println(result.getRetResult().getData().size());
	}
}
