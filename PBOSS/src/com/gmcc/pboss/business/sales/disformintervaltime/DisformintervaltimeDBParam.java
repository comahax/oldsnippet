/**
 * auto-generated code
 * Sat Mar 31 17:39:06 CST 2012
 */
package com.gmcc.pboss.business.sales.disformintervaltime;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: DisformintervaltimeDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformintervaltimeDBParam extends DBQueryParam {
    private String _se_countyid;
    private String _se_mareacode;
    private String _ne_starlevel;
    private String _dnm_createtime;
    private String _dnl_createtime;

	public String get_dnm_createtime() {
		return _dnm_createtime;
	}
	public void set_dnm_createtime(String _dnm_createtime) {
		this._dnm_createtime = _dnm_createtime;
	}
	public String get_dnl_createtime() {
		return _dnl_createtime;
	}
	public void set_dnl_createtime(String _dnl_createtime) {
		this._dnl_createtime = _dnl_createtime;
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
     * @return Returns the _se_mareacode.
     */
    public String get_se_mareacode() {
        return this._se_mareacode;
    }
    /**
     * @param _sk_companyname The _se_mareacode to set.
     */
    public void set_se_mareacode(String _se_mareacode) {
        this._se_mareacode = _se_mareacode;
    }

	/**
     * @return Returns the _ne_starlevel.
     */
    public String get_ne_starlevel() {
        return this._ne_starlevel;
    }
    /**
     * @param _sk_companyname The _ne_starlevel to set.
     */
    public void set_ne_starlevel(String _ne_starlevel) {
        this._ne_starlevel = _ne_starlevel;
    }

}
