/**
 * auto-generated code
 * Fri Oct 20 20:01:29 CST 2006
 */
package com.sunrise.boss.business.rightmanage.operrole.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: ListVO
 * </p>
 * <p>
 * Description: Query Params Object for DAO
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
public class OperroleListVO extends BaseListVO {
	private String _se_operid;

	private String _se_roleid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private Byte _ne_status;
	
	private List _sin_roleid;

	public List get_sin_roleid() {
		return _sin_roleid;
	}

	public void set_sin_roleid(List _sin_roleid) {
		this._sin_roleid = _sin_roleid;
	}

	public String get_dnl_createdate() {
		return _dnl_createdate;
	}

	public void set_dnl_createdate(String _dnl_createdate) {
		this._dnl_createdate = _dnl_createdate;
	}

	public String get_dnm_createdate() {
		return _dnm_createdate;
	}

	public void set_dnm_createdate(String _dnm_createdate) {
		this._dnm_createdate = _dnm_createdate;
	}

	public Byte get_ne_status() {
		return _ne_status;
	}

	public void set_ne_status(Byte _ne_status) {
		this._ne_status = _ne_status;
	}

	public String get_se_operid() {
		return _se_operid;
	}

	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}

	public String get_se_roleid() {
		return _se_roleid;
	}

	public void set_se_roleid(String _se_roleid) {
		this._se_roleid = _se_roleid;
	}

}
