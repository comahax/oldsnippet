package com.gmcc.pboss.biz.info.reward.payment.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class PaymentWayQueryParameter extends QueryParameter {
	private String cityid;

	private String wayid;

	private String wayname;

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public PaymentWayQueryParameter() {
		super();
		setAction(QueryAction.ALL);
	}

}
