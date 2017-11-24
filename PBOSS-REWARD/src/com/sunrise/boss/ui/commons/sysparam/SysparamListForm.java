package com.sunrise.boss.ui.commons.sysparam;

import com.sunrise.boss.ui.base.BaseActionForm;

public class SysparamListForm extends BaseActionForm {
	private String _ne_systemid;
	private String _sl_paramvalue;
	public String get_ne_systemid() {
		return _ne_systemid;
	}
	public void set_ne_systemid(String _ne_systemid) {
		this._ne_systemid = _ne_systemid;
	}
	public String get_sl_paramvalue() {
		return _sl_paramvalue;
	}
	public void set_sl_paramvalue(String _sl_paramvalue) {
		this._sl_paramvalue = _sl_paramvalue;
	}
}
