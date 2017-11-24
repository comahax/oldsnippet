/**
 * auto-generated code
 * Sat Sep 05 15:14:44 CST 2009
 */
package com.gmcc.pboss.business.resource.comcategoryrela;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ComcategoryrelaDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComcategoryrelaDBParam extends DBQueryParam {
    private String _se_comcategory;
    private String _ne_comid;
    private String _se_restype;
    private String _se_brand;

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
     * @return Returns the _ne_comid.
     */
    public String get_ne_comid() {
        return this._ne_comid;
    }
    /**
     * @param _sk_companyname The _ne_comid to set.
     */
    public void set_ne_comid(String _ne_comid) {
        this._ne_comid = _ne_comid;
    }

	/**
     * @return Returns the _se_restype.
     */
    public String get_se_restype() {
        return this._se_restype;
    }
    /**
     * @param _sk_companyname The _se_restype to set.
     */
    public void set_se_restype(String _se_restype) {
        this._se_restype = _se_restype;
    }
	public String get_se_brand() {
		return _se_brand;
	}
	public void set_se_brand(String _se_brand) {
		this._se_brand = _se_brand;
	}
    
}
