package com.gmcc.pboss.biz.info.reward.cityrecord.support;

import java.io.Serializable;

public class OpnbusiInfo implements Serializable {
	private String opnid1;
	private String opn1name;
	private int opn1count;
	private String opnid2;
	private String opn2name;
	private int opn2count;
	private String rewardtype;
	private String rewardname;
	private int rewardcount;
	private String oprmonth;
	private double busitotal;
	private double paytotal;
	public OpnbusiInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpnbusiInfo(String opnid1, String opn1name, int opn1count,
			String opnid2, String opn2name, int opn2count, String rewardtype,
			String rewardname, int rewardcount, String oprmonth,
			double busitotal, double paytotal) {
		super();
		this.opnid1 = opnid1;
		this.opn1name = opn1name;
		this.opn1count = opn1count;
		this.opnid2 = opnid2;
		this.opn2name = opn2name;
		this.opn2count = opn2count;
		this.rewardtype = rewardtype;
		this.rewardname = rewardname;
		this.rewardcount = rewardcount;
		this.oprmonth = oprmonth;
		this.busitotal = busitotal;
		this.paytotal = paytotal;
	}
	public String getOpnid1() {
		return opnid1;
	}
	public void setOpnid1(String opnid1) {
		this.opnid1 = opnid1;
	}
	public String getOpn1name() {
		return opn1name;
	}
	public void setOpn1name(String opn1name) {
		this.opn1name = opn1name;
	}
	public int getOpn1count() {
		return opn1count;
	}
	public void setOpn1count(int opn1count) {
		this.opn1count = opn1count;
	}
	public String getOpnid2() {
		return opnid2;
	}
	public void setOpnid2(String opnid2) {
		this.opnid2 = opnid2;
	}
	public String getOpn2name() {
		return opn2name;
	}
	public void setOpn2name(String opn2name) {
		this.opn2name = opn2name;
	}
	public int getOpn2count() {
		return opn2count;
	}
	public void setOpn2count(int opn2count) {
		this.opn2count = opn2count;
	}
	public String getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getRewardname() {
		return rewardname;
	}
	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}
	public int getRewardcount() {
		return rewardcount;
	}
	public void setRewardcount(int rewardcount) {
		this.rewardcount = rewardcount;
	}
	public String getOprmonth() {
		return oprmonth;
	}
	public void setOprmonth(String oprmonth) {
		this.oprmonth = oprmonth;
	}
	public double getBusitotal() {
		return busitotal;
	}
	public void setBusitotal(double busitotal) {
		this.busitotal = busitotal;
	}
	public double getPaytotal() {
		return paytotal;
	}
	public void setPaytotal(double paytotal) {
		this.paytotal = paytotal;
	}
}
