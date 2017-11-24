/**
 * auto-generated code
 * Fri Oct 16 13:35:33 CST 2009
 */
package com.gmcc.pboss.business.sales.ordertask;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrdertaskDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrdertaskDBParam extends DBQueryParam {
    private String _se_cityid;
    private String _se_orderid;
    private String _ne_effective;
    private String _dnm_createtime;
    private String _dnl_createtime;

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
     * @return Returns the _se_orderid.
     */
    public String get_se_orderid() {
        return this._se_orderid;
    }
    /**
     * @param _sk_companyname The _se_orderid to set.
     */
    public void set_se_orderid(String _se_orderid) {
        this._se_orderid = _se_orderid;
    }

	/**
     * @return Returns the _ne_effective.
     */
    public String get_ne_effective() {
        return this._ne_effective;
    }
    /**
     * @param _sk_companyname The _ne_effective to set.
     */
    public void set_ne_effective(String _ne_effective) {
        this._ne_effective = _ne_effective;
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
