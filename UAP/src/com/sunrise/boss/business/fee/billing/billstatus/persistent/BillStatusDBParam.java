package com.sunrise.boss.business.fee.billing.billstatus.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;



/**
 * 
 * @author ryan 2013-10-22
 *
 */
public class BillStatusDBParam extends DBQueryParam {
	
	private String _se_phase;
	
	private String _ne_subphase;
	
	private String _ne_validbillcyc;
	
	private String[] citygroup; //市标识组
	
	private String regiongroup;

	
	 
	/* 新增地市字段，对应VO */
	private String _ne_region;

	public String get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}
	
	public String getRegiongroup() {
		return regiongroup;
	}

	public void setRegiongroup(String regiongroup) {
		this.regiongroup = regiongroup;
	}

	public String[] getCitygroup() {
		return citygroup;
	}

	public void setCitygroup(String[] citygroup) {
		this.citygroup = citygroup;
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

	public String get_ne_subphase() {
		return _ne_subphase;
	}

	public void set_ne_subphase(String _ne_subphase) {
		this._ne_subphase = _ne_subphase;
	}

}
