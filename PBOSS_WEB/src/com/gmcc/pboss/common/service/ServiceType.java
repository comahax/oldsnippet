package com.gmcc.pboss.common.service;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-7-29
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public class ServiceType {
	/**
	 * 查询
	 * 对应业务Service的query方法 
	 */
	public static final short QUERY = 0x00;
	
	/**
	 * 查询单个对象
	 * 对应业务Service的queryForOne方法 
	 */
	public static final short QUERY_ONE = 0x01;
	
	/**
	 * 办理/开通 
	 * 对应业务Service的initiate方法
	 * */
	public static final short INITIATE = 0x03;
	
	/**
	 * 修改 
	 * 对应业务Service的modify方法
	 */
	public static final short MODIFY = 0x04;
	
	/**
	 * 取消
	 * 对应业务Service的cancel方法
	 */
	public static final short CANCEL = 0x05;
	
	/**
	 * 其他
	 * 对应业务Service的other方法
	 */
	public static final short OTHER = 0x06;
	
}
