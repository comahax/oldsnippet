package com.gmcc.pboss.service.sms.send;

/**
 * ������Ʒ����BOSS������ ���ݰ�
 * 
 * @author hbm
 * 
 */

/*
 	���ͱ��ģ�
 	
	�����֣�52211
	datatrans����������~��������~�շѷ�ʽ��~���ô�~PBOSS�������~BOSS���˹������;

	����˵����
		����������ҵ����������
		�������ţ�ҵ���������Ա����
		�շѷ�ʽ�����շѷ�ʽ^���^POS���׺�^, ˵�����շѷ�ʽ����CASH���ֽ𣩡�POS��POS������BANK�����л��ˣ�����POSʱPOS���׺�Ϊ�գ����Ҳ��ԭ�����෴��
		���ô���XS^��Ʒ����^-100.00^, ˵����ԭ�����ܷ��õ��෴��,"XS^��Ʒ����^"�ǹ̶�ֵ
		PBOSS������ţ�PBOSS������Ʒ���۶������
		BOSS���˹�����ţ�BOSSϵͳ����ʱ�ǼǵĹ������
 */
public class CancelAccountDataPack extends IncomeAccountDataPack {
	private String bossNo;// BOSS���˹������

	public String getBossNo() {
		return bossNo;
	}

	public void setBossNo(String bossNo) {
		this.bossNo = bossNo;
	}

}
