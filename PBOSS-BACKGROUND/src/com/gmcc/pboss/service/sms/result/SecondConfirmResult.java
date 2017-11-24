package com.gmcc.pboss.service.sms.result;

public class SecondConfirmResult extends SMSResult {

	public static final String RET_TYPE_SUCC_0 = "0"; //成功
	
	public static final String RET_TYPE_FAIL_111 = "111"; //失败
	public static final String RET_TYPE_FAIL_1 = "1"; //确认记录不存在
	public static final String RET_TYPE_FAIL_2 = "2"; //确认超时
	public static final String RET_TYPE_FAIL_3 = "3"; //订单信息不存在
	public static final String RET_TYPE_FAIL_4 = "4"; //订单流程错误
	
	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if(RET_TYPE_SUCC_0.equals(super.getRet())){
			return "订单号~客户姓名;20~30;";
		}else {
			return "";
		}
	}

}
