package com.sunrise.boss.ui.cms.reward.taskstate;

public class StatusBean {
	
	private Long subphase;
	
	private String stepname;
	
	private Short status;
	
	private Short mainState;

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

	public Long getSubphase() {
		return subphase;
	}

	public void setSubphase(Long subphase) {
		this.subphase = subphase;
	}

	public Short getMainState() {
		return mainState;
	}

	public void setMainState(Short mainState) {
		this.mainState = mainState;
	}


}
