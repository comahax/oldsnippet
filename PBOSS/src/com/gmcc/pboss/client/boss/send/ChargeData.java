/**
 * 
 */
package com.gmcc.pboss.client.boss.send;

/**
 * @author hbm
 * 
 */

// 收费方式串：收费方式^金额^POS交易号^，说明：收费方式包括CASH（现金）、POS（POS机）、BANK（银行划账），非POS时POS交易号为空
// 金额："分"做单位
public class ChargeData {
	static public String CHARGE_TYPE_CASH = "CASH";
	static public String CHARGE_TYPE_POS = "POS";
	static public String CHARGE_TYPE_BANK = "BANK";

	private String chargeType;// 收费方式
	private String money;// 金额
	private String posNo;// POS交易号

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getPosNo() {
		return posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

}
