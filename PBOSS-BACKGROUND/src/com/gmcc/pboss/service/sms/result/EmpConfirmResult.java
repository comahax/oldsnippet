package com.gmcc.pboss.service.sms.result;

public class EmpConfirmResult extends SMSResult{
	
	public static final String RET_TYPE_SUCC_0 = "0"; //成功
	public static final String RET_TYPE_FAIL_1 = "1"; 
	//public static final String RET_TYPE_FAIL_2 = "2"; 
	//public static final String RET_TYPE_FAIL_3 = "3"; 
	//public static final String RET_TYPE_FAIL_4 = "4"; 
	public static final String RET_TYPE_FAIL_111 = "111"; //失败
	
	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if (RET_TYPE_SUCC_0.equals(super.getRet())) {
			return "专员状态~专员昵称~渠道ID~渠道名称;3~20~20~50;";
		} else {
			return "";
		}
	}

}