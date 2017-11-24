/**
 * auto-generated code
 * Tue Oct 13 14:29:08 CST 2009
 */
package com.gmcc.pboss.business.sales.orderstd;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderstdDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderstdDBParam extends DBQueryParam {
    private String _se_cityid;
    private String _se_countyid;
    private String _se_cooptype;
    private String _ne_starlevel;
    private String _se_brand;
    private String _se_stdtype;
    private String _ne_effective;
    private String _nne_recid;

	/**
     * @return Returns the _se_cityid.
     */
    public String get_se_cityid() {
        return this._se_cityid;
    }
    /**
     * @param _sk_companyname The _se_cityid to set.
     */
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
     * @return Returns the _se_cooptype.
     */
    public String get_se_cooptype() {
        return this._se_cooptype;
    }
    /**
     * @param _sk_companyname The _se_cooptype to set.
     */
    public void set_se_cooptype(String _se_cooptype) {
        this._se_cooptype = _se_cooptype;
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

	/**
     * @return Returns the _se_stdtype.
     */
    public String get_se_stdtype() {
        return this._se_stdtype;
    }
    /**
     * @param _sk_companyname The _se_stdtype to set.
     */
    public void set_se_stdtype(String _se_stdtype) {
        this._se_stdtype = _se_stdtype;
    }
	public String get_nne_recid() {
		return _nne_recid;
	}
	public void set_nne_recid(String _nne_recid) {
		this._nne_recid = _nne_recid;
	}
	public String get_ne_effective() {
		return _ne_effective;
	}
	public void set_ne_effective(String _ne_effective) {
		this._ne_effective = _ne_effective;
	}

}
