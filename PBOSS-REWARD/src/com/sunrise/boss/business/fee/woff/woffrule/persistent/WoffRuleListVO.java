/**
* auto-generated code
* Fri Aug 11 09:34:48 CST 2006
*/
package com.sunrise.boss.business.fee.woff.woffrule.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: IbRuWoffruleVoListVO</p>
 * <p>Description: Query Params Object for IbRuWoffruleVoDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public class WoffRuleListVO extends BaseListVO {

	private String _ne_acctid;
	private String _ne_eboxunitid;
	public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}
	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}
	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	}
	
	private String _dnm_endtime;
	
	private String _dnl_begintime;
	
	public String get_dnl_begintime() {
		return _dnl_begintime;
	}

	public void set_dnl_begintime(String _dnl_begintime) {
		this._dnl_begintime = _dnl_begintime;
	}

	public String get_dnm_endtime() {
		return _dnm_endtime;
	}

	public void set_dnm_endtime(String _dnm_endtime) {
		this._dnm_endtime = _dnm_endtime;
	}
}
