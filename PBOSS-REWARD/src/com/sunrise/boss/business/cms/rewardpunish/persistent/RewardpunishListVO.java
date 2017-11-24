/**
* auto-generated code
* Sat Dec 06 16:11:20 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpunish.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardpunishListVO</p>
 * <p>Description: Query Params Object for RewardpunishDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class RewardpunishListVO extends BaseListVO {
	/** persistent field */
    private String _se_objectid;

    /** nullable persistent field */
    private String _se_wayid;

    /** nullable persistent field */
    private String _se_waytype;

    /** nullable persistent field */
    private String _dnl_rptime;

    private String _dnm_rptime;

	public String get_dnl_rptime() {
		return _dnl_rptime;
	}

	public void set_dnl_rptime(String _dnl_rptime) {
		this._dnl_rptime = _dnl_rptime;
	}

	public String get_dnm_rptime() {
		return _dnm_rptime;
	}

	public void set_dnm_rptime(String _dnm_rptime) {
		this._dnm_rptime = _dnm_rptime;
	}

	public String get_se_objectid() {
		return _se_objectid;
	}

	public void set_se_objectid(String _se_objectid) {
		this._se_objectid = _se_objectid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_waytype() {
		return _se_waytype;
	}

	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}

}
