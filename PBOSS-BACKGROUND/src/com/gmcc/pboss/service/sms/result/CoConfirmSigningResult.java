package com.gmcc.pboss.service.sms.result;

/**
 * 【合作商确认签收】返回码
 * @author zsw
 *
 */
public class CoConfirmSigningResult extends SMSResult {

	public static final String RET_TYPE_SUCC_0 = "0"; //成功
	
	public static final String RET_TYPE_FAIL_111 = "111"; //失败
	public static final String RET_TYPE_FAIL_1 = "1"; //确认记录不存在
	public static final String RET_TYPE_FAIL_2 = "2"; //订单信息不存在
	public static final String RET_TYPE_FAIL_3 = "3"; //订单已签收，无需重复确认
	public static final String RET_TYPE_FAIL_4 = "4"; //当前签收状态错误
	public static final String RET_TYPE_FAIL_5 = "5"; //签收超时
	
	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		return null;
	}

}
