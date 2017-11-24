package com.gmcc.pboss.web.common.login;

import org.apache.log4j.Logger;

import com.sunrise.jop.ui.User;
import com.sunrise.ws.client.Result;

public interface INGLoginCheck {
	public static final Logger log = Logger.getLogger(LoginAction.LOGIN_LOGGER_NAME);
	
	public static final String MSG_SPLIT = "|";
	
	static final String SUCCESS = "0";	
	static final String OPR_NOT_EXIST = "601";//操作员不存在
	static final String WRONG_PASSWORD = "602";// 密码不正确
	static final String WRONG_RSA = "603";// RSA码发生漂移
	static final String OTHER = "111"; // 其他
	//登陆方式
	final static String SIMP_LOGIN = "SimpAuth";  // 简单登录
	final static String SEC_LOGIN = "SecAuth";     // 短信密码
	final static String CHALLENGE_LOGIN = "SafeWord";   // safeword挑战码
	final static String RSA_LOGIN = "RSA";		   // RSA密码校验
	
	public Result getLogintype(User user)throws Exception;
	public Result doSimpAuth(User user) throws Exception;
	public Result doSecAuth(User user) throws Exception;
	public Result doSafewordAuth(User user)throws Exception;
	public Result doRSAAuth(User user) throws Exception;
}
