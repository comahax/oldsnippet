package com.gmcc.pboss.web.common.login;


import org.apache.log4j.Logger;

import com.huawei.boss.webservice.loginauth.DynamicCheckRequest;
import com.huawei.boss.webservice.loginauth.DynamicCheckResult;
import com.huawei.boss.webservice.loginauth.GetAuthTypeRequest;
import com.huawei.boss.webservice.loginauth.GetAuthTypeResult;
import com.huawei.boss.webservice.loginauth.LoginAuth;
import com.huawei.boss.webservice.loginauth.LoginAuthServiceSZ;
import com.huawei.boss.webservice.loginauth.RSACheckRequest;
import com.huawei.boss.webservice.loginauth.RSACheckResult;
import com.huawei.boss.webservice.loginauth.RequestHeader;
import com.huawei.boss.webservice.loginauth.SafeWordCheckRequest;
import com.huawei.boss.webservice.loginauth.SafeWordCheckResult;
import com.huawei.boss.webservice.loginauth.SecAuthCheckRequest;
import com.huawei.boss.webservice.loginauth.SecAuthCheckResult;
import com.huawei.boss.webservice.loginauth.SimpAuthCheckRequest;
import com.huawei.boss.webservice.loginauth.SimpAuthCheckResult;
import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public class NewLoginCheckSZ extends AbstractLoginCheck {
	public static final Logger log = Logger.getLogger(NewLoginCheckSZ.class);
	/**
	 * 登陆方式查询
	 * 入参:
	 * 1 工号 OperatorID 必须输入
	 * 出参:
	 * 1. 处理结果 0 还有下一步,1 成功，2 失败
	 * 2 认证方式 列值如下
	 *		Dynamic    动态登录认证
	 *		RSA        RSA登录认证
	 *		SafeWord   安全码登录
	 *		SimpAuth    简单登录(对应需求中提到的固定密码)
	 *		SecAuth      二次登录
   	 * 3 错误信息：如果失败，此值放入错误信息
	 */
	public Result doQueryUserType(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.GetAuthTypeRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.GetAuthTypeRequest.MessageBody();
		
		// 设置head
		head.setVersion("1.0");
		// 设置body
		body.setOperatorID(user.getOprcode());
		body.setRemoteIP(user.getIp());
		body.setMacAddr(user.getMacAddr());
		body.setRemoteName(user.getRemoteName());
		log.info("##send------doSimpAuth--OperatorID:["+body.getOperatorID()+"]");
		LoginAuthServiceSZ service=new LoginAuthServiceSZ();
		LoginAuth loginAuth=service.getLoginAuthServicePort();
		GetAuthTypeRequest authTypeRequestMessage=new GetAuthTypeRequest();
		authTypeRequestMessage.setMessageHead(head);//.setMessageHead(head);
		authTypeRequestMessage.setMessageBody(body);
		GetAuthTypeResult res=loginAuth.getAuthType(authTypeRequestMessage);
		Result result = new Result();
		if(res.getMessageHead()!=null){
			result.setResultCode(res.getMessageHead().getRtCode());
			result.setResultDec(res.getMessageHead().getRtMessage());
		}
		if(res.getMessageBody() != null){
			result.setUserType(res.getMessageBody().getType());//设置userType值
		}
		log.info("##------doQueryUserType-----:"+result);
		return result;
	}
	/**
	 * 固定密码校验
	 * 入参:
	 * 1 工号 OperatorID 必须输入
	 * 2 固定密码 Password 必须输入
	 * 出参:
	 * 1 处理结果 0 还有下一步,1 成功，2 失败
	 * 2 错误信息：如果失败，此值放入错误信息
	 */
	public Result doSimpAuth(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.SimpAuthCheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.SimpAuthCheckRequest.MessageBody();

		// 设置head
		head.setVersion("1.0");
		// 设置body
		body.setOperatorID(user.getOprcode());
		body.setRemoteIP(user.getIp());
		body.setMacAddr(user.getMacAddr());
		body.setRemoteName(user.getRemoteName());
		body.setPassWord(user.getPassword());
		log.info("##send------doSimpAuth--OperatorID:["+body.getOperatorID()+"]");
		LoginAuthServiceSZ service=new LoginAuthServiceSZ();
		LoginAuth loginAuth=service.getLoginAuthServicePort();
		SimpAuthCheckRequest simpAuthCheckRequest=new SimpAuthCheckRequest();
		simpAuthCheckRequest.setMessageHead(head);
		simpAuthCheckRequest.setMessageBody(body);
		SimpAuthCheckResult res=loginAuth.simpAuthCheck(simpAuthCheckRequest);
		Result result = new Result();
		if(res.getMessageHead()!=null){
			result.setResultCode(res.getMessageHead().getRtCode());
			result.setResultDec(res.getMessageHead().getRtMessage());
		}
		log.info("##------doSimpAuth-----:"+result);

		return result;
	}
	
	/**
	 * 短信码 --验证密码发送短信码（第二步）
	 * 
	 */
	public Result doSecSand(User user) throws Exception {
		return this.secAuthCheck(user);
	}
	/**
	 * 短信码校验（三步）
	 */
	public Result doSecAuth(User user) throws Exception {
		return this.secAuthCheck(user);
	}
	/**
	 * 安全码校验-获取挑战码（第一步）
	 */
	public Result doChallengeQuery(User user) throws Exception {
		user.setStep(1);
		return this.safeWordCheck(user);
	}
	/**
	 * 安全码校验（第二步）
	 */
	public Result doChallengeAuth(User user) throws Exception {
		user.setStep(2);
		return this.safeWordCheck(user);
	}
	
	/**
	 * RSA动态验证(第一，二，三步)
	 */
	public Result doDynamicPassAuth(User user) throws Exception {
		return this.RSACheck(user);
	}
	
	/**
	 * RSA动态漂移验证（第四步）
	 */
	public Result doDynamicExcursionAuth(User user) throws Exception {
		user.setStep(4);
		return this.RSACheck(user);
	}
	
	public Result doError(User user) throws Exception {
		throw new Exception("无此指令!");
	}
	/**
	 * 动态密码校验
	 * 入参：
	 * 1 工号 OperatorID 必须输入
	 * 2 步骤 Step 首次输入 1,第二次输入2
	 * 3 固定密码 Password 步骤1可选,步骤2 必须输入
	 * 出参：
	 * 1. 处理结果 0 还有下一步,1 成功，2 失败
     * 2  错误信息：如果失败，此值放入错误信息
	 */ 
	public Result doDynamicCheck(User user) throws Exception{
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.DynamicCheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.DynamicCheckRequest.MessageBody();

		// 设置head
		head.setVersion("1.0");
		// 设置body
		body.setStep(user.getStep());
		body.setOperatorID(user.getOprcode());
		body.setRemoteIP(user.getIp());
		body.setMacAddr(user.getMacAddr());
		body.setRemoteName(user.getRemoteName());
		if(2==user.getStep()){
			/*JAXBElement<String> ps = new JAXBElement<String>(new QName(
					"", "passWord"), String.class, user.getPassword());*/
			body.setPassWord(user.getPassword());
		}
		log.info("##send------dynamicCheck动态密码-step:["+user.getStep()+"-OperatorID:["+body.getOperatorID()+"]");
		System.out.println("#########send------dynamicCheck动态密码-step:["+user.getStep()+"-OperatorID:["+body.getOperatorID()+"]");
		LoginAuthServiceSZ service=new LoginAuthServiceSZ();
		LoginAuth loginAuth=service.getLoginAuthServicePort();
		DynamicCheckRequest dynamicCheckRequest=new DynamicCheckRequest();
		dynamicCheckRequest.setMessageHead(head);
		dynamicCheckRequest.setMessageBody(body);
		DynamicCheckResult res=loginAuth.dynamicCheck(dynamicCheckRequest);
		Result result = new Result();
		if(res.getMessageHead()!=null){
			result.setResultCode(res.getMessageHead().getRtCode());
			result.setResultDec(res.getMessageHead().getRtMessage());
		}
		System.out.println("#########------dynamicCheck动态密码-step:["+user.getStep()+"]----:"+result);
		log.info("##------dynamicCheck动态密码-step:["+user.getStep()+"]----:"+result);
		return result;
	}
	/**
	 * 短信密码校验
	 * 入参:
	 * 1 工号 OperatorID 必须输入
	 * 2 步骤 Step 首次输入 1,第二次输入2,第三次输入3
	 * 3 固定密码 Password 步骤1可选,步骤2 必须输入,步骤3必须输入
	 * 4 短信二次确认密码 secondpass 步骤1,2 可选，步骤3必须输入
	 * 出参:
	 * 1. 处理结果 0 还有下一步,1 成功，2 失败
	 * 2  错误信息：如果失败，此值放入错误信息
	 */ 
	public Result secAuthCheck(User user) throws Exception{
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.SecAuthCheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.SecAuthCheckRequest.MessageBody();
		
		// 设置head
		head.setVersion("1.0");
		// 设置body
		body.setOperatorID(user.getOprcode());
		body.setRemoteIP(user.getIp());
		body.setMacAddr(user.getMacAddr());
		body.setRemoteName(user.getRemoteName());
		body.setStep(user.getStep());
		if(user.getStep()>1){
			/*JAXBElement<String> ps = new JAXBElement<String>(new QName(
				     "", "passWord"), String.class, user.getPassword());*/
			body.setPassWord(user.getPassword());//固定密码
			if(user.getStep()==3){
				/*JAXBElement<String> ps2 = new JAXBElement<String>(new QName(
					     "", "secondPass"), String.class, user.getPassword());*/
				body.setSecondPass(user.getSecondPass());//二次密码
			}
		}
		log.info("##send------secAuthCheck-step:["+user.getStep()+"-OperatorID:["+body.getOperatorID()+"]");
		LoginAuthServiceSZ service=new LoginAuthServiceSZ();
		LoginAuth loginAuth=service.getLoginAuthServicePort();
		SecAuthCheckRequest secAuthCheckRequest=new SecAuthCheckRequest();
		secAuthCheckRequest.setMessageHead(head);
		secAuthCheckRequest.setMessageBody(body);
		SecAuthCheckResult res=loginAuth.secAuthCheck(secAuthCheckRequest);
		Result result = new Result();
		if(res.getMessageHead()!=null){
			result.setResultCode(res.getMessageHead().getRtCode());
			result.setResultDec(res.getMessageHead().getRtMessage());
		}
		log.info("##------secAuthCheck--step:["+user.getStep()+"]---:"+result);
		return result;
	}
	/**
	 * 安全码校验
	 * 入参:
	 * 1 工号 OperatorID 必须输入
	 * 2 步骤 Step 首次输入 1,第二次输入2
	 * 3 挑战信息 challengeMessage 第二次必须输入（根据第一次的返回）
	 * 4 挑战码 challengeCode第二次必须输入
	 * 5 挑战计算密码 password 第二次必须输入
	 * 出参:
	 * 1. 处理结果 0 还有下一步,1 成功，2 失败
	 * 2．挑战信息 challengeMessage 第一步会返回一个xml报文的挑战码信息
	 * 3．挑战码 challengeCode 第一步会返回一个code码
	 * 3．错误信息：如果失败，此值放入错误信息。
	 */ 
	public Result safeWordCheck(User user)throws Exception {
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.SafeWordCheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.SafeWordCheckRequest.MessageBody();

		// 设置head
		head.setVersion("1.0");
		// 设置body
		body.setOperatorID(user.getOprcode());
		body.setRemoteIP(user.getIp());
		body.setMacAddr(user.getMacAddr());
		body.setRemoteName(user.getRemoteName());
		body.setStep(user.getStep());
		if(user.getStep()==2){
			/*JAXBElement<String> challengeMes = new JAXBElement<String>(new QName(
				     "", "challengeMessage"), String.class, user.getSafewordMessage());*/
			body.setChallengeMessage(user.getSafewordMessage());
			/*JAXBElement<String> challengeC = new JAXBElement<String>(new QName(
				     "", "challengeCode"), String.class, user.getSafewordCode());*/
			body.setChallengeCode(user.getSafewordCode());
			/*JAXBElement<String> ps = new JAXBElement<String>(new QName(
				     "", "passWord"), String.class, user.getPassword());*/
			body.setPassWord(user.getPassword());
		}
		log.info("##send------safeWordCheck-step:["+user.getStep()+"-OperatorID:["+body.getOperatorID()+"]--challengeMessage:["+body.getChallengeMessage()+"]--challengeCode:["+body.getChallengeCode()+"]");
		LoginAuthServiceSZ service=new LoginAuthServiceSZ();
		LoginAuth loginAuth=service.getLoginAuthServicePort();
		SafeWordCheckRequest safeWordCheckRequest=new SafeWordCheckRequest();
		safeWordCheckRequest.setMessageHead(head);
		safeWordCheckRequest.setMessageBody(body);
		SafeWordCheckResult res=loginAuth.safeWordCheck(safeWordCheckRequest);
		Result result = new Result();
		if(res.getMessageHead()!=null){
			result.setResultCode(res.getMessageHead().getRtCode());
			result.setResultDec(res.getMessageHead().getRtMessage());
		}
		if(res.getMessageBody()!=null){
			result.setSafewordCode(res.getMessageBody().getChallengecode());
			result.setSafewordMessage(res.getMessageBody().getChallengemsg());
		}
		log.info("##------safeWordCheck--step:["+user.getStep()+"]---:"+result);
		return result;
	}
	/**
	 * RSA校验
	 * 入参:
	 * 1 工号 OperatorID 必须输入
	 * 2 步骤 Step 首次输入 1,步骤2输入2，步骤3输入3，步骤4，输入4
	 * 3 固定密码，步骤2，3，4 必须输入。
	 * 4 RSA当前token 步骤3，4 必须输入。
	 * 5 RSA下一分钟token 步骤4必须输入。
	 * 出参:
	 * 1. 处理结果 0 还有下一步,1 成功，2 失败
	 * 2  错误信息：如果失败，此值放入错误信息
	 */ 
	public Result RSACheck(User user) throws Exception{
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.RSACheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.RSACheckRequest.MessageBody();
		
		// 设置head
		head.setVersion("1.0");
		// 设置body
		body.setOperatorID(user.getOprcode());//工号
		body.setRemoteIP(user.getIp());
		body.setMacAddr(user.getMacAddr());
		body.setRemoteName(user.getRemoteName());
		body.setStep(user.getStep());//步骤 Step
		if(user.getStep()>1){
			/*JAXBElement<String> ps = new JAXBElement<String>(new QName(
				     "", "passWord"), String.class, user.getPassword());*/
			body.setPassWord(user.getPassword());//固定密码
			if(user.getStep()>2){
				/*JAXBElement<String> curToken = new JAXBElement<String>(new QName(
					     "", "curToken"), String.class, user.getCurToken());*/
				body.setCurToken(user.getCurToken());//RSA当前token
				if(user.getStep()==4){
					/*JAXBElement<String> nextToken = new JAXBElement<String>(new QName(
						     "", "nextToken"), String.class, user.getNextToken());*/
					body.setNextToken(user.getNextToken());//RSA下一分钟token
				}
			}
		}
		log.info("##send------RSACheck-step:["+user.getStep()+"-Operator:["+body.getOperatorID()+"]");
		LoginAuthServiceSZ service=new LoginAuthServiceSZ();
		LoginAuth loginAuth=service.getLoginAuthServicePort();
		RSACheckRequest rsaCheckRequest=new RSACheckRequest();
		rsaCheckRequest.setMessageHead(head);
		rsaCheckRequest.setMessageBody(body);
		RSACheckResult res=loginAuth.rsaCheck(rsaCheckRequest);
		Result result = new Result();
		if(res.getMessageHead()!=null){
			result.setResultCode(res.getMessageHead().getRtCode());
			result.setResultDec(res.getMessageHead().getRtMessage());
		}
		log.info("##------RSACheck--step:["+user.getStep()+"]---:"+result);
		return result;
	}
	
}
