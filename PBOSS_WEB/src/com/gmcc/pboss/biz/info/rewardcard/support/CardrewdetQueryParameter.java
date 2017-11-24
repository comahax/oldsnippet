package com.gmcc.pboss.biz.info.rewardcard.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class CardrewdetQueryParameter extends QueryParameter {
	private String wayid;
	private String mobile;
	private Date activeFrom;
	private Date activeTo;
	private Date rechargeFrom;
	private Date rechargeTo;
	private String waymagcode;//渠道经理在人员表中对应的ID
	
	public CardrewdetQueryParameter() {
		this.wayid = null;
		this.mobile = null;
		this.activeFrom = null;
		this.activeTo = null;
		this.rechargeFrom = null;
		this.rechargeTo = null;
		this.waymagcode = null;
	}
	public CardrewdetQueryParameter(String wayid, String mobile,
			Date activeFrom, Date activeTo, Date rechargeFrom, Date rechargeTo,String waymagcode) {
		super();
		this.wayid = wayid;
		this.mobile = mobile;
		this.activeFrom = activeFrom;
		this.activeTo = activeTo;
		this.rechargeFrom = rechargeFrom;
		this.rechargeTo = rechargeTo;
		this.waymagcode = waymagcode;
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
	public Date getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}
	public Date getActiveTo() {
		return activeTo;
	}
	public void setActiveTo(Date activeTo) {
		this.activeTo = activeTo;
	}
	public Date getRechargeFrom() {
		return rechargeFrom;
	}
	public void setRechargeFrom(Date rechargeFrom) {
		this.rechargeFrom = rechargeFrom;
	}
	public Date getRechargeTo() {
		return rechargeTo;
	}
	public void setRechargeTo(Date rechargeTo) {
		this.rechargeTo = rechargeTo;
	}
	public String getWaymagcode() {
		return waymagcode;
	}
	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}
	
}
