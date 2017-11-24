package com.gmcc.pboss.web.common.login;

import com.huawei.boss.webservice.echannel.LongResult;
import com.huawei.boss.webservice.echannel.RequestHeader;
import com.huawei.boss.webservice.echannel.LongRequest.MessageBody;
import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public class LoginCheck extends AbstractLoginCheck{

	public Result doQueryUserType(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		head.setVersion("1.0");
		head.setInterface(QUERY_USER_TYPE);
		head.setUserId(user.getOprcode());
		body.setUsername(user.getOprcode());
		LongResult res = execute(head, body);
		Result result = assemble(res);
		if(res.getMessageBody() != null){
			result.setUserType(res.getMessageBody().getCommonId());//����userTypeֵ
		}
		return result;
	}
	
	public Result doSimpAuth(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		head.setVersion("1.0");
		head.setInterface(SIMP_AUTH);
		head.setUserId(user.getOprcode());
		head.setPassword(user.getPassword());
		body.setUsername(user.getOprcode());
		body.setPassword(user.getPassword());
		return assemble(execute(head, body));
	}
	
	public Result doSecSand(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		head.setVersion("1.0");
		head.setInterface(SEC_SAND);
		head.setUserId(user.getOprcode());
		body.setUsername(user.getOprcode());
		return assemble(execute(head, body));
	}
	
	public Result doSecAuth(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		head.setVersion("1.0");
		head.setInterface(SEC_AUTH);
		head.setUserId(user.getOprcode());
		head.setPassword(user.getPassword());
		body.setUsername(user.getOprcode());
		body.setPassword(user.getPassword());
		return assemble(execute(head, body));
	}
	
	public Result doChallengeQuery(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		head.setVersion("1.0");
		head.setInterface(CHALLENGE_QUERY_VALUE);
		head.setUserId(user.getOprcode());
		body.setUsername(user.getOprcode());
		LongResult res = execute(head, body);
		Result result = assemble(res);
		if(res.getMessageHead() != null){
			result.setSafewordMessage(res.getMessageHead().getSequenceId());//����safewordMessageֵ
			result.setSafewordCode(res.getMessageHead().getSequenceId());//����safewordMessageֵ
		}
		return result;
	}
	
	public Result doChallengeAuth(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		// ����head
		head.setVersion("1.0");
		head.setInterface(CHALLENGE_AUTH_VALUE);
		head.setUserId(user.getOprcode());
		head.setPassword(user.getSafewordMessage());
		head.setSequenceId(user.getSafewordMessage());
		body.setUsername(user.getOprcode());
		body.setPassword(user.getPassword());
		return assemble(execute(head, body));
	}
	
	/**
	 * ָ��:8
	 * RSA��̬��֤
	 */
	public Result doDynamicPassAuth(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		head.setVersion("1.0");
		head.setInterface(DYNAMIC_PASS_AUTH);
		head.setUserId(user.getOprcode());
		head.setPassword(user.getPassword());
		body.setUsername(user.getOprcode());
		body.setPassword(user.getPassword());
		return assemble(execute(head, body));
	}
	
	/**
	 * ָ��:9
	 * RSA��̬Ư����֤
	 */
	public Result doDynamicExcursionAuth(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		head.setVersion("1.0");
		head.setInterface(DYNAMIC_EXCURSION_AUTH);
		head.setUserId(user.getOprcode());
		head.setPassword(user.getPassword());
		body.setUsername(user.getOprcode());
		body.setPassword(user.getCurToken());
		return assemble(execute(head, body));
	}
	
	public Result doError(User user) throws Exception {
		throw new Exception("�޴�ָ��!");
	}

	@Override
	public Result doDynamicCheck(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
