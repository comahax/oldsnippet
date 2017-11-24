package com.sunrise.boss.business.fee.billing.checkserv.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class CheckServDBParam extends DBQueryParam {

	private String _ne_logid;
	
	private String _se_servnumber;

	public String get_ne_logid() {
		return _ne_logid;
	}

	public void set_ne_logid(String _ne_logid) {
		this._ne_logid = _ne_logid;
	}

	public String get_se_servnumber() {
		return _se_servnumber;
	}

	public void set_se_servnumber(String _se_servnumber) {
		this._se_servnumber = _se_servnumber;
	}
	
	
}
