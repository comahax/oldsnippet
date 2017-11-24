package com.gmcc.pboss.biz.info.reward.payment.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class PaymentConfigQueryParameter extends QueryParameter {
	private String key;

	private String value;

	public PaymentConfigQueryParameter() {
		super();
		setAction(QueryAction.ALL);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
