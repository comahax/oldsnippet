package com.gmcc.pboss.service.sms.result;

public class LocalComOrderResult extends SMSResult{

	public static final String RET_TYPE_SUCC_0 = "0"; //成功
	public static final String RET_TYPE_FAIL_111 = "111"; //套卡激活率信息不存在
	public static final String RET_TYPE_FAIL_1 = "1"; //号码归属地未知
	public static final String RET_TYPE_FAIL_2 = "2"; //号码未登记
	public static final String RET_TYPE_FAIL_3 = "3"; //非店主号码无权限	
	public static final String RET_TYPE_FAIL_4 = "4"; //无商品订购权限
	public static final String RET_TYPE_FAIL_5 = "5"; //短信格式错误
	public static final String RET_TYPE_FAIL_6 = "6"; //不能订购混合资源类别的订单
	public static final String RET_TYPE_FAIL_7 = "7"; //银行账号信息不存在或不完整
	public static final String RET_TYPE_FAIL_8 = "8"; //超出本月最大订购次数
	public static final String RET_TYPE_FAIL_9 = "9"; //今天不提供商品订购服务
	public static final String RET_TYPE_FAIL_10 = "10"; //不在系统订购时间段
	public static final String RET_TYPE_FAIL_11 = "11"; //商品重复
	public static final String RET_TYPE_FAIL_12 = "12"; //商品不存在
	public static final String RET_TYPE_FAIL_13 = "13"; //商品订购状态不正常
	public static final String RET_TYPE_FAIL_14 = "14"; //订购数量非大于零的整数	
	public static final String RET_TYPE_FAIL_15 = "15"; //订购商品数量非订购基数整数倍
	
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
