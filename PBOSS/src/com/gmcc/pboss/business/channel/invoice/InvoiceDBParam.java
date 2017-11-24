/**
 * auto-generated code
 * Fri Dec 30 09:40:47 CST 2011
 */
package com.gmcc.pboss.business.channel.invoice;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: InvoiceDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class InvoiceDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _dnm_applytime;
    private String _dnl_applytime;
    private String _ne_state;
    private String _se_countyid;
    private String _ne_information;

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
     * @return Returns the _dnm_applytime.
     */
    public String get_dnm_applytime() {
        return this._dnm_applytime;
    }
    /**
     * @param _sk_companyname The _dnm_applytime to set.
     */
    public void set_dnm_applytime(String _dnm_applytime) {
        this._dnm_applytime = _dnm_applytime;
    }

	/**
     * @return Returns the _dnl_applytime.
     */
    public String get_dnl_applytime() {
        return this._dnl_applytime;
    }
    /**
     * @param _sk_companyname The _dnl_applytime to set.
     */
    public void set_dnl_applytime(String _dnl_applytime) {
        this._dnl_applytime = _dnl_applytime;
    }

	/**
     * @return Returns the _ne_state.
     */
    public String get_ne_state() {
        return this._ne_state;
    }
    /**
     * @param _sk_companyname The _ne_state to set.
     */
    public void set_ne_state(String _ne_state) {
        this._ne_state = _ne_state;
    }
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public String get_ne_information() {
		return _ne_information;
	}
	public void set_ne_information(String _ne_information) {
		this._ne_information = _ne_information;
	}
 

}
