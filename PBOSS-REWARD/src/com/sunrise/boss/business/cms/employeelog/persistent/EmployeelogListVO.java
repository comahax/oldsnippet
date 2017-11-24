/**
 * auto-generated code Tue Oct 24 17:27:56 CST 2006
 */
package com.sunrise.boss.business.cms.employeelog.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: EmployeelogListVO
 * </p>
 * <p>
 * Description: Query Params Object for EmployeelogDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author He Kun
 * @version 1.0
 */
public class EmployeelogListVO extends BaseListVO {
	private String _dnl_optime;

	private String _dnm_optime;

	private String _sk_oprcode;

	private String _se_oprcode;

	private String _se_oprtype;

	private String _se_success;

	private String _se_waytype;

	private String _sql_waycondition;

	private List _nin_station;

	private List _nnin_station;

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

	public String get_sk_oprcode() {
		return _sk_oprcode;
	}

	public void set_sk_oprcode(String _sk_oprcode) {
		this._sk_oprcode = _sk_oprcode;
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

	public String get_se_success() {
		return _se_success;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public String get_se_waytype() {
		return _se_waytype;
	}

	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}

	public List get_nin_station() {
		return _nin_station;
	}

	public void set_nin_station(List _nin_station) {
		this._nin_station = _nin_station;
	}

	public List get_nnin_station() {
		return _nnin_station;
	}

	public void set_nnin_station(List _nnin_station) {
		this._nnin_station = _nnin_station;
	}

	public String get_sql_waycondition() {
		return _sql_waycondition;
	}

	public void set_sql_waycondition(String _sql_waycondition) {
		this._sql_waycondition = _sql_waycondition;
	}

}
