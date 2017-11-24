/**
 * auto-generated code
 * Mon Sep 14 14:22:16 CST 2009
 */
package com.gmcc.pboss.business.promotion.elmttmpl;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ElmttmplDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public class ElmttmplDBParam extends DBQueryParam {
	private String _se_tmplid;
	
	private String _sk_tmplname;
	
	private String _se_gatheringmode;
	
	private String _se_state;

	public String get_se_gatheringmode() {
		return _se_gatheringmode;
	}

	public void set_se_gatheringmode(String _se_gatheringmode) {
		this._se_gatheringmode = _se_gatheringmode;
	}

	public String get_se_state() {
		return _se_state;
	}

	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}

	public String get_se_tmplid() {
		return _se_tmplid;
	}

	public void set_se_tmplid(String _se_tmplid) {
		this._se_tmplid = _se_tmplid;
	}

	public String get_sk_tmplname() {
		return _sk_tmplname;
	}

	public void set_sk_tmplname(String _sk_tmplname) {
		this._sk_tmplname = _sk_tmplname;
	}
}
