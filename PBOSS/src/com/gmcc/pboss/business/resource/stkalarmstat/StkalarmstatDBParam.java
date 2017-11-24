/**
 * auto-generated code
 * Tue Jul 27 12:08:11 CST 2010
 */
package com.gmcc.pboss.business.resource.stkalarmstat;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: StkalarmstatDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StkalarmstatDBParam extends DBQueryParam {
    private String _dnm_alarmdate;
    private String _dnl_alarmdate;
    private String _se_wayid;
    private String _se_brand;
    private String _se_alarmlevel;
    private String _se_orderid;
    
    private String _se_countyid;
    private String _se_mareacode;

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
     * @return Returns the _se_brand.
     */
    public String get_se_brand() {
        return this._se_brand;
    }
    /**
     * @param _sk_companyname The _se_brand to set.
     */
    public void set_se_brand(String _se_brand) {
        this._se_brand = _se_brand;
    }

	/**
     * @return Returns the _se_alarmlevel.
     */
    public String get_se_alarmlevel() {
        return this._se_alarmlevel;
    }
    /**
     * @param _sk_companyname The _se_alarmlevel to set.
     */
    public void set_se_alarmlevel(String _se_alarmlevel) {
        this._se_alarmlevel = _se_alarmlevel;
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
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public String get_se_mareacode() {
		return _se_mareacode;
	}
	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}

}
