/**
 * auto-generated code
 * Sun Jan 04 10:44:26 CST 2009
 */
package com.sunrise.boss.business.cms.reward.busiwayrel.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BusiwayrelListVO</p>
 * <p>Description: Query Params Object for BusiwayrelDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BusiwayrelListVO extends BaseListVO {
	/** identifier field */
	private String _se_opnid;

	/** identifier field */
	private String _se_wayid;

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

}
