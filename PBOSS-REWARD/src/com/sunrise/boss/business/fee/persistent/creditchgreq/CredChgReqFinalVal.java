package com.sunrise.boss.business.fee.persistent.creditchgreq;

public class CredChgReqFinalVal {
	
	/**
	 * �ſ����������-������Դ
	 */
	public final static Short SRC_PAY_PAY = new Short("0"); //�ɷ�
	public final static Short SRC_PAY_ROLL = new Short("1"); //�˷�
	public final static Short SRC_TRAN_FAILD = new Short("2"); //����ʧ��
	public final static Short SRC_TRAN_SUCC = new Short("3"); //���ʳɹ�
	public final static Short SRC_REAL_FLASH = new Short("4"); //ʵʱ���ø���
	public final static Short SRC_HIGH_FLASH = new Short("5"); //�߶����
	public final static Short SRC_REC_CHANGE = new Short("6"); //Ӧ�ձ��
	public final static Short SRC_FEE_CX = new Short("7"); //��������
	public final static Short SRC_FEE_ADJUDGE = new Short("8"); //���ѵ���
	public final static Short SRC_CREDIT_POLL = new Short("9"); //���ô�����ѭ
	public final static Short SRC_CREDIT_ACT_ = new Short("10"); //�½�ͣ��ר��
	//public final static Short SRC_CREDIT_MON_STOP = new Short("11"); //�½�ͣ��
	public final static Short SRC_ACC_FAILD = new Short("20"); //����ʧ�ܣ��ʺ��쳣
	//public final static Short SRC_CREDIT_ACT = new Short("1000"); //
	public final static Short SRC_ALL = new Short("10000"); //������Դ
	
	/**
	 * �ſ����������-��������
	 */
	public final static Short REQTYPE_REALRT = new Short("1"); //ʵʱ����
	public final static Short REQTYPE_OPEN = new Short("2"); //����
	
}
