package com.gmcc.pboss.biz.info.salesDetail.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class EmployeeQueryParameter extends QueryParameter {
	//��������
	private String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	
	//��Ա����
	private long isnet;//0-��Ա��1-������3-�����̣�4-����
	public void setIsnet(long isnet){
		this.isnet = isnet;
	}
	public long getIsnet(){
		return this.isnet;
	}
	
	//������Ա����
	private String waymagcode;
	public String getWaymagcode() {
		return waymagcode;
	}
	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}
	
	//������ʹ��
	private String employeeid;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	//������ʹ��
	private String employeename;
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
}
