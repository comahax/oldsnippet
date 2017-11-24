/**
 * auto-generated code
 * Sat Jun 14 21:14:25 CST 2008
 */
package com.sunrise.boss.business.resmanage.oprresmanage.auditlog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: AuditlogListVO
 * </p>
 * <p>
 * Description: Query Params Object for AuditlogDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class AuditlogListVO extends BaseListVO {

	private String _se_reqoprcode;
	private String _se_auditoprcode;
	private String _se_inoprcode;
	private String _se_outoprcode;
	private String _se_sheetid;
	private String _ne_oprtype;
	private String _dnl_createtime;
	private String _dnm_createtime;
	private String _dnl_audittime;
	private String _dnm_audittime;
	private String _se_wayid;

	public String get_dnl_audittime() {
		return _dnl_audittime;
	}

	public void set_dnl_audittime(String _dnl_audittime) {
		this._dnl_audittime = _dnl_audittime;
	}

	public String get_dnl_createtime() {
		return _dnl_createtime;
	}

	public void set_dnl_createtime(String _dnl_createtime) {
		this._dnl_createtime = _dnl_createtime;
	}

	public String get_dnm_audittime() {
		return _dnm_audittime;
	}

	public void set_dnm_audittime(String _dnm_audittime) {
		this._dnm_audittime = _dnm_audittime;
	}

	public String get_dnm_createtime() {
		return _dnm_createtime;
	}

	public void set_dnm_createtime(String _dnm_createtime) {
		this._dnm_createtime = _dnm_createtime;
	}

	public String get_ne_oprtype() {
		return _ne_oprtype;
	}

	public void set_ne_oprtype(String _ne_oprtype) {
		this._ne_oprtype = _ne_oprtype;
	}

	public String get_se_reqoprcode() {
		return _se_reqoprcode;
	}

	public void set_se_reqoprcode(String _se_reqoprcode) {
		this._se_reqoprcode = _se_reqoprcode;
	}

	public String get_se_sheetid() {
		return _se_sheetid;
	}

	public void set_se_sheetid(String _se_sheetid) {
		this._se_sheetid = _se_sheetid;
	}

	public String get_se_auditoprcode() {
		return _se_auditoprcode;
	}

	public void set_se_auditoprcode(String _se_auditoprcode) {
		this._se_auditoprcode = _se_auditoprcode;
	}

	public String get_se_inoprcode() {
		return _se_inoprcode;
	}

	public void set_se_inoprcode(String _se_inoprcode) {
		this._se_inoprcode = _se_inoprcode;
	}

	public String get_se_outoprcode() {
		return _se_outoprcode;
	}

	public void set_se_outoprcode(String _se_outoprcode) {
		this._se_outoprcode = _se_outoprcode;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

}
