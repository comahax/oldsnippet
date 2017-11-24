package com.gmcc.pboss.common.bean;

import java.io.Serializable;

/**
 * �Զ�������־
 * @author yuwenjun
 *
 */
public interface AutoLogBean extends Serializable {
	//AutoLog��������
	public static final String[] logProperties = new String[]{"logid","opntime","opncode","oprtype"};
	
	//������������
	public static final String[] odrLogProperties = new String[]{"logid","optime","oprcode","oprtype","success"};
	
	public static final int logid = 0;
	public static final int opntime = 1;
	public static final int opncode = 2;
	public static final int oprtype = 3;
	public static final int success = 4;
	
	
	/**
	 * ���ض�Ӧ��Log VO��
	 * @return
	 */
	public Class getLogClass();
	
	/**
	 * ���ع������Ե����ͣ����ø����Բ�ͬ��Bean��
	 */
	public String[] getLogProperties();
	
}
