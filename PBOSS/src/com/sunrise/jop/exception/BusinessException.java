package com.sunrise.jop.exception;

import java.text.MessageFormat;

/**
 * ҵ���쳣,��Ϊi18n��ԭ�����е�ҵ���쳣ʹ�ô�����<br/>
 * ���������зֶι���,��ʽ����:BUSI-10001,����ǰ��λΪҵ��ģ����룬����λΪ����.<br/>
 * Ϊ�˱������ֺ��棵λ�����ֲ��ظ�,��Ҫ�滮�ֶ�.ǰ��λ���ڷֶ�.����滮����ҵ�������滮<br/>
 * ��:COM-100001 : COM��ʾ���� 10���ڹ���.
 *    RES-100001 :��RES��ʾ��Դ��10Ϊ�ڲ��淶��š�
 * @author $Author:JinBo $</br>
 * @version $ReVersion: 1.0 JinBo Exp at 2007-1-18 9:44:11 $</br>
 * @since 1.0
 * @see com.sunrise.jop.JopException
 */
public class BusinessException extends Exception {
	private String errorCode = ERROR_CODE_BUSINESS_COMMON;

	public static final String ERROR_CODE_BUSINESS_COMMON = "business.common";
	/* �쳣Ψһ��� */
//	private String sid = "";

	/**
	 * @param errorCode  �������
	 */
	public BusinessException(String errorCode) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode), ""));
		setErrorCode(errorCode);
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		setErrorCode(ERROR_CODE_BUSINESS_COMMON);
	}

	public BusinessException(String errorCode, String[] msgParam, Throwable cause) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode),msgParam), cause);
		setErrorCode(errorCode);
	}

	public BusinessException(String errorCode, String msgParam, Throwable cause) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode), msgParam), cause);
		setErrorCode(errorCode);
	}

	protected static String checkErrorCode(String errorCode){
		return (errorCode==null)?ERROR_CODE_BUSINESS_COMMON:errorCode;
	}
	

	public String getCode() {
		return errorCode;
	}

	/**
	 * �쳣Ψһ��� ʹ��ϵͳʱ���errorCode
	 * @return
	 */
//	public String Sid() {
//		return sid;
//	}

	public String getErrorCode() {
		return errorCode;
	}

	protected void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
//		this.sid = System.currentTimeMillis() + "-" + errorCode;
	}
}