/**
 * 
 */
package com.gmcc.pboss.service.sms.result;

/**
 * ������Ʒ����BOSS���� �����
 * 
 * @author hbm
 * 
 */

/*
	���ͱ���:
	
	datatrans��ret~˵��;[����;�п��;]���ݶ�;
	
	���ݶθ�ʽ��BOSS�Ĺ������;
	ret=0   �����ɹ�
	ret=1   δ�ҵ�������Ӧ����Ʒ��Դ
	ret=MMM ����ʧ�ܣ�Ҫ���ڡ�˵����������ʧ��ԭ��
 */
public class IncomeAccountResult{
	static public String RET_TYPE_SUSS = "0"; //�����ɹ�
	static public String RET_TYPE_NO_EXIST = "1"; //δ�ҵ�������Ӧ����Ʒ��Դ
	static public String RET_TYPE_FAIL = "MMM"; //����ʧ��
	
	private String ret;//��������
	private String explain;//˵��
	private String bossNo; //BOSS�Ĺ������
	private String other; //[����;�п��;]    ������Ϊ��
	
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getBossNo() {
		return bossNo;
	}
	public void setBossNo(String bossNo) {
		this.bossNo = bossNo;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
}
