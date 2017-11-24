package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.service.impl;

import java.io.Serializable;

public class RealtimefailInfo implements Serializable {
	//s.seq,s.oprcode,s.wayid,s.mobile,o.name,s.opnid,to_char(s.oprtime,'yyyy-MM-dd')
	private Long seq;
	private String oprcode;
	private String wayid;
	private String mobile;
	private String opnname;
	private String opnid;
	private String oprtime;
	public RealtimefailInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RealtimefailInfo(Long seq, String oprcode, String wayid,
			String mobile, String opnname, String opnid, String oprtime) {
		super();
		this.seq = seq;
		this.oprcode = oprcode;
		this.wayid = wayid;
		this.mobile = mobile;
		this.opnname = opnname;
		this.opnid = opnid;
		this.oprtime = oprtime;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOpnname() {
		return opnname;
	}
	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getOprtime() {
		return oprtime;
	}
	public void setOprtime(String oprtime) {
		this.oprtime = oprtime;
	}
}
