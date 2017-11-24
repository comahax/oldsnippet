/**
* auto-generated code
* Fri Aug 11 16:47:18 CST 2006
*/
package com.sunrise.boss.business.common.sysparam.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: SysparamDBParam</p>
 * <p>Description: Query Params Object for SysparamDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author pmf
 * @version 1.0
 */
public class SysparamDBParam extends DBQueryParam {

	private String _ne_systemid;
	private String _se_paramtype;
	private String _ne_region;

	public String get_ne_region() {
		return _ne_region;
	}
	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}
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
}
