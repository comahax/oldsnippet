/**
 * auto-generated code
 * Wed Jul 01 17:30:11 CST 2009
 */
package com.gmcc.pboss.business.channel.waycompact;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: WaycompactDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class WaycompactDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _ne_logid;
    private String _dnm_optime;
    private String _dnl_optime;
    private String _se_oprcode;
    private String _se_success;

	public String get_ne_logid() {
		return _ne_logid;
	}
	public void set_ne_logid(String _ne_logid) {
		this._ne_logid = _ne_logid;
	}
	public String get_dnm_optime() {
		return _dnm_optime;
	}
	public void set_dnm_optime(String _dnm_optime) {
		this._dnm_optime = _dnm_optime;
	}
	public String get_dnl_optime() {
		return _dnl_optime;
	}
	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}
	public String get_se_oprcode() {
		return _se_oprcode;
	}
	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}
	public String get_se_success() {
		return _se_success;
	}
	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}
	/**
     * @return Returns the _se_wayid.
     */
    public String get_se_wayid() {
        return this._se_wayid;
    }
    /**
     * @param _sk_companyname The _se_wayid to set.
     */
    public void set_se_wayid(String _se_wayid) {
        this._se_wayid = _se_wayid;
    }

}
