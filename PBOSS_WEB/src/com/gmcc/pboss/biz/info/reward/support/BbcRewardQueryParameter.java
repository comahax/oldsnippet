package com.gmcc.pboss.biz.info.reward.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class BbcRewardQueryParameter extends QueryParameter {

	// 渠道标识
	private String wayid;
	// 业务代码
	private String opnid;
	// 酬金类型--明细查询中一次选择多个种类
	private String rewardtype;
	// 结算月份 /发放月份yyyyMM
	private String month;
	
	// 是否汇总
	private boolean group = false;
	
	//网站酬金种类：B2M or UNPB(创新联盟)
	String rewardKind;
	public String getRewardKind() {
		return rewardKind;
	}
	public void setRewardKind(String rewardKind) {
		this.rewardKind = rewardKind;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public boolean isGroup() {
		return group;
	}
	public void setGroup(boolean group) {
		this.group = group;
	}
}
