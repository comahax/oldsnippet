package com.sunrise.boss.business.fee.billing.billresult.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * 
 * @author ryan 2013-10-16
 *
 */
public class BillResultDBParam extends DBQueryParam {
	
	private String _se_phase;
	
	private String _ne_subphase;
	
	private String _ne_validbillcyc;	 
	 
	private String _ne_region;

	public String get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}
	

	public String get_ne_subphase() {
		return _ne_subphase;
	}

	public void set_ne_subphase(String _ne_subphase) {
		this._ne_subphase = _ne_subphase;
	}

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}

	public String get_se_phase() {
		return _se_phase;
	}

	public void set_se_phase(String _se_phase) {
		this._se_phase = _se_phase;
	}
	

}
