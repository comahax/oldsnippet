/**
 * auto-generated code
 * Tue Oct 13 14:32:53 CST 2009
 */
package com.gmcc.pboss.business.sales.orderunit;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderunitDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderunitDBParam extends DBQueryParam {
    private String _se_cityid;
    private String _se_comcategory;
    private String _nne_recid;
    private String _se_unitagemode;

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
	public String get_nne_recid() {
		return _nne_recid;
	}
	public void set_nne_recid(String _nne_recid) {
		this._nne_recid = _nne_recid;
	}
	public String get_se_unitagemode() {
		return _se_unitagemode;
	}
	public void set_se_unitagemode(String _se_unitagemode) {
		this._se_unitagemode = _se_unitagemode;
	}

}
