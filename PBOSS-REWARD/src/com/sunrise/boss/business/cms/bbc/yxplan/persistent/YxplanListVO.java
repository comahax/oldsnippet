/**
 * auto-generated code
 * Tue May 05 11:03:52 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.yxplan.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: yxplanListVO
 * </p>
 * <p>
 * Description: Query Params Object for yxplanDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class YxplanListVO extends BaseListVO {
	private String _se_opnid;

	private String _ne_yxplanid;

	private String _sk_yxplanname;

	private String _sk_opnname;

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String get_sk_opnname() {
		return _sk_opnname;
	}

	public void set_sk_opnname(String _sk_opnname) {
		this._sk_opnname = _sk_opnname;
	}

	public String get_sk_yxplanname() {
		return _sk_yxplanname;
	}

	public void set_sk_yxplanname(String _sk_yxplanname) {
		this._sk_yxplanname = _sk_yxplanname;
	}

}
