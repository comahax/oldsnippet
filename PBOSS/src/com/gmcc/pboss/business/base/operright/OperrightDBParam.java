/**
 * auto-generated code
 * Mon Jul 13 10:33:51 CST 2009
 */
package com.gmcc.pboss.business.base.operright;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OperrightDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public class OperrightDBParam extends DBQueryParam {
    private String _se_operid;
    private String _se_rightid;
    private String _dnl_statusdate;
    private String _dnm_statusdate;

    private String _querytext;
    
	public String get_querytext() {
		return _querytext;
	}
	public void set_querytext(String _querytext) {
		this._querytext = _querytext;
	}
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
	public String get_dnl_statusdate() {
		return _dnl_statusdate;
	}
	public void set_dnl_statusdate(String _dnl_statusdate) {
		this._dnl_statusdate = _dnl_statusdate;
	}
	public String get_dnm_statusdate() {
		return _dnm_statusdate;
	}
	public void set_dnm_statusdate(String _dnm_statusdate) {
		this._dnm_statusdate = _dnm_statusdate;
	}

}
