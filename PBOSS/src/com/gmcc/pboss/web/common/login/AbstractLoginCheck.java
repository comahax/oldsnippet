package com.gmcc.pboss.web.common.login;

import com.huawei.boss.webservice.echannel.EChannel;
import com.huawei.boss.webservice.echannel.EChannelService;
import com.huawei.boss.webservice.echannel.LongRequest;
import com.huawei.boss.webservice.echannel.LongResult;
import com.huawei.boss.webservice.echannel.RequestHeader;
import com.huawei.boss.webservice.echannel.LongRequest.MessageBody;
import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public abstract class AbstractLoginCheck implements ILoginCheck{
	
	public Result doSend2WS(User user, String type) throws Exception{
		if(type.equals(this.QUERY_USER_TYPE)){ //查询用户登陆类型
			return doQueryUserType(user);
		}else if(type.equals(this.SIMP_AUTH)){ //普通登陆
			return doSimpAuth(user);
		}else if(type.equals(this.SEC_SAND)){ //短信获取
			return doSecSand(user);
		}else if(type.equals(this.SEC_AUTH)){ //短信验证
			return doSecAuth(user);
		}else if(type.equals(this.CHALLENGE_QUERY_VALUE)){ //挑战码获取
			user.setStep(1);
			return doChallengeQuery(user);
		}else if(type.equals(this.CHALLENGE_AUTH_VALUE)){ //挑战码验证
			user.setStep(2);
			return doChallengeAuth(user);
		}else if(type.equals(this.DYNAMIC_PASS_AUTH)){ //RSA动态密码校验
			return doDynamicPassAuth(user);
		}else if(type.equals(this.DYNAMIC_EXCURSION_AUTH)){ //RSA动态密码漂移校验
			return doDynamicExcursionAuth(user);
		}else{
			return doError(user);
		}
	}
	
	
	public abstract Result doQueryUserType(User user) throws Exception;
	public abstract Result doSimpAuth(User user) throws Exception;
	public abstract Result doSecSand(User user) throws Exception;
	public abstract Result doSecAuth(User user) throws Exception;
	public abstract Result doChallengeQuery(User user) throws Exception;
	public abstract Result doChallengeAuth(User user) throws Exception;
	public abstract Result doDynamicPassAuth(User user) throws Exception;
	public abstract Result doDynamicExcursionAuth(User user) throws Exception;
	public abstract Result doError(User user) throws Exception;
	public abstract Result doDynamicCheck(User user) throws Exception;
	
	protected LongResult execute(RequestHeader head, MessageBody body) throws Exception{
		EChannelService service = new EChannelService();
		LongRequest request = new LongRequest();
		request.setMessageHead(head);
		request.setMessageBody(body);
		EChannel portType = service.getEChannelServicePort();
		return portType.judge(request);
	}
	
	//拼装result
	protected Result assemble(LongResult res) throws Exception{
		Result result = new Result();
		if(res.getMessageHead()!= null){
			result.setResultCode(res.getMessageHead().getResultCode());
			result.setResultDec(res.getMessageHead().getResultDesc());
		}
		if(res.getMessageBody() != null){
			result.setUserType(res.getMessageBody().getCommonId());//设置userType值
		}
		System.out.println(result);
		return result;
	}
	
	public String getSIMP_LOGIN() {
		return SIMP_LOGIN;
	}

	public String getSEC_LOGIN() {
		return SEC_LOGIN;
	}

	public String getCHALLENGE_LOGIN() {
		return CHALLENGE_LOGIN;
	}

	public String getDYANMIC_LOGIN() {
		return DYANMIC_LOGIN;
	}

	public String getRSA_LOGIN() {
		return RSA_LOGIN;
	}
	
}
