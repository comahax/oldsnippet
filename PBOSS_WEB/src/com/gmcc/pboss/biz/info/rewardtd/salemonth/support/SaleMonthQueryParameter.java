package com.gmcc.pboss.biz.info.rewardtd.salemonth.support;

import com.gmcc.pboss.common.support.QueryParameter;

public class SaleMonthQueryParameter extends QueryParameter {
	
	private String rwmon;   //结算月份
	private String oprmon;//销售月份
	private String wayid;//渠道编码

	private String maxcount;//月份数量N
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

	public String getMaxcount() {
		return maxcount;
	}

	public void setMaxcount(String maxcount) {
		this.maxcount = maxcount;
	}

	public String getOprmon() {
		return oprmon;
	}

	public void setOprmon(String oprmon) {
		this.oprmon = oprmon;
	} 
	
}
