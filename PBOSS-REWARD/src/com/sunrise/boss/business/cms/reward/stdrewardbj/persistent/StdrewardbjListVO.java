/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.business.cms.reward.stdrewardbj.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: StdrewardbjListVO
 * </p>
 * <p>
 * Description: Query Params Object for StdrewardbjDAO
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
public class StdrewardbjListVO extends BaseListVO {
	private String _ne_rewardid;

	private String _se_region;

	private String _se_opnid;

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public String get_se_region() {
		return _se_region;
	}

	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}
}
