/**
 * auto-generated code
 * Sun Feb 03 10:15:39 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.rule;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: RuleForm
 * </p>
 * <p>
 * Description:
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
public class RuleForm extends BaseActionForm {
	private String ruleid;

	private String rulename;

	private java.util.Date startdate;

	private java.util.Date enddate;

	private String remark;
	
	private String ruletype;

	private String _se_ruleid;

	private String _se_rulename;

	private String _sk_rulename;

	private String _dnl_startdate;

	private String _dnm_startdate;

	private String _dnl_enddate;

	private String _dnm_enddate;
	
	private String _se_ruletype;

	public String get_se_ruletype() {
		return _se_ruletype;
	}

	public void set_se_ruletype(String _se_ruletype) {
		this._se_ruletype = _se_ruletype;
	}

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

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getRulename() {
		return rulename;
	}

	public void setRulename(String rulename) {
		this.rulename = rulename;
	}

	public java.util.Date getStartdate() {
		return startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.util.Date getEnddate() {
		return enddate;
	}

	public void setEnddate(java.util.Date enddate) {
		this.enddate = enddate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRuletype() {
		return ruletype;
	}

	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}
}
