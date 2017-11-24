/**
 * 
 */
package com.gmcc.pboss.client.boss.result;

/**
 * 分销商品销售BOSS入账 结果包
 * 
 * @author hbm
 * 
 */

/*
	回送报文:
	
	datatrans：ret~说明;[标题;列宽段;]数据段;
	
	数据段格式：BOSS的工单编号;
	ret=0   操作成功
	ret=1   未找到订单对应的商品资源
	ret=MMM 操作失败，要求在“说明”中描述失败原因
 */
public class IncomeAccountResult{
	static public String RET_TYPE_SUSS = "0"; //操作成功
	static public String RET_TYPE_NO_EXIST = "1"; //未找到订单对应的商品资源
	static public String RET_TYPE_FAIL = "MMM"; //操作失败
	
	private String ret;//返回类型
	private String explain;//说明
	private String bossNo; //BOSS的工单编号
	private String other; //[标题;列宽段;]    理论上为空
	private String orderid;
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getBossNo() {
		return bossNo;
	}
	public void setBossNo(String bossNo) {
		this.bossNo = bossNo;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
}
