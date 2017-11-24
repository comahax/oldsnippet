/**
 * auto-generated code
 * Tue Oct 10 10:11:29 CST 2006
 */
package com.sunrise.boss.business.fee.persistent.chkhangadj;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: ChkHangAdjListVO
 * </p>
 * <p>
 * Description: Query Params Object for ChkHangAdjDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class ChkHangAdjListVO extends BaseListVO {

	private String _ne_eboxid;

	private String _ne_acctid;

	private String _ne_validbillcyc;

	private String _ne_subsid;

	private String _dnl_hangtime;

	private String _dnm_hangtime;
	
	private String _se_checkercode;
	
	private String startindex;
	
	private String endindex;

	public String get_ne_eboxid() {
		return _ne_eboxid;
	}

	public void set_ne_eboxid(String _ne_eboxid) {
		this._ne_eboxid = _ne_eboxid;
	}

	public String get_ne_subsid() {
		return _ne_subsid;
	}

	public void set_ne_subsid(String _ne_subsid) {
		this._ne_subsid = _ne_subsid;
	}

	public String get_dnl_hangtime() {
		return _dnl_hangtime;
	}

	public void set_dnl_hangtime(String _dnl_hangtime) {
		this._dnl_hangtime = _dnl_hangtime;
	}

	public String get_dnm_hangtime() {
		return _dnm_hangtime;
	}

	public void set_dnm_hangtime(String _dnm_hangtime) {
		this._dnm_hangtime = _dnm_hangtime;
	}

	public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}
    
	public String getStartindex(){
		return startindex;
	}
	
	public void setStartindex(String startindex){
		this.startindex = startindex;
	}
	
	public String getEndindex(){
		return endindex;
	}
	
	public void setEndindex(String endindex){
		this.endindex = endindex;
	}
	public String get_se_checkercode() {
		return _se_checkercode;
	}

	public void set_se_checkercode(String _se_checkercode) {
		this._se_checkercode = _se_checkercode;
	}
	
}
