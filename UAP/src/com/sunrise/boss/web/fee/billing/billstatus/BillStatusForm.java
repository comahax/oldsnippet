package com.sunrise.boss.web.fee.billing.billstatus;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusVO;

public class BillStatusForm extends BillStatusVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _ne_validbillcyc;
	
	private String regiongroup;

	private String[] citygroup; 
	
	private String phase;
	
	private String regiongroup_text;

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}

	public String[] getCitygroup() {
		return citygroup;
	}

	public void setCitygroup(String[] citygroup) {
		this.citygroup = citygroup;
	}	

	public String getRegiongroup() {
		return regiongroup;
	}

	public void setRegiongroup(String regiongroup) {
		this.regiongroup = regiongroup;
		this.citygroup = StringUtils.split(regiongroup, ",");
	}

	public String getRegiongroup_text() {
		return regiongroup_text;
	}

	public void setRegiongroup_text(String regiongroup_text) {
		this.regiongroup_text = regiongroup_text;
	}

	
}
