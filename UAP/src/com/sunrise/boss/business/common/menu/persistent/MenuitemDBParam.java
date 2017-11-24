package com.sunrise.boss.business.common.menu.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class MenuitemDBParam extends DBQueryParam {
	
	private String _ne_region;
	
	private String _se_guiobject;
	
	private String _ne_status;

	public String get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}

	public String get_se_guiobject() {
		return _se_guiobject;
	}

	public void set_se_guiobject(String _se_guiobject) {
		this._se_guiobject = _se_guiobject;
	}

	public String get_ne_status() {
		return _ne_status;
	}

	public void set_ne_status(String _ne_status) {
		this._ne_status = _ne_status;
	}

}
