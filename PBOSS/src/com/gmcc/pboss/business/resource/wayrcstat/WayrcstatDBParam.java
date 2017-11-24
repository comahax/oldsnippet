package com.gmcc.pboss.business.resource.wayrcstat;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class WayrcstatDBParam extends DBQueryParam {

	
	//查询标识，Y表示模糊查询，其他值表示第一次查询
	private String queryflag;
	
	private String _se_countyid;

	private String _se_mareacode;

	private String _se_wayid;

	private String _se_brand;

	private String _se_alarmlevel;
	
	private String _se_waymagcode;
	
	private Long _ne_starlevel;
	/** 快照起止日期(注意:这里使用的是_s类型, 因查询语句中进行了转换) */
	private String _dnl_statdate;

	private String _dnm_statdate;

	public String get_dnl_statdate() {
		return _dnl_statdate;
	}

	public void set_dnl_statdate(String _dnl_statdate) {
		this._dnl_statdate = _dnl_statdate;
	}

	public String get_dnm_statdate() {
		return _dnm_statdate;
	}

	public void set_dnm_statdate(String _dnm_statdate) {
		this._dnm_statdate = _dnm_statdate;
	}

	public String get_se_brand() {
		return _se_brand;
	}

	public void set_se_brand(String _se_brand) {
		this._se_brand = _se_brand;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_mareacode() {
		return _se_mareacode;
	}

	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_alarmlevel() {
		return _se_alarmlevel;
	}

	public void set_se_alarmlevel(String _se_alarmlevel) {
		this._se_alarmlevel = _se_alarmlevel;
	}

	public String get_se_waymagcode() {
		return _se_waymagcode;
	}

	public void set_se_waymagcode(String _se_waymagcode) {
		this._se_waymagcode = _se_waymagcode;
	}

	public Long get_ne_starlevel() {
		return _ne_starlevel;
	}

	public void set_ne_starlevel(Long _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}

	public String getQueryflag() {
		return queryflag;
	}

	public void setQueryflag(String queryflag) {
		this.queryflag = queryflag;
	}
}
