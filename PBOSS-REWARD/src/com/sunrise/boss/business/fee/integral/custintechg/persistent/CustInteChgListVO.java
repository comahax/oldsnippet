/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custintechg.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * Title: CustInteListVO Description: Query Params Object for CustInteDAO
 * Copyright: Copyright (c) 2006 Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
public class CustInteChgListVO extends BaseListVO {

	// ²éÑ¯Ìõ¼þ
	private String _ne_custid;

	private String _se_firmid;

	private String _dnl_updatetime;

	private String _dnm_updatetime;

	private String _ne_intchgrsn;

	private String mobileno;

	private String datas;

	private String startindex;

	private String endindex;
	
	private String _ne_integralcyc;
	
	private String _se_descrp;


	public String get_se_descrp() {
		return _se_descrp;
	}

	public void set_se_descrp(String _se_descrp) {
		this._se_descrp = _se_descrp;
	}

	public String get_ne_integralcyc() {
		return _ne_integralcyc;
	}

	public void set_ne_integralcyc(String _ne_integralcyc) {
		this._ne_integralcyc = _ne_integralcyc;
	}

	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String get_dnl_updatetime() {
		return _dnl_updatetime;
	}

	public void set_dnl_updatetime(String _dnl_updatetime) {
		this._dnl_updatetime = _dnl_updatetime;
	}

	public String get_dnm_updatetime() {
		return _dnm_updatetime;
	}

	public void set_dnm_updatetime(String _dnm_updatetime) {
		this._dnm_updatetime = _dnm_updatetime;
	}

	public String get_ne_custid() {
		return _ne_custid;
	}

	public void set_ne_custid(String _ne_custid) {
		this._ne_custid = _ne_custid;
	}

	public String get_ne_intchgrsn() {
		return _ne_intchgrsn;
	}

	public void set_ne_intchgrsn(String _ne_intchgrsn) {
		this._ne_intchgrsn = _ne_intchgrsn;
	}

	public String get_se_firmid() {
		return _se_firmid;
	}

	public void set_se_firmid(String _se_firmid) {
		this._se_firmid = _se_firmid;
	}

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}

}
