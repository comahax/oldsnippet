package com.gmcc.pboss.common.bean;

import java.io.Serializable;

/**
 * 自动生成日志
 * @author yuwenjun
 *
 */
public interface AutoLogBean extends Serializable {
	//AutoLog公共属性
	public static final String[] logProperties = new String[]{"logid","opntime","opncode","oprtype"};
	
	//订单表公共属性
	public static final String[] odrLogProperties = new String[]{"logid","optime","oprcode","oprtype","success"};
	
	public static final int logid = 0;
	public static final int opntime = 1;
	public static final int opncode = 2;
	public static final int oprtype = 3;
	public static final int success = 4;
	
	
	/**
	 * 返回对应的Log VO类
	 * @return
	 */
	public Class getLogClass();
	
	/**
	 * 返回公共属性的类型（设置给个性不同的Bean）
	 */
	public String[] getLogProperties();
	
}
