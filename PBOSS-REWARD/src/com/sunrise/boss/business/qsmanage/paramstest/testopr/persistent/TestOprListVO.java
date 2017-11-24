package com.sunrise.boss.business.qsmanage.paramstest.testopr.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class TestOprListVO extends BaseListVO{
	private String _se_oprcode;
	private String _ne_state;
	public String get_ne_state() {
		return _ne_state;
	}
	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}
	public String get_se_oprcode() {
		return _se_oprcode;
	}
	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}
	
}
