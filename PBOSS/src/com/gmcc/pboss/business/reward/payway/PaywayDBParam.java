package com.gmcc.pboss.business.reward.payway;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: PaywayDBParam
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
 * @author caiwr
 * @version 1.0
 */
public class PaywayDBParam extends DBQueryParam {
	private String _sk_payee;
	private String _se_payee;
	private String _se_cityid;
	private String _se_wayid;

	private String _ne_seq;

	private List _sin_cityid;

	public String get_sk_payee() {
		return _sk_payee;
	}

	public void set_sk_payee(String _sk_payee) {
		this._sk_payee = _sk_payee;
	}

	public String get_se_payee() {
		return _se_payee;
	}

	public void set_se_payee(String _se_payee) {
		this._se_payee = _se_payee;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_ne_seq() {
		return _ne_seq;
	}

	public void set_ne_seq(String _ne_seq) {
		this._ne_seq = _ne_seq;
	}

	public List get_sin_cityid() {
		return _sin_cityid;
	}

	public void set_sin_cityid(List sinCityid) {
		_sin_cityid = sinCityid;
	}

}
