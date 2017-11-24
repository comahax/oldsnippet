/**
* auto-generated code
* Wed Sep 04 16:35:49 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPdRewardruleListVO</p>
 * <p>Description: Query Params Object for ChPdRewardruleDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardruleListVO extends BaseListVO {
	private String _ne_coopertype;
	private String _se_subcategory;
	private String _sql_condition;

	public String get_ne_coopertype() {
		return _ne_coopertype;
	}

	public void set_ne_coopertype(String _ne_coopertype) {
		this._ne_coopertype = _ne_coopertype;
	}

	public String get_se_subcategory() {
		return _se_subcategory;
	}

	public void set_se_subcategory(String _se_subcategory) {
		this._se_subcategory = _se_subcategory;
	}

	public String get_sql_condition() {
		return _sql_condition;
	}

	public void set_sql_condition(String _sql_condition) {
		this._sql_condition = _sql_condition;
	}

}
