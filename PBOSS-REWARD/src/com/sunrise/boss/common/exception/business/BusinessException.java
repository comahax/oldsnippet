/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-6-23
 */
package com.sunrise.boss.common.exception.business;

/**
 * BusinessException
 * <br> Description: class BusinessException
 * <br> Company: sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-6-23
 */
public class BusinessException extends Exception {

	private String code;
	
	public BusinessException(String code) {
		this.code = code;
	}
	/**
	 * @param message
	 */
	public BusinessException(String code,String message) {
		this(code,message,null);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String code,String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	/**
	 * @param cause
	 */
	public BusinessException(String code,Throwable cause) {
		super(cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String toString() {
		
		return (code!=null? code : "" ) + ":" + getMessage();
	}

}
