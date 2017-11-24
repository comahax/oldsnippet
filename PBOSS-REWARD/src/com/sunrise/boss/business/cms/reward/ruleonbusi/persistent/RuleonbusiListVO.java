/**
 * auto-generated code
 * Fri Apr 18 17:02:15 CST 2008
 */
package com.sunrise.boss.business.cms.reward.ruleonbusi.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: RuleonbusiListVO
 * </p>
 * <p>
 * Description: Query Params Object for RuleonbusiDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public class RuleonbusiListVO extends BaseListVO {
	private String _se_opnid;

	private String _se_ruleid;
	
	private String _sk_name;

	public String get_sk_name() {
		return _sk_name;
	}

	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_ruleid() {
		return _se_ruleid;
	}

	public void set_se_ruleid(String _se_ruleid) {
		this._se_ruleid = _se_ruleid;
	}
}
