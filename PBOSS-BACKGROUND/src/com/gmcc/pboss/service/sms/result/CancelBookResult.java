package com.gmcc.pboss.service.sms.result;

public class CancelBookResult extends SMSResult {

	public static final String RET_TYPE_SUCC_0 = "0"; // �ɹ�
	public static final String RET_TYPE_FAIL_1 = "1"; // ��1����˵��ȡ����ȡ�����������ʧ�ܡ�
	public static final String RET_TYPE_FAIL_2 = "2"; // ȡ��2����˵��ȡ��ȷ�ϳ�ʱ��
	public static final String RET_TYPE_FAIL_3 = "3"; // ������ȡ��3����˵��ȡ��������Ϣ�����ڡ�
	public static final String RET_TYPE_FAIL_4 = "4"; // ������ȡ��4����˵��ȡ������״̬����
	public static final String RET_TYPE_FAIL_DATA = "111"; // ������ȡ��111����˵�����ݴ���

	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if (RET_TYPE_SUCC_0.equals(super.getRet())) {
			return "������~�ͻ�����;20~30;";
		} else {
			return "";
		}
	}

}
