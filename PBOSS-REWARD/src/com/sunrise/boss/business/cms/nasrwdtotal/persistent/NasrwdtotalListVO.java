/**
 * auto-generated code
 * Mon Jun 29 11:25:27 CST 2009
 */
package com.sunrise.boss.business.cms.nasrwdtotal.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: NasrwdtotalListVO
 * </p>
 * <p>
 * Description: Query Params Object for NasrwdtotalDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class NasrwdtotalListVO extends BaseListVO {
	private String _ne_totalid;

	private String _se_rewardmonth;

	private String _ne_rewardtype;

	private String _se_wayid;

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public String get_ne_totalid() {
		return _ne_totalid;
	}

	public void set_ne_totalid(String _ne_totalid) {
		this._ne_totalid = _ne_totalid;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

}
