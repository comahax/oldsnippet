/**
 * auto-generated code
 * Tue Oct 13 14:27:11 CST 2009
 */
package com.gmcc.pboss.business.sales.monamtchgrule;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: MonamtchgruleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class MonamtchgruleDBParam extends DBQueryParam {
    private String _se_cityid;
    private String _ne_starlevel;
    private String _se_brand;
    private String _ne_effective;
    private String _nne_ruleid;

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
     * @return Returns the _ne_effective.
     */
    public String get_ne_effective() {
        return this._ne_effective;
    }
    /**
     * @param _sk_companyname The _ne_effective to set.
     */
    public void set_ne_effective(String _ne_effective) {
        this._ne_effective = _ne_effective;
    }
	public String get_nne_ruleid() {
		return _nne_ruleid;
	}
	public void set_nne_ruleid(String _nne_ruleid) {
		this._nne_ruleid = _nne_ruleid;
	}
}
