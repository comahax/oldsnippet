package test.com.gmcc.pboss.biz.basic.constants.service;

import com.gmcc.pboss.biz.basic.dictItem.support.DictItemQueryParameter;
import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.common.support.QueryParameter;

import test.com.gmcc.pboss.common.BaseTest;

/**
 * 商品种类Service测试
 * @author Jimmy
 *
 */
public class ConstantsServiceTest extends BaseTest {

	private ConstantService constantService;


	/**
	 * @return the constantService
	 */
	public ConstantService getConstantService() {
		return constantService;
	}

	/**
	 * @param constantService the constantService to set
	 */
	public void setConstantService(ConstantService constantService) {
		this.constantService = constantService;
	}

	public QueryParameter getParameter() {
//		parameter = ;
		//parameter.setName(getQ());
		return new DictItemQueryParameter();
	}

	public void testQuery() {
		System.out.println("::ONTEST::"+constantService.getConstantName("CH_REWARDTYPE", "30"));
		System.out.println("::ONTEST::"+constantService.getConstantName("CH_REWARDTYPE", "7"));
	}

}
