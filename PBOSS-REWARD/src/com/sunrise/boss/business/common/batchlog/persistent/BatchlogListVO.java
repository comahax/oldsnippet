package com.sunrise.boss.business.common.batchlog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: BatchlogListVO
 * </p>
 * <p>
 * Description: Query Params Object for BatchlogDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author liminghao
 * @version 1.0
 */
public class BatchlogListVO extends BaseListVO {
	private String _se_logid;

	private String _se_optime;

	private String _se_oprtype;

	private String _se_oprcode;

	private String _se_oprwayid;

	private String _se_success;

	private String _se_batchname;

	private String _se_uploadpath;

	private String _se_resultpath;

	private String _dnl_optime;

	private String _dnm_optime;

	private String _sk_batchname;

	public String get_se_logid() {
		return _se_logid;
	}

	public String get_se_optime() {
		return _se_optime;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public String get_se_oprwayid() {
		return _se_oprwayid;
	}

	public String get_se_success() {
		return _se_success;
	}

	public String get_se_batchname() {
		return _se_batchname;
	}

	public String get_se_uploadpath() {
		return _se_uploadpath;
	}

	public String get_se_resultpath() {
		return _se_resultpath;
	}

	public void set_se_logid(String _se_logid) {
		this._se_logid = _se_logid;
	}

	public void set_se_optime(String _se_optime) {
		this._se_optime = _se_optime;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public void set_se_oprwayid(String _se_oprwayid) {
		this._se_oprwayid = _se_oprwayid;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public void set_se_batchname(String _se_batchname) {
		this._se_batchname = _se_batchname;
	}

	public void set_se_uploadpath(String _se_uploadpath) {
		this._se_uploadpath = _se_uploadpath;
	}

	public void set_se_resultpath(String _se_resultpath) {
		this._se_resultpath = _se_resultpath;
	}

	public String get_sk_batchname() {
		return _sk_batchname;
	}

	public void set_sk_batchname(String _sk_batchname) {
		this._sk_batchname = _sk_batchname;
	}

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		this._dnm_optime = _dnm_optime;
	}

}
