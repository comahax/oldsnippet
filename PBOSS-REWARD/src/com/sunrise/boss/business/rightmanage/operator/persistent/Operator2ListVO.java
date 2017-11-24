/**
 * auto-generated code
 * Sat Oct 21 10:49:43 CST 2006
 */
package com.sunrise.boss.business.rightmanage.operator.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: OperatorListVO
 * </p>
 * <p>
 * Description: Query Params Object for OperatorDAO
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
public class Operator2ListVO extends BaseListVO {
	private String _se_operid;

	private String _ne_region;

	private String _se_opername;

	private String _se_opergroup;

	private String _se_opertype;

	private String _se_operlevel;

	private String _ne_ismanager;

	private String _se_orgid;

	public String get_ne_ismanager() {
		return _ne_ismanager;
	}

	public void set_ne_ismanager(String _ne_ismanager) {
		this._ne_ismanager = _ne_ismanager;
	}

	public String get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}

	public String get_se_opergroup() {
		return _se_opergroup;
	}

	public void set_se_opergroup(String _se_opergroup) {
		this._se_opergroup = _se_opergroup;
	}

	public String get_se_operid() {
		return _se_operid;
	}

	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}

	public String get_se_operlevel() {
		return _se_operlevel;
	}

	public void set_se_operlevel(String _se_operlevel) {
		this._se_operlevel = _se_operlevel;
	}

	public String get_se_opername() {
		return _se_opername;
	}

	public void set_se_opername(String _se_opername) {
		this._se_opername = _se_opername;
	}

	public String get_se_opertype() {
		return _se_opertype;
	}

	public void set_se_opertype(String _se_opertype) {
		this._se_opertype = _se_opertype;
	}

	public String get_se_orgid() {
		return _se_orgid;
	}

	public void set_se_orgid(String _se_orgid) {
		this._se_orgid = _se_orgid;
	}

}
