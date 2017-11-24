/**
* auto-generated code
* Wed Dec 24 15:55:56 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChZjtyRewarddetailListVO</p>
 * <p>Description: Query Params Object for ChZjtyRewarddetailDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyRewarddetailListVO extends BaseListVO {

	private String _se_opnid;
	
	private String _se_wayid;
	
	private Short _se_rewardtype;
	
	private Short _se_acctype;
	
	private String _se_rewardmont;
	
	private String _snl_rewardmont;
	
	private String _snm_rewardmont;

	public Short get_se_acctype() {
		return _se_acctype;
	}

	public void set_se_acctype(Short _se_acctype) {
		this._se_acctype = _se_acctype;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public Short get_se_rewardtype() {
		return _se_rewardtype;
	}

	public void set_se_rewardtype(Short _se_rewardtype) {
		this._se_rewardtype = _se_rewardtype;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_snl_rewardmont() {
		return _snl_rewardmont;
	}

	public void set_snl_rewardmont(String _snl_rewardmont) {
		this._snl_rewardmont = _snl_rewardmont;
	}

	public String get_snm_rewardmont() {
		return _snm_rewardmont;
	}

	public void set_snm_rewardmont(String _snm_rewardmont) {
		this._snm_rewardmont = _snm_rewardmont;
	}

	public String get_se_rewardmont() {
		return _se_rewardmont;
	}

	public void set_se_rewardmont(String _se_rewardmont) {
		this._se_rewardmont = _se_rewardmont;
	}

	
	
	
}
