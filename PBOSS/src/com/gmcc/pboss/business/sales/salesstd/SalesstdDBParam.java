/**
 * auto-generated code
 * Tue Oct 25 16:42:25 CST 2011
 */
package com.gmcc.pboss.business.sales.salesstd;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: SalesstdDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SalesstdDBParam extends DBQueryParam {
    private String _se_countyid;
    private String _se_mareacode;
    private String _ne_starlevel;
    private String _se_brand;
    private String _se_cityid;
    private String _se_wayid;
    

	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
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
     * @return Returns the _se_mareacode.
     */
    public String get_se_mareacode() {
        return this._se_mareacode;
    }
    /**
     * @param _sk_companyname The _se_mareacode to set.
     */
    public void set_se_mareacode(String _se_mareacode) {
        this._se_mareacode = _se_mareacode;
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

}
