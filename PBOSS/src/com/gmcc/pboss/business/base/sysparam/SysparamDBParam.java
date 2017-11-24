/**
 * auto-generated code
 * Wed Sep 02 17:01:06 CST 2009
 */
package com.gmcc.pboss.business.base.sysparam;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: SysparamDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class SysparamDBParam extends DBQueryParam {
    private String _ne_systemid;
    private String _se_paramtype;
    private String _sk_paramname;
	public String get_ne_systemid() {
		return _ne_systemid;
	}
	public void set_ne_systemid(String _ne_systemid) {
		this._ne_systemid = _ne_systemid;
	}
	public String get_se_paramtype() {
		return _se_paramtype;
	}
	public void set_se_paramtype(String _se_paramtype) {
		this._se_paramtype = _se_paramtype;
	}
	public String get_sk_paramname() {
		return _sk_paramname;
	}
	public void set_sk_paramname(String _sk_paramname) {
		this._sk_paramname = _sk_paramname;
	}

}
