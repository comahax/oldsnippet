package com.gmcc.pboss.biz.info.reward.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class RewardFailQueryParameter extends QueryParameter {

	private String wayid;

	private String type;

	private byte flag = -1;//状态位直接加在条件中，暂不使用此字段

	private String opnid;

	private String month;

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
