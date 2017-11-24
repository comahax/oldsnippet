package test.com.gmcc.pboss.biz.info.node.service;

import java.util.Date;

import com.gmcc.pboss.biz.info.node.service.NodeInfoService;
import com.gmcc.pboss.biz.info.node.support.NodeInfoQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;

import test.com.gmcc.pboss.common.BaseTest;

public class NodeInfoServiceTest extends BaseTest {

	private NodeInfoService nodeInfoService;

	public NodeInfoService getNodeInfoService() {
		return nodeInfoService;
	}

	public void setNodeInfoService(NodeInfoService nodeInfoService) {
		this.nodeInfoService = nodeInfoService;
	}

	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");

		NodeInfoQueryParameter parameter = new NodeInfoQueryParameter();
		parameter.setEmployeeId("2");

		ServiceResult result = nodeInfoService.query(new LoginMember(), parameter);
		System.out.println(result);
	}


	public void testEmployeeModify() {
		NodeInfoQueryParameter saveParm = new NodeInfoQueryParameter();

		LoginMember member = new LoginMember();
		member.setCityid("ZS");
		member.setWayid("CH_2323");
		
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		System.out.println("Employee Modify!");
		
		ChPwWayapply saveObj = new ChPwWayapply();
		saveObj.setPrincipal("Test");
		saveObj.setWayid("CH_2323");
		saveObj.setCityid("ZS");
		saveObj.setAuditstatus(Byte.valueOf("0"));
		saveObj.setOptime(new Date());
		saveParm.setSaveObj(saveObj);
		
		nodeInfoService.modify(member, saveParm);
	}

}
