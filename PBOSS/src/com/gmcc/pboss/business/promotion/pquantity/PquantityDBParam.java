/**
 * auto-generated code
 * Mon Sep 14 16:43:36 CST 2009
 */
package com.gmcc.pboss.business.promotion.pquantity;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: PquantityDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class PquantityDBParam extends DBQueryParam {
	private String _se_prodid;

	private String _ne_ruleid;

	private String _sk_rulename;

	private String queryRuleid;

	private String pid;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getQueryRuleid() {
		return queryRuleid;
	}

	public void setQueryRuleid(String queryRuleid) {
		this.queryRuleid = queryRuleid;
	}

	/**
	 * @return Returns the _se_prodid.
	 */
	public String get_se_prodid() {
		return this._se_prodid;
	}

	/**
	 * @param _sk_companyname The _se_prodid to set.
	 */
	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

	public String get_ne_ruleid() {
		return _ne_ruleid;
	}

	public void set_ne_ruleid(String _ne_ruleid) {
		this._ne_ruleid = _ne_ruleid;
	}

	public String get_sk_rulename() {
		return _sk_rulename;
	}

	public void set_sk_rulename(String _sk_rulename) {
		this._sk_rulename = _sk_rulename;
	}

}
