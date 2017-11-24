package com.asisinfo.staff.bean;

import java.util.Date;

/**
 * 员工号码
 * @author lianzhonghong 
 *
 */

public class EmployeesNumber {
	private String svrnum;
	private Integer status;
	private String numberattr;
	private Integer isprimary;
	private Date chgtime;
	private String staffid;
	private String staffname;
	private String staffattr;
	private String dept;
	private Integer states;
	private String subsid; 
	private Integer position;
	private Date createtime;
	//员工账单
	private String mainsubsid;
	private Integer billcyc;
	private Integer reposition;
	private Integer flag;
	private Integer acctid;
	private String acctname;
	private float amt;
	
	private String staffperm;
	
	public String getSvrnum() {
		return svrnum;
	}
	public void setSvrnum(String svrnum) {
		this.svrnum = svrnum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNumberattr() {
		return numberattr;
	}
	public void setNumberattr(String numberattr) {
		this.numberattr = numberattr;
	}
	public Integer getIsprimary() {
		return isprimary;
	}
	public void setIsprimary(Integer isprimary) {
		this.isprimary = isprimary;
	}
	public Date getChgtime() {
		return chgtime;
	}
	public void setChgtime(Date chgtime) {
		this.chgtime = chgtime;
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
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
	
	public String getSubsid() {
		return subsid;
	}
	public void setSubsid(String subsid) {
		this.subsid = subsid;
	}
	
	public String getMainsubsid() {
		return mainsubsid;
	}
	public void setMainsubsid(String mainsubsid) {
		this.mainsubsid = mainsubsid;
	}
	public Integer getBillcyc() {
		return billcyc;
	}
	public void setBillcyc(Integer billcyc) {
		this.billcyc = billcyc;
	}
	public Integer getReposition() {
		return reposition;
	}
	public void setReposition(Integer reposition) {
		this.reposition = reposition;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getAcctid() {
		return acctid;
	}
	public void setAcctid(Integer acctid) {
		this.acctid = acctid;
	}
	public String getAcctname() {
		return acctname;
	}
	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	public String getStaffperm() {
		return staffperm;
	}
	public void setStaffperm(String staffperm) {
		this.staffperm = staffperm;
	}
	
	
}
