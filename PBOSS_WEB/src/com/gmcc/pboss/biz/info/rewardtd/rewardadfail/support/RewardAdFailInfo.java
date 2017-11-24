package com.gmcc.pboss.biz.info.rewardtd.rewardadfail.support;

import java.util.Date;

public class RewardAdFailInfo {
	private String name;
	private String rewardtype;
	private String comname;
	private String bakinfo;
	private String mobile;
	private String oprtime;
	private String rewardmonth;
	private short acctype;
	private double rewardstd;
	private double paysum;
	private double assegrade;
	private double wrapfee;
	private double assegrade2; 
	private short noncyc;
	private String bakinfo7;
	private String bakinfo8;
	private String failreason;

	public RewardAdFailInfo() {
		super();
	}

	public RewardAdFailInfo(String name, String rewardtype, String comname,
			String bakinfo, String mobile, String oprtime, String rewardmonth,
			short acctype, double rewardstd, double paysum, double assegrade,
			double wrapfee, double assegrade2,  short noncyc,
			String bakinfo7, String bakinfo8, String  failreason) {
		this.name = name;
		this.rewardtype = rewardtype;
		this.comname = comname;
		this.bakinfo = bakinfo;
		this.mobile = mobile;
		this.oprtime = oprtime;
		this.rewardmonth = rewardmonth;
		this.acctype = acctype;
		this.rewardstd = rewardstd;
		this.paysum = paysum;
		this.assegrade = assegrade;
		this.wrapfee = wrapfee; 
		this.noncyc = noncyc;
		this.bakinfo7 = bakinfo7;
		this.bakinfo8 = bakinfo8;
		this.failreason = failreason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getBakinfo() {
		return bakinfo;
	}

	public void setBakinfo(String bakinfo) {
		this.bakinfo = bakinfo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOprtime() {
		return oprtime;
	}

	public void setOprtime(String oprtime) {
		this.oprtime = oprtime;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public short getAcctype() {
		return acctype;
	}

	public void setAcctype(short acctype) {
		this.acctype = acctype;
	} 
	public double getPaysum() {
		return paysum;
	}

	public void setPaysum(double paysum) {
		this.paysum = paysum;
	}

	public void setAssegrade2(short assegrade2) {
		this.assegrade2 = assegrade2;
	} 

	public short getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(short noncyc) {
		this.noncyc = noncyc;
	}

	public String getBakinfo7() {
		return bakinfo7;
	}

	public void setBakinfo7(String bakinfo7) {
		this.bakinfo7 = bakinfo7;
	}

	public String getBakinfo8() {
		return bakinfo8;
	}

	public void setBakinfo8(String bakinfo8) {
		this.bakinfo8 = bakinfo8;
	}

	public String getFailreason() {
		return failreason;
	}

	public void setFailreason(String failreason) {
		this.failreason = failreason;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}  
	public void setRewardstd(double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public double getRewardstd() {
		return rewardstd;
	}

	public double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(double wrapfee) {
		this.wrapfee = wrapfee;
	}

	public double getAssegrade() {
		return assegrade;
	}

	public void setAssegrade(double assegrade) {
		this.assegrade = assegrade;
	}

	public double getAssegrade2() {
		return assegrade2;
	}

	public void setAssegrade2(double assegrade2) {
		this.assegrade2 = assegrade2;
	}
}
