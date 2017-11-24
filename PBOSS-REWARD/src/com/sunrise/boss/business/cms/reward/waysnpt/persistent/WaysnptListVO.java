/**
* auto-generated code
* Tue Jul 14 16:42:23 CST 2009
*/
package com.sunrise.boss.business.cms.reward.waysnpt.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WaysnptListVO</p>
 * <p>Description: Query Params Object for WaysnptDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaysnptListVO extends BaseListVO {

	private String _se_calcmonth;
	
	private String _se_wayid;
	
	private String _se_cityid;

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_calcmonth() {
		return _se_calcmonth;
	}

	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
}
