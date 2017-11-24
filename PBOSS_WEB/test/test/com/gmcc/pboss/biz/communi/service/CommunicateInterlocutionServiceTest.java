package test.com.gmcc.pboss.biz.communi.service;

import java.util.List;

import test.com.gmcc.pboss.common.BaseTest;

import com.gmcc.pboss.biz.communi.service.CommunicateInterlocutionService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.bean.BaseModel;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

public class CommunicateInterlocutionServiceTest extends BaseTest {

	private CommunicateInterlocutionService communicateInterlocutionService;

	public CommunicateInterlocutionService getCommunicateInterlocutionService() {
		return communicateInterlocutionService;
	}

	public void setCommunicateInterlocutionService(
			CommunicateInterlocutionService communicateInterlocutionService) {
		this.communicateInterlocutionService = communicateInterlocutionService;
	}
	public ServiceResult testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
//		member.setCityid("ZS");
//		member.setWayid("CH_2323");
		
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setEmployeeid("2");
		param.setIndexPage(false);
		param.setStartDate("");
//		param.setAccountDate("2010-10-01");
		param.setTitle("ssssssss");
		param.setState("3");
		ServiceResult result = communicateInterlocutionService.query(member, param);
		
		System.out.println("********************************"+result.getRetResult().getData());
		List data = result.getRetResult().getData();
		for(int i=0;i<data.size();i++) {
			BaseModel bm = (BaseModel)data.get(i);
			System.out.println("---------------------------"+bm);
			System.out.println("---------------------------"+bm.getDatas());
		}
		return result;
		
	}
}
