package com.gmcc.pboss.common.config.bean;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-17
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������������������bean
 */
public class PendingTaskConfigBean {
	/**������������*/
	private String name;
	/**�����������*/
	private String titel;
	/**��������URL*/
	private String url;
	/**��������ƻ����ʱ�䣨Ĭ��Ϊ7�죩*/
	private int plantime = 7;
	/**����������ܶ���Ĭ��Ϊ4 �ض���Ա��*/
	private int desttype = 4;
	/**���������Ƿ����֪ͨ��Ĭ��Ϊ1 ��Ҫ��*/
	private int smsnotify= 1;
	/**���������Ƿ���Ҫ������Ĭ��Ϊ0 ��*/
	private int ndapproval = 0;
	/**��������״̬��Ĭ��Ϊ3�ѷ�����*/
	private int state = 3;
	
	/**������������*/
	public String getName() {
		return name;
	}
	/**������������*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**�����������*/
	public String getTitel() {
		return titel;
	}
	/**�����������*/
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	/**��������URL*/
	public String getUrl() {
		return url;
	}
	/**��������URL*/
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**��������ƻ����ʱ�䣨Ĭ��Ϊ7�죩*/
	public int getPlantime() {
		return plantime;
	}
	/**��������ƻ����ʱ�䣨Ĭ��Ϊ7�죩*/
	public void setPlantime(int plantime) {
		this.plantime = plantime;
	}
	
	/**����������ܶ���Ĭ��Ϊ4 �ض���Ա��*/
	public int getDesttype() {
		return desttype;
	}
	/**����������ܶ���Ĭ��Ϊ4 �ض���Ա��*/
	public void setDesttype(int desttype) {
		this.desttype = desttype;
	}
	
	/**���������Ƿ����֪ͨ��Ĭ��Ϊ1 ��Ҫ��*/
	public int getSmsnotify() {
		return smsnotify;
	}
	/**���������Ƿ����֪ͨ��Ĭ��Ϊ1 ��Ҫ��*/
	public void setSmsnotify(int smsnotify) {
		this.smsnotify = smsnotify;
	}
	
	/**���������Ƿ���Ҫ������Ĭ��Ϊ0 ��*/
	public int getNdapproval() {
		return ndapproval;
	}
	/**���������Ƿ���Ҫ������Ĭ��Ϊ0 ��*/
	public void setNdapproval(int ndapproval) {
		this.ndapproval = ndapproval;
	}
	
	/**��������״̬��Ĭ��Ϊ1 δ������*/
	public int getState() {
		return state;
	}
	/**��������״̬��Ĭ��Ϊ1 δ������*/
	public void setState(int state) {
		this.state = state;
	}
	
	
}
