package com.gmcc.pboss.service.sms.result;

public class DisformFinishenrolResult extends SMSResult{

	public static final String RET_TYPE_SUCC_0 = "0";

	public static final String RET_TYPE_FAIL_1 = "1"; //����δ�Ǽ�
	public static final String RET_TYPE_FAIL_2 = "2";//���͵���Ϣ������
	public static final String RET_TYPE_FAIL_3 = "3";//���͵���Ϣ����
	public static final String RET_TYPE_FAIL_4 = "4";//����״̬����
	public static final String RET_TYPE_FAIL_5 = "5";//��������͵Ǽǣ������ظ��Ǽ�
	public static final String RET_TYPE_FAIL_111 = "111";//ʧ��

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
