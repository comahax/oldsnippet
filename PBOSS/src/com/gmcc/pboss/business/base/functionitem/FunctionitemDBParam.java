/**
 * auto-generated code
 * Tue Jul 14 14:52:45 CST 2009
 */
package com.gmcc.pboss.business.base.functionitem;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: FunctionitemDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class FunctionitemDBParam extends DBQueryParam {

	private String _se_parentid;
	
	private String _ne_status;
	
	private String _dnl_statusdate;

	public String get_se_parentid() {
		return _se_parentid;
	}

	public void set_se_parentid(String _se_parentid) {
		this._se_parentid = _se_parentid;
	}

	public String get_ne_status() {
		return _ne_status;
	}

	public void set_ne_status(String _ne_status) {
		this._ne_status = _ne_status;
	}

	public String get_dnl_statusdate() {
		return _dnl_statusdate;
	}

	public void set_dnl_statusdate(String _dnl_statusdate) {
		this._dnl_statusdate = _dnl_statusdate;
	}

}
