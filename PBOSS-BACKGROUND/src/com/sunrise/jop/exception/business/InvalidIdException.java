package com.sunrise.jop.exception.business;

import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: �Ƿ�����</p>
 * <p>Description: ��������Ӧ�ļ�¼�����ڻ���Ч</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sunrise Tech Ltd. </p>
 * @author sunrise
 * @version 1.0
 */
public class InvalidIdException extends BusinessException {
	public static final String ERROR_CODE_DB_INVALIDID = "db.invalidid";
	/**
	 * @param errorCode  �������
	 */
	public InvalidIdException(String errorCode) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode), ""));
		setErrorCode(errorCode);
	}
	
	public InvalidIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidIdException(String errorCode, String[] msgParam, Throwable cause) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode),msgParam), cause);
		setErrorCode(errorCode);
	}

	public InvalidIdException(String errorCode, String msgParam, Throwable cause) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode), msgParam), cause);
		setErrorCode(errorCode);
	}

	protected static String checkErrorCode(String errorCode){
		return (errorCode==null)?ERROR_CODE_DB_INVALIDID:errorCode;
	}
}
