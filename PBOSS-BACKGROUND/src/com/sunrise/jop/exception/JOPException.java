package com.sunrise.jop.exception;

import java.text.MessageFormat;

import org.apache.commons.lang.ClassUtils;

import com.sunrise.jop.common.utils.i18n.I18nMessage;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

/**
 * $Id: JOPException.java JinBo Exp at 2007-1-18 13:51:37 $<br/>
 * �����쳣��Ҫ��ָ��ܱ����µĴ��󣬺�һЩ�ڲ����������쳣
 * ϵͳ�쳣,����ʱ�쳣,��Ϊi18n��ԭ�����е�ϵͳ�쳣ʹ�ô�����<br/> 
 * ���������зֶι���,��ʽ����:NET-10001,����ǰ��Ϊ������룬����λΪ����.<br/> 
 * Ϊ�˱������ֺ���5λ�����ֲ��ظ�,��Ҫ�滮�ֶ�.ǰ��λ���ڷֶ�.<br/>
 * ��:DB-00001 :DB��ʾ���ݿ�����쳣 DB���ڹ���.
 * @author $Author:JinBo $</br>
 * @version $ReVersion: 1.0$</br>
 * @since  1.0
 * @see com.sunrise.jop.BusinessException
 */
public class JOPException extends RuntimeException {
	/* �쳣Ψһ��� */
//	private String sid = "";
	private String errorCode = ERROR_CODE_JOP_COMMON;

	public static final String ERROR_CODE_JOP_COMMON = "jop.common";
	/**
	 * @param errorCode  �������
	 */
	
	public JOPException(String errorCode) {
		super (toMessage(JOPException.class, checkErrorCode(errorCode), ""));
		setErrorCode(errorCode);
	}
	
	public JOPException(String message, Throwable cause) {
		super(message, cause);
		setErrorCode(ERROR_CODE_JOP_COMMON);
	}

	public JOPException(String errorCode, String[] msgParam, Throwable cause) {
		super (toMessage(JOPException.class, checkErrorCode(errorCode),msgParam), cause);
		setErrorCode(errorCode);
	}

	public JOPException(String errorCode, String msgParam, Throwable cause) {
		super (toMessage(JOPException.class, checkErrorCode(errorCode), msgParam), cause);
		setErrorCode(errorCode);
	}

	public JOPException(Exception ex) {
		// TODO Auto-generated constructor stub
		super(ex);
	}

	protected static String checkErrorCode(String errorCode){
		return (errorCode==null)?ERROR_CODE_JOP_COMMON:errorCode;
	}
	
	/**
	 * @return �������
	 */
	public String getCode() {
		return errorCode;
	}

	/**
	 * 
	 * @return �쳣Ψһ��� ʹ��ϵͳʱ���errorCode
	 */
//	public String Sid() {
//		return sid;
//	}
	
	protected void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
//		this.sid = errorCode + "-" + System.currentTimeMillis();
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public static String toMessage(Class cls, String errorCode, String[] msgParam){
		if(errorCode == null) return null;
		String[] param = new String[msgParam.length + 1];
		System.arraycopy(msgParam, 0, param, 1, msgParam.length);
		param[0] = errorCode + "-" + System.currentTimeMillis();
		StringBuffer resname = new StringBuffer(CoreConfigInfo.CFG_ROOT_PATH).append(".exception.").append(ClassUtils.getShortClassName(cls));
		return I18nMessage.getString(resname.toString(), errorCode, param);
	}
	
	public static String toMessage(Class cls, String errorCode, String msgParam){
		String[] param = {msgParam}; 
		return toMessage(cls, errorCode, param);
	}
	
}