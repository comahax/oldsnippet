package com.gmcc.pboss.common.sms.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-9
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class SMSRetCode extends ServiceRetCode{
	public static final int RND_CODE_FORBIDDEN = 110;
	
	/**�·��ɹ�*/
	public static final int SEND_SUCCESS = 100;//��ȷ
	
	public static final int W_MSG = 101;//��Ϣ�ṹ��
	public static final int W_CMD = 102;//�����ִ�
	public static final int R_MSG_SERIALNUM = 103;//��Ϣ����ظ�
	
	public static final int W_MSGLENGTH = 104;//��Ϣ���ȴ�
	public static final int W_FEECODE = 105;//�ʷѴ����
	public static final int O_MAXLENGTH = 106;//���������Ϣ��
	public static final int W_BIZCODE = 107;//ҵ������
	public static final int W_FLOWCON = 108;//�������ƴ�
	public static final int W_OTHERS = 109;//��������
	public static final int W_UNIQUE = 111;//���ҵ�employee����Ψһ��
	
}
