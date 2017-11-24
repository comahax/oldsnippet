/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-6-23
 */
package com.sunrise.jop.exception.business;

import java.io.Serializable;

import org.apache.commons.lang.ClassUtils;

import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.system.ServiceLocatorException;



/**
 * RecordNotFoundException��δ�ҵ���Ӧ��¼ʱ�׳���
 * <br> Description: class RecordNotFoundException
 * <br> Company: sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-6-23
 */
public class RecordNotFoundException extends BusinessException {
	public static final String ERROR_CODE_DB_RECORDNOTFOUND = "db.recordnotfound";
	/**
	 * @param errorCode  �������
	 */
	public RecordNotFoundException(String errorCode) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode), ""));
		setErrorCode(errorCode);
	}
	
	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordNotFoundException(String errorCode, String[] msgParam, Throwable cause) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode),msgParam), cause);
		setErrorCode(errorCode);
	}

	public RecordNotFoundException(String errorCode, String msgParam, Throwable cause) {
		super (JOPException.toMessage(BusinessException.class, checkErrorCode(errorCode), msgParam), cause);
		setErrorCode(errorCode);
	}

	protected static String checkErrorCode(String errorCode){
		return (errorCode==null)?ERROR_CODE_DB_RECORDNOTFOUND:errorCode;
	}

	public RecordNotFoundException(Class voClass, Serializable pk) {
		super (JOPException.toMessage(BusinessException.class, ERROR_CODE_DB_RECORDNOTFOUND, new String[]{pk.toString(), ClassUtils.getShortClassName(voClass)}), null);
		setErrorCode(ERROR_CODE_DB_RECORDNOTFOUND);
	}

}
