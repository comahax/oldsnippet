package com.sunrise.boss.common.webservice;

import java.io.Serializable;

public class RetResult implements Serializable{
	
	private boolean authResult;
	
	private String idsTokenName;
	
	private String idsTokenValue ;
	
	private String account;
	
	private String authMsg;

	public boolean isAuthResult() {
		return authResult;
	}

	public void setAuthResult(boolean authResult) {
		this.authResult = authResult;
	}

	public String getIdsTokenName() {
		return idsTokenName;
	}

	public void setIdsTokenName(String idsTokenName) {
		this.idsTokenName = idsTokenName;
	}

	public String getIdsTokenValue() {
		return idsTokenValue;
	}

	public void setIdsTokenValue(String idsTokenValue) {
		this.idsTokenValue = idsTokenValue;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAuthMsg() {
		return authMsg;
	}

	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}

	

}
