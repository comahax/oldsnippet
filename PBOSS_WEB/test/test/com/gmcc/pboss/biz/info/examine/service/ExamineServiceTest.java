package test.com.gmcc.pboss.biz.info.examine.service;

import com.gmcc.pboss.biz.info.examine.service.ChPwExmnRsltService;
import com.gmcc.pboss.biz.info.examine.support.ChPwExmnRsltQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class ExamineServiceTest extends BaseTest {

	private ChPwExmnRsltService ChPwExmnRsltService;


	/**
	 * @return the chPwExmnRsltService
	 */
	public ChPwExmnRsltService getChPwExmnRsltService() {
		return ChPwExmnRsltService;
	}


	/**
	 * @param chPwExmnRsltService the chPwExmnRsltService to set
	 */
	public void setChPwExmnRsltService(ChPwExmnRsltService chPwExmnRsltService) {
		ChPwExmnRsltService = chPwExmnRsltService;
	}


	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		ChPwExmnRsltQueryParameter parameter = new ChPwExmnRsltQueryParameter();
		parameter.setWayid("CH_2323");
		parameter.setMonth("200906");
		parameter.setAction(QueryAction.ALL);
		ServiceResult result = ChPwExmnRsltService.query(new LoginMember(), parameter);
		System.out.println(result);
		System.out.println(result.getRetResult().getData().size());
	}

}
