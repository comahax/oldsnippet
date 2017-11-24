/**
 * auto-generated code
 * Wed Jul 08 10:58:01 CST 2009
 */
package com.gmcc.pboss.business.channel.cntycompany;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: CntycompanyDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class CntycompanyDBParam extends DBQueryParam {
    private String _se_countycompid;
    private String _se_citycompid;
    private String _sk_countycompid;

	public String get_sk_countycompid() {
		return _sk_countycompid;
	}
	public void set_sk_countycompid(String _sk_countycompid) {
		this._sk_countycompid = _sk_countycompid;
	}
	/**
     * @return Returns the _se_countycompid.
     */
    public String get_se_countycompid() {
        return this._se_countycompid;
    }
    /**
     * @param _sk_companyname The _se_countycompid to set.
     */
    public void set_se_countycompid(String _se_countycompid) {
        this._se_countycompid = _se_countycompid;
    }

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

}
