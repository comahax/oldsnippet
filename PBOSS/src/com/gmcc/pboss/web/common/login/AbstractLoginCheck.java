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
		if(type.equals(this.QUERY_USER_TYPE)){ //��ѯ�û���½����
			return doQueryUserType(user);
		}else if(type.equals(this.SIMP_AUTH)){ //��ͨ��½
			return doSimpAuth(user);
		}else if(type.equals(this.SEC_SAND)){ //���Ż�ȡ
			return doSecSand(user);
		}else if(type.equals(this.SEC_AUTH)){ //������֤
			return doSecAuth(user);
		}else if(type.equals(this.CHALLENGE_QUERY_VALUE)){ //��ս���ȡ
			user.setStep(1);
			return doChallengeQuery(user);
		}else if(type.equals(this.CHALLENGE_AUTH_VALUE)){ //��ս����֤
			user.setStep(2);
			return doChallengeAuth(user);
		}else if(type.equals(this.DYNAMIC_PASS_AUTH)){ //RSA��̬����У��
			return doDynamicPassAuth(user);
		}else if(type.equals(this.DYNAMIC_EXCURSION_AUTH)){ //RSA��̬����Ư��У��
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
	
	//ƴװresult
	protected Result assemble(LongResult res) throws Exception{
		Result result = new Result();
		if(res.getMessageHead()!= null){
			result.setResultCode(res.getMessageHead().getResultCode());
			result.setResultDec(res.getMessageHead().getResultDesc());
		}
		if(res.getMessageBody() != null){
			result.setUserType(res.getMessageBody().getCommonId());//����userTypeֵ
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
