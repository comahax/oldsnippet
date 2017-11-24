package com.gmcc.pboss.biz.info.salesRpt.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-7-31
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public class SalesrServiceRetCode extends ServiceRetCode {
	/**
	 * 记录不存在
	 */
	public static final int INIT_FAIL = 105;
	/**
	 * 没有此记录的权限
	 */
	public static final int AUTHOR_FAIL = 103;
	/**
	 * 订单归属渠道错误
	 */
	public static final int WAY_FAIL = 106;
	/**
	 * 订单状态错误，请联系管理员
	 */
	public static final int ORDERSTAT_ERROR = 107;
	/**
	 * 订单状态错误，请联系管理员
	 */
	public static final int ORDERPROCE_ERROR = 108;
	/**
	 * 订单放弃订购成功
	 */
	public static final int ORDERCANCEL_SUCCESS = 109;
	/**
	 * 订单确认成功
	 */
	public static final int ORDERCNFRM_SUCCESS = 110;
	/**
	 * ID丢失
	 */
	public static final int ID_Empty = 101;
	/**
	 * 状态丢失
	 */
	public static final int State_Empty = 106;
	/**
	 * 状态丢失
	 */
	public static final int State_Error = 107;
	/**
	 * 
	 */
	public static final int State_Error_108 = 108;
	/**
	 * ID丢失
	 */
	public static final int WAY_EMPTY = 102;
	/**
	 * 修改物流单号失败
	 */
	public static final int MOD_LOGI_ERROR = 109;
}
