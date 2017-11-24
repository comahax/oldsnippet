package com.gmcc.pboss.common.sms.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-9
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class SMSRetCode extends ServiceRetCode{
	public static final int RND_CODE_FORBIDDEN = 110;
	
	/**下发成功*/
	public static final int SEND_SUCCESS = 100;//正确
	
	public static final int W_MSG = 101;//消息结构错
	public static final int W_CMD = 102;//命令字错
	public static final int R_MSG_SERIALNUM = 103;//消息序号重复
	
	public static final int W_MSGLENGTH = 104;//消息长度错
	public static final int W_FEECODE = 105;//资费代码错
	public static final int O_MAXLENGTH = 106;//超过最大信息长
	public static final int W_BIZCODE = 107;//业务代码错
	public static final int W_FLOWCON = 108;//流量控制错
	public static final int W_OTHERS = 109;//其他错误
	public static final int W_UNIQUE = 111;//查找的employee不是唯一的
	
}
