package com.sunrise.jop.ui;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author HuangBaiming
 * @author He Kun 
 * 
 * @version 1.0
 */
public class User extends DBAccessUser {
	private static final long serialVersionUID = 3628497740671279410L;

	private String opername; //操作员名称 
	
	private String password; //操作员密码
	
	private String wayid;	//渠道

	private Date logintime; //登陆时间
	
	private String validateCode; //验证码
	
	private String sessionID;
	
	private boolean provinceUser = false; //是否全省用户
	
	private String safewordMessage; //选择短信登陆
	
	private String hwcityid; //华为所用的地市ID(数字)
	
	public Date getLogintime() {
		return logintime;
	}

	public String getOpername() {
		return opername;
	}

	public String getWayid() {
		return wayid;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public boolean isProvinceUser() {
		return provinceUser;
	}

	public void setProvinceUser(boolean provinceUser) {
		this.provinceUser = provinceUser;
	}
	
	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getSafewordMessage() {
		return safewordMessage;
	}

	public void setSafewordMessage(String safewordMessage) {
		this.safewordMessage = safewordMessage;
	}

	public String getHwcityid() {
		return hwcityid;
	}

	public void setHwcityid(String hwcityid) {
		this.hwcityid = hwcityid;
	}
}
