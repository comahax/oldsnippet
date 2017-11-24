package com.gmcc.pboss.web.common.login;

import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public interface ILoginCheck {

	//指令集
	final static String QUERY_USER_TYPE = "2"; // 查询用户登陆方式
	final static String SIMP_AUTH = "3"; // 静态密码登陆
	final static String SEC_SAND = "4"; // 发信送短信密码
	final static String SEC_AUTH = "5"; // 校验短信密码
	final static String CHALLENGE_QUERY_VALUE = "6";// 查询挑战码
	final static String CHALLENGE_AUTH_VALUE = "7";// 校验挑战码
	final static String DYNAMIC_PASS_AUTH = "8"; // RSA动态密码校验
	final static String DYNAMIC_EXCURSION_AUTH = "9"; // RSA动态漂移校验
	final static String ERROR = "-1"; // 动态漂移校验
	
	//登陆方式
	//SimpAuth or Dynamic is nothing different
	final static String SIMP_LOGIN = "SimpAuth";  // 简单登录
	final static String SEC_LOGIN = "SecAuth";     // 短信密码
	final static String CHALLENGE_LOGIN = "SafeWord";   // safeword挑战码
	final static String DYANMIC_LOGIN = "Dynamic"; // 动态密码
	final static String RSA_LOGIN = "RSA";		   // RSA密码校验
	
	//成功失败
	final static String FAILURE = "2";//"-1";
	final static String SUCCESS = "1";//"0";
	final static String WAIT = "0";//"1"
	/**
	 * 传指令给WS
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


