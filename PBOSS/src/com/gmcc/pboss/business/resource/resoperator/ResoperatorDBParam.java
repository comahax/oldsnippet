/**
 * auto-generated code
 * Fri May 25 11:37:59 CST 2012
 */
package com.gmcc.pboss.business.resource.resoperator;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ResoperatorDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ResoperatorDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _se_operid;
    private String _se_cityid;

	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
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
     * @return Returns the _se_operid.
     */
    public String get_se_operid() {
        return this._se_operid;
    }
    /**
     * @param _sk_companyname The _se_operid to set.
     */
    public void set_se_operid(String _se_operid) {
        this._se_operid = _se_operid;
    }

}
