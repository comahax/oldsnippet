package com.asisinfo.staff.querybean;

import com.asisinfo.staff.bean.EmployeesNumber;

public class EmployeeQueryBean extends EmployeesNumber{
	private Integer page = 0;
	private Integer rows = 10;
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
