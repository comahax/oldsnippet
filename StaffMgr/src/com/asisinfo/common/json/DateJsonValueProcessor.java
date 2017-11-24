/**
 * Copyright(c)1999-2008 Sunrise Electronics Developmnet Co.,Ltd<br>
 * All rights reserved. Use is subject to license terms.
 */
package com.asisinfo.common.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wanhongquan
 * @created at 2009-10-23 ����09:13:27
 * @version $Id$
 */
public class DateJsonValueProcessor implements JsonValueProcessor {

	/** * logger. */
	private static Log logger = LogFactory.getLog(DateJsonValueProcessor.class);

	/** * Ĭ�ϵ�����ת����ʽ. */
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	/** * ����ת����. */
	private DateFormat dateFormat;

	/**
	 * ���췽��.
	 * @param datePattern ���ڸ�ʽ         
	 */
	public DateJsonValueProcessor(String datePattern) {
		try {
			dateFormat = new SimpleDateFormat(datePattern);
		} catch (Exception ex) {
			logger.info(ex);
			dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		}
	}

	/**
	 * ת�����飿.
	 * @param value Object       
	 * @param jsonConfig ����          
	 * @return Object
	 */
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return process(value);
	}

	/**
	 * ת������.
	 * @param key String         
	 * @param value Object     
	 * @param jsonConfig ����   
	 * @return Object
	 */
	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		return process(value);
	}

	/**
	 * ��ʽ������.
	 * @param value Object
	 * @return Object
	 */
	private Object process(Object value) {
		try {
			if(value==null)
				return "";
			return dateFormat.format((Date) value);
		} catch (Exception ex) {
			return "";
		}
	}

}
