/**
 * auto-generated code
 * Wed Oct 07 16:55:22 CST 2009
 */
package com.gmcc.pboss.business.channel.employeelog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: EmployeelogDBParam
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
 * @author wefrogll
 * @version 1.0
 */
public class EmployeelogDBParam extends DBQueryParam {
	private String _ne_logid;
	private String _dnm_optime;
	private String _dnl_optime;
	private String _se_oprcode;
	private String _se_success;
	private String _sql_waycondition;
	private String _se_waytype;
	private String _se_oprtype;
	private String _se_posittype;

	public String get_se_waytype() {
		return _se_waytype;
	}

	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
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

	public String get_sql_waycondition() {
		return _sql_waycondition;
	}

	public void set_sql_waycondition(String _sql_waycondition) {
		this._sql_waycondition = _sql_waycondition;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_posittype() {
		return _se_posittype;
	}

	public void set_se_posittype(String _se_posittype) {
		this._se_posittype = _se_posittype;
	}
}
