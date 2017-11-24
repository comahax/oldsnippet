/**
 * auto-generated code
 * Tue Oct 31 14:19:28 CST 2006
 */
package com.sunrise.boss.business.rightmanage.rightitem.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: RightitemListVO
 * </p>
 * <p>
 * Description: Query Params Object for RightitemDAO
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
public class RightitemListVO extends BaseListVO {
	private String _se_rightid;

	private Long _ne_region;

	private String _se_operid;

	private String _se_rightname;

	private String _se_orgid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private Byte _ne_status;

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

	public Long get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(Long _ne_region) {
		this._ne_region = _ne_region;
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

	public String get_se_orgid() {
		return _se_orgid;
	}

	public void set_se_orgid(String _se_orgid) {
		this._se_orgid = _se_orgid;
	}

	public String get_se_rightid() {
		return _se_rightid;
	}

	public void set_se_rightid(String _se_rightid) {
		this._se_rightid = _se_rightid;
	}

	public String get_se_rightname() {
		return _se_rightname;
	}

	public void set_se_rightname(String _se_rightname) {
		this._se_rightname = _se_rightname;
	}

}
