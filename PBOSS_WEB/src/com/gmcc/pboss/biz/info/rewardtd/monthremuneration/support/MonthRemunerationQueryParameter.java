package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class MonthRemunerationQueryParameter extends QueryParameter {
	
	private String rwmon;   //�����·�
	
	private String wayid;//��������

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
