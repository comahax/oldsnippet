/**
* auto-generated code
* Wed Aug 16 14:03:04 CST 2006
*/
package com.sunrise.boss.business.fee.hangbill.persistent;

import java.util.Collection;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * Title: WoffCustListVO
 * Description: Query Params Object for WoffCustDAO
 * Copyright: Copyright (c) 2006
 * Company: Maywide Tech Ltd.
 * @author mys
 * @version 1.0
 */ 
public class WoffCustListVO extends BaseListVO {

	private String _ne_subsid;
	private String _ne_eboxid;
	private String _ne_validbillcyc;
	private Collection _nnin_eboxid;
	private String _ne_acctid;
	
	private String startindex;
	private String endindex;
	
	private boolean hascount = true;
	
	public String get_ne_eboxid() {
		return _ne_eboxid;
	}
	public void set_ne_eboxid(String _ne_eboxid) {
		this._ne_eboxid = _ne_eboxid;
	}
	public Collection get_nnin_eboxid() {
		return _nnin_eboxid;
	}
	public void set_nnin_eboxid(Collection _nnin_eboxid) {
		this._nnin_eboxid = _nnin_eboxid;
	}
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
	public boolean isHascount() {
		return hascount;
	}
	public void setHascount(boolean hascount) {
		this.hascount = hascount;
	}
	public String get_ne_acctid() {
		return _ne_acctid;
	}
	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}
	
	
    
}
