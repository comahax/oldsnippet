package com.gmcc.pboss.model.sms;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-2
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ���������ų�����
 */
public abstract class SMS {
	/**Դ����*/
	private String srcterminal;
	/**Ŀ�����*/
	private String destterminal;
	/**��������*/
	private String content;
	
	/**Դ����*/
	public String getSrcterminal() {
		return this.srcterminal;
	}
	/**Դ����*/
	public void setSrcterminal(String srcterminal) {
		this.srcterminal = srcterminal;
	}
	/**Ŀ�����*/
	public String getDestterminal() {
		return this.destterminal;
	}
	/**Ŀ�����*/
	public void setDestterminal(String destterminal) {
		this.destterminal = destterminal;
	}
	/**��������*/
	public String getContent() {
		return this.content;
	}
	/**��������*/
	public void setContent(String content) {
		this.content = content;
	}
}
