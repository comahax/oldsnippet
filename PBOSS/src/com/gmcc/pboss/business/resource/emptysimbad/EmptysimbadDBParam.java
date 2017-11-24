/**
 * auto-generated code
 * Wed Jul 16 15:07:03 CST 2014
 */
package com.gmcc.pboss.business.resource.emptysimbad;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: EmptysimbadDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class EmptysimbadDBParam extends DBQueryParam {
	private String _se_emptyno;
	private String _sk_emptyno;
    private String _se_wayid;
    private String _dnm_createtime;
    private String _dnl_createtime;

    public String get_se_emptyno() {
		return _se_emptyno;
	}

	public void set_se_emptyno(String _se_emptyno) {
		this._se_emptyno = _se_emptyno;
	}

	/**
     * @return Returns the _sk_emptyno.
     */
    public String get_sk_emptyno() {
        return this._sk_emptyno;
    }
    /**
     * @param _sk_companyname The _sk_emptyno to set.
     */
    public void set_sk_emptyno(String _sk_emptyno) {
        this._sk_emptyno = _sk_emptyno;
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
     * @return Returns the _dnm_createtime.
     */
    public String get_dnm_createtime() {
        return this._dnm_createtime;
    }
    /**
     * @param _sk_companyname The _dnm_createtime to set.
     */
    public void set_dnm_createtime(String _dnm_createtime) {
        this._dnm_createtime = _dnm_createtime;
    }

	/**
     * @return Returns the _dnl_createtime.
     */
    public String get_dnl_createtime() {
        return this._dnl_createtime;
    }
    /**
     * @param _sk_companyname The _dnl_createtime to set.
     */
    public void set_dnl_createtime(String _dnl_createtime) {
        this._dnl_createtime = _dnl_createtime;
    }

}
