package test.com.gmcc.pboss.biz.basic.node.service;

import com.gmcc.pboss.biz.basic.node.service.WayApplyService;
import com.gmcc.pboss.biz.basic.node.support.WayApplyQueryParameter;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;

import test.com.gmcc.pboss.common.BaseTest;

public class WayApplyServiceTest extends BaseTest {

	private WayApplyService wayApplyService;

	public WayApplyService getWayApplyService() {
		return wayApplyService;
	}

	public void setWayApplyService(WayApplyService wayApplyService) {
		this.wayApplyService = wayApplyService;
	}

	public void testSave() {
		WayApplyQueryParameter apply = new WayApplyQueryParameter();
		apply.setPrincipal("≤‚ ‘TEST");
		apply.setPrincipaltel("13560697221");
		apply.setCityid("ZS");
		wayApplyService.initiate(null, apply);
	}

}
