/**
 * auto-generated code
 * Wed Sep 02 14:03:48 CST 2009
 */
package com.gmcc.pboss.business.resource.emptysimlog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: EmptysimlogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class EmptysimlogDBParam extends DBQueryParam {
    private String _dnm_optime;
    private String _de_optime;
    private String _dnl_optime;
    private String _se_oprcode2;
    private String _se_oprtype;
    private String _snm_emptyno;
    private String _snl_emptyno;
    private String _se_wayid;
    private String _ne_simtype;
    private String _ne_usestate;
    private Long _ne_comid;; // 套卡商品标识 

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
     * @return Returns the _de_optime.
     */
    public String get_de_optime() {
        return this._de_optime;
    }
    /**
     * @param _sk_companyname The _de_optime to set.
     */
    public void set_de_optime(String _de_optime) {
        this._de_optime = _de_optime;
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
     * @return Returns the _se_oprcode2.
     */
    public String get_se_oprcode2() {
        return this._se_oprcode2;
    }
    /**
     * @param _sk_companyname The _se_oprcode2 to set.
     */
    public void set_se_oprcode2(String _se_oprcode2) {
        this._se_oprcode2 = _se_oprcode2;
    }

	/**
     * @return Returns the _se_oprtype.
     */
    public String get_se_oprtype() {
        return this._se_oprtype;
    }
    /**
     * @param _sk_companyname The _se_oprtype to set.
     */
    public void set_se_oprtype(String _se_oprtype) {
        this._se_oprtype = _se_oprtype;
    }

	/**
     * @return Returns the _snm_emptyno.
     */
    public String get_snm_emptyno() {
        return this._snm_emptyno;
    }
    /**
     * @param _sk_companyname The _snm_emptyno to set.
     */
    public void set_snm_emptyno(String _snm_emptyno) {
        this._snm_emptyno = _snm_emptyno;
    }

	/**
     * @return Returns the _snl_emptyno.
     */
    public String get_snl_emptyno() {
        return this._snl_emptyno;
    }
    /**
     * @param _sk_companyname The _snl_emptyno to set.
     */
    public void set_snl_emptyno(String _snl_emptyno) {
        this._snl_emptyno = _snl_emptyno;
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
     * @return Returns the _ne_simtype.
     */
    public String get_ne_simtype() {
        return this._ne_simtype;
    }
    /**
     * @param _sk_companyname The _ne_simtype to set.
     */
    public void set_ne_simtype(String _ne_simtype) {
        this._ne_simtype = _ne_simtype;
    }

	/**
     * @return Returns the _ne_usestate.
     */
    public String get_ne_usestate() {
        return this._ne_usestate;
    }
    /**
     * @param _sk_companyname The _ne_usestate to set.
     */
    public void set_ne_usestate(String _ne_usestate) {
        this._ne_usestate = _ne_usestate;
    }
	public Long get_ne_comid() {
		return _ne_comid;
	}
	public void set_ne_comid(Long neComid) {
		_ne_comid = neComid;
	}
}
