package com.sunrise.boss.ui.qsmanage.paramstest.testopr;

import com.sunrise.boss.ui.base.BaseActionForm;

public class TestOprForm extends BaseActionForm{
	private String _ne_state;
	private String _se_oprcode;
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
	public String get_se_oprcode() {
		return _se_oprcode;
	}
	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}
	public String get_ne_state() {
		return _ne_state;
	}
	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}
}
