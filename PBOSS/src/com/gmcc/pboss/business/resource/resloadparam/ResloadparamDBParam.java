/**
 * auto-generated code
 * Sat Sep 05 16:17:17 CST 2009
 */
package com.gmcc.pboss.business.resource.resloadparam;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ResloadparamDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResloadparamDBParam extends DBQueryParam {
    private String _ne_id;
    private String _se_cityid;
    private String _se_restype;

	/**
     * @return Returns the _ne_id.
     */
    public String get_ne_id() {
        return this._ne_id;
    }
    /**
     * @param _sk_companyname The _ne_id to set.
     */
    public void set_ne_id(String _ne_id) {
        this._ne_id = _ne_id;
    }

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

}
