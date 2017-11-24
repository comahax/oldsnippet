/**
 * auto-generated code
 * Sun Sep 27 11:45:09 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.vstdreward.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: vstdrewardListVO
 * </p>
 * <p>
 * Description: Query Params Object for vstdrewardDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class VstdrewardListVO extends BaseListVO {
	private String _sk_rewardname;

	private String _se_opnid;

	private String _se_region;

	private String _ne_ossrc;

	// dnl >=
	private String _dnl_startdate;

	private String _dnm_startdate;

	private String _dnm_stopdate;

	private String _dnl_stopdate;

	private String _ne_intvmonth;

	private String _nne_rewardid;

	private String _ne_rewardid;

	public String get_sk_rewardname() {
		return _sk_rewardname;
	}

	public void set_sk_rewardname(String _sk_rewardname) {
		this._sk_rewardname = _sk_rewardname;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_ne_ossrc() {
		return _ne_ossrc;
	}

	public void set_ne_ossrc(String _ne_ossrc) {
		this._ne_ossrc = _ne_ossrc;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
	}

	public String get_dnm_stopdate() {
		return _dnm_stopdate;
	}

	public void set_dnm_stopdate(String _dnm_stopdate) {
		this._dnm_stopdate = _dnm_stopdate;
	}

	public String get_dnl_stopdate() {
		return _dnl_stopdate;
	}

	public void set_dnl_stopdate(String _dnl_stopdate) {
		this._dnl_stopdate = _dnl_stopdate;
	}

	public String get_dnm_startdate() {
		return _dnm_startdate;
	}

	public void set_dnm_startdate(String _dnm_startdate) {
		this._dnm_startdate = _dnm_startdate;
	}

	public String get_ne_intvmonth() {
		return _ne_intvmonth;
	}

	public void set_ne_intvmonth(String _ne_intvmonth) {
		this._ne_intvmonth = _ne_intvmonth;
	}

	public String get_nne_rewardid() {
		return _nne_rewardid;
	}

	public void set_nne_rewardid(String _nne_rewardid) {
		this._nne_rewardid = _nne_rewardid;
	}

	public String get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public String get_se_region() {
		return _se_region;
	}

	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}

}
