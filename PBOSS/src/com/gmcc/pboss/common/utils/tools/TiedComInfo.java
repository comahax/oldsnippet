package com.gmcc.pboss.common.utils.tools;
/**
 * ��������������/���ͣ��ӿڷ��� ���ص���Ϣ��װ��
 * @author zhangsiwei
 *
 */
public class TiedComInfo {
	// ������ʶ
	private long pid;
	// �����ʶ
	private long ruleid;
	// (����/����)��Ʒ����
	private String tComCategory;
	// (����/����)��Ʒ����
	private int tQuantity;
	
	
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public long getRuleid() {
		return ruleid;
	}
	public void setRuleid(long ruleid) {
		this.ruleid = ruleid;
	}
	public String getTComCategory() {
		return tComCategory;
	}
	public void setTComCategory(String comCategory) {
		tComCategory = comCategory;
	}
	public int getTQuantity() {
		return tQuantity;
	}
	public void setTQuantity(int quantity) {
		tQuantity = quantity;
	}
	
	

}
