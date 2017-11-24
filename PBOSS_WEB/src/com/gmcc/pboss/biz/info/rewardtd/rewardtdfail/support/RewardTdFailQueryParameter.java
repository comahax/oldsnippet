package com.gmcc.pboss.biz.info.rewardtd.rewardtdfail.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class RewardTdFailQueryParameter extends QueryParameter {
	
	private String rewardtype;    //酬金类型
	private String rewardmonth;   //结算月份
	private String wayid; 
	private String repairmonth;  //上半月预发酬金
	private String city;  //上半月预发酬金
	
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
	public String getRepairmonth() {
		return repairmonth;
	}
	public void setRepairmonth(String repairmonth) {
		this.repairmonth = repairmonth;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	} 
	
}
