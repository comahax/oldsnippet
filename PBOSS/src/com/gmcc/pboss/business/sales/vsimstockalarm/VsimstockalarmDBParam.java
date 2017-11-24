/**
 * auto-generated code
 * Sat Mar 31 16:00:36 CST 2012
 */
package com.gmcc.pboss.business.sales.vsimstockalarm;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: VsimstockalarmDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class VsimstockalarmDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _se_countyid;
    private String _se_comcategory;
    private String _ne_starlevel;
    private String _ne_waystate;

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
	public String get_se_comcategory() {
		return _se_comcategory;
	}
	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}

}
