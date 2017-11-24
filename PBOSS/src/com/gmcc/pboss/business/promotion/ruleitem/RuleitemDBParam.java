/**
 * auto-generated code
 * Fri Sep 18 18:06:45 CST 2009
 */
package com.gmcc.pboss.business.promotion.ruleitem;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: RuleitemDBParam
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class RuleitemDBParam extends DBQueryParam {
	private String _ne_itemid;

	private String _se_datatype;

	private String _ne_ruleid;

	private String _sk_rulename;

	private String queryRuleid;

	public String get_ne_itemid() {
		return _ne_itemid;
	}

	public void set_ne_itemid(String _ne_itemid) {
		this._ne_itemid = _ne_itemid;
	}

	public String get_ne_ruleid() {
		return _ne_ruleid;
	}

	public void set_ne_ruleid(String _ne_ruleid) {
		this._ne_ruleid = _ne_ruleid;
	}

	public String get_se_datatype() {
		return _se_datatype;
	}

	public void set_se_datatype(String _se_datatype) {
		this._se_datatype = _se_datatype;
	}

	public String get_sk_rulename() {
		return _sk_rulename;
	}

	public void set_sk_rulename(String _sk_rulename) {
		this._sk_rulename = _sk_rulename;
	}

	public String getQueryRuleid() {
		return queryRuleid;
	}

	public void setQueryRuleid(String queryRuleid) {
		this.queryRuleid = queryRuleid;
	}
}
