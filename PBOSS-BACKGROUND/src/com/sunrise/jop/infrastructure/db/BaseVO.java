package com.sunrise.jop.infrastructure.db;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * ��Struts2�ֵ�������û�����࣬��ҳ��ת��Form����ʱ��������
 * @author bo
 *
 */
public class BaseVO implements Serializable{
	
	public String toString() {		
		return ReflectionToStringBuilder.toString(this);
	}
	
}
