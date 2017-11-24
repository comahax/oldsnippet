package test.com.gmcc.pboss.biz.communi.service;

import java.util.List;

import test.com.gmcc.pboss.common.BaseTest;

import com.gmcc.pboss.biz.communi.service.CommunicateReplyService;
import com.gmcc.pboss.biz.communi.support.CommunicateReplyParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.communi.ChPwReply;

public class CommunicateReplyServiceTest extends BaseTest {

	CommunicateReplyService communicateReplyService;

	public CommunicateReplyService getCommunicateReplyService() {
		return communicateReplyService;
	}

	public void setCommunicateReplyService(
			CommunicateReplyService communicateReplyService) {
		this.communicateReplyService = communicateReplyService;
	}
	public ServiceResult testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
		ServiceResult result = new ServiceResult();
		CommunicateReplyParameter param = new CommunicateReplyParameter();
		param.setAdvinfoid(new Long("96"));
		param.setOid("0");
		
		param.setSize(5);
		param.setNo(1);
		
		result = communicateReplyService.query(member, param);
		QueryResult queryResult = result.getRetResult();
		List<ChPwReply> data = queryResult.getData();
		for(ChPwReply reply : data) {
			System.out.println("回复id: "+reply.getReplyid()+"\t回复内容: "+reply.getReplycontent()+
					"\t回复时间: "+reply.getReplytime());
		}
		return result;
	}
}
