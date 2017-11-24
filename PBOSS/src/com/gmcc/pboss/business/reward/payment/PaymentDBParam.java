package com.gmcc.pboss.business.reward.payment;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: PaymentDBParam
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public class PaymentDBParam extends DBQueryParam {

	private static final long serialVersionUID = -8130379678149143635L;
	
	private String _se_optype;
	private String _sk_optype;
	private String _snm_opmonth;
	private String _se_opmonth;
	private String _snl_opmonth;
	private String _snm_paymonth;
	private String _se_paymonth;
	private String _snl_paymonth;
	private String _se_stype;
	private String _sk_stype;
	private String _se_ltype;
	private String _sk_ltype;
	private String _se_payee;
	private String _sk_payee;
	private String _ne_paysum;
	private String _ne_rewardstd;
	private String _ne_rule;
	private String _ne_deduction;
	private String _nk_deduction;
	private String _se_batch;
	private String _sk_batch;
	private String _ne_seq;
	private String _se_wayid;
	private String _se_pubpri;
	private String _se_employeeNum;

	private String _se_checkedflag;
	private String _se_upoprcode;
	private String _se_calcmonth;
	
	private String _se_countyid;


	public String get_ne_seq() {
		return _ne_seq;
	}

	public void set_ne_seq(String neSeq) {
		_ne_seq = neSeq;
	}

	/**
	 * @return Returns the _se_optype.
	 */
	public String get_se_optype() {
		return this._se_optype;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_optype to set.
	 */
	public void set_se_optype(String _se_optype) {
		this._se_optype = _se_optype;
	}

	/**
	 * @return Returns the _sk_optype.
	 */
	public String get_sk_optype() {
		return this._sk_optype;
	}

	/**
	 * @param _sk_companyname
	 *            The _sk_optype to set.
	 */
	public void set_sk_optype(String _sk_optype) {
		this._sk_optype = _sk_optype;
	}

	/**
	 * @return Returns the _snm_opmonth.
	 */
	public String get_snm_opmonth() {
		return this._snm_opmonth;
	}

	/**
	 * @param _sk_companyname
	 *            The _snm_opmonth to set.
	 */
	public void set_snm_opmonth(String _snm_opmonth) {
		this._snm_opmonth = _snm_opmonth;
	}

	/**
	 * @return Returns the _se_opmonth.
	 */
	public String get_se_opmonth() {
		return this._se_opmonth;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_opmonth to set.
	 */
	public void set_se_opmonth(String _se_opmonth) {
		this._se_opmonth = _se_opmonth;
	}

	/**
	 * @return Returns the _snl_opmonth.
	 */
	public String get_snl_opmonth() {
		return this._snl_opmonth;
	}

	/**
	 * @param _sk_companyname
	 *            The _snl_opmonth to set.
	 */
	public void set_snl_opmonth(String _snl_opmonth) {
		this._snl_opmonth = _snl_opmonth;
	}

	/**
	 * @return Returns the _snm_paymonth.
	 */
	public String get_snm_paymonth() {
		return this._snm_paymonth;
	}

	/**
	 * @param _sk_companyname
	 *            The _snm_paymonth to set.
	 */
	public void set_snm_paymonth(String _snm_paymonth) {
		this._snm_paymonth = _snm_paymonth;
	}

	/**
	 * @return Returns the _se_paymonth.
	 */
	public String get_se_paymonth() {
		return this._se_paymonth;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_paymonth to set.
	 */
	public void set_se_paymonth(String _se_paymonth) {
		this._se_paymonth = _se_paymonth;
	}

	/**
	 * @return Returns the _snl_paymonth.
	 */
	public String get_snl_paymonth() {
		return this._snl_paymonth;
	}

	/**
	 * @param _sk_companyname
	 *            The _snl_paymonth to set.
	 */
	public void set_snl_paymonth(String _snl_paymonth) {
		this._snl_paymonth = _snl_paymonth;
	}

	/**
	 * @return Returns the _se_stype.
	 */
	public String get_se_stype() {
		return this._se_stype;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_stype to set.
	 */
	public void set_se_stype(String _se_stype) {
		this._se_stype = _se_stype;
	}

	/**
	 * @return Returns the _sk_stype.
	 */
	public String get_sk_stype() {
		return this._sk_stype;
	}

	/**
	 * @param _sk_companyname
	 *            The _sk_stype to set.
	 */
	public void set_sk_stype(String _sk_stype) {
		this._sk_stype = _sk_stype;
	}

	/**
	 * @return Returns the _se_payee.
	 */
	public String get_se_payee() {
		return this._se_payee;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_payee to set.
	 */
	public void set_se_payee(String _se_payee) {
		this._se_payee = _se_payee;
	}

	/**
	 * @return Returns the _sk_payee.
	 */
	public String get_sk_payee() {
		return this._sk_payee;
	}

	/**
	 * @param _sk_companyname
	 *            The _sk_payee to set.
	 */
	public void set_sk_payee(String _sk_payee) {
		this._sk_payee = _sk_payee;
	}

	/**
	 * @return Returns the _ne_paysum.
	 */
	public String get_ne_paysum() {
		return this._ne_paysum;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_paysum to set.
	 */
	public void set_ne_paysum(String _ne_paysum) {
		this._ne_paysum = _ne_paysum;
	}

	/**
	 * @return Returns the _ne_rewardstd.
	 */
	public String get_ne_rewardstd() {
		return this._ne_rewardstd;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_rewardstd to set.
	 */
	public void set_ne_rewardstd(String _ne_rewardstd) {
		this._ne_rewardstd = _ne_rewardstd;
	}

	/**
	 * @return Returns the _ne_rule.
	 */
	public String get_ne_rule() {
		return this._ne_rule;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_rule to set.
	 */
	public void set_ne_rule(String _ne_rule) {
		this._ne_rule = _ne_rule;
	}

	/**
	 * @return Returns the _ne_deduction.
	 */
	public String get_ne_deduction() {
		return this._ne_deduction;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_deduction to set.
	 */
	public void set_ne_deduction(String _ne_deduction) {
		this._ne_deduction = _ne_deduction;
	}

	/**
	 * @return Returns the _nk_deduction.
	 */
	public String get_nk_deduction() {
		return this._nk_deduction;
	}

	/**
	 * @param _sk_companyname
	 *            The _nk_deduction to set.
	 */
	public void set_nk_deduction(String _nk_deduction) {
		this._nk_deduction = _nk_deduction;
	}

	public String get_se_batch() {
		return _se_batch;
	}

	public void set_se_batch(String seBatch) {
		_se_batch = seBatch;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_ltype() {
		return _se_ltype;
	}

	public void set_se_ltype(String _se_ltype) {
		this._se_ltype = _se_ltype;
	}

	public String get_sk_ltype() {
		return _sk_ltype;
	}

	public void set_sk_ltype(String _sk_ltype) {
		this._sk_ltype = _sk_ltype;
	}

	public String get_sk_batch() {
		return _sk_batch;
	}

	public void set_sk_batch(String _sk_batch) {
		this._sk_batch = _sk_batch;
	}

	public String get_se_pubpri() {
		return _se_pubpri;
	}

	public void set_se_pubpri(String _se_pubpri) {
		this._se_pubpri = _se_pubpri;
	}

	public String get_se_employeeNum() {
		return _se_employeeNum;
	}

	public void set_se_employeeNum(String num) {
		_se_employeeNum = num;
	}

	public String get_se_checkedflag() {
		return _se_checkedflag;
	}

	public void set_se_checkedflag(String _se_checkedflag) {
		this._se_checkedflag = _se_checkedflag;
	}

	public String get_se_upoprcode() {
		return _se_upoprcode;
	}

	public void set_se_upoprcode(String _se_upoprcode) {
		this._se_upoprcode = _se_upoprcode;
	}

	public String get_se_calcmonth() {
		return _se_calcmonth;
	}

	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	
}
