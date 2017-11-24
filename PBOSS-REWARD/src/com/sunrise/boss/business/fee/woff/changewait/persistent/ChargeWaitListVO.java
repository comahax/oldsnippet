package com.sunrise.boss.business.fee.woff.changewait.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class ChargeWaitListVO extends BaseListVO{
	
	private String _ne_eboxid;
	private String _ne_billcyc;
	private String _ne_source;
	private String _ne_chargetype;
	private String _ne_iscredit;
	
	
	public String get_ne_iscredit() {
		return _ne_iscredit;
	}
	public void set_ne_iscredit(String _ne_iscredit) {
		this._ne_iscredit = _ne_iscredit;
	}
	public String get_ne_billcyc() {
		return _ne_billcyc;
	}
	public void set_ne_billcyc(String _ne_billcyc) {
		this._ne_billcyc = _ne_billcyc;
	}
	public String get_ne_eboxid() {
		return _ne_eboxid;
	}
	public void set_ne_eboxid(String _ne_eboxid) {
		this._ne_eboxid = _ne_eboxid;
	}
	public String get_ne_source() {
		return _ne_source;
	}
	public void set_ne_source(String _ne_source) {
		this._ne_source = _ne_source;
	}
	public String get_ne_chargetype() {
		return _ne_chargetype;
	}
	public void set_ne_chargetype(String _ne_chargetype) {
		this._ne_chargetype = _ne_chargetype;
	}
	


}
