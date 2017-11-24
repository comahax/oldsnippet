package com.gmcc.pboss.web.common.login;

import org.apache.log4j.Logger;

import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public interface INGLoginCheck {
	public static final Logger log = Logger.getLogger(LoginAction.LOGIN_LOGGER_NAME);
	
	public static final String MSG_SPLIT = "|";
	
	static final String SUCCESS = "0";	
	static final String OPR_NOT_EXIST = "601";//����Ա������
	static final String WRONG_PASSWORD = "602";// ���벻��ȷ
	static final String WRONG_RSA = "603";// RSA�뷢��Ư��
	static final String OTHER = "111"; // ����
	//��½��ʽ
	final static String SIMP_LOGIN = "SimpAuth";  // �򵥵�¼
	final static String SEC_LOGIN = "SecAuth";     // ��������
	final static String CHALLENGE_LOGIN = "SafeWord";   // safeword��ս��
	final static String RSA_LOGIN = "RSA";		   // RSA����У��
	
	public Result getLogintype(User user)throws Exception;
	public Result doSimpAuth(User user) throws Exception;
	public Result doSecAuth(User user) throws Exception;
	public Result doSafewordAuth(User user)throws Exception;
	public Result doRSAAuth(User user) throws Exception;
}
