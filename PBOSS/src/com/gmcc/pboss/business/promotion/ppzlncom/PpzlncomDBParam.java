/**
 * auto-generated code
 * Thu Sep 17 15:16:11 CST 2009
 */
package com.gmcc.pboss.business.promotion.ppzlncom;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: PpzlncomDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlncomDBParam extends DBQueryParam {

	private String _se_comcategory;

	private String _se_pid;

	private String _ne_pid;

	public String get_ne_pid() {
		return _ne_pid;
	}

	public void set_ne_pid(String _ne_pid) {
		this._ne_pid = _ne_pid;
	}

	public String get_se_pid() {
		return _se_pid;
	}

	public void set_se_pid(String _se_pid) {
		this._se_pid = _se_pid;
	}

	public String get_se_comcategory() {
		return _se_comcategory;
	}

	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}

}
