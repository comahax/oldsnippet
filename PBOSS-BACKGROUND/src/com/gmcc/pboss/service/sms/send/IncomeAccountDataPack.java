package com.gmcc.pboss.service.sms.send;

/**
 * ������Ʒ����BOSS���� ���ݰ�
 * 
 * @author hbm
 *
 */

/*
	���ͱ��ģ�
	
	�����֣�52210
	datatrans����������~��������~�շѷ�ʽ��~���ô�~PBOSS�������;
	
	����˵����
		����������ҵ����������
		�������ţ�ҵ���������Ա����
		�շѷ�ʽ�����շѷ�ʽ^���^POS���׺�^��˵�����շѷ�ʽ����CASH���ֽ𣩡�POS��POS������BANK�����л��ˣ�����POSʱPOS���׺�Ϊ��
		���ô���XS^��Ʒ����^100.00^�� ˵�������η����������ܷ���,"XS^��Ʒ����^"�ǹ̶�ֵ
		PBOSS������ţ�PBOSSϵͳ������ţ�˵����������Դ��ϸ��ѯ
*/
public class IncomeAccountDataPack{
	private String wayid;//��������
	private String oprcode;//��������
	private ChargeData chargeData;//�շѷ�ʽ��
	private String feeStr;//���ô�
	private String pbossNo;//PBOSS�������
	
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
