package test.com.gmcc.pboss.biz.info.regact.service;

import com.gmcc.pboss.biz.info.regactInfo.service.RegactStatisticsService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactStatisticsQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class RegactStatisticsServiceTest extends BaseTest {

	private RegactStatisticsService regactStatisticsService;

	public RegactStatisticsService getRegactStatisticsService() {
		return regactStatisticsService;
	}

	public void setRegactStatisticsService(RegactStatisticsService regactStatisticsService) {
		this.regactStatisticsService = regactStatisticsService;
	}
	
	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		RegactStatisticsQueryParameter parameter = new RegactStatisticsQueryParameter();
		parameter.setMonth("200908");
		parameter.setWayid("CH_2323");
//		ServiceResult result = regactStatisticsService.transact(new LoginMember(), parameter, ServiceType.QUERY);
		ServiceResult result = regactStatisticsService.query(new LoginMember(), parameter);
		System.out.println(result);
	}

}
