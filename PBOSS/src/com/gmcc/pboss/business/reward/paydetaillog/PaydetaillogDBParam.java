package com.gmcc.pboss.business.reward.paydetaillog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class PaydetaillogDBParam extends DBQueryParam{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4876215082856069204L;

	private String _se_calcmonth;
	
	private String _sk_mobile;
	
	private String _se_oprcode;
	
	private String _ne_logid;
	
	private String _se_success;
	
	private String _se_type;
	
	private String _se_wayid;
	
	private String _se_opmonth;

	public String get_se_calcmonth() {
		return _se_calcmonth;
	}

	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}

	public String get_sk_mobile() {
		return _sk_mobile;
	}

	public void set_sk_mobile(String _sk_mobile) {
		this._sk_mobile = _sk_mobile;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_ne_logid() {
		return _ne_logid;
	}

	public void set_ne_logid(String _ne_logid) {
		this._ne_logid = _ne_logid;
	}

	public String get_se_success() {
		return _se_success;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public String get_se_type() {
		return _se_type;
	}

	public void set_se_type(String _se_type) {
		this._se_type = _se_type;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_opmonth() {
		return _se_opmonth;
	}

	public void set_se_opmonth(String _se_opmonth) {
		this._se_opmonth = _se_opmonth;
	}
	
	
}
