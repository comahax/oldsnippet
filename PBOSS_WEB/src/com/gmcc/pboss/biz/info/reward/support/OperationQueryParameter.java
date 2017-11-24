package com.gmcc.pboss.biz.info.reward.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class OperationQueryParameter extends QueryParameter {

	public OperationQueryParameter() {
		setAction(QueryAction.ALL);// ≤ª∑÷“≥
	}

	private String query;

	private int limit = 10;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
