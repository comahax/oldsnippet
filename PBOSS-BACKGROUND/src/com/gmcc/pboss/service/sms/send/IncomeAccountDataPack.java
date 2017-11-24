package com.gmcc.pboss.service.sms.send;

/**
 * 分销商品销售BOSS入账 数据包
 * 
 * @author hbm
 *
 */

/*
	发送报文：
	
	命令字：52210
	datatrans：操作渠道~操作工号~收费方式串~费用串~PBOSS订单编号;
	
	参数说明：
		操作渠道：业务受理渠道
		操作工号：业务受理操作员工号
		收费方式串：收费方式^金额^POS交易号^，说明：收费方式包括CASH（现金）、POS（POS机）、BANK（银行划账），非POS时POS交易号为空
		费用串：XS^商品费用^100.00^， 说明：本次分销订单的总费用,"XS^商品费用^"是固定值
		PBOSS订单编号：PBOSS系统订单编号，说明：用于资源明细查询
*/
public class IncomeAccountDataPack{
	private String wayid;//操作渠道
	private String oprcode;//操作工号
	private ChargeData chargeData;//收费方式串
	private String feeStr;//费用串
	private String pbossNo;//PBOSS订单编号
	
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public ChargeData getChargeData() {
		return chargeData;
	}
	public void setChargeData(ChargeData chargeData) {
		this.chargeData = chargeData;
	}
	public String getFeeStr() {
		return feeStr;
	}
	public void setFeeStr(String feeStr) {
		this.feeStr = feeStr;
	}
	public String getPbossNo() {
		return pbossNo;
	}
	public void setPbossNo(String pbossNo) {
		this.pbossNo = pbossNo;
	}
	
}
