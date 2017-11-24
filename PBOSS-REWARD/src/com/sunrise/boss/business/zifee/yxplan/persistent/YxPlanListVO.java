package com.sunrise.boss.business.zifee.yxplan.persistent;

import java.util.Collection;

import com.sunrise.boss.common.base.db.BaseListVO;

public class YxPlanListVO extends BaseListVO {
	private String _ne_yxplanid;

	private String _nnm_yxplanid; // 营销方案<=

	private String _nnl_yxplanid; // 营销方案>=
	
	private String _ssw_yxplanid;

	private String _sk_yxplanname;

	private String _se_checkercode;

	private String _se_operatorcode;

	private String _sk_discscope;

	private String _sk_feecomment;

	private String _sk_remark;

	private String _se_plankind;

	private String _se_areacode;

	private String _ne_groupflag;

	private String _dnl_startdate;

	private String _dnm_startdate;

	private String _dnl_stopdate;

	private String _dnm_stopdate;

	private Collection _sin_areacode;

	private String _sql_areacode;

	private Short _ne_checkus;

	private Short _ne_planbigkind;

	private String _ne_plankind;
	
	public Short get_ne_planbigkind() {
		return _ne_planbigkind;
	}

	public void set_ne_planbigkind(Short _ne_planbigkind) {
		this._ne_planbigkind = _ne_planbigkind;
	}

	public Collection get_sin_areacode() {
		return _sin_areacode;
	}

	public void set_sin_areacode(Collection _sin_areacode) {
		this._sin_areacode = _sin_areacode;
	}

	public String get_sql_areacode() {
		return _sql_areacode;
	}

	public void set_sql_areacode(String _sql_areacode) {
		this._sql_areacode = _sql_areacode;
	}

	public String get_nnl_yxplanid() {
		return _nnl_yxplanid;
	}

	public void set_nnl_yxplanid(String _nnl_yxplanid) {
		this._nnl_yxplanid = _nnl_yxplanid;
	}

	public String get_nnm_yxplanid() {
		return _nnm_yxplanid;
	}

	public void set_nnm_yxplanid(String _nnm_yxplanid) {
		this._nnm_yxplanid = _nnm_yxplanid;
	}

	public String get_ne_groupflag() {
		return _ne_groupflag;
	}

	public void set_ne_groupflag(String _ne_groupflag) {
		this._ne_groupflag = _ne_groupflag;
	}

	public String get_se_areacode() {
		return _se_areacode;
	}

	public void set_se_areacode(String _se_areacode) {
		this._se_areacode = _se_areacode;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String get_se_checkercode() {
		return _se_checkercode;
	}

	public void set_se_checkercode(String _se_checkercode) {
		this._se_checkercode = _se_checkercode;
	}

	public String get_sk_discscope() {
		return _sk_discscope;
	}

	public void set_sk_discscope(String _sk_discscope) {
		this._sk_discscope = _sk_discscope;
	}

	public String get_se_operatorcode() {
		return _se_operatorcode;
	}

	public void set_se_operatorcode(String _se_operatorcode) {
		this._se_operatorcode = _se_operatorcode;
	}

	public String get_se_plankind() {
		return _se_plankind;
	}

	public void set_se_plankind(String _se_plankind) {
		this._se_plankind = _se_plankind;
	}

	public String get_sk_feecomment() {
		return _sk_feecomment;
	}

	public void set_sk_feecomment(String _sk_feecomment) {
		this._sk_feecomment = _sk_feecomment;
	}

	public String get_sk_remark() {
		return _sk_remark;
	}

	public void set_sk_remark(String _sk_remark) {
		this._sk_remark = _sk_remark;
	}

	public String get_sk_yxplanname() {
		return _sk_yxplanname;
	}

	public void set_sk_yxplanname(String _sk_yxplanname) {
		this._sk_yxplanname = _sk_yxplanname;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
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

	public String get_dnm_stopdate() {
		return _dnm_stopdate;
	}

	public void set_dnm_stopdate(String _dnm_stopdate) {
		this._dnm_stopdate = _dnm_stopdate;
	}

	public Short get_ne_checkus() {
		return _ne_checkus;
	}

	public void set_ne_checkus(Short _ne_checkus) {
		this._ne_checkus = _ne_checkus;
	}

	public String get_ssw_yxplanid() {
		return _ssw_yxplanid;
	}

	public void set_ssw_yxplanid(String _ssw_yxplanid) {
		this._ssw_yxplanid = _ssw_yxplanid;
	}

	public String get_ne_plankind() {
		return _ne_plankind;
	}

	public void set_ne_plankind(String _ne_plankind) {
		this._ne_plankind = _ne_plankind;
	}
}
