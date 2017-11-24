package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class MonthRemunerationQueryParameter extends QueryParameter {
	
	private String rwmon;   //结算月份
	
	private String wayid;//渠道编码

	public String getRwmon() {
		return rwmon;
	}

	public void setRwmon(String rwmon) {
		this.rwmon = rwmon;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	} 
	
}
