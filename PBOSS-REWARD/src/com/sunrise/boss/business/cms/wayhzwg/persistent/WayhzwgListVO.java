/**
* auto-generated code
* Thu Feb 12 09:39:32 CST 2009
*/
package com.sunrise.boss.business.cms.wayhzwg.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WayhzwgListVO</p>
 * <p>Description: Query Params Object for WayhzwgDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WayhzwgListVO extends BaseListVO {
	/** identifier field */
    private String _se_wayid;

    /** identifier field */
    private String _se_wgmonth;

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_wgmonth() {
		return _se_wgmonth;
	}

	public void set_se_wgmonth(String _se_wgmonth) {
		this._se_wgmonth = _se_wgmonth;
	}

}
