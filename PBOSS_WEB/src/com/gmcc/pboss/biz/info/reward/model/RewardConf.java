package com.gmcc.pboss.biz.info.reward.model;

import java.util.Date;

/**
 * ChCbRewardconf entity. @author MyEclipse Persistence Tools
 */

public class RewardConf implements java.io.Serializable {

	// Fields

	private String rewardmonth;
	private String cityid;
	private String rewardkind;
	private Short state;
	private String oprcode;
	private Date oprtime;

	// Property accessors

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getRewardkind() {
		return rewardkind;
	}

	public void setRewardkind(String rewardkind) {
		this.rewardkind = rewardkind;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		RewardConf rc = (RewardConf)obj;
		if(rc.cityid.equals(this.cityid) &&
		   rc.rewardmonth.equals(this.rewardmonth) &&
		   rc.rewardkind.equals(this.rewardkind))
		{
			return true;
		}
		return false;
		
//		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}