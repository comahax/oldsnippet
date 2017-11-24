package com.gmcc.pboss.biz.info.adpay.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

public class AdpayServiceRetCode extends ServiceRetCode {
	/**
	 * 垫资单管理 支付报错
	 */
	//public static final int PAY_ERROR = 101;//划扣记录已存在
	
	public static final int PAY_ERR_RECORD_EXIST = 101;//划扣记录已存在
	
	public static final int PAY_ERR_CUST_NOT_EXIST = 102;//账户资料不存在
	
	public static final int PAY_ERR_ACC_TYPE_NULL = 103;//合作商账户资料帐号类型为空
	
	public static final int PAY_ERR_ACC_NO_NULL = 104;//合作商账户资料银行账号为空
	
	public static final int PAY_ERR_ACC_NAME_NULL = 105;//合作商账户资料帐号名称为空
	
	public static final int PAY_ERR_ACC_MARK_NULL = 106;//合作商账户资料银行标识为空
	
	public static final int PAY_ERR_STATE_ERROR = 107;//该汇总单不是”待提交状态“或“已确认状态”
	
	public static final int PAY_ERR_NO_ACCOUNT = 108;//银行商户信息不存在
	
	public static final int PAY_ERR_ID_EMPTY = 109;//ID丢失

	public static final int PAY_ERR_STATE_EMPTY = 110;//状态不存在
	
	
}
