package com.gmcc.pboss.business.resource.resalarmrulelog;


import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ResalarmrulelogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarmrulelogDBParam extends DBQueryParam {
    private String _se_success;
    private String _se_cityid;
    private String _se_countyid;
    private String _se_comcategory;
    private String _nnm_upactrate;
    private String _nnl_upactrate;
    private String _se_handlercode;

	/**
     * @return Returns the _se_success.
     */
    public String get_se_success() {
        return this._se_success;
    }
    /**
     * @param _sk_companyname The _se_success to set.
     */
    public void set_se_success(String _se_success) {
        this._se_success = _se_success;
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

	/**
     * @return Returns the _se_comcategory.
     */
    public String get_se_comcategory() {
        return this._se_comcategory;
    }
    /**
     * @param _sk_companyname The _se_comcategory to set.
     */
    public void set_se_comcategory(String _se_comcategory) {
        this._se_comcategory = _se_comcategory;
    }

	/**
     * @return Returns the _nnm_upactrate.
     */
    public String get_nnm_upactrate() {
        return this._nnm_upactrate;
    }
    /**
     * @param _sk_companyname The _nnm_upactrate to set.
     */
    public void set_nnm_upactrate(String _nnm_upactrate) {
        this._nnm_upactrate = _nnm_upactrate;
    }

	/**
     * @return Returns the _nnl_upactrate.
     */
    public String get_nnl_upactrate() {
        return this._nnl_upactrate;
    }
    /**
     * @param _sk_companyname The _nnl_upactrate to set.
     */
    public void set_nnl_upactrate(String _nnl_upactrate) {
        this._nnl_upactrate = _nnl_upactrate;
    }

	/**
     * @return Returns the _se_handlercode.
     */
    public String get_se_handlercode() {
        return this._se_handlercode;
    }
    /**
     * @param _sk_companyname The _se_handlercode to set.
     */
    public void set_se_handlercode(String _se_handlercode) {
        this._se_handlercode = _se_handlercode;
    }

}
