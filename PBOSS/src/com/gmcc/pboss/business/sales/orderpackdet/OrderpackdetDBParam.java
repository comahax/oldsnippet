/**
 * auto-generated code
 * Tue Oct 13 14:59:20 CST 2009
 */
package com.gmcc.pboss.business.sales.orderpackdet;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderpackdetDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderpackdetDBParam extends DBQueryParam {
    private String _se_orderid;
    private String _se_comcategory;
    private String _se_batchno;
    private String _se_boxnum;

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
     * @return Returns the _se_batchno.
     */
    public String get_se_batchno() {
        return this._se_batchno;
    }
    /**
     * @param _sk_companyname The _se_batchno to set.
     */
    public void set_se_batchno(String _se_batchno) {
        this._se_batchno = _se_batchno;
    }

	/**
     * @return Returns the _se_boxnum.
     */
    public String get_se_boxnum() {
        return this._se_boxnum;
    }
    /**
     * @param _sk_companyname The _se_boxnum to set.
     */
    public void set_se_boxnum(String _se_boxnum) {
        this._se_boxnum = _se_boxnum;
    }

}
