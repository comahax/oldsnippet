package com.gmcc.pboss.manager.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class ManagerNodeQueryParameter extends QueryParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7914290168663261794L;
	
	//��ѯ�������������waymagcode,���ڵ�½¼���idֵ�����������б�
	private String waymagcode;
	public void setWaymagcode(String managerid){
		this.waymagcode = managerid;
	}
	public String getWaymagcode(){
		return this.waymagcode;
	}
	//�����������ƣ�֧��ģ����ѯ
	private String wayname;
	public void setWayname(String name){
		this.wayname = name;
	}
	public String getWayname(){
		return this.wayname;
	}
	
	//����wayid��ѯ������ϸ��Ϣ
	public String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	
	//�Ƿ�Ϊ�������ѡ�񵯳���
	private boolean popup;
	public boolean isPopup() {
		return popup;
	}
	public void setPopup(boolean popup) {
		this.popup = popup;
	}

}
