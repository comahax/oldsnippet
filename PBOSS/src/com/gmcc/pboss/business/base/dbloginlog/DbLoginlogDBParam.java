/**
 * auto-generated code
 * Wed Sep 21 15:48:49 CST 2011
 */
package com.gmcc.pboss.business.base.dbloginlog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: DbLoginlogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class DbLoginlogDBParam extends DBQueryParam {
    private String _se_oprcode;
    private String _dnm_logintime;
    private String _dnl_logintime;
    private String _se_ipaddress;
    private String _se_cityid;

	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}
	/**
     * @return Returns the _se_oprcode.
     */
    public String get_se_oprcode() {
        return this._se_oprcode;
    }
    /**
     * @param _sk_companyname The _se_oprcode to set.
     */
    public void set_se_oprcode(String _se_oprcode) {
        this._se_oprcode = _se_oprcode;
    }

	/**
     * @return Returns the _dnm_logintime.
     */
    public String get_dnm_logintime() {
        return this._dnm_logintime;
    }
    /**
     * @param _sk_companyname The _dnm_logintime to set.
     */
    public void set_dnm_logintime(String _dnm_logintime) {
        this._dnm_logintime = _dnm_logintime;
    }

	/**
     * @return Returns the _dnl_logintime.
     */
    public String get_dnl_logintime() {
        return this._dnl_logintime;
    }
    /**
     * @param _sk_companyname The _dnl_logintime to set.
     */
    public void set_dnl_logintime(String _dnl_logintime) {
        this._dnl_logintime = _dnl_logintime;
    }

	/**
     * @return Returns the _se_ipaddress.
     */
    public String get_se_ipaddress() {
        return this._se_ipaddress;
    }
    /**
     * @param _sk_companyname The _se_ipaddress to set.
     */
    public void set_se_ipaddress(String _se_ipaddress) {
        this._se_ipaddress = _se_ipaddress;
    }

}
