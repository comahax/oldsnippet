/**
 * auto-generated code
 * Fri Jul 09 09:11:20 CST 2010
 */
package com.gmcc.pboss.business.resource.resalarminfo;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ResalarminfoDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarminfoDBParam extends DBQueryParam {
    private String _dnm_alarmdate;
    private String _dnl_alarmdate;
    private String _se_countyid;
    private String _se_comcategory;
    private String _se_alarmsignal;

	/**
     * @return Returns the _dnm_alarmdate.
     */
    public String get_dnm_alarmdate() {
        return this._dnm_alarmdate;
    }
    /**
     * @param _sk_companyname The _dnm_alarmdate to set.
     */
    public void set_dnm_alarmdate(String _dnm_alarmdate) {
        this._dnm_alarmdate = _dnm_alarmdate;
    }

	/**
     * @return Returns the _dnl_alarmdate.
     */
    public String get_dnl_alarmdate() {
        return this._dnl_alarmdate;
    }
    /**
     * @param _sk_companyname The _dnl_alarmdate to set.
     */
    public void set_dnl_alarmdate(String _dnl_alarmdate) {
        this._dnl_alarmdate = _dnl_alarmdate;
    }

	/**
     * @return Returns the _se_countyid.
     */
    public String get_se_countyid() {
        return this._se_countyid;
    }
    /**
     * @param _sk_companyname The _se_countyid to set.
     */
    public void set_se_countyid(String _se_countyid) {
        this._se_countyid = _se_countyid;
    }

	/**
     * @return Returns the _se_comcategory.
     */
    public String get_se_comcategory() {
        return this._se_comcategory;
    }
    /**
     * @param _sk_companyname The _se_comcategory to set.
     */
    public void set_se_comcategory(String _se_comcategory) {
        this._se_comcategory = _se_comcategory;
    }

	/**
     * @return Returns the _se_alarmsignal.
     */
    public String get_se_alarmsignal() {
        return this._se_alarmsignal;
    }
    /**
     * @param _sk_companyname The _se_alarmsignal to set.
     */
    public void set_se_alarmsignal(String _se_alarmsignal) {
        this._se_alarmsignal = _se_alarmsignal;
    }

}
