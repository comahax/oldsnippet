package com.sunrise.boss.business.fee.persistent.batchoper;

import com.sunrise.boss.common.base.db.BaseListVO;

public class BatchOperListVO extends BaseListVO{
	
	private String _se_mobileno;  
	private String _dnl_operdate; 
	private String _dnm_operdate;
	private String _se_wayid;
	private String _se_opercode;
	
	public String get_se_opercode() {
		return _se_opercode;
	}
	public void set_se_opercode(String _se_opercode) {
		this._se_opercode = _se_opercode;
	}
	public String get_se_mobileno() {
		return _se_mobileno;
	}
	public void set_se_mobileno(String _se_mobileno) {
		this._se_mobileno = _se_mobileno;
	}
	public String get_dnl_operdate() {
		return _dnl_operdate;
	}
	public void set_dnl_operdate(String _dnl_operdate) {
		this._dnl_operdate = _dnl_operdate;
	}
	public String get_dnm_operdate() {
		return _dnm_operdate;
	}
	public void set_dnm_operdate(String _dnm_operdate) {
		this._dnm_operdate = _dnm_operdate;
	}
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	} 
	
	
	
	
}
