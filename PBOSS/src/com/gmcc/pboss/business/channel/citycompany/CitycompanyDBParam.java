/**
 * auto-generated code
 * Wed Jul 08 10:49:25 CST 2009
 */
package com.gmcc.pboss.business.channel.citycompany;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: CitycompanyDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class CitycompanyDBParam extends DBQueryParam {
    private String _se_citycompid;
    private String _se_centerid;

	/**
     * @return Returns the _se_citycompid.
     */
    public String get_se_citycompid() {
        return this._se_citycompid;
    }
    /**
     * @param _sk_companyname The _se_citycompid to set.
     */
    public void set_se_citycompid(String _se_citycompid) {
        this._se_citycompid = _se_citycompid;
    }

	/**
     * @return Returns the _se_centerid.
     */
    public String get_se_centerid() {
        return this._se_centerid;
    }
    /**
     * @param _sk_companyname The _se_centerid to set.
     */
    public void set_se_centerid(String _se_centerid) {
        this._se_centerid = _se_centerid;
    }

}
