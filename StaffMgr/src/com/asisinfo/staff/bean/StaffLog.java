package com.asisinfo.staff.bean;

import java.util.Date;

public class StaffLog {
	private String operid;
	private Date operdate;
	private int opertype;
	private String staffid;
	private String staffname;
	private String staffattr;
	private String dept;
	private int status;
	private int position;
	private Date createtime;
	private Date chgtime;
	
	private String svrnum;
	private int states;
	private String numberattr;
	private int isprimary;
	
	public String getOperid() {
		return operid;
	}
	public void setOperid(String operid) {
		this.operid = operid;
	}
	public Date getOperdate() {
		return operdate;
	}
	public void setOperdate(Date operdate) {
		this.operdate = operdate;
	}
	public int getOpertype() {
		return opertype;
	}
	public void setOpertype(int opertype) {
		this.opertype = opertype;
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	
	public String getStaffattr() {
		return staffattr;
	}
	public void setStaffattr(String staffattr) {
		this.staffattr = staffattr;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getChgtime() {
		return chgtime;
	}
	public void setChgtime(Date chgtime) {
		this.chgtime = chgtime;
	}
	public String getSvrnum() {
		return svrnum;
	}
	public void setSvrnum(String svrnum) {
		this.svrnum = svrnum;
	}
	public int getStates() {
		return states;
	}
	public void setStates(int states) {
		this.states = states;
	}
	public String getNumberattr() {
		return numberattr;
	}
	public void setNumberattr(String numberattr) {
		this.numberattr = numberattr;
	}
	public int getIsprimary() {
		return isprimary;
	}
	public void setIsprimary(int isprimary) {
		this.isprimary = isprimary;
	}
	
	
	
}
