/**
 * auto-generated code
 * Fri Oct 20 01:01:43 CST 2006
 */
package com.sunrise.boss.business.rightmanage.operright.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: SaSrOperrightListVO
 * </p>
 * <p>
 * Description: Query Params Object for SaSrOperrightDAO
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
public class OperrightListVO extends BaseListVO {
	private String _se_operid;

	private String _se_rightid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private String _ne_status;

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

	public String get_ne_status() {
		return _ne_status;
	}

	public void set_ne_status(String _ne_status) {
		this._ne_status = _ne_status;
	}

	public String get_se_operid() {
		return _se_operid;
	}

	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}

	public String get_se_rightid() {
		return _se_rightid;
	}

	public void set_se_rightid(String _se_rightid) {
		this._se_rightid = _se_rightid;
	}

}
