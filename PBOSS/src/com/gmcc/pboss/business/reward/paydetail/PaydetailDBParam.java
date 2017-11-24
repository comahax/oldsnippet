package com.gmcc.pboss.business.reward.paydetail;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class PaydetailDBParam extends DBQueryParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5764848618753530379L;

	private String _ne_seq;
	
	private String _se_wayid;
	
	private String _sk_mobile;
	
	private String _se_mobile;
	
	private String _se_opmonth;
	
	private String _se_calcmonth;
	
	private String _se_type;

	public String get_ne_seq() {
		return _ne_seq;
	}

	public void set_ne_seq(String _ne_seq) {
		this._ne_seq = _ne_seq;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sk_mobile() {
		return _sk_mobile;
	}

	public void set_sk_mobile(String _sk_mobile) {
		this._sk_mobile = _sk_mobile;
	}

	public String get_se_opmonth() {
		return _se_opmonth;
	}

	public void set_se_opmonth(String _se_opmonth) {
		this._se_opmonth = _se_opmonth;
	}

	public String get_se_calcmonth() {
		return _se_calcmonth;
	}

	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}

	public String get_se_type() {
		return _se_type;
	}

	public void set_se_type(String _se_type) {
		this._se_type = _se_type;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}
	
	
}
