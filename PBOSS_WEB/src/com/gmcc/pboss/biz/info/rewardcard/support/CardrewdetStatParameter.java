package com.gmcc.pboss.biz.info.rewardcard.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

public class CardrewdetStatParameter extends QueryParameter {
	private String wayid;
	private Date activeFrom;
	private Date activeTo;
	private Date rechargeFrom;
	private Date rechargeTo;
	
	
	public CardrewdetStatParameter(){
	}
	
	public CardrewdetStatParameter(String wayid, Date activeFrom,
			Date activeTo, Date rechargeFrom, Date rechargeTo) {
		super();
		this.wayid = wayid;
		this.activeFrom = activeFrom;
		this.activeTo = activeTo;
		this.rechargeFrom = rechargeFrom;
		this.rechargeTo = rechargeTo;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
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
	
}
