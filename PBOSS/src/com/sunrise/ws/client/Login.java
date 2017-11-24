package com.sunrise.ws.client;

import com.huawei.boss.webservice.echannel.EChannel;
import com.huawei.boss.webservice.echannel.EChannelService;
import com.huawei.boss.webservice.echannel.LongRequest;
import com.huawei.boss.webservice.echannel.LongResult;
import com.huawei.boss.webservice.echannel.RequestHeader;
import com.huawei.boss.webservice.echannel.LongRequest.MessageBody;

/**
 * @author �ư���
 */

public class Login {
	// simpAuth ��������֤�����û��������룬�ù��ź����������֤;
	// dynamic ��̬���룺 ���û��������룬�ù��ź����������֤;
	// secAuth ������֤���ڴ˵��ö��Žӿڷ��Ͷ��ŵ��û����û��ڶ�����֤ҳ����������е����룬�ù��ź����������֤
	// RSA
	// ��̬������֤����������Ĺ��ź�RSA��̬����,��RSA������У�����Ա��RSA��̬���룬���Ư�Ƹ�������Ĺ��ź�����RSA��̬����,��RSA��������������ͬ������.
	// safeword ��֤����������Ĺ���,�ڶ�����֤ҳ������safeword��ս�룬������ս���������룬�ù��ź����������֤

	
	// ����ĳ�������Ӧ������"interface"

	final static String QUERY_USER_TYPE = "2"; // ��ѯ�û���½��ʽ
	final static String SIMP_AUTH = "3"; // ��̬�����½
	final static String SEC_SAND = "4"; // �����Ͷ�������
	final static String SEC_AUTH = "5"; // У���������
	final static String QUERY_CHALLENGE_VALUE = "6";// ��ѯ��ս��
	final static String AUTH_CHALLENGE_VALUE = "7";// У����ս��
	final static String DYNAMIC_PASS_AUTH = "8"; // ��̬����У��
	final static String DYNAMIC_EXCURSION_AUTH = "9"; // ��̬Ư��У��

	// ��ѯ�û���½��ʽ
	//     ����ֵ�� resultCode��ȡֵΪ����5�ֿ��ܣ�
	//         RSA , Dynamic , SimpAuth , SecAuth , SafeWord 
	public Result queryUserType(String operator) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		
		// ����head
		head.setVersion("1.0");
		head.setInterface(QUERY_USER_TYPE);
		head.setUserId(operator);
		// ����body
		body.setUsername(operator);
		
		LongResult res = execute(head, body);
		Result result = assemble(res);
		if(res.getMessageBody() != null){
			result.setUserType(res.getMessageBody().getCommonId());//����userTypeֵ
		}
		return result;
	}
	
	// ��̬�����½
	public Result simpAuth(String operator, String password) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// ����head
		head.setVersion("1.0");
		head.setInterface(SIMP_AUTH);
		head.setUserId(operator);
		head.setPassword(password);
		// ����body
		body.setUsername(operator);
		body.setPassword(password);

		return assemble(execute(head, body));
	}
	
	// �����Ͷ�������
	public Result secSand(String operator) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		
		// ����head
		head.setVersion("1.0");
		head.setInterface(SEC_SAND);
		head.setUserId(operator);
		// ����body
		body.setUsername(operator);
		
		return assemble(execute(head, body));
	}
	
	// У���������
	public Result secAuth(String operator, String password) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// ����head
		head.setVersion("1.0");
		head.setInterface(SEC_AUTH);
		head.setUserId(operator);
		head.setPassword(password);
		// ����body
		body.setUsername(operator);
		body.setPassword(password);
		
		return assemble(execute(head, body));
	}
	
	// ��ѯ��ս��
	public Result queryChallengeValue(String operator) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// ����head
		head.setVersion("1.0");
		head.setInterface(QUERY_CHALLENGE_VALUE);
		head.setUserId(operator);
		// ����body
		body.setUsername(operator);
		
		LongResult res = execute(head, body);
		Result result = assemble(res);
		if(res.getMessageHead() != null){
			result.setSafewordMessage(res.getMessageHead().getSequenceId());//����safewordMessageֵ
		}
		return result;
	}
	
	// У����ս��
	public Result authChallengeValue(String operator, String challengeValue, String safewordMessage) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// ����head
		head.setVersion("1.0");
		head.setInterface(AUTH_CHALLENGE_VALUE);
		head.setUserId(operator);
		head.setPassword(challengeValue);
		head.setSequenceId(safewordMessage);
		// ����body
		body.setUsername(operator);
		body.setPassword(challengeValue);
		
		return assemble(execute(head, body));
	}
	
	// ��̬����У��
	public Result dynamicPassAuth(String operator, String password) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();

		// ����head
		head.setVersion("1.0");
		head.setInterface(DYNAMIC_PASS_AUTH);
		head.setUserId(operator);
		head.setPassword(password);
		// ����body
		body.setUsername(operator);
		body.setPassword(password);
		
		return assemble(execute(head, body));
	}
	
	// ��̬Ư��У��
	public Result dynamicExcursionAuth(String operator, String password, String password2) {
		RequestHeader head = new RequestHeader();
		MessageBody body = new MessageBody();
		
		// ����head
		head.setVersion("1.0");
		head.setInterface(DYNAMIC_EXCURSION_AUTH);
		head.setUserId(operator);
		head.setPassword(password);
		head.setSequenceId(password2);
		// ����body
		body.setUsername(operator);
		body.setPassword(password);
		
		return assemble(execute(head, body));
	}

	
	//-----------------------------------------------------------------------
	
	//����Web service����
	protected LongResult execute(RequestHeader head, MessageBody body) {
		EChannelService service = new EChannelService();
		LongRequest request = new LongRequest();
		request.setMessageHead(head);
		request.setMessageBody(body);
		EChannel portType = service.getEChannelServicePort();
		return portType.judge(request);
	}
	
	//ƴװresult
	protected Result assemble(LongResult res){
		Result result = new Result();
		if(res.getMessageHead()!= null){
			result.setResultCode(res.getMessageHead().getResultCode());
			result.setResultDec(res.getMessageHead().getResultDesc());
		}
		return result;
	}

	 
}
