package com.sunrise.ws.client;

/*
 * 包装 华为的LongResult类中的相应属性, 起隔离效果
 */
public class Result {
	//常用属性
	private String resultCode;
	private String resultDec;
	
	//只有查询用户登陆方式时才set该值
	private String userType;
	
	//只有查询挑战码时才set该值
	private String safewordMessage;
	
	private String safewordCode;
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDec() {
		return resultDec;
	}

	public void setResultDec(String resultDec) {
		this.resultDec = resultDec;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getSafewordMessage() {
		return safewordMessage;
	}

	public void setSafewordMessage(String safewordMessage) {
		this.safewordMessage = safewordMessage;
	}
	
	public String getSafewordCode() {
		return safewordCode;
	}

	public void setSafewordCode(String safewordCode) {
		this.safewordCode = safewordCode;
	}

	public String toString(){
		return "[resultCode:" + resultCode + "] [resultDec:" + resultDec + "] [userType:" + userType + "] [safewordMessage:" + safewordMessage + "][safewordCode:" + safewordCode + "]";
	}



}
