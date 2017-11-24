/**
 * auto-generated code
 * Thu Sep 17 15:12:35 CST 2009
 */
package com.gmcc.pboss.business.promotion.ppzlnrule;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: PpzlnruleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnruleDBParam extends DBQueryParam {

	private String _sk_rulename;

	private String _ne_pid;

	private String _ne_ruleid;

	private String queryRuleid;

	private String _se_comcategory;

	private String _ne_itemid;

	private String _se_datatype;

	private String _se_prodid;

	private String _se_tcomcategory;

	private String _se_pcomcategory;
	
	private String pid;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String get_se_pcomcategory() {
		return _se_pcomcategory;
	}

	public void set_se_pcomcategory(String _se_pcomcategory) {
		this._se_pcomcategory = _se_pcomcategory;
	}

	public String get_se_tcomcategory() {
		return _se_tcomcategory;
	}

	public void set_se_tcomcategory(String _se_tcomcategory) {
		this._se_tcomcategory = _se_tcomcategory;
	}

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

	public String get_ne_itemid() {
		return _ne_itemid;
	}

	public void set_ne_itemid(String _ne_itemid) {
		this._ne_itemid = _ne_itemid;
	}

	public String get_se_datatype() {
		return _se_datatype;
	}

	public void set_se_datatype(String _se_datatype) {
		this._se_datatype = _se_datatype;
	}

	public String get_se_comcategory() {
		return _se_comcategory;
	}

	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}

	public String getQueryRuleid() {
		return queryRuleid;
	}

	public void setQueryRuleid(String queryRuleid) {
		this.queryRuleid = queryRuleid;
	}

	public String get_ne_ruleid() {
		return _ne_ruleid;
	}

	public void set_ne_ruleid(String _ne_ruleid) {
		this._ne_ruleid = _ne_ruleid;
	}

	public String get_ne_pid() {
		return _ne_pid;
	}

	public void set_ne_pid(String _ne_pid) {
		this._ne_pid = _ne_pid;
	}

	public String get_sk_rulename() {
		return _sk_rulename;
	}

	public void set_sk_rulename(String _sk_rulename) {
		this._sk_rulename = _sk_rulename;
	}

}
