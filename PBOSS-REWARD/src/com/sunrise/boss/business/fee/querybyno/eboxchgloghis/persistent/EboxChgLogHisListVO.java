/**
 * auto-generated code
 * Wed Aug 16 14:03:04 CST 2006
 */
package com.sunrise.boss.business.fee.querybyno.eboxchgloghis.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * Title: EboxChgLogListVO Description: Query Params Object for EboxChgLogDAO
 * Copyright: Copyright (c) 2006 Company: Maywide Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
public class EboxChgLogHisListVO extends BaseListVO {

	private String _ne_eboxid;

	private String _dnl_chgtime;

	private String _dnm_chgtime;

	private String _ne_eboxunitid;
	private String _sk_reason;
	private String _se_opercode;

  	private String startindex;
	private String endindex;
	
	
	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}

	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}

	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	}

	public String get_se_opercode() {
		return _se_opercode;
	}

	public void set_se_opercode(String _se_opercode) {
		this._se_opercode = _se_opercode;
	}

	public String get_sk_reason() {
		return _sk_reason;
	}

	public void set_sk_reason(String _sk_reason) {
		this._sk_reason = _sk_reason;
	}

	
	public String get_dnl_chgtime() {
		return _dnl_chgtime;
	}

	public void set_dnl_chgtime(String _dnl_chgtime) {
		this._dnl_chgtime = _dnl_chgtime;
	}

	public String get_dnm_chgtime() {
		return _dnm_chgtime;
	}

	public void set_dnm_chgtime(String _dnm_chgtime) {
		this._dnm_chgtime = _dnm_chgtime;
	}

	public String get_ne_eboxid() {
		return _ne_eboxid;
	}

	public void set_ne_eboxid(String _ne_eboxid) {
		this._ne_eboxid = _ne_eboxid;
	}

}
