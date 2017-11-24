/**
 * auto-generated code
 * Mon Jul 04 16:25:21 CST 2011
 */
package com.gmcc.pboss.business.resource.phonestate;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: PhonestateDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class PhonestateDBParam extends DBQueryParam {
	private String _se_comresid;
	private List _sin_comresid;
	private String _se_reswayid;
    private String _dnm_saletime;
	private String _dnl_saletime;
	
	public List get_sin_comresid() {
		return _sin_comresid;
	}

	public void set_sin_comresid(List _sin_comresid) {
		this._sin_comresid = _sin_comresid;
	}

	public String get_se_comresid() {
		return _se_comresid;
	}

	public void set_se_comresid(String _se_comresid) {
		this._se_comresid = _se_comresid;
	}

	public String get_se_reswayid() {
		return _se_reswayid;
	}

	public void set_se_reswayid(String _se_reswayid) {
		this._se_reswayid = _se_reswayid;
	}

	public String get_dnm_saletime() {
		return _dnm_saletime;
	}

	public void set_dnm_saletime(String _dnm_saletime) {
		this._dnm_saletime = _dnm_saletime;
	}

	public String get_dnl_saletime() {
		return _dnl_saletime;
	}

	public void set_dnl_saletime(String _dnl_saletime) {
		this._dnl_saletime = _dnl_saletime;
	}

 
}
