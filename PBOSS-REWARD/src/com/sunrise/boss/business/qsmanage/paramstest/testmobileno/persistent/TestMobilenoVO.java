package com.sunrise.boss.business.qsmanage.paramstest.testmobileno.persistent;

import java.io.Serializable;

public class TestMobilenoVO implements Serializable {
	private String mobileno;
	private Integer state;
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
