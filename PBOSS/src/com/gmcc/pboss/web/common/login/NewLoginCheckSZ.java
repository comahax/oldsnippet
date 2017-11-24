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
	 * ��½��ʽ��ѯ
	 * ���:
	 * 1 ���� OperatorID ��������
	 * ����:
	 * 1. ������ 0 ������һ��,1 �ɹ���2 ʧ��
	 * 2 ��֤��ʽ ��ֵ����
	 *		Dynamic    ��̬��¼��֤
	 *		RSA        RSA��¼��֤
	 *		SafeWord   ��ȫ���¼
	 *		SimpAuth    �򵥵�¼(��Ӧ�������ᵽ�Ĺ̶�����)
	 *		SecAuth      ���ε�¼
   	 * 3 ������Ϣ�����ʧ�ܣ���ֵ���������Ϣ
	 */
	public Result doQueryUserType(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.GetAuthTypeRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.GetAuthTypeRequest.MessageBody();
		
		// ����head
		head.setVersion("1.0");
		// ����body
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
			result.setUserType(res.getMessageBody().getType());//����userTypeֵ
		}
		log.info("##------doQueryUserType-----:"+result);
		return result;
	}
	/**
	 * �̶�����У��
	 * ���:
	 * 1 ���� OperatorID ��������
	 * 2 �̶����� Password ��������
	 * ����:
	 * 1 ������ 0 ������һ��,1 �ɹ���2 ʧ��
	 * 2 ������Ϣ�����ʧ�ܣ���ֵ���������Ϣ
	 */
	public Result doSimpAuth(User user) throws Exception {
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.SimpAuthCheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.SimpAuthCheckRequest.MessageBody();

		// ����head
		head.setVersion("1.0");
		// ����body
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
	 * ������ --��֤���뷢�Ͷ����루�ڶ�����
	 * 
	 */
	public Result doSecSand(User user) throws Exception {
		return this.secAuthCheck(user);
	}
	/**
	 * ������У�飨������
	 */
	public Result doSecAuth(User user) throws Exception {
		return this.secAuthCheck(user);
	}
	/**
	 * ��ȫ��У��-��ȡ��ս�루��һ����
	 */
	public Result doChallengeQuery(User user) throws Exception {
		user.setStep(1);
		return this.safeWordCheck(user);
	}
	/**
	 * ��ȫ��У�飨�ڶ�����
	 */
	public Result doChallengeAuth(User user) throws Exception {
		user.setStep(2);
		return this.safeWordCheck(user);
	}
	
	/**
	 * RSA��̬��֤(��һ����������)
	 */
	public Result doDynamicPassAuth(User user) throws Exception {
		return this.RSACheck(user);
	}
	
	/**
	 * RSA��̬Ư����֤�����Ĳ���
	 */
	public Result doDynamicExcursionAuth(User user) throws Exception {
		user.setStep(4);
		return this.RSACheck(user);
	}
	
	public Result doError(User user) throws Exception {
		throw new Exception("�޴�ָ��!");
	}
	/**
	 * ��̬����У��
	 * ��Σ�
	 * 1 ���� OperatorID ��������
	 * 2 ���� Step �״����� 1,�ڶ�������2
	 * 3 �̶����� Password ����1��ѡ,����2 ��������
	 * ���Σ�
	 * 1. ������ 0 ������һ��,1 �ɹ���2 ʧ��
     * 2  ������Ϣ�����ʧ�ܣ���ֵ���������Ϣ
	 */ 
	public Result doDynamicCheck(User user) throws Exception{
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.DynamicCheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.DynamicCheckRequest.MessageBody();

		// ����head
		head.setVersion("1.0");
		// ����body
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
		log.info("##send------dynamicCheck��̬����-step:["+user.getStep()+"-OperatorID:["+body.getOperatorID()+"]");
		System.out.println("#########send------dynamicCheck��̬����-step:["+user.getStep()+"-OperatorID:["+body.getOperatorID()+"]");
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
		System.out.println("#########------dynamicCheck��̬����-step:["+user.getStep()+"]----:"+result);
		log.info("##------dynamicCheck��̬����-step:["+user.getStep()+"]----:"+result);
		return result;
	}
	/**
	 * ��������У��
	 * ���:
	 * 1 ���� OperatorID ��������
	 * 2 ���� Step �״����� 1,�ڶ�������2,����������3
	 * 3 �̶����� Password ����1��ѡ,����2 ��������,����3��������
	 * 4 ���Ŷ���ȷ������ secondpass ����1,2 ��ѡ������3��������
	 * ����:
	 * 1. ������ 0 ������һ��,1 �ɹ���2 ʧ��
	 * 2  ������Ϣ�����ʧ�ܣ���ֵ���������Ϣ
	 */ 
	public Result secAuthCheck(User user) throws Exception{
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.SecAuthCheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.SecAuthCheckRequest.MessageBody();
		
		// ����head
		head.setVersion("1.0");
		// ����body
		body.setOperatorID(user.getOprcode());
		body.setRemoteIP(user.getIp());
		body.setMacAddr(user.getMacAddr());
		body.setRemoteName(user.getRemoteName());
		body.setStep(user.getStep());
		if(user.getStep()>1){
			/*JAXBElement<String> ps = new JAXBElement<String>(new QName(
				     "", "passWord"), String.class, user.getPassword());*/
			body.setPassWord(user.getPassword());//�̶�����
			if(user.getStep()==3){
				/*JAXBElement<String> ps2 = new JAXBElement<String>(new QName(
					     "", "secondPass"), String.class, user.getPassword());*/
				body.setSecondPass(user.getSecondPass());//��������
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
	 * ��ȫ��У��
	 * ���:
	 * 1 ���� OperatorID ��������
	 * 2 ���� Step �״����� 1,�ڶ�������2
	 * 3 ��ս��Ϣ challengeMessage �ڶ��α������루���ݵ�һ�εķ��أ�
	 * 4 ��ս�� challengeCode�ڶ��α�������
	 * 5 ��ս�������� password �ڶ��α�������
	 * ����:
	 * 1. ������ 0 ������һ��,1 �ɹ���2 ʧ��
	 * 2����ս��Ϣ challengeMessage ��һ���᷵��һ��xml���ĵ���ս����Ϣ
	 * 3����ս�� challengeCode ��һ���᷵��һ��code��
	 * 3��������Ϣ�����ʧ�ܣ���ֵ���������Ϣ��
	 */ 
	public Result safeWordCheck(User user)throws Exception {
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.SafeWordCheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.SafeWordCheckRequest.MessageBody();

		// ����head
		head.setVersion("1.0");
		// ����body
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
	 * RSAУ��
	 * ���:
	 * 1 ���� OperatorID ��������
	 * 2 ���� Step �״����� 1,����2����2������3����3������4������4
	 * 3 �̶����룬����2��3��4 �������롣
	 * 4 RSA��ǰtoken ����3��4 �������롣
	 * 5 RSA��һ����token ����4�������롣
	 * ����:
	 * 1. ������ 0 ������һ��,1 �ɹ���2 ʧ��
	 * 2  ������Ϣ�����ʧ�ܣ���ֵ���������Ϣ
	 */ 
	public Result RSACheck(User user) throws Exception{
		RequestHeader head = new RequestHeader();
		com.huawei.boss.webservice.loginauth.RSACheckRequest.MessageBody body = new com.huawei.boss.webservice.loginauth.RSACheckRequest.MessageBody();
		
		// ����head
		head.setVersion("1.0");
		// ����body
		body.setOperatorID(user.getOprcode());//����
		body.setRemoteIP(user.getIp());
		body.setMacAddr(user.getMacAddr());
		body.setRemoteName(user.getRemoteName());
		body.setStep(user.getStep());//���� Step
		if(user.getStep()>1){
			/*JAXBElement<String> ps = new JAXBElement<String>(new QName(
				     "", "passWord"), String.class, user.getPassword());*/
			body.setPassWord(user.getPassword());//�̶�����
			if(user.getStep()>2){
				/*JAXBElement<String> curToken = new JAXBElement<String>(new QName(
					     "", "curToken"), String.class, user.getCurToken());*/
				body.setCurToken(user.getCurToken());//RSA��ǰtoken
				if(user.getStep()==4){
					/*JAXBElement<String> nextToken = new JAXBElement<String>(new QName(
						     "", "nextToken"), String.class, user.getNextToken());*/
					body.setNextToken(user.getNextToken());//RSA��һ����token
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
