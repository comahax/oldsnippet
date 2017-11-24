/**
 * auto-generated code
 * Wed Jun 23 09:45:51 CST 2010
 */
package com.gmcc.pboss.business.sales.stockalarm;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: StockalarmDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class StockalarmDBParam extends DBQueryParam {
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
	public String get_se_updatechannel() {
		return _se_updatechannel;
	}
	public void set_se_updatechannel(String seUpdatechannel) {
		_se_updatechannel = seUpdatechannel;
	}
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public String get_ne_starlevel() {
		return _ne_starlevel;
	}
	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}
	public String get_ne_waystate() {
		return _ne_waystate;
	}
	public void set_ne_waystate(String _ne_waystate) {
		this._ne_waystate = _ne_waystate;
	}
    
}
