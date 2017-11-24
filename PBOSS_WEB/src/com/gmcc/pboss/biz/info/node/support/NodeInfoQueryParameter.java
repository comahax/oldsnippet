package com.gmcc.pboss.biz.info.node.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class NodeInfoQueryParameter extends QueryParameter {

	public NodeInfoQueryParameter() {
		setAction(QueryAction.ALL);
	}

	private String employeeId;
	
	private Object saveObj;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the saveObj
	 */
	public Object getSaveObj() {
		return saveObj;
	}

	/**
	 * @param saveObj the saveObj to set
	 */
	public void setSaveObj(Object saveObj) {
		this.saveObj = saveObj;
	}

}
