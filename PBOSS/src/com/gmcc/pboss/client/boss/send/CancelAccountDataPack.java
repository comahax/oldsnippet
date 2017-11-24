package com.gmcc.pboss.client.boss.send;

/**
 * 分销商品销售BOSS退入账 数据包
 * 
 * @author hbm
 * 
 */

/*
 	发送报文：
 	
	命令字：52211
	datatrans：操作渠道~操作工号~收费方式串~费用串~PBOSS订单编号~BOSS入账工单编号;

	参数说明：
		操作渠道：业务受理渠道
		操作工号：业务受理操作员工号
		收费方式串：收费方式^金额^POS交易号^, 说明：收费方式包括CASH（现金）、POS（POS机）、BANK（银行划账），非POS时POS交易号为空，金额也是原金额的相反数
		费用串：XS^商品费用^-100.00^, 说明：原订单总费用的相反数,"XS^商品费用^"是固定值
		PBOSS订单编号：PBOSS分销商品退售订单编号
		BOSS入账工单编号：BOSS系统入账时登记的工单编号
 */
public class CancelAccountDataPack extends IncomeAccountDataPack {
	private String bossNo;// BOSS入账工单编号

	public String getBossNo() {
		return bossNo;
	}

	public void setBossNo(String bossNo) {
		this.bossNo = bossNo;
	}

}
