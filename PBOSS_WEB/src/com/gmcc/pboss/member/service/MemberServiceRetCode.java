package com.gmcc.pboss.member.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-7-31
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public class MemberServiceRetCode extends ServiceRetCode {
	/**
	 * 验证码失败
	 */
	public static final int VERIFY_FAIL = 101;
	
	/**
	 * 未注册
	 */
	public static final int NOT_REGISTER = 102;
	
	/**
	 * 未输入验证码
	 */
	public static final int NOT_VCODE = 103;
	
	/**
	 * 输入不正确
	 */
	public static final int INPUT_FAIL = 104;
	
	/**
	 * 渠道信息查询失败
	 */
	public static final int CHANNEL_FAIL = 105;
	
	/**
	 *渠道商登录 
	 */
	public static final int CHANNEL_LOGIN = 106;
	
	/**
	 * 配送商登录
	 */
	public static final int DELIVERY_LOGIN = 107;
	
	/**
	 * 公务机对应多个在岗人员
	 */
	public static final int MORE_THAN_ONE_MASTER = 198;
	
	/**
	 * 固定密码-验证失败
	 */
	public static final int FIXED_PW_VERIFY_FAIL = 199;
	
	/**
	 * 经理人员登录
	 */
	public static final int MANAGER_LOGIN = 191;
	
	/**
	 * 渠道类型不正确
	 */
	public static final int UNCORRECT_WAYTYPE = 108;
	
	/**
	 * 店员申请书成功
	 */
	public static final int EMPLOYEEAPPLY= 200;
	/**
	 * 店员修改申请书成功
	 */
	public static final int EMPLOYEEUPADEAPPLY= 202;
	/**
	 * 店员退出申请成功
	 */
	public static final int EMPLOYEEQUIT= 201;
	/**
	 * 找不到默认处理人
	 */
	public static final int OPRCODEISNULL = 210;
	/**
	 * 混合角色登陆：配送商+渠道经理
	 */
	public static final int MIX_ROLE = 211;
	
	/**
	 * 无法确定登陆人员所属地市
	 */
	public static final int MEMBERCITY = 212;
	/**
	 * 专员类型为空，不能访问
	 */
	public static final int MEMBERNULL = 213;
	/**
	 * 您所属的专员类型不支持访问
	 */
	public static final int MEMBERTYPE = 214;
	
	/**
	 * 省经理人员登录
	 */
	public static final int GDMEMBERTYPE = 220;
	/**
	 * 市经理人员登录
	 */
	public static final int CITYMEMBERTYPE = 221;
}
