package com.sunrise.boss.business.fee.billing.uapreq.persistent;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class UapReqDBParam extends DBQueryParam {

	private String _se_req_type;
	
	private List _sin_req_type;
	
	private String _ne_state;
	
	private String _dnl_req_time;
	
	private String _dnm_req_time;
	
	private String _ne_validbillcyc;
	
	private String[] _selectitem2;

	public String get_se_req_type() {
		return _se_req_type;
	}

	public void set_se_req_type(String _se_req_type) {
		this._se_req_type = _se_req_type;
	}

	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}

	public String get_dnl_req_time() {
		return _dnl_req_time;
	}

	public void set_dnl_req_time(String _dnl_req_time) {
		this._dnl_req_time = _dnl_req_time;
	}

	public String get_dnm_req_time() {
		return _dnm_req_time;
	}

	public void set_dnm_req_time(String _dnm_req_time) {
		this._dnm_req_time = _dnm_req_time;
	}

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String neValidbillcyc) {
		_ne_validbillcyc = neValidbillcyc;
	}

	public List get_sin_req_type() {
		return _sin_req_type;
	}

	public void set_sin_req_type(List sinReqType) {
		_sin_req_type = sinReqType;
	}

	public String[] get_selectitem2() {
		return _selectitem2;
	}

	public void set_selectitem2(String[] selectitem2) {
		_selectitem2 = selectitem2;
	}

	

	

	
}
