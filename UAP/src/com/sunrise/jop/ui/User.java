package com.sunrise.jop.ui;

import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * <p>
 * Title: USER
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
	
	private boolean provinceUser = false; //是否全省用户
	
	private String password;
	
	private String system; // 双方约定的发起请求方系统
	
	private String token;  // 登录时生成的票据
	

	public boolean isProvinceUser() {
		return provinceUser;
	}

	public void setProvinceUser(boolean provinceUser) {
		this.provinceUser = provinceUser;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
