package com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class RewardBusinessQueryParameter extends QueryParameter {
	
	private String oprmon;   //�����·�
	
	private String wayid;//��������

	public String getOprmon() {
		return oprmon;
	}

	public void setOprmon(String oprmon) {
		this.oprmon = oprmon;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	} 
	
}
