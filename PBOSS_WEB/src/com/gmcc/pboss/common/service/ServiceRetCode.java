package com.gmcc.pboss.common.service;

/**
 * 从兴公司电子渠道业务部
 * 
 * @author tangzhu
 * @date 2009-7-31 所属项目： 所属模块： 描述： 业务公共返回码 小于100
 */
public class ServiceRetCode {
	/**
	 * 业务成功
	 */
	public static final int SUCCESS = 0;
	/**
	 * 业务失败
	 */
	public static final int FAIL = 1;
	/**
	 * 用户未登录不能使用
	 */
	public static final int NOT_LOGIN = 2;
	/**
	 * 没有权限使用该业务
	 */
	public static final int NOT_AUTHOR = 3;
	/**
	 * 发生异常
	 */
	public static final int EXCEPTION = 4;

	/**
	 * 业务编码/名称未初始化
	 */
	public static final int INIT_FAIL = 5;

	/**
	 * 退出
	 */
	public static final int LOGOUT = 6;

	/**
	 * 登录方式错误
	 */
	public static final int UN_LOGINTYPE = 7;

	/**
	 * 渠道失效
	 */
	public static final int CHANNEL_INVALIDATION = 8;

	/**
	 * 渠道被删除
	 */
	public static final int CHANNEL_DELETE = 9;

	/**
	 * 渠道状态错误
	 */
	public static final int CHANNEL_STATE_MISTAKE = 10;

	/**
	 * 错误提示信息
	 */
	public static final String ERRORMESSAGE = "Error:";

	/**
	 * 未出账信息
	 */
	public static final int REWARD_STRIKE_BALANCE = 11;
	
	/**
	 * 注册成功信息
	 */
	public static final int REGISTER_SUCCESS = 12;
	
	/**
	 * 非广东省移动号码
	 */
	public static final int UN_GD_MOBILE = 13;
	
	/**
	 * 已离职
	 */
	public static final int DISMISSIONED = 14;
	
	/**
	 * 非移动手机号码
	 */
	public static final int UNMOBILE = 15;
	
	/**
	 * 验证码错误
	 */
	public static final int FAIL_ICODE = 16;
	
	/**
	 * 日期格式错误
	 */
	public static final int DATE_FORMAT = 17;
	
	/**
	 * 非法操作
	 */
	public static final int ILLEGALITY = 18;
	
	/**
	 * 工号未查到
	 */
	public static final int NOTFOUND_OPRCODE = 19;
	
	/**
	 * 问题已关闭
	 */
	public static final int QUESTION_CLOSE = 20;
	
	/***
	 * 数据为空
	 */
	public static final int EMPTY = 21;
	
	/**用户手机号码非系统默认地市*/
	public static final int UNDEFAULT_BRANCH = 22;
	/***
	 * 手机号码已经存在
	 */
	public static final int MOBLEEXIST = 23;
	
	/**用户手机号码不存在*/
	public static final int MOBLENOTEXIST = 24;

	/** 手机号码不是所选地市号码 */
	public static final int MOBILENOCITYERROR = 25;
	/**
	 * 地市已经关闭
	 */
	public static final int INVALIDCITY = 30;
	
	/**
	 * 渠道经理不存在
	 */
	public static final int EMPTY_WAYMMG = 190;
	
	/**
	 * 提交成功
	 */
	public static final int DEF_APPLY = 200;
	/**
	 * 退出成功
	 */
	public static final int DEF_OUT = 201;
	
	/**
	 * 业务运行出错
	 */
	//public static final int SERVICE_RUN = 99;
}
