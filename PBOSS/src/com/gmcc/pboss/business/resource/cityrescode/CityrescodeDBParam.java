/**
 * auto-generated code
 * Wed Aug 10 19:25:23 CST 2011
 */
package com.gmcc.pboss.business.resource.cityrescode;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: CityrescodeDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class CityrescodeDBParam extends DBQueryParam {
    private String _se_cityrescode;
    private String _se_comcategory;
    private String _se_cityid;
    
	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}
	/**
     * @return Returns the _se_cityrescode.
     */
    public String get_se_cityrescode() {
        return this._se_cityrescode;
    }
    /**
     * @param _sk_companyname The _se_cityrescode to set.
     */
    public void set_se_cityrescode(String _se_cityrescode) {
        this._se_cityrescode = _se_cityrescode;
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

}
