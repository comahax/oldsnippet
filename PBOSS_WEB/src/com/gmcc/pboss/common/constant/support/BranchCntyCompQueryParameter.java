package com.gmcc.pboss.common.constant.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class BranchCntyCompQueryParameter extends QueryParameter {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public BranchCntyCompQueryParameter() {
		setAction(QueryAction.ALL);// ≤ª∑÷“≥
	}

	private String citycompid;

	/**
	 * @return the citycompid
	 */
	public String getCitycompid() {
		return citycompid;
	}

	/**
	 * @param citycompid the citycompid to set
	 */
	public void setCitycompid(String citycompid) {
		this.citycompid = citycompid;
	}

	

}
