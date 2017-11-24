/**
 * auto-generated code
 * Wed Apr 28 13:14:56 CST 2010
 */
package com.gmcc.pboss.business.sales.adpaydet;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: AdpaydetDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class AdpaydetDBParam extends DBQueryParam {
    private String _ne_sumid;
    private String _se_orderid;

	/**
     * @return Returns the _ne_sumid.
     */
    public String get_ne_sumid() {
        return this._ne_sumid;
    }
    /**
     * @param _sk_companyname The _ne_sumid to set.
     */
    public void set_ne_sumid(String _ne_sumid) {
        this._ne_sumid = _ne_sumid;
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

}
