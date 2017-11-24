/**
 * auto-generated code
 * Fri Jul 02 15:54:31 CST 2010
 */
package com.gmcc.pboss.business.cms.examine.rewardasse;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: RewardasseDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardasseDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _ne_rewardtype;

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
     * @return Returns the _ne_rewardtype.
     */
    public String get_ne_rewardtype() {
        return this._ne_rewardtype;
    }
    /**
     * @param _sk_companyname The _ne_rewardtype to set.
     */
    public void set_ne_rewardtype(String _ne_rewardtype) {
        this._ne_rewardtype = _ne_rewardtype;
    }

}
