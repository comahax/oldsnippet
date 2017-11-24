package com.sunrise.boss.business.qsmanage.paramstest.testmobileno.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class TestMobilenoListVO extends BaseListVO{
	private String _ne_state;
	private String _se_mobileno;
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
}
