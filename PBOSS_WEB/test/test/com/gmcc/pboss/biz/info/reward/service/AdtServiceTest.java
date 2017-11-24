package test.com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.biz.info.reward.service.AdtService;

import test.com.gmcc.pboss.common.BaseTest;

public class AdtServiceTest extends BaseTest {

	private AdtService adtService;

	public AdtService getAdtService() {
		return adtService;
	}

	public void setAdtService(AdtService adtService) {
		this.adtService = adtService;
	}

	public void testGetRemark() {
		String remark = adtService.getRemark("COMM_WAYIDNOTEXIST");
		System.out.println(remark);
	}

}
