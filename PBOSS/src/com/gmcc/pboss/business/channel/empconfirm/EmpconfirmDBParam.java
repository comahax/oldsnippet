/**
 * auto-generated code
 * Tue Mar 01 19:20:26 CST 2011
 */
package com.gmcc.pboss.business.channel.empconfirm;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: EmpconfirmDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmpconfirmDBParam extends DBQueryParam {
    private String _se_employeeid;
    private String _se_wayid;
    private String _ne_empstatus;
    private String _ne_confirmid;
    private String _ne_smsstatus;
    private String _dnm_smscreattime;
    private String _dnl_smscreattime;
    private String _se_telephone;

	/**
     * @return Returns the _se_employeeid.
     */
    public String get_se_employeeid() {
        return this._se_employeeid;
    }
    /**
     * @param _sk_companyname The _se_employeeid to set.
     */
    public void set_se_employeeid(String _se_employeeid) {
        this._se_employeeid = _se_employeeid;
    }

	/**
     * @return Returns the _se_wayid.
     */
    public String get_se_wayid() {
        return this._se_wayid;
    }
    /**
     * @param _sk_companyname The _se_wayid to set.
     */
    public void set_se_wayid(String _se_wayid) {
        this._se_wayid = _se_wayid;
    }

	/**
     * @return Returns the _ne_empstatus.
     */
    public String get_ne_empstatus() {
        return this._ne_empstatus;
    }
    /**
     * @param _sk_companyname The _ne_empstatus to set.
     */
    public void set_ne_empstatus(String _ne_empstatus) {
        this._ne_empstatus = _ne_empstatus;
    }

	/**
     * @return Returns the _ne_confirmid.
     */
    public String get_ne_confirmid() {
        return this._ne_confirmid;
    }
    /**
     * @param _sk_companyname The _ne_confirmid to set.
     */
    public void set_ne_confirmid(String _ne_confirmid) {
        this._ne_confirmid = _ne_confirmid;
    }

	/**
     * @return Returns the _ne_smsstatus.
     */
    public String get_ne_smsstatus() {
        return this._ne_smsstatus;
    }
    /**
     * @param _sk_companyname The _ne_smsstatus to set.
     */
    public void set_ne_smsstatus(String _ne_smsstatus) {
        this._ne_smsstatus = _ne_smsstatus;
    }

	/**
     * @return Returns the _dnm_smscreattime.
     */
    public String get_dnm_smscreattime() {
        return this._dnm_smscreattime;
    }
    /**
     * @param _sk_companyname The _dnm_smscreattime to set.
     */
    public void set_dnm_smscreattime(String _dnm_smscreattime) {
        this._dnm_smscreattime = _dnm_smscreattime;
    }

	/**
     * @return Returns the _dnl_smscreattime.
     */
    public String get_dnl_smscreattime() {
        return this._dnl_smscreattime;
    }
    /**
     * @param _sk_companyname The _dnl_smscreattime to set.
     */
    public void set_dnl_smscreattime(String _dnl_smscreattime) {
        this._dnl_smscreattime = _dnl_smscreattime;
    }
	public String get_se_telephone() {
		return _se_telephone;
	}
	public void set_se_telephone(String _se_telephone) {
		this._se_telephone = _se_telephone;
	}

}
