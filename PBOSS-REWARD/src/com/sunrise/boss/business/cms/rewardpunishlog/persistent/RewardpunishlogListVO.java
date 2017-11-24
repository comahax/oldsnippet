/**
* auto-generated code
* Tue Dec 09 14:05:03 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpunishlog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardpunishlogListVO</p>
 * <p>Description: Query Params Object for RewardpunishlogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class RewardpunishlogListVO extends BaseListVO {
	private String _se_oprcode;
	
	private String _dnl_optime;
	
	private String _dnm_optime;
	
	private String _se_objectid;
	
	private String _se_wayid;
	
	private String _se_waytype;

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		this._dnm_optime = _dnm_optime;
	}

	public String get_se_objectid() {
		return _se_objectid;
	}

	public void set_se_objectid(String _se_objectid) {
		this._se_objectid = _se_objectid;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
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
