package com.gmcc.pboss.common.dictionary;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-3
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public class CommonConfig {
	/**登录日志路径*/
//	public static final String LOGIN_LOG_PATH = "LOGIN_LOG_PATH";
	/**错误日志路径*/
//	public static final String ERROR_LOG_PATH = "ERROR_LOG_PATH";
	/**业务日志路径*/
//	public static final String BIZ_LOG_PATH = "BIZ_LOG_PATH";
	
	/**验证码：存放路径*/
//	public static final String IARRAY_PATH = "IARRAY_PATH";
	/**验证码：内容目录*/
//	public static final String ICODE_PATH = "ICODE_PATH";
	
	/**号码段文件*/
//	public static final String PNRG_FILE = "PNRG_FILE";
	
	
	/**验证码：生成个数*/
	public static final String ICODE_SIZE = "ICODE_SIZE";
	
	/**随机短信验证码信息*/
	public static final String SMS_RND_MSG = "SMS_RND_MSG";
	/**随机短信验证码信息限制时间*/
	public static final String SMS_RND_LIMIT_TIME="SMS_RND_LIMIT_TIME";
	/**随机短信验证码信息最小限制发送个数*/
	public static final String SMS_RND_MIN_NUM="SMS_RND_MIN_NUM";
	/**随机短信验证码信息最大限制发送个数*/
	public static final String SMS_RND_MAX_NUM="SMS_RND_MAX_NUM";
	/**短信发送号码（系统免费短信）*/
	public static final String SMS_SEND_MOBILE = "SMS_SEND_MOBILE";
	/**短信发送企业id，与SMProxy30.xml的source-addr一致*/
	public static final String SMS_MSG_SRC = "SMS_MSG_SRC";
	
	/**渠道类型*/
	public static final String CHANNLE_TYPE = "CHANNLE_TYPE";
	/**配送商类型*/
	public static final String DELIVERY_TYPE = "DELIVERY_TYPE";
	/**经理类型*/
	public static final String MANAGER_TYPE= "MANAGER_TYPE";
	
	public static final String REWARD_TYPE = "REWARD_TYPE";
	
	/**登录页面公开信息默认地市*/
	public static final String PUBLIC_CITY_ID = "PUBLIC_CITY_ID";
	
	
	/**注册待办标题*/
	public static final String MISSION_REGISTER_TITLE = "MISSION_REGISTER_TITLE";
	/**注册待办URL*/
	public static final String MISSION_REGISTER_CONTENT = "MISSION_REGISTER_CONTENT";
	/**注册待办计划完成时间*/
	public static final String MISSION_REGISTER_PLANTIME = "MISSION_REGISTER_PLANTIME";
	
	/**商品资源 一页记录数*/
	public static final String GOODSRESOURCE_PAGESIZE = "GOODSRESOURCE_PAGESIZE";
	
	/**系统默认地市*/
	public static final String SYSSUPPORT_BRANCH = "SYSSUPPORT_BRANCH";
}
