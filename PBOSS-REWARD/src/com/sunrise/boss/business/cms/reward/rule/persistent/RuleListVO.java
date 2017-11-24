/**
 * auto-generated code
 * Sun Feb 03 10:15:39 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rule.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: RuleListVO
 * </p>
 * <p>
 * Description: Query Params Object for RuleDAO
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
public class RuleListVO extends BaseListVO {

	private String _se_ruleid;

	private String _se_rulename;

	private String _sk_rulename;

	private String _dnl_startdate;

	private String _dnm_startdate;

	private String _dnl_enddate;

	private String _dnm_enddate;
	
	private String _se_ruletype;

	public String get_dnl_enddate() {
		return _dnl_enddate;
	}

	public void set_dnl_enddate(String _dnl_enddate) {
		this._dnl_enddate = _dnl_enddate;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
	}

	public String get_dnm_enddate() {
		return _dnm_enddate;
	}

	public void set_dnm_enddate(String _dnm_enddate) {
		this._dnm_enddate = _dnm_enddate;
	}

	public String get_dnm_startdate() {
		return _dnm_startdate;
	}

	public void set_dnm_startdate(String _dnm_startdate) {
		this._dnm_startdate = _dnm_startdate;
	}

	public String get_se_ruleid() {
		return _se_ruleid;
	}

	public void set_se_ruleid(String _se_ruleid) {
		this._se_ruleid = _se_ruleid;
	}

	public String get_se_rulename() {
		return _se_rulename;
	}

	public void set_se_rulename(String _se_rulename) {
		this._se_rulename = _se_rulename;
	}

	public String get_sk_rulename() {
		return _sk_rulename;
	}

	public void set_sk_rulename(String _sk_rulename) {
		this._sk_rulename = _sk_rulename;
	}

	public String get_se_ruletype() {
		return _se_ruletype;
	}

	public void set_se_ruletype(String _se_ruletype) {
		this._se_ruletype = _se_ruletype;
	}

}
