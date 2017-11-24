/**
* auto-generated code
* Fri Aug 11 18:21:13 CST 2006
*/
package com.sunrise.boss.business.common.managelog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;


/**
 * <p>Title: ManagelogListVO</p>
 * <p>Description: Query Params Object for ManagelogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy,wgy
 * @version 1.0
 */
public class ManageLogListVO extends BaseListVO {

	private String _se_oprtype;
	private String _se_opraction;
	private String _se_oprcode;
	private String _dnm_oprtime;
	private String _dnl_oprtime;
	
	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}
	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}
	public String get_dnm_oprtime() {
		return _dnm_oprtime;
	}
	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}
	public String get_se_opraction() {
		return _se_opraction;
	}
	public void set_se_opraction(String _se_opraction) {
		this._se_opraction = _se_opraction;
	}
	public String get_se_oprcode() {
		return _se_oprcode;
	}
	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}
	public String get_se_oprtype() {
		return _se_oprtype;
	}
	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

}
