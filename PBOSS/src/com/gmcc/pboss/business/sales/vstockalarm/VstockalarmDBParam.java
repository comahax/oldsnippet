/**
 * auto-generated code
 * Wed Jun 01 09:15:31 GMT 2011
 */
package com.gmcc.pboss.business.sales.vstockalarm;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: VstockalarmDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class VstockalarmDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _se_brand;
    private String _se_updatechannel;
    private String _se_countyid;
    private String _ne_starlevel;
    private String _ne_waystate;
    private String _sk_brand;
    
	public String get_sk_brand() {
		return _sk_brand;
	}
	public void set_sk_brand(String _sk_brand) {
		this._sk_brand = _sk_brand;
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
     * @return Returns the _se_updatechannel.
     */
    public String get_se_updatechannel() {
        return this._se_updatechannel;
    }
    /**
     * @param _sk_companyname The _se_updatechannel to set.
     */
    public void set_se_updatechannel(String _se_updatechannel) {
        this._se_updatechannel = _se_updatechannel;
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
     * @return Returns the _ne_starlevel.
     */
    public String get_ne_starlevel() {
        return this._ne_starlevel;
    }
    /**
     * @param _sk_companyname The _ne_starlevel to set.
     */
    public void set_ne_starlevel(String _ne_starlevel) {
        this._ne_starlevel = _ne_starlevel;
    }

	/**
     * @return Returns the _ne_waystate.
     */
    public String get_ne_waystate() {
        return this._ne_waystate;
    }
    /**
     * @param _sk_companyname The _ne_waystate to set.
     */
    public void set_ne_waystate(String _ne_waystate) {
        this._ne_waystate = _ne_waystate;
    }

}
