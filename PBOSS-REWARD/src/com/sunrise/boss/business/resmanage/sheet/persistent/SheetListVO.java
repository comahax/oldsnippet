package com.sunrise.boss.business.resmanage.sheet.persistent;

import java.util.List;

import com.sunrise.boss.business.resmanage.common.excelout.persistent.ResExceloutListVO;

public class SheetListVO extends ResExceloutListVO{
	private String _se_wayid;
	private String _se_sheetid;
	private String _se_salesopr;
	private String _se_oprcode;
	private String _dnl_createtime;
	private String _dnm_createtime;
	private String _ne_sheettype;
	private String _ne_sheetstate;
	private String _ne_hasprinted;
	private String _dnl_oprtime;
	private String _dnm_oprtime;
	private String _ne_sheetrestype;
	private List _nin_sheetstate;


	public String get_dnl_createtime() {
		return _dnl_createtime;
	}

	public void set_dnl_createtime(String _dnl_createtime) {
		this._dnl_createtime = _dnl_createtime;
	}

	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}

	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}

	public String get_dnm_createtime() {
		return _dnm_createtime;
	}

	public void set_dnm_createtime(String _dnm_createtime) {
		this._dnm_createtime = _dnm_createtime;
	}

	public String get_dnm_oprtime() {
		return _dnm_oprtime;
	}

	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}

	public String get_ne_hasprinted() {
		return _ne_hasprinted;
	}

	public void set_ne_hasprinted(String _ne_hasprinted) {
		this._ne_hasprinted = _ne_hasprinted;
	}

	public String get_ne_sheetrestype() {
		return _ne_sheetrestype;
	}

	public void set_ne_sheetrestype(String _ne_sheetrestype) {
		this._ne_sheetrestype = _ne_sheetrestype;
	}

	public String get_ne_sheetstate() {
		return _ne_sheetstate;
	}

	public void set_ne_sheetstate(String _ne_sheetstate) {
		this._ne_sheetstate = _ne_sheetstate;
	}

	public String get_ne_sheettype() {
		return _ne_sheettype;
	}

	public void set_ne_sheettype(String _ne_sheettype) {
		this._ne_sheettype = _ne_sheettype;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_salesopr() {
		return _se_salesopr;
	}

	public void set_se_salesopr(String _se_salesopr) {
		this._se_salesopr = _se_salesopr;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_sheetid() {
		return _se_sheetid;
	}

	public void set_se_sheetid(String _se_sheetid) {
		this._se_sheetid = _se_sheetid;
	}

	public List get_nin_sheetstate() {
		return _nin_sheetstate;
	}

	public void set_nin_sheetstate(List _nin_sheetstate) {
		this._nin_sheetstate = _nin_sheetstate;
	}

}
