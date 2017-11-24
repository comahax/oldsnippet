package com.gmcc.pboss.biz.info.reward.cityrecord.support;

import java.io.Serializable;

public class CityrecordInfo implements Serializable {
	private String wayid;
	private String wayname;
	private String opnid;
	private String opnname;
	private short rewardtype;
	private String rewardtypename;
	private String mobile;
	private String rewardmonth;
	private String oprtime;
	private double busivalue;
	private double paymoney;
	public CityrecordInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityrecordInfo(String wayid, String wayname, String opnid,
			String opnname, short rewardtype, String rewardtypename,
			String mobile, String rewardmonth, String oprtime,
			double busivalue, double paymoney) {
		super();
		this.wayid = wayid;
		this.wayname = wayname;
		this.opnid = opnid;
		this.opnname = opnname;
		this.rewardtype = rewardtype;
		this.rewardtypename = rewardtypename;
		this.mobile = mobile;
		this.rewardmonth = rewardmonth;
		this.oprtime = oprtime;
		this.busivalue = busivalue;
		this.paymoney = paymoney;
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
	public short getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(short rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getRewardtypename() {
		return rewardtypename;
	}
	public void setRewardtypename(String rewardtypename) {
		this.rewardtypename = rewardtypename;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRewardmonth() {
		return rewardmonth;
	}
	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}
	public String getOprtime() {
		return oprtime;
	}
	public void setOprtime(String oprtime) {
		this.oprtime = oprtime;
	}
	public double getBusivalue() {
		return busivalue;
	}
	public void setBusivalue(double busivalue) {
		this.busivalue = busivalue;
	}
	public double getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(double paymoney) {
		this.paymoney = paymoney;
	}
}
