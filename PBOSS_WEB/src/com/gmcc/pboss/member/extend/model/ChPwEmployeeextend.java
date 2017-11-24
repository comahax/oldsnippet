package com.gmcc.pboss.member.extend.model;

import java.io.Serializable;

import com.gmcc.pboss.common.bean.BaseModel;

public class ChPwEmployeeextend extends BaseModel implements Serializable {

	// Fields

	private String employeeId;
	private String password;
	
	/** default constructor */
	public ChPwEmployeeextend() {
	}

	/** minimal constructor */
	public ChPwEmployeeextend(String employeeId) {
		this.employeeId = employeeId;
	}

	/** full constructor */
	public ChPwEmployeeextend(String employeeId, String password) {
		this.employeeId=employeeId;
		this.password=password;
	}
	
	// Property accessors

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
