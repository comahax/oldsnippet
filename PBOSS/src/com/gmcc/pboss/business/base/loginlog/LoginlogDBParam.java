/**
 * auto-generated code
 * Mon Dec 20 10:03:23 CST 2010
 */
package com.gmcc.pboss.business.base.loginlog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: LoginlogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LoginlogDBParam extends DBQueryParam {
    private String _ne_logid;
    private String _se_wayid;
    private String _se_cityid;

	/**
     * @return Returns the _ne_logid.
     */
    public String get_ne_logid() {
        return this._ne_logid;
    }
    /**
     * @param _sk_companyname The _ne_logid to set.
     */
    public void set_ne_logid(String _ne_logid) {
        this._ne_logid = _ne_logid;
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

}
