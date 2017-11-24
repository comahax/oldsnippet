/**
 * auto-generated code
 * Tue Sep 15 10:39:05 CST 2009
 */
package com.gmcc.pboss.business.promotion.promotingwayid;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: PromotingwayidDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PromotingwayidDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _ne_pid;
    private String _ne_ruleid;

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
     * @return Returns the _ne_pid.
     */
    public String get_ne_pid() {
        return this._ne_pid;
    }
    /**
     * @param _sk_companyname The _ne_pid to set.
     */
    public void set_ne_pid(String _ne_pid) {
        this._ne_pid = _ne_pid;
    }

	/**
     * @return Returns the _ne_ruleid.
     */
    public String get_ne_ruleid() {
        return this._ne_ruleid;
    }
    /**
     * @param _sk_companyname The _ne_ruleid to set.
     */
    public void set_ne_ruleid(String _ne_ruleid) {
        this._ne_ruleid = _ne_ruleid;
    }

}
