/**
 * auto-generated code
 * Thu Sep 17 10:37:46 CST 2009
 */
package com.gmcc.pboss.business.promotion.daemon;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: DaemonDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DaemonDBParam extends DBQueryParam {
	private String _de_startingdate;
	private String _dnl_startingdate;
    private String _dnm_startingdate;
	private Long _ne_processid;
	private String _se_module;
	private String _se_params;
	
	public Long get_ne_processid() {
		return _ne_processid;
	}

	public void set_ne_processid(Long _ne_processid) {
		this._ne_processid = _ne_processid;
	}

	public String get_se_module() {
		return _se_module;
	}

	public void set_se_module(String _se_module) {
		this._se_module = _se_module;
	}

	public String get_se_params() {
		return _se_params;
	}

	public void set_se_params(String _se_params) {
		this._se_params = _se_params;
	}

	public String get_de_startingdate() {
		return _de_startingdate;
	}

	public void set_de_startingdate(String _de_startingdate) {
		this._de_startingdate = _de_startingdate;
	}

	public String get_dnl_startingdate() {
		return _dnl_startingdate;
	}

	public void set_dnl_startingdate(String _dnl_startingdate) {
		this._dnl_startingdate = _dnl_startingdate;
	}

	public String get_dnm_startingdate() {
		return _dnm_startingdate;
	}

	public void set_dnm_startingdate(String _dnm_startingdate) {
		this._dnm_startingdate = _dnm_startingdate;
	}
	
	

}
