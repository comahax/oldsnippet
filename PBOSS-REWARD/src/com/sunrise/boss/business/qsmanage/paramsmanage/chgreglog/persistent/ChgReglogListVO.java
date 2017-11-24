/**
* auto-generated code
* Fri Jul 11 10:07:46 CST 2008
*/
package com.sunrise.boss.business.qsmanage.paramsmanage.chgreglog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChgReglogListVO</p>
 * <p>Description: Query Params Object for ChgReglogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChgReglogListVO extends BaseListVO {
	private String _ne_reqid;
	private String _se_chgcode;
	private String _se_tabname;
	private String _dnm_chgtime;
	private String _dnl_chgtime;
	public String get_dnl_chgtime() {
		return _dnl_chgtime;
	}
	public void set_dnl_chgtime(String _dnl_chgtime) {
		this._dnl_chgtime = _dnl_chgtime;
	}
	public String get_dnm_chgtime() {
		return _dnm_chgtime;
	}
	public void set_dnm_chgtime(String _dnm_chgtime) {
		this._dnm_chgtime = _dnm_chgtime;
	}
	public String get_ne_reqid() {
		return _ne_reqid;
	}
	public void set_ne_reqid(String _ne_reqid) {
		this._ne_reqid = _ne_reqid;
	}
	public String get_se_chgcode() {
		return _se_chgcode;
	}
	public void set_se_chgcode(String _se_chgcode) {
		this._se_chgcode = _se_chgcode;
	}
	public String get_se_tabname() {
		return _se_tabname;
	}
	public void set_se_tabname(String _se_tabname) {
		this._se_tabname = _se_tabname;
	}

}
