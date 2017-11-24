package com.sunrise.boss.business.qsmanage.paramstest.testopr.persistent;

import java.io.Serializable;

public class TestOprVO implements Serializable{
	private String oprcode;
	private Integer state;
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
