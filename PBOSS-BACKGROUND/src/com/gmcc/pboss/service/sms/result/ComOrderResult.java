package com.gmcc.pboss.service.sms.result;

public class ComOrderResult extends SMSResult{

	public static final String RET_TYPE_SUCC_0 = "0"; //�ɹ�
	public static final String RET_TYPE_FAIL_111 = "111"; //�׿���������Ϣ������
	public static final String RET_TYPE_FAIL_1 = "1"; //����δ�Ǽ�
	public static final String RET_TYPE_FAIL_2 = "2"; //�ǵ���������Ȩ��	
	public static final String RET_TYPE_FAIL_3 = "3"; //����Ʒ����Ȩ��
	public static final String RET_TYPE_FAIL_4 = "4"; //�����˺���Ϣ�����ڻ�����	
	public static final String RET_TYPE_FAIL_5 = "5"; //����ϵͳ����ʱ���
	public static final String RET_TYPE_FAIL_6 = "6"; //��Ʒ������
	public static final String RET_TYPE_FAIL_7 = "7"; //��Ʒ�ظ�
	public static final String RET_TYPE_FAIL_8 = "8"; //��Ʒ����״̬������
	public static final String RET_TYPE_FAIL_9 = "9"; //��Ʒ���ඩ����������
	public static final String RET_TYPE_FAIL_10 = "10"; //��������С�ڵ�����
	public static final String RET_TYPE_FAIL_11 = "11"; //��������������
	public static final String RET_TYPE_FAIL_12 = "12"; //�����������ڵ�����󶩹�����
	public static final String RET_TYPE_FAIL_13 = "13"; //���첻�ṩ��Ʒ��������
	public static final String RET_TYPE_FAIL_14 = "14"; //���ܶ��������Դ���Ķ���
	
	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if(RET_TYPE_SUCC_0.equals(super.getRet())){
			return "������;20;";
		}else{
			return "";
		}
	}
	
}
