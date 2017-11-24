package com.gmcc.pboss.business.reward.setcard;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: PaymentDBParam
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public class SetcardDBParam extends DBQueryParam {
	
	private static final long serialVersionUID = 8745570731331373034L;
	
	private String _ne_seq;
	private String _se_wayid;
	private String _se_mobile;
	private String _sk_filename;

	private String _se_waytype;
	private String _se_actvday;
	private String _dnm_intime;
	private String _dnl_intime;

	public String get_ne_seq() {
		return _ne_seq;
	}

	public void set_ne_seq(String neSeq) {
		_ne_seq = neSeq;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_sk_filename() {
		return _sk_filename;
	}

	public void set_sk_filename(String _sk_filename) {
		this._sk_filename = _sk_filename;
	}

	public String get_se_waytype() {
		return _se_waytype;
	}

	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}

	public String get_se_actvday() {
		return _se_actvday;
	}

	public void set_se_actvday(String _se_actvday) {
		this._se_actvday = _se_actvday;
	}

	public String get_dnm_intime() {
		return _dnm_intime;
	}

	public void set_dnm_intime(String _dnm_intime) {
		this._dnm_intime = _dnm_intime;
	}

	public String get_dnl_intime() {
		return _dnl_intime;
	}

	public void set_dnl_intime(String _dnl_intime) {
		this._dnl_intime = _dnl_intime;
	}
}
