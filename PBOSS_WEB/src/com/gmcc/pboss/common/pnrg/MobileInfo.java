package com.gmcc.pboss.common.pnrg;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-8-18
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 * 		�й��ƶ��ֻ�������Ϣ
 */
public class MobileInfo {
	/**��ȡ�ɹ�*/
	public static final String SUCCESS = "SUCCESS";
	/**�ǹ㶫ʡ����*/
	public static final String UN_EXIST = "UN_EXIST";
	/**���غ�����ļ������쳣*/
	public static final String EXCEPTION = "EXCEPTION";
	
	/**���*/
	private String flage;
	/**���б���*/
	private String branchCode;
	
	/**���б���*/
	public String getBranchCode() {
		return branchCode;
	}
	/**���б���*/
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getFlage() {
		return flage;
	}
	public void setFlage(String flage) {
		this.flage = flage;
	}
	
}
