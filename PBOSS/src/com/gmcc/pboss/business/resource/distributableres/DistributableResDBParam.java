package com.gmcc.pboss.business.resource.distributableres;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class DistributableResDBParam extends DBQueryParam {

	private String _se_countyid;

	private String _se_wayid;

	private String _se_brand;

	private String _se_comcategory;

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_brand() {
		return _se_brand;
	}

	public void set_se_brand(String _se_brand) {
		this._se_brand = _se_brand;
	}

	public String get_se_comcategory() {
		return _se_comcategory;
	}

	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}
	
	
}
