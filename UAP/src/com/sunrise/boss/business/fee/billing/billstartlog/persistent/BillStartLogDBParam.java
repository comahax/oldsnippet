/**
 * 
 */
package com.sunrise.boss.business.fee.billing.billstartlog.persistent;


import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * Title: CompanyDelegate
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: sunrise Tech Ltd.
 * @author mys
 * @version 1.0
 */
public class BillStartLogDBParam extends DBQueryParam {
	
	private String _ne_validbillcyc;

	private String _se_batchnum;

	private String _se_startstep;
	
	private String _ne_ruleid;
	
	private String _ne_region;

	public String get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}

	
	public String get_ne_ruleid() {
		return _ne_ruleid;
	}

	public void set_ne_ruleid(String _ne_ruleid) {
		this._ne_ruleid = _ne_ruleid;
	}

	public String get_se_startstep() {
		return _se_startstep;
	}

	public void set_se_startstep(String _se_startstep) {
		this._se_startstep = _se_startstep;
	}

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}

	public String get_se_batchnum() {
		return _se_batchnum;
	}

	public void set_se_batchnum(String _se_batchnum) {
		this._se_batchnum = _se_batchnum;
	}

}
