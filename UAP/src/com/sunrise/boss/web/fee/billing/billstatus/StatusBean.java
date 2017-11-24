package com.sunrise.boss.web.fee.billing.billstatus;

public class StatusBean {
	
	private Short subphase;
	
	private String stepname;
	
	private Short status;

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getStepname() {
		return stepname;
	}

	public void setStepname(String stepname) {
		this.stepname = stepname;
	}

	public Short getSubphase() {
		return subphase;
	}

	public void setSubphase(Short subphase) {
		this.subphase = subphase;
	}
}
