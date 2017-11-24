package com.gmcc.pboss.service.sms.result;

public class ComOrderResult extends SMSResult{

	public static final String RET_TYPE_SUCC_0 = "0"; //成功
	public static final String RET_TYPE_FAIL_111 = "111"; //套卡激活率信息不存在
	public static final String RET_TYPE_FAIL_1 = "1"; //号码未登记
	public static final String RET_TYPE_FAIL_2 = "2"; //非店主号码无权限	
	public static final String RET_TYPE_FAIL_3 = "3"; //无商品订购权限
	public static final String RET_TYPE_FAIL_4 = "4"; //银行账号信息不存在或不完整	
	public static final String RET_TYPE_FAIL_5 = "5"; //不在系统订购时间段
	public static final String RET_TYPE_FAIL_6 = "6"; //商品不存在
	public static final String RET_TYPE_FAIL_7 = "7"; //商品重复
	public static final String RET_TYPE_FAIL_8 = "8"; //商品订购状态不正常
	public static final String RET_TYPE_FAIL_9 = "9"; //商品种类订购基数错误
	public static final String RET_TYPE_FAIL_10 = "10"; //订购数量小于等于零
	public static final String RET_TYPE_FAIL_11 = "11"; //订购数量非整数
	public static final String RET_TYPE_FAIL_12 = "12"; //订单总数大于等于最大订购次数
	public static final String RET_TYPE_FAIL_13 = "13"; //当天不提供商品订购服务
	public static final String RET_TYPE_FAIL_14 = "14"; //不能订购混合资源类别的订单
	
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
