package com.gmcc.pboss.service.sms.result;

public class SecondConfirmResult extends SMSResult {

	public static final String RET_TYPE_SUCC_0 = "0"; //�ɹ�
	
	public static final String RET_TYPE_FAIL_111 = "111"; //ʧ��
	public static final String RET_TYPE_FAIL_1 = "1"; //ȷ�ϼ�¼������
	public static final String RET_TYPE_FAIL_2 = "2"; //ȷ�ϳ�ʱ
	public static final String RET_TYPE_FAIL_3 = "3"; //������Ϣ������
	public static final String RET_TYPE_FAIL_4 = "4"; //�������̴���
	
	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if(RET_TYPE_SUCC_0.equals(super.getRet())){
			return "������~�ͻ�����;20~30;";
		}else {
			return "";
		}
	}

}
