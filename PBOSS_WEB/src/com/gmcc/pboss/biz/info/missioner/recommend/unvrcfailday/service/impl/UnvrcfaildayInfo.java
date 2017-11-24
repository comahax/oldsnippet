package com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.service.impl;

import java.io.Serializable;

public class UnvrcfaildayInfo implements Serializable {
//	u.failid,u.rcno,u.mobileno,u.opnid,o.name as opnname,u.rcmonth,u.rcdate
//	u.reason,u.ossrc,u.wayid,w.wayname,e.empattr2 
	private Long failid;
	private String rcno;
	private String mobileno;
	private String opnid;
	private String opnname;
	private String rcmonth;
	private String rcdate;
	private String reason;
	private String ossrc;
	private String wayid;
	private String wayname;
	private String empattr2;
	
	public UnvrcfaildayInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UnvrcfaildayInfo(Long failid, String rcno, String mobileno,
			String opnid, String opnname, String rcmonth, String rcdate,
			String reason, String ossrc, String wayid, String wayname,
			String empattr2) {
		super();
		this.failid = failid;
		this.rcno = rcno;
		this.mobileno = mobileno;
		this.opnid = opnid;
		this.opnname = opnname;
		this.rcmonth = rcmonth;
		this.rcdate = rcdate;
		this.reason = reason;
		this.ossrc = ossrc;
		this.wayid = wayid;
		this.wayname = wayname;
		this.empattr2 = empattr2;
	}
	public Long getFailid() {
		return failid;
	}
	public void setFailid(Long failid) {
		this.failid = failid;
	}
	public String getRcno() {
		return rcno;
	}

	public void setRcno(String rcno) {
		this.rcno = rcno;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public String getRcmonth() {
		return rcmonth;
	}

	public void setRcmonth(String rcmonth) {
		this.rcmonth = rcmonth;
	}

	public String getRcdate() {
		return rcdate;
	}

	public void setRcdate(String rcdate) {
		this.rcdate = rcdate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOssrc() {
		return ossrc;
	}

	public void setOssrc(String ossrc) {
		this.ossrc = ossrc;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getEmpattr2() {
		return empattr2;
	}

	public void setEmpattr2(String empattr2) {
		this.empattr2 = empattr2;
	}	
}
