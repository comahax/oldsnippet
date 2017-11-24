package com.sunrise.boss.business.fee.billing.uapreq.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class UapRuDownloadDBParam extends DBQueryParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7861133444805543717L;

	private String _se_req_ruleId;

	public String get_se_req_ruleId() {
		return _se_req_ruleId;
	}

	public void set_se_req_ruleId(String _se_req_ruleId) {
		this._se_req_ruleId = _se_req_ruleId;
	}

}
