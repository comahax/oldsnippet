/**
 * auto-generated code
 * Sun Oct 18 20:23:20 CST 2009
 */
package com.gmcc.pboss.business.channel.waylog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: WaylogDBParam
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class WaylogDBParam extends DBQueryParam {
	private String _se_wayid;
	private String _se_wayname;
	private String _ne_waystate;
	private String _ne_logid;
	private String _dnm_optime;
	private String _dnl_optime;
	private String _se_oprcode;
	private String _se_success;
	private String _se_waytype;
	private String _se_waysubtype;
	private String _sql_waysubtype;
	private String _se_oprtype;
	/**
	 * @return Returns the _se_wayid.
	 */
	public String get_se_wayid() {
		return this._se_wayid;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_wayid to set.
	 */
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	/**
	 * @return Returns the _ne_waystate.
	 */
	public String get_ne_waystate() {
		return this._ne_waystate;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_waystate to set.
	 */
	public void set_ne_waystate(String _ne_waystate) {
		this._ne_waystate = _ne_waystate;
	}

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

	public String get_se_waytype() {
		return _se_waytype;
	}

	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}

	public String get_se_waysubtype() {
		return _se_waysubtype;
	}

	public void set_se_waysubtype(String _se_waysubtype) {
		this._se_waysubtype = _se_waysubtype;
	}

	public String get_sql_waysubtype() {
		return _sql_waysubtype;
	}

	public void set_sql_waysubtype(String _sql_waysubtype) {
		this._sql_waysubtype = _sql_waysubtype;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_wayname() {
		return _se_wayname;
	}

	public void set_se_wayname(String _se_wayname) {
		this._se_wayname = _se_wayname;
	}

}
