package com.gmcc.pboss.service.sms.result;


public class OrderQueryResult extends SMSResult{

	public static final String RET_TYPE_SUCC_0 = "0"; //成功
	
	public static final String RET_TYPE_FAIL_111 = "111"; //失败
	public static final String RET_TYPE_FAIL_1 = "1"; //号码未登记
	public static final String RET_TYPE_FAIL_2 = "2"; //非店主号码无权限
	public static final String RET_TYPE_FAIL_3 = "3"; //订单信息不存在
	
	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if(RET_TYPE_SUCC_0.equals(super.getRet())){
			return "订单编号或商品名称~订单状态或商品数量;50~30;";
		}else{
			return "";
		}
	}
	
}
