package com.gmcc.pboss.biz.info.rewardtd.settlementmonth.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class SettlementMonthQueryParameter extends QueryParameter {
	
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
