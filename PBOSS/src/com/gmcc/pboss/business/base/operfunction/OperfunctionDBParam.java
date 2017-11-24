/**
 * auto-generated code
 * Tue Sep 08 16:02:06 CST 2009
 */
package com.gmcc.pboss.business.base.operfunction;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OperfunctionDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OperfunctionDBParam extends DBQueryParam {
    private String _se_operid;
    private String _se_functionid;
    private String _dnm_statusdate;
    private String _dnl_statusdate;

	/**
     * @return Returns the _se_operid.
     */
    public String get_se_operid() {
        return this._se_operid;
    }
    /**
     * @param _sk_companyname The _se_operid to set.
     */
    public void set_se_operid(String _se_operid) {
        this._se_operid = _se_operid;
    }

	/**
     * @return Returns the _se_functionid.
     */
    public String get_se_functionid() {
        return this._se_functionid;
    }
    /**
     * @param _sk_companyname The _se_functionid to set.
     */
    public void set_se_functionid(String _se_functionid) {
        this._se_functionid = _se_functionid;
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
