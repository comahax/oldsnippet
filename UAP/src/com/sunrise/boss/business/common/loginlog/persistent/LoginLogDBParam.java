package com.sunrise.boss.business.common.loginlog.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class LoginLogDBParam extends DBQueryParam {
	
	String _se_staffid;
	
	String _ne_result;
	// add by 2014-1-14
	String _ne_logid;
	

	public String get_se_staffid() {
		return _se_staffid;
	}

	public void set_se_staffid(String _se_staffid) {
		this._se_staffid = _se_staffid;
	}

	public String get_ne_result() {
		return _ne_result;
	}

	public void set_ne_result(String _ne_result) {
		this._ne_result = _ne_result;
	}

	public String get_ne_logid() {
		return _ne_logid;
	}

	public void set_ne_logid(String _ne_logid) {
		this._ne_logid = _ne_logid;
	}
	
	
}
