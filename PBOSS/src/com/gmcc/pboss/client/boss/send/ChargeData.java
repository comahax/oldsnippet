/**
 * 
 */
package com.gmcc.pboss.client.boss.send;

/**
 * @author hbm
 * 
 */

// �շѷ�ʽ�����շѷ�ʽ^���^POS���׺�^��˵�����շѷ�ʽ����CASH���ֽ𣩡�POS��POS������BANK�����л��ˣ�����POSʱPOS���׺�Ϊ��
// ��"��"����λ
public class ChargeData {
	static public String CHARGE_TYPE_CASH = "CASH";
	static public String CHARGE_TYPE_POS = "POS";
	static public String CHARGE_TYPE_BANK = "BANK";

	private String chargeType;// �շѷ�ʽ
	private String money;// ���
	private String posNo;// POS���׺�

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
