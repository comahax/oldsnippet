/**
 * auto-generated code
 * Tue Sep 01 21:44:37 CST 2009
 */
package com.gmcc.pboss.business.base.roleright;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: RolerightDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class RolerightDBParam extends DBQueryParam {
    private String _se_itemid;
    private String _se_rightid;
    private String _dnm_statusdate;
    private String _dnl_statusdate;

	/**
     * @return Returns the _se_itemid.
     */
    public String get_se_itemid() {
        return this._se_itemid;
    }
    /**
     * @param _sk_companyname The _se_itemid to set.
     */
    public void set_se_itemid(String _se_itemid) {
        this._se_itemid = _se_itemid;
    }

	/**
     * @return Returns the _se_rightid.
     */
    public String get_se_rightid() {
        return this._se_rightid;
    }
    /**
     * @param _sk_companyname The _se_rightid to set.
     */
    public void set_se_rightid(String _se_rightid) {
        this._se_rightid = _se_rightid;
    }

	/**
     * @return Returns the _dnm_statusdate.
     */
    public String get_dnm_statusdate() {
        return this._dnm_statusdate;
    }
    /**
     * @param _sk_companyname The _dnm_statusdate to set.
     */
    public void set_dnm_statusdate(String _dnm_statusdate) {
        this._dnm_statusdate = _dnm_statusdate;
    }

	/**
     * @return Returns the _dnl_statusdate.
     */
    public String get_dnl_statusdate() {
        return this._dnl_statusdate;
    }
    /**
     * @param _sk_companyname The _dnl_statusdate to set.
     */
    public void set_dnl_statusdate(String _dnl_statusdate) {
        this._dnl_statusdate = _dnl_statusdate;
    }

}
