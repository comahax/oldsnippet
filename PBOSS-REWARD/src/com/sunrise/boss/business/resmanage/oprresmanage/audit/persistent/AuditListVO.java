/**
* auto-generated code
* Mon Jun 02 17:52:17 CST 2008
*/
package com.sunrise.boss.business.resmanage.oprresmanage.audit.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AuditListVO</p>
 * <p>Description: Query Params Object for AuditDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditListVO extends BaseListVO {
	private String _se_auditoprcode;
	private String _ne_state;
	private String _dnl_createtime;
	private String _dnm_createtime;
	private String _se_sheetid;
	private String _se_inoprcode;
	
	public String get_se_inoprcode() {
		return _se_inoprcode;
	}
	public void set_se_inoprcode(String _se_inoprcode) {
		this._se_inoprcode = _se_inoprcode;
	}
	public String get_se_sheetid() {
		return _se_sheetid;
	}
	public void set_se_sheetid(String _se_sheetid) {
		this._se_sheetid = _se_sheetid;
	}
	public String get_dnl_createtime() {
		return _dnl_createtime;
	}
	public void set_dnl_createtime(String _dnl_createtime) {
		this._dnl_createtime = _dnl_createtime;
	}
	public String get_dnm_createtime() {
		return _dnm_createtime;
	}
	public void set_dnm_createtime(String _dnm_createtime) {
		this._dnm_createtime = _dnm_createtime;
	}
	public String get_ne_state() {
		return _ne_state;
	}
	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}
	public String get_se_auditoprcode() {
		return _se_auditoprcode;
	}
	public void set_se_auditoprcode(String _se_auditoprcode) {
		this._se_auditoprcode = _se_auditoprcode;
	}
	
}
