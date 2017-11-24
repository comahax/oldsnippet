package com.gmcc.pboss.model.reward.unvrcfailday;

import java.util.Date;

/**
 * ChBbcUnvrcfailday entity. @author MyEclipse Persistence Tools
 */
public class ChBbcUnvrcfailday implements java.io.Serializable {

	// Fields

	private Long failid;
	private String rcno;
	private String mobileno;
	private String opnid;
	private String rcmonth;
	private Date rcdate;
	private String reason;
	private Byte ossrc;
	private String wayid;
	private String src;
	public ChBbcUnvrcfailday() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChBbcUnvrcfailday(Long failid, String rcno, String mobileno,
			String opnid, String rcmonth, Date rcdate, String reason,
			Byte ossrc, String wayid, String src) {
		super();
		this.failid = failid;
		this.rcno = rcno;
		this.mobileno = mobileno;
		this.opnid = opnid;
		this.rcmonth = rcmonth;
		this.rcdate = rcdate;
		this.reason = reason;
		this.ossrc = ossrc;
		this.wayid = wayid;
		this.src = src;
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
	public String getRcmonth() {
		return rcmonth;
	}
	public void setRcmonth(String rcmonth) {
		this.rcmonth = rcmonth;
	}
	public Date getRcdate() {
		return rcdate;
	}
	public void setRcdate(Date rcdate) {
		this.rcdate = rcdate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Byte getOssrc() {
		return ossrc;
	}
	public void setOssrc(Byte ossrc) {
		this.ossrc = ossrc;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}
