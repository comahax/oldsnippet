package com.gmcc.pboss.service.sms.result;

public class ActivityRatioResult extends SMSResult{
	
	public static final String RET_TYPE_SUCC_0 = "0"; //�ɹ�
	public static final String RET_TYPE_SUCC_000 = "000"; //�ɹ���������Ʒ�ƣ�
	
	public static final String RET_TYPE_FAIL_111 = "111"; //ʧ��
	public static final String RET_TYPE_FAIL_1 = "1"; //����δ�Ǽ�
	public static final String RET_TYPE_FAIL_2 = "2"; //�ǵ���������Ȩ��
	public static final String RET_TYPE_FAIL_3 = "3"; //�׿���������Ϣ������
	
	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		if(RET_TYPE_SUCC_0.equals(super.getRet()) || RET_TYPE_SUCC_000.equals(super.getRet()) ){
			return "Ʒ������~������;20~10;";
		}else{
			return "";
		}
	}
	
}
