package com.sunrise.boss.business.fee.billing.billstatus.persistent;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.ManageLog;


public class BillStatusVO extends BaseVO  implements ManageLog{

	private String phase;
	
	private Short subphase;
	
	private String phasename;
	
	private Long validbillcyc;
	
	private Short state;
	
	private Date starttime;
	
	private Date endtime;
	
	

	/* 新增地市字段，对应VO */
	private Integer region;

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPhasename() {
		return phasename;
	}

	public void setPhasename(String phasename) {
		this.phasename = phasename;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Short getSubphase() {
		return subphase;
	}

	public void setSubphase(Short subphase) {
		this.subphase = subphase;
	}

	public Long getValidbillcyc() {
		return validbillcyc;
	}

	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}


}