package com.gmcc.pboss.service.sms.result;

public class LocalComOrderResult extends SMSResult{

	public static final String RET_TYPE_SUCC_0 = "0"; //�ɹ�
	public static final String RET_TYPE_FAIL_111 = "111"; //�׿���������Ϣ������
	public static final String RET_TYPE_FAIL_1 = "1"; //���������δ֪
	public static final String RET_TYPE_FAIL_2 = "2"; //����δ�Ǽ�
	public static final String RET_TYPE_FAIL_3 = "3"; //�ǵ���������Ȩ��	
	public static final String RET_TYPE_FAIL_4 = "4"; //����Ʒ����Ȩ��
	public static final String RET_TYPE_FAIL_5 = "5"; //���Ÿ�ʽ����
	public static final String RET_TYPE_FAIL_6 = "6"; //���ܶ��������Դ���Ķ���
	public static final String RET_TYPE_FAIL_7 = "7"; //�����˺���Ϣ�����ڻ�����
	public static final String RET_TYPE_FAIL_8 = "8"; //����������󶩹�����
	public static final String RET_TYPE_FAIL_9 = "9"; //���첻�ṩ��Ʒ��������
	public static final String RET_TYPE_FAIL_10 = "10"; //����ϵͳ����ʱ���
	public static final String RET_TYPE_FAIL_11 = "11"; //��Ʒ�ظ�
	public static final String RET_TYPE_FAIL_12 = "12"; //��Ʒ������
	public static final String RET_TYPE_FAIL_13 = "13"; //��Ʒ����״̬������
	public static final String RET_TYPE_FAIL_14 = "14"; //���������Ǵ����������	
	public static final String RET_TYPE_FAIL_15 = "15"; //������Ʒ�����Ƕ�������������
	
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
