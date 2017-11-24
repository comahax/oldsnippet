/**
* auto-generated code
* Sat Aug 19 17:06:54 CST 2006
*/
package com.sunrise.boss.business.fee.persistent.cbincdecrdata;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: IncDecrDataListVO</p>
 * <p>Description: Query Params Object for IncDecrDataDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public class CBIncDecrDataListVO extends BaseListVO {
	private String _ne_subsid;
	
	private String _ne_validbillcyc;
	
//	private String _ne_servnum;
	
	private String _ne_type;
	
	private String _ne_genbillcyc;
	
	private String _se_incrdecrreason;
	
	private String _se_smallrsncode;
	
	private String _ne_attribute;
	
	private String _ne_acctid;
	
	private String _ne_busitype;
	
	private String _ne_desputetype;
	
	
	public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}

	public String get_ne_attribute() {
		return _ne_attribute;
	}

	public void set_ne_attribute(String _ne_attribute) {
		this._ne_attribute = _ne_attribute;
	}
	public String get_ne_genbillcyc() {
		return _ne_genbillcyc;
	}

	public void set_ne_genbillcyc(String _ne_genbillcyc) {
		this._ne_genbillcyc = _ne_genbillcyc;
	}

	public String get_se_incrdecrreason() {
		return _se_incrdecrreason;
	}

	public void set_se_incrdecrreason(String _se_incrdecrreason) {
		this._se_incrdecrreason = _se_incrdecrreason;
	}

	public String get_se_smallrsncode() {
		return _se_smallrsncode;
	}

	public void set_se_smallrsncode(String _se_smallrsncode) {
		this._se_smallrsncode = _se_smallrsncode;
	}

	public String get_ne_type() {
		return _ne_type;
	}

	public void set_ne_type(String _ne_type) {
		this._ne_type = _ne_type;
	}

//	public String get_ne_servnum() {
//		return _ne_servnum;
//	}
//
//	public void set_ne_servnum(String _ne_servnum) {
//		this._ne_servnum = _ne_servnum;
//	}
	public String get_ne_subsid() {
		return _ne_subsid;
	}
	public void set_ne_subsid(String _ne_subsid) {
		this._ne_subsid = _ne_subsid;
	}
	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}
	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}

	public String get_ne_busitype() {
		return _ne_busitype;
	}

	public void set_ne_busitype(String _ne_busitype) {
		this._ne_busitype = _ne_busitype;
	}

	public String get_ne_desputetype() {
		return _ne_desputetype;
	}

	public void set_ne_desputetype(String _ne_desputetype) {
		this._ne_desputetype = _ne_desputetype;
	}
}
