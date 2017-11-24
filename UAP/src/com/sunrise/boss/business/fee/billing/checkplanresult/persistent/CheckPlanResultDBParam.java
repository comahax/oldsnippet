package com.sunrise.boss.business.fee.billing.checkplanresult.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class CheckPlanResultDBParam extends DBQueryParam {

	private String _ne_logid;

	private String startindex;
	private String endindex;
	
	public String get_ne_logid() {
		return _ne_logid;
	}

	public void set_ne_logid(String _ne_logid) {
		this._ne_logid = _ne_logid;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}	
	
}
