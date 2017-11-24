package com.sunrise.boss.business.cms.reward.faildataquery.persistent;

import java.util.Date;

import com.sunrise.boss.common.base.db.BaseListVO;

public class FaildataqueryListVO extends BaseListVO {
	private String _se_rewardtype;

	private String _se_opnid;

	private String _se_wayid;

	private String _dnl_oprtime;

	private String _dnm_oprtime;

	private String _se_oprcode;
	
	private String _se_mobile;
	
	private String _sk_adtcode;
	
	private String _sk_adtremark;
	
	private String _ne_rewardflag;
	private String _se_repairmonth;
	private String _se_batchno;
	
	private String _sql_condition;
	private String _se_calcmonth;

	public String get_se_calcmonth() {
		return _se_calcmonth;
	}

	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}

	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}

	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}

	public String get_dnm_oprtime() {
		return _dnm_oprtime;
	}

	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_rewardtype() {
		return _se_rewardtype;
	}

	public void set_se_rewardtype(String _se_rewardtype) {
		this._se_rewardtype = _se_rewardtype;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sk_adtremark() {
		return _sk_adtremark;
	}

	public void set_sk_adtremark(String _sk_adtremark) {
		this._sk_adtremark = _sk_adtremark;
	}

	public String get_sk_adtcode() {
		return _sk_adtcode;
	}

	public void set_sk_adtcode(String _sk_adtcode) {
		this._sk_adtcode = _sk_adtcode;
	}

	public String get_ne_rewardflag() {
		return _ne_rewardflag;
	}

	public void set_ne_rewardflag(String _ne_rewardflag) {
		this._ne_rewardflag = _ne_rewardflag;
	}

	public String get_se_repairmonth() {
		return _se_repairmonth;
	}

	public void set_se_repairmonth(String _se_repairmonth) {
		this._se_repairmonth = _se_repairmonth;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_sql_condition() {
		return _sql_condition;
	}

	public void set_sql_condition(String _sql_condition) {
		this._sql_condition = _sql_condition;
	}

}
