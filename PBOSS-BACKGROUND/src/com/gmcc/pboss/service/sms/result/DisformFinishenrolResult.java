package com.gmcc.pboss.service.sms.result;

public class DisformFinishenrolResult extends SMSResult{

	public static final String RET_TYPE_SUCC_0 = "0";

	public static final String RET_TYPE_FAIL_1 = "1"; //号码未登记
	public static final String RET_TYPE_FAIL_2 = "2";//配送单信息不存在
	public static final String RET_TYPE_FAIL_3 = "3";//配送单信息错误
	public static final String RET_TYPE_FAIL_4 = "4";//配送状态错误
	public static final String RET_TYPE_FAIL_5 = "5";//已完成配送登记，请勿重复登记
	public static final String RET_TYPE_FAIL_111 = "111";//失败

	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if(RET_TYPE_SUCC_0.equals(super.getRet())){
			return "订单号;20;";
		}else{
			return "";
		}
	}

}
