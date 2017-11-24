package com.gmcc.pboss.service.sms.result;

public class CancelBookResult extends SMSResult {

	public static final String RET_TYPE_SUCC_0 = "0"; // 成功
	public static final String RET_TYPE_FAIL_1 = "1"; // “1”，说明取“获取号码归属地市失败”
	public static final String RET_TYPE_FAIL_2 = "2"; // 取“2”，说明取“确认超时”
	public static final String RET_TYPE_FAIL_3 = "3"; // 返回码取“3”，说明取“订单信息不存在”
	public static final String RET_TYPE_FAIL_4 = "4"; // 返回码取“4”，说明取“订单状态错误”
	public static final String RET_TYPE_FAIL_DATA = "111"; // 返回码取“111”，说明数据错误

	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if (RET_TYPE_SUCC_0.equals(super.getRet())) {
			return "订单号~客户姓名;20~30;";
		} else {
			return "";
		}
	}

}
