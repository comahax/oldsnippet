package com.gmcc.pboss.biz.info.adpay.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

public class AdpayServiceRetCode extends ServiceRetCode {
	/**
	 * ���ʵ����� ֧������
	 */
	//public static final int PAY_ERROR = 101;//���ۼ�¼�Ѵ���
	
	public static final int PAY_ERR_RECORD_EXIST = 101;//���ۼ�¼�Ѵ���
	
	public static final int PAY_ERR_CUST_NOT_EXIST = 102;//�˻����ϲ�����
	
	public static final int PAY_ERR_ACC_TYPE_NULL = 103;//�������˻������ʺ�����Ϊ��
	
	public static final int PAY_ERR_ACC_NO_NULL = 104;//�������˻����������˺�Ϊ��
	
	public static final int PAY_ERR_ACC_NAME_NULL = 105;//�������˻������ʺ�����Ϊ��
	
	public static final int PAY_ERR_ACC_MARK_NULL = 106;//�������˻��������б�ʶΪ��
	
	public static final int PAY_ERR_STATE_ERROR = 107;//�û��ܵ����ǡ����ύ״̬������ȷ��״̬��
	
	public static final int PAY_ERR_NO_ACCOUNT = 108;//�����̻���Ϣ������
	
	public static final int PAY_ERR_ID_EMPTY = 109;//ID��ʧ

	public static final int PAY_ERR_STATE_EMPTY = 110;//״̬������
	
	
}
