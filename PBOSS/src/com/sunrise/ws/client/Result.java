package com.sunrise.ws.client;

/*
 * ��װ ��Ϊ��LongResult���е���Ӧ����, �����Ч��
 */
public class Result {
	//��������
	private String resultCode;
	private String resultDec;
	
	//ֻ�в�ѯ�û���½��ʽʱ��set��ֵ
	private String userType;
	
	//ֻ�в�ѯ��ս��ʱ��set��ֵ
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
