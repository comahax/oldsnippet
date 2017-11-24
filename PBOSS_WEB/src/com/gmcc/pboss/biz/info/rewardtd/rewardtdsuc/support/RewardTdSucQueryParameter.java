package com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class RewardTdSucQueryParameter extends QueryParameter {

	private String rewardtype;    //�������
	private String rewardmonth;   //�����·�
	private String wayid; 
	private String repairmonth;  //�����·�
	private String city;  //����
	
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
