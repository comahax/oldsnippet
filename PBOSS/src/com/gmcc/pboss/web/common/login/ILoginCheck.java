package com.gmcc.pboss.web.common.login;

import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public interface ILoginCheck {

	//ָ�
	final static String QUERY_USER_TYPE = "2"; // ��ѯ�û���½��ʽ
	final static String SIMP_AUTH = "3"; // ��̬�����½
	final static String SEC_SAND = "4"; // �����Ͷ�������
	final static String SEC_AUTH = "5"; // У���������
	final static String CHALLENGE_QUERY_VALUE = "6";// ��ѯ��ս��
	final static String CHALLENGE_AUTH_VALUE = "7";// У����ս��
	final static String DYNAMIC_PASS_AUTH = "8"; // RSA��̬����У��
	final static String DYNAMIC_EXCURSION_AUTH = "9"; // RSA��̬Ư��У��
	final static String ERROR = "-1"; // ��̬Ư��У��
	
	//��½��ʽ
	//SimpAuth or Dynamic is nothing different
	final static String SIMP_LOGIN = "SimpAuth";  // �򵥵�¼
	final static String SEC_LOGIN = "SecAuth";     // ��������
	final static String CHALLENGE_LOGIN = "SafeWord";   // safeword��ս��
	final static String DYANMIC_LOGIN = "Dynamic"; // ��̬����
	final static String RSA_LOGIN = "RSA";		   // RSA����У��
	
	//�ɹ�ʧ��
	final static String FAILURE = "2";//"-1";
	final static String SUCCESS = "1";//"0";
	final static String WAIT = "0";//"1"
	/**
	 * ��ָ���WS
	 * @param user
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public abstract Result doSend2WS(User user, String type) throws Exception;
	public abstract Result doDynamicCheck(User user) throws Exception;
	
	public String getSIMP_LOGIN();
	public String getSEC_LOGIN();
	public String getCHALLENGE_LOGIN();
	public String getDYANMIC_LOGIN();
	public String getRSA_LOGIN();
}


