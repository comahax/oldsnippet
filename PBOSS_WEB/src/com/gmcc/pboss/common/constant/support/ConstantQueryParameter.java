package com.gmcc.pboss.common.constant.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class ConstantQueryParameter extends QueryParameter {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public ConstantQueryParameter() {
		setAction(QueryAction.ALL);// ≤ª∑÷“≥
	}

	private String[] groupid;

	/**
	 * @return the groupid
	 */
	public String[] getGroupid() {
		return groupid;
	}

	/**
	 * @param groupid the groupid to set
	 */
	public void setGroupid(String[] groupid) {
		this.groupid = groupid;
	}

	

}
