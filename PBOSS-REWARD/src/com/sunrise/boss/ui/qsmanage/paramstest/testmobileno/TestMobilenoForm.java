package com.sunrise.boss.ui.qsmanage.paramstest.testmobileno;

import com.sunrise.boss.ui.base.BaseActionForm;

public class TestMobilenoForm extends BaseActionForm{
	private String _se_mobileno;
	private String _ne_state;
	
	private String mobileno;
	private Integer state;
	public String get_ne_state() {
		return _ne_state;
	}
	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}
	public String get_se_mobileno() {
		return _se_mobileno;
	}
	public void set_se_mobileno(String _se_mobileno) {
		this._se_mobileno = _se_mobileno;
	}
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
