package com.gmcc.pboss.business.resource.resalarmrule;


import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ResalarmruleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarmruleDBParam extends DBQueryParam {
    private String _se_cityid;
    private String _se_countyid;
    private String _se_comcategory;
    private String _se_handlercode;

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
