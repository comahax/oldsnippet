package com.gmcc.pboss.business.base.role;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: RoleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RoleDBParam extends DBQueryParam{

	private String _se_roleid;
	private String _sk_rolename;
	private String _se_orgid;
	private String _ne_isback;
	private String _ne_status;
 	
	public String get_se_roleid() {
		return _se_roleid;
	}
	public void set_se_roleid(String _se_roleid) {
		this._se_roleid = _se_roleid;
	}
	public String get_sk_rolename() {
		return _sk_rolename;
	}
	public void set_sk_rolename(String _sk_rolename) {
		this._sk_rolename = _sk_rolename;
	}
	public String get_se_orgid() {
		return _se_orgid;
	}
	public void set_se_orgid(String _se_orgid) {
		this._se_orgid = _se_orgid;
	}
	public String get_ne_isback() {
		return _ne_isback;
	}
	public void set_ne_isback(String _ne_isback) {
		this._ne_isback = _ne_isback;
	}
	public String get_ne_status() {
		return _ne_status;
	}
	public void set_ne_status(String _ne_status) {
		this._ne_status = _ne_status;
	}
}
