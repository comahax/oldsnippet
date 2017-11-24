package com.gmcc.pboss.biz.communi.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-29
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：沟通平台返回码 从100递增
 */
public class CommunicatePlateauRetCode extends ServiceRetCode {

	/**
	 * 该公告信息不存在
	 */
	public static final int ADVINFO_NOT_EXIST = 101;
	
	/**
	 * 回复成功
	 */
	public static final int REPLY_SAVE_SUCCESS = 102;
	
	/**
	 * 日期格式不正确
	 */
	public static final int COMMUNICATE_DATE_FORMAT = 103;
	
	/**
	 * 代办任务查看失败
	 */
	public static final int COMMISSION_TASK_FAIL = 104;
}
