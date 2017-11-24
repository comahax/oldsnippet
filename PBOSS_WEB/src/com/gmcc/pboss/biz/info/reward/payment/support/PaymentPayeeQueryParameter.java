package com.gmcc.pboss.biz.info.reward.payment.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class PaymentPayeeQueryParameter extends QueryParameter {
	private String cityid;

	private String payee;

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public PaymentPayeeQueryParameter() {
		super();
		setAction(QueryAction.ALL);
	}
}
