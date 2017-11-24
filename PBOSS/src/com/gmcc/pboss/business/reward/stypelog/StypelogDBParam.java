package com.gmcc.pboss.business.reward.stypelog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: StypelogDBParam </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class StypelogDBParam extends DBQueryParam {
    private String _ne_logid;
    private String _dnm_optime;
    private String _dnl_optime;
    private String _se_oprcode;
    private String _se_oprtype;
    private String _se_ltype;
    private String _se_cityid;

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
     * @return Returns the _se_ltype.
     */
    public String get_se_ltype() {
        return this._se_ltype;
    }
    /**
     * @param _sk_companyname The _se_ltype to set.
     */
    public void set_se_ltype(String _se_ltype) {
        this._se_ltype = _se_ltype;
    }

	/**
     * @return Returns the _se_cityid.
     */
    public String get_se_cityid() {
        return this._se_cityid;
    }
    /**
     * @param _sk_companyname The _se_cityid to set.
     */
    public void set_se_cityid(String _se_cityid) {
        this._se_cityid = _se_cityid;
    }

}
