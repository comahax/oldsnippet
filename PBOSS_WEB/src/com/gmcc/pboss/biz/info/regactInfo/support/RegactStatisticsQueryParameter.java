package com.gmcc.pboss.biz.info.regactInfo.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RegactStatisticsQueryParameter extends QueryParameter {

	public RegactStatisticsQueryParameter() {
		setAction(QueryAction.ALL);// ≤ª∑÷“≥
	}

	private String wayid;

	private String month;

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
