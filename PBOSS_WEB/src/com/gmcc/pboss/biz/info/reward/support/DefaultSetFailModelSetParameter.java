package com.gmcc.pboss.biz.info.reward.support;

public abstract class DefaultSetFailModelSetParameter implements FailModelSetParameter {

	private String rewardtypeName;
	private String opnname;
	private String remark;

	public String getRewardtypeName() {
		return rewardtypeName;
	}

	public void setRewardtypeName(String rewardtypeName) {
		this.rewardtypeName = rewardtypeName;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
