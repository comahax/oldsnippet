/**
 * auto-generated code
 * Wed Jul 08 10:58:48 CST 2009
 */
package com.gmcc.pboss.business.channel.servcent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ServcentDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class ServcentDBParam extends DBQueryParam {
    private String _se_svccode;
    private String _se_countyid;

	/**
     * @return Returns the _se_svccode.
     */
    public String get_se_svccode() {
        return this._se_svccode;
    }
    /**
     * @param _sk_companyname The _se_svccode to set.
     */
    public void set_se_svccode(String _se_svccode) {
        this._se_svccode = _se_svccode;
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

}
