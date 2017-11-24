package com.gmcc.pboss.business.reward.paymentlog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: PaymentlogDBParam </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PaymentlogDBParam extends DBQueryParam {
    private String _dnm_optime;
    private String _dnl_optime;
    private String _se_oprcode;
    private String _se_oprtype;
    private String _se_optype;
    private String _snm_opmonth;
    private String _snl_opmonth;
    private String _snm_paymonth;
    private String _snl_paymonth;
    private String _se_wayid;

	/**
     * @return Returns the _dnm_optime.
     */
    public String get_dnm_optime() {
        return this._dnm_optime;
    }
    /**
     * @param _sk_companyname The _dnm_optime to set.
     */
    public void set_dnm_optime(String _dnm_optime) {
        this._dnm_optime = _dnm_optime;
    }

	/**
     * @return Returns the _dnl_optime.
     */
    public String get_dnl_optime() {
        return this._dnl_optime;
    }
    /**
     * @param _sk_companyname The _dnl_optime to set.
     */
    public void set_dnl_optime(String _dnl_optime) {
        this._dnl_optime = _dnl_optime;
    }

	/**
     * @return Returns the _se_oprcode.
     */
    public String get_se_oprcode() {
        return this._se_oprcode;
    }
    /**
     * @param _sk_companyname The _se_oprcode to set.
     */
    public void set_se_oprcode(String _se_oprcode) {
        this._se_oprcode = _se_oprcode;
    }

	/**
     * @return Returns the _se_oprtype.
     */
    public String get_se_oprtype() {
        return this._se_oprtype;
    }
    /**
     * @param _sk_companyname The _se_oprtype to set.
     */
    public void set_se_oprtype(String _se_oprtype) {
        this._se_oprtype = _se_oprtype;
    }

	/**
     * @return Returns the _se_optype.
     */
    public String get_se_optype() {
        return this._se_optype;
    }
    /**
     * @param _sk_companyname The _se_optype to set.
     */
    public void set_se_optype(String _se_optype) {
        this._se_optype = _se_optype;
    }

	/**
     * @return Returns the _snm_opmonth.
     */
    public String get_snm_opmonth() {
        return this._snm_opmonth;
    }
    /**
     * @param _sk_companyname The _snm_opmonth to set.
     */
    public void set_snm_opmonth(String _snm_opmonth) {
        this._snm_opmonth = _snm_opmonth;
    }

	/**
     * @return Returns the _snl_opmonth.
     */
    public String get_snl_opmonth() {
        return this._snl_opmonth;
    }
    /**
     * @param _sk_companyname The _snl_opmonth to set.
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
     * @param _sk_companyname The _snm_paymonth to set.
     */
    public void set_snm_paymonth(String _snm_paymonth) {
        this._snm_paymonth = _snm_paymonth;
    }

	/**
     * @return Returns the _snl_paymonth.
     */
    public String get_snl_paymonth() {
        return this._snl_paymonth;
    }
    /**
     * @param _sk_companyname The _snl_paymonth to set.
     */
    public void set_snl_paymonth(String _snl_paymonth) {
        this._snl_paymonth = _snl_paymonth;
    }
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

}
