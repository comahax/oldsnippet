package com.gmcc.pboss.biz.info.reward.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * 从兴公司电子渠道业务部
 * @author yuwenjun
 * @date 2009-7-31
 * 所属项目：酬金
 * 所属模块：
 * 描述：
 */
public class RewardServiceRetCode extends ServiceRetCode {
	/**
	 * 验证码失败
	 */
	public static final int ADVINFO_ERROR = 111;
		
	/**
	 * 本地酬金数据用户对应数据
	 */
	public static final int USER_EMPTY = 150;
	/**
	 * 本地酬金数据不存在
	 */
	public static final int DATA_ERROR = 151;
}
