package com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support; 

import com.gmcc.pboss.common.support.QueryParameter;

public class RewardTdRecordQueryParameter extends QueryParameter {
 
 
	private String rewardtype;    //酬金类型
	private String rewardmonth;   //结算月份
	private String wayid; 
	 
	
	public RewardTdRecordQueryParameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}
	public String getRewardmonth() {
		return rewardmonth;
	}
	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
 
 
}
