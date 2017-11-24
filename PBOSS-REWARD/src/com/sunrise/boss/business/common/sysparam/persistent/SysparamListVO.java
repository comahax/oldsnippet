/**
* auto-generated code
* Fri Aug 11 16:47:18 CST 2006
*/
package com.sunrise.boss.business.common.sysparam.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;


/**
 * <p>Title: SysparamListVO</p>
 * <p>Description: Query Params Object for SysparamDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public class SysparamListVO extends BaseListVO {

	private String _ne_systemid;
	private String _sk_paramtype;
	private String _se_paramtype;
	private String _sk_paramname;
	public String get_ne_systemid() {
		return _ne_systemid;
	}
	public void set_ne_systemid(String _ne_systemid) {
		this._ne_systemid = _ne_systemid;
	}
	public String get_sk_paramname() {
		return _sk_paramname;
	}
	public void set_sk_paramname(String _sk_paramname) {
		this._sk_paramname = _sk_paramname;
	}
	public String get_sk_paramtype() {
		return _sk_paramtype;
	}
	public void set_sk_paramtype(String _sk_paramtype) {
		this._sk_paramtype = _sk_paramtype;
	}
	public String get_se_paramtype() {
		return _se_paramtype;
	}
	public void set_se_paramtype(String _se_paramtype) {
		this._se_paramtype = _se_paramtype;
	}
}
