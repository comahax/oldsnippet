package com.gmcc.pboss.biz.info.rewardcard.support;

import java.io.Serializable;
import java.util.Date;

public class CardrewdetDetail implements Serializable {
	private String wayid;
	private String wayname;
	private String mobile;
	private String activetime;
	private String rechargenum;
	private String rechargetime;
	private String rewardnum;
	private String cmonth;
	
	public CardrewdetDetail(){
		
	}

	public CardrewdetDetail(String wayid, String wayname, String mobile,
			String activetime, String rechargenum, String rechargetime,
			String rewardnum, String cmonth) {
		this.wayid = wayid;
		this.wayname = wayname;
		this.mobile = mobile;
		this.activetime = activetime;
		this.rechargenum = rechargenum;
		this.rechargetime = rechargetime;
		this.rewardnum = rewardnum;
		this.cmonth = cmonth;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getActivetime() {
		return activetime;
	}

	public void setActivetime(String activetime) {
		this.activetime = activetime;
	}

	public String getRechargenum() {
		return rechargenum;
	}

	public void setRechargenum(String rechargenum) {
		this.rechargenum = rechargenum;
	}

	public String getRechargetime() {
		return rechargetime;
	}

	public void setRechargetime(String rechargetime) {
		this.rechargetime = rechargetime;
	}

	public String getRewardnum() {
		return rewardnum;
	}

	public void setRewardnum(String rewardnum) {
		this.rewardnum = rewardnum;
	}

	public String getCmonth() {
		return cmonth;
	}

	public void setCmonth(String cmonth) {
		this.cmonth = cmonth;
	}	
}
