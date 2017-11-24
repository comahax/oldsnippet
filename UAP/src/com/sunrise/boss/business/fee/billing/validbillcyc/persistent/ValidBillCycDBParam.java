package com.sunrise.boss.business.fee.billing.validbillcyc.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class ValidBillCycDBParam extends DBQueryParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5298800072932533023L;
	
	private String _ne_validbillcyc;

	private String _se_state;
	
	private String _ne_region;

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}

	public String get_se_state() {
		return _se_state;
	}

	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}

	public String get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}
	
}
