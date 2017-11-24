/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-6-23
 */
package com.sunrise.boss.common.exception.dao;

import java.io.Serializable;

import org.apache.commons.lang.ClassUtils;

import com.sunrise.boss.common.exception.business.*;

/**
 * RecordNotFoundException，未找到对应记录时抛出。
 * <br> Description: class RecordNotFoundException
 * <br> Company: sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-6-23
 */
public class RecordNotFoundException extends BusinessException {

	
	/**
	 * 
	 */
	public RecordNotFoundException() {
		super("COMM-10001");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RecordNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public RecordNotFoundException(Throwable cause) {
		super("COMM-10001",cause);
		// TODO Auto-generated constructor stub
	}
	
	public RecordNotFoundException(Class voClass,Serializable pk) {
		this("Not found " + ClassUtils.getShortClassName(voClass) +" pk:"+pk);
	}

}
