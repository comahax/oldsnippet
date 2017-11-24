/**
 * auto-generated code
 * Thu Sep 17 14:50:44 CST 2009
 */
package com.gmcc.pboss.business.promotion.rule;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: RuleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleDBParam extends DBQueryParam {
	
	private List<Long> _sin_ruleid;
	
	private String _ne_ruleid;
	
	private String _se_pri;
	
	private String _sk_rulename;

	public String get_se_pri() {
		return _se_pri;
	}

	public void set_se_pri(String _se_pri) {
		this._se_pri = _se_pri;
	}



	public List<Long> get_sin_ruleid() {
		return _sin_ruleid;
	}

	public void set_sin_ruleid(List<Long> list) {
		this._sin_ruleid = list;
	}

	public String get_sk_rulename() {
		return _sk_rulename;
	}

	public void set_sk_rulename(String _sk_rulename) {
		this._sk_rulename = _sk_rulename;
	}

	public String get_ne_ruleid() {
		return _ne_ruleid;
	}

	public void set_ne_ruleid(String _ne_ruleid) {
		this._ne_ruleid = _ne_ruleid;
	}

}
