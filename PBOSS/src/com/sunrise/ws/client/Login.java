package com.sunrise.ws.client;

import com.huawei.boss.webservice.echannel.EChannel;
import com.huawei.boss.webservice.echannel.EChannelService;
import com.huawei.boss.webservice.echannel.LongRequest;
import com.huawei.boss.webservice.echannel.LongResult;
import com.huawei.boss.webservice.echannel.RequestHeader;
import com.huawei.boss.webservice.echannel.LongRequest.MessageBody;

/**
 * @author 黄佰明
 */

public class Login {
	// simpAuth 简单密码认证：让用户输入密码，用工号和密码进行认证;
	// dynamic 动态密码： 让用户输入密码，用工号和密码进行认证;
	// secAuth 短信认证：在此调用短信接口发送短信到用户，用户在二次认证页面输入短信中的密码，用工号和密码进行认证
	// RSA
	// 动态密码认证：根据输入的工号和RSA动态密码,向RSA服务器校验操作员的RSA动态密码，如果漂移根据输入的工号和两个RSA动态密码,向RSA服务器发起密码同步请求.
	// safeword 认证：根据输入的工号,在二次认证页面生成safeword挑战码，根据挑战码生成密码，用工号和密码进行认证

	
	// 下面的常量，对应命令字"interface"

	final static String QUERY_USER_TYPE = "2"; // 查询用户登陆方式
	final static String SIMP_AUTH = "3"; // 静态密码登陆
	final static String SEC_SAND = "4"; // 发信送短信密码
	final static String SEC_AUTH = "5"; // 校验短信密码
	final static String QUERY_CHALLENGE_VALUE = "6";// 查询挑战码
	final static String AUTH_CHALLENGE_VALUE = "7";// 校验挑战码
	final static String DYNAMIC_PASS_AUTH = "8"; // 动态密码校验
	final static String DYNAMIC_EXCURSION_AUTH = "9"; // 动态漂移校验

	// 查询用户登陆方式
	//     返回值中 resultCode的取值为下面5种可能：
	//         RSA , Dynamic , SimpAuth , SecAuth , SafeWord 
	public Result queryUserType(String operator) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		
		// 设置head
		head.setVersion("1.0");
		head.setInterface(QUERY_USER_TYPE);
		head.setUserId(operator);
		// 设置body
		body.setUsername(operator);
		
		LongResult res = execute(head, body);
		Result result = assemble(res);
		if(res.getMessageBody() != null){
			result.setUserType(res.getMessageBody().getCommonId());//设置userType值
		}
		return result;
	}
	
	// 静态密码登陆
	public Result simpAuth(String operator, String password) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// 设置head
		head.setVersion("1.0");
		head.setInterface(SIMP_AUTH);
		head.setUserId(operator);
		head.setPassword(password);
		// 设置body
		body.setUsername(operator);
		body.setPassword(password);

		return assemble(execute(head, body));
	}
	
	// 发信送短信密码
	public Result secSand(String operator) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		
		// 设置head
		head.setVersion("1.0");
		head.setInterface(SEC_SAND);
		head.setUserId(operator);
		// 设置body
		body.setUsername(operator);
		
		return assemble(execute(head, body));
	}
	
	// 校验短信密码
	public Result secAuth(String operator, String password) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// 设置head
		head.setVersion("1.0");
		head.setInterface(SEC_AUTH);
		head.setUserId(operator);
		head.setPassword(password);
		// 设置body
		body.setUsername(operator);
		body.setPassword(password);
		
		return assemble(execute(head, body));
	}
	
	// 查询挑战码
	public Result queryChallengeValue(String operator) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// 设置head
		head.setVersion("1.0");
		head.setInterface(QUERY_CHALLENGE_VALUE);
		head.setUserId(operator);
		// 设置body
		body.setUsername(operator);
		
		LongResult res = execute(head, body);
		Result result = assemble(res);
		if(res.getMessageHead() != null){
			result.setSafewordMessage(res.getMessageHead().getSequenceId());//设置safewordMessage值
		}
		return result;
	}
	
	// 校验挑战码
	public Result authChallengeValue(String operator, String challengeValue, String safewordMessage) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// 设置head
		head.setVersion("1.0");
		head.setInterface(AUTH_CHALLENGE_VALUE);
		head.setUserId(operator);
		head.setPassword(challengeValue);
		head.setSequenceId(safewordMessage);
		// 设置body
		body.setUsername(operator);
		body.setPassword(challengeValue);
		
		return assemble(execute(head, body));
	}
	
	// 动态密码校验
	public Result dynamicPassAuth(String operator, String password) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// 设置head
		head.setVersion("1.0");
		head.setInterface(DYNAMIC_PASS_AUTH);
		head.setUserId(operator);
		head.setPassword(password);
		// 设置body
		body.setUsername(operator);
		body.setPassword(password);
		
		return assemble(execute(head, body));
	}
	
	// 动态漂移校验
	public Result dynamicExcursionAuth(String operator, String password, String password2) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		
		// 设置head
		head.setVersion("1.0");
		head.setInterface(DYNAMIC_EXCURSION_AUTH);
		head.setUserId(operator);
		head.setPassword(password);
		head.setSequenceId(password2);
		// 设置body
		body.setUsername(operator);
		body.setPassword(password);
		
		return assemble(execute(head, body));
	}

	
	//-----------------------------------------------------------------------
	
	//调用Web service方法
	protected LongResult execute(RequestHeader head, MessageBody body) {
		EChannelService service = new EChannelService();
		LongRequest request = new LongRequest();
		request.setMessageHead(head);
		request.setMessageBody(body);
		EChannel portType = service.getEChannelServicePort();
		return portType.judge(request);
	}
	
	//拼装result
	protected Result assemble(LongResult res){
		Result result = new Result();
		if(res.getMessageHead()!= null){
			result.setResultCode(res.getMessageHead().getResultCode());
			result.setResultDec(res.getMessageHead().getResultDesc());
		}
		return result;
	}

	 
}
