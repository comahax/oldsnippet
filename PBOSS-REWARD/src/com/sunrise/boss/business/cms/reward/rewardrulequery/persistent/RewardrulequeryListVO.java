/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rewardrulequery.persistent;

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
 * @author linli
 * @version 1.0
 */
public class RewardrulequeryListVO extends BaseListVO {
	
	private Long _ne_rewardid;

	private String _se_region;

	private Long _ne_rewardtype;
	
	private String _se_rewardname;

	public Long get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(Long _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public Long get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(Long _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public String get_se_region() {
		return _se_region;
	}

	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}

	public String get_se_rewardname() {
		return _se_rewardname;
	}

	public void set_se_rewardname(String _se_rewardname) {
		this._se_rewardname = _se_rewardname;
	}

}
