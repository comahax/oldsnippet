package test.com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.biz.info.reward.service.FailService;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class BbcFailServiceTest extends BaseTest {

	private FailService bbcFailService;

	public FailService getBbcFailService() {
		return bbcFailService;
	}

	public void setBbcFailService(FailService bbcFailService) {
		this.bbcFailService = bbcFailService;
	}

	public void testGetAll() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		RewardFailQueryParameter parameter = new RewardFailQueryParameter();
		parameter.setMonth("200905");
//		parameter.setOpnid("0101020200389");
		parameter.setWayid("CH_2323");
		parameter.setType("9");
		ServiceResult result = bbcFailService.query(new LoginMember(), parameter);
		System.out.println(result.getRetResult());
	}
	
}
