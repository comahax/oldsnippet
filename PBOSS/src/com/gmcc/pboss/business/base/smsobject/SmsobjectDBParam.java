/**
 * auto-generated code
 * Tue Jul 05 09:55:04 CST 2011
 */
package com.gmcc.pboss.business.base.smsobject;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: SmsobjectDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class SmsobjectDBParam extends DBQueryParam {
    private String _se_countyid;

    private String _se_objecttype;

    private String _se_busitype;


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
     * @return Returns the _se_objecttype.
     */
    public String get_se_objecttype() {
        return this._se_objecttype;
    }
    /**
     * @param _sk_companyname The _se_objecttype to set.
     */
    public void set_se_objecttype(String _se_objecttype) {
        this._se_objecttype = _se_objecttype;
    }
	public String get_se_busitype() {
		return _se_busitype;
	}
	public void set_se_busitype(String _se_busitype) {
		this._se_busitype = _se_busitype;
	}

}
