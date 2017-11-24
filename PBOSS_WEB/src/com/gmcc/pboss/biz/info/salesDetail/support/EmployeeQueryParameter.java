package com.gmcc.pboss.biz.info.salesDetail.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class EmployeeQueryParameter extends QueryParameter {
	//渠道编码
	private String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	
	//人员类型
	private long isnet;//0-店员，1-店主，3-配送商，4-经理
	public void setIsnet(long isnet){
		this.isnet = isnet;
	}
	public long getIsnet(){
		return this.isnet;
	}
	
	//经理人员编码
	private String waymagcode;
	public String getWaymagcode() {
		return waymagcode;
	}
	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}
	
	//弹出框使用
	private String employeeid;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	//弹出框使用
	private String employeename;
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
}
