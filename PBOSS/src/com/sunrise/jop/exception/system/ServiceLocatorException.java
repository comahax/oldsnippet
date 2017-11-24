package com.sunrise.jop.exception.system;

import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: GDIBOSS</p>
 *
 * <p>Description: ����λ��ServiceLocator�׳����쳣</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author HuangBaiming
 *
 * @version 1.0
 */
public class ServiceLocatorException extends JOPException {
	public static final String ERROR_CODE_LOCATOR_COMMON = "locator.common";
//	private String errorCode = ERROR_CODE_LOCATOR_COMMON;
	/**
	 * @param errorCode  �������
	 */
	public ServiceLocatorException(String errorCode) {
		super (toMessage(JOPException.class, checkErrorCode(errorCode), ""));
		setErrorCode(errorCode);
	}
	
	public ServiceLocatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceLocatorException(String errorCode, String[] msgParam, Throwable cause) {
		super (toMessage(ServiceLocatorException.class, checkErrorCode(errorCode),msgParam), cause);
		setErrorCode(errorCode);
	}

	public ServiceLocatorException(String errorCode, String msgParam, Throwable cause) {
		super (toMessage(ServiceLocatorException.class, checkErrorCode(errorCode), msgParam), cause);
		setErrorCode(errorCode);
	}

	protected static String checkErrorCode(String errorCode){
		return (errorCode==null)?ERROR_CODE_LOCATOR_COMMON:errorCode;
	}
	
}
