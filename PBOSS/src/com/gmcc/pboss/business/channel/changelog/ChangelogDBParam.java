/**
 * auto-generated code
 * Wed May 18 19:21:10 CST 2011
 */
package com.gmcc.pboss.business.channel.changelog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ChangelogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChangelogDBParam extends DBQueryParam {
    private String _ne_logid;
    private String _dnm_optime;
    private String _dnl_optime;
    private String _sk_oprcode;
    private String _sk_oprtype;
    private String _sk_wayid;
    private String _se_wayid;
    private String _ne_changetype;

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
     * @return Returns the _dnm_optime.
     */
    public String get_dnm_optime() {
        return this._dnm_optime;
    }
    /**
     * @param _sk_companyname The _dnm_optime to set.
     */
    public void set_dnm_optime(String _dnm_optime) {
        this._dnm_optime = _dnm_optime;
    }

	/**
     * @return Returns the _dnl_optime.
     */
    public String get_dnl_optime() {
        return this._dnl_optime;
    }
    /**
     * @param _sk_companyname The _dnl_optime to set.
     */
    public void set_dnl_optime(String _dnl_optime) {
        this._dnl_optime = _dnl_optime;
    }

	/**
     * @return Returns the _sk_oprcode.
     */
    public String get_sk_oprcode() {
        return this._sk_oprcode;
    }
    /**
     * @param _sk_companyname The _sk_oprcode to set.
     */
    public void set_sk_oprcode(String _sk_oprcode) {
        this._sk_oprcode = _sk_oprcode;
    }

	/**
     * @return Returns the _sk_oprtype.
     */
    public String get_sk_oprtype() {
        return this._sk_oprtype;
    }
    /**
     * @param _sk_companyname The _sk_oprtype to set.
     */
    public void set_sk_oprtype(String _sk_oprtype) {
        this._sk_oprtype = _sk_oprtype;
    }

	/**
     * @return Returns the _sk_wayid.
     */
    public String get_sk_wayid() {
        return this._sk_wayid;
    }
    /**
     * @param _sk_companyname The _sk_wayid to set.
     */
    public void set_sk_wayid(String _sk_wayid) {
        this._sk_wayid = _sk_wayid;
    }

	/**
     * @return Returns the _ne_changetype.
     */
    public String get_ne_changetype() {
        return this._ne_changetype;
    }
    /**
     * @param _sk_companyname The _ne_changetype to set.
     */
    public void set_ne_changetype(String _ne_changetype) {
        this._ne_changetype = _ne_changetype;
    }
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

}
