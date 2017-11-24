/**
 * auto-generated code
 * Fri Oct 02 10:38:11 CST 2009
 */
package com.gmcc.pboss.business.resource.resdisform;

import java.util.Collection;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ResdisformDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResdisformDBParam extends DBQueryParam {
    private String _se_disid;
    private String _se_discomcode;
    private String _se_storarea;
    private String _dnm_distime;
    private String _dnl_distime;
    private String _se_disformstate;
    
    private Collection _sin_logiscode;

	public Collection get_sin_logiscode() {
		return _sin_logiscode;
	}
	public void set_sin_logiscode(Collection _sin_logiscode) {
		this._sin_logiscode = _sin_logiscode;
	}
	/**
     * @return Returns the _se_disid.
     */
    public String get_se_disid() {
        return this._se_disid;
    }
    /**
     * @param _sk_companyname The _se_disid to set.
     */
    public void set_se_disid(String _se_disid) {
        this._se_disid = _se_disid;
    }

	/**
     * @return Returns the _se_discomcode.
     */
    public String get_se_discomcode() {
        return this._se_discomcode;
    }
    /**
     * @param _sk_companyname The _se_discomcode to set.
     */
    public void set_se_discomcode(String _se_discomcode) {
        this._se_discomcode = _se_discomcode;
    }

	/**
     * @return Returns the _se_storarea.
     */
    public String get_se_storarea() {
        return this._se_storarea;
    }
    /**
     * @param _sk_companyname The _se_storarea to set.
     */
    public void set_se_storarea(String _se_storarea) {
        this._se_storarea = _se_storarea;
    }

	/**
     * @return Returns the _dnm_distime.
     */
    public String get_dnm_distime() {
        return this._dnm_distime;
    }
    /**
     * @param _sk_companyname The _dnm_distime to set.
     */
    public void set_dnm_distime(String _dnm_distime) {
        this._dnm_distime = _dnm_distime;
    }

	/**
     * @return Returns the _dnl_distime.
     */
    public String get_dnl_distime() {
        return this._dnl_distime;
    }
    /**
     * @param _sk_companyname The _dnl_distime to set.
     */
    public void set_dnl_distime(String _dnl_distime) {
        this._dnl_distime = _dnl_distime;
    }

	/**
     * @return Returns the _se_disformstate.
     */
    public String get_se_disformstate() {
        return this._se_disformstate;
    }
    /**
     * @param _sk_companyname The _se_disformstate to set.
     */
    public void set_se_disformstate(String _se_disformstate) {
        this._se_disformstate = _se_disformstate;
    }

}
