/**
 * auto-generated code
 * Tue Aug 24 11:24:17 CST 2010
 */
package com.gmcc.pboss.business.sales.bankdeduct;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: BankdeductDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankdeductDBParam extends DBQueryParam {
    private String _ne_deductid;
    private String _se_orderid;
    private String _se_bankid;
    private String _se_acctnum;
    private String _dnm_creatdate;
    private String _dnl_creatdate;
    private String _se_shopnum;
    private String _se_terminalnum;
    private String _se_state;
    
    
    
    
	public String get_se_state() {
		return _se_state;
	}
	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}
	/**
     * @return Returns the _ne_deductid.
     */
    public String get_ne_deductid() {
        return this._ne_deductid;
    }
    /**
     * @param _sk_companyname The _ne_deductid to set.
     */
    public void set_ne_deductid(String _ne_deductid) {
        this._ne_deductid = _ne_deductid;
    }

	/**
     * @return Returns the _se_orderid.
     */
    public String get_se_orderid() {
        return this._se_orderid;
    }
    /**
     * @param _sk_companyname The _se_orderid to set.
     */
    public void set_se_orderid(String _se_orderid) {
        this._se_orderid = _se_orderid;
    }

	/**
     * @return Returns the _se_bankid.
     */
    public String get_se_bankid() {
        return this._se_bankid;
    }
    /**
     * @param _sk_companyname The _se_bankid to set.
     */
    public void set_se_bankid(String _se_bankid) {
        this._se_bankid = _se_bankid;
    }

	/**
     * @return Returns the _se_acctnum.
     */
    public String get_se_acctnum() {
        return this._se_acctnum;
    }
    /**
     * @param _sk_companyname The _se_acctnum to set.
     */
    public void set_se_acctnum(String _se_acctnum) {
        this._se_acctnum = _se_acctnum;
    }

	/**
     * @return Returns the _dnm_creatdate.
     */
    public String get_dnm_creatdate() {
        return this._dnm_creatdate;
    }
    /**
     * @param _sk_companyname The _dnm_creatdate to set.
     */
    public void set_dnm_creatdate(String _dnm_creatdate) {
        this._dnm_creatdate = _dnm_creatdate;
    }

	/**
     * @return Returns the _dnl_creatdate.
     */
    public String get_dnl_creatdate() {
        return this._dnl_creatdate;
    }
    /**
     * @param _sk_companyname The _dnl_creatdate to set.
     */
    public void set_dnl_creatdate(String _dnl_creatdate) {
        this._dnl_creatdate = _dnl_creatdate;
    }

	/**
     * @return Returns the _se_shopnum.
     */
    public String get_se_shopnum() {
        return this._se_shopnum;
    }
    /**
     * @param _sk_companyname The _se_shopnum to set.
     */
    public void set_se_shopnum(String _se_shopnum) {
        this._se_shopnum = _se_shopnum;
    }

	/**
     * @return Returns the _se_terminalnum.
     */
    public String get_se_terminalnum() {
        return this._se_terminalnum;
    }
    /**
     * @param _sk_companyname The _se_terminalnum to set.
     */
    public void set_se_terminalnum(String _se_terminalnum) {
        this._se_terminalnum = _se_terminalnum;
    }

}
