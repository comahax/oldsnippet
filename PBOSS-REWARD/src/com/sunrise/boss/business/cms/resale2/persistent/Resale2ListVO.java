/**
 * auto-generated code
 * Sun Feb 03 10:15:39 CST 2008
 */
package com.sunrise.boss.business.cms.resale2.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: RuleListVO
 * </p>
 * <p>
 * Description: Query Params Object for RuleDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class Resale2ListVO extends BaseListVO {
	private String _se_opnid;

	private String _se_comresid;

	public String get_se_comresid() {
		return _se_comresid;
	}

	public void set_se_comresid(String _se_comresid) {
		this._se_comresid = _se_comresid;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

}
