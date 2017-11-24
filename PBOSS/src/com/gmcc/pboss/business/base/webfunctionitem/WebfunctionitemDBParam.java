/**
 * auto-generated code
 * Tue Dec 07 10:33:29 CST 2010
 */
package com.gmcc.pboss.business.base.webfunctionitem;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: WebfunctionitemDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WebfunctionitemDBParam extends DBQueryParam {
    private String _se_funcid;
    private String _ne_status;
    private String _dnm_statusdate;
    private String _dnl_statusdate;
    private String _se_parentid;

	/**
     * @return Returns the _se_funcid.
     */
    public String get_se_funcid() {
        return this._se_funcid;
    }
    /**
     * @param _sk_companyname The _se_funcid to set.
     */
    public void set_se_funcid(String _se_funcid) {
        this._se_funcid = _se_funcid;
    }

	/**
     * @return Returns the _ne_status.
     */
    public String get_ne_status() {
        return this._ne_status;
    }
    /**
     * @param _sk_companyname The _ne_status to set.
     */
    public void set_ne_status(String _ne_status) {
        this._ne_status = _ne_status;
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
	public String get_se_parentid() {
		return _se_parentid;
	}
	public void set_se_parentid(String _se_parentid) {
		this._se_parentid = _se_parentid;
	}

}
