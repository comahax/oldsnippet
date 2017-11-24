/**
* auto-generated code
* Tue Jul 07 16:26:52 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyDdtrewardListVO</p>
 * <p>Description: Query Params Object for ZjtyDdtrewardDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDdtrewardListVO extends BaseListVO {

	private String _snl_rewardmont;
	
	private String _snm_rewardmont;
	
	private String _se_wayid;
	
	private String _se_ddttype;

	public String get_se_ddttype() {
		return _se_ddttype;
	}

	public void set_se_ddttype(String _se_ddttype) {
		this._se_ddttype = _se_ddttype;
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
	
}
