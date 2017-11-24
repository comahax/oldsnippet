/**
* auto-generated code
* Fri Oct 24 09:17:11 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyRewardcoefListVO</p>
 * <p>Description: Query Params Object for ZjtyRewardcoefDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyRewardcoefListVO extends BaseListVO {

	private String _se_wayid;
	private String _se_cityid;
	private String _ne_coefid;
	private String _se_effectiblemonth;
	
	public String get_ne_coefid() {
		return _ne_coefid;
	}
	public void set_ne_coefid(String _ne_coefid) {
		this._ne_coefid = _ne_coefid;
	}
	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}
	public String get_se_effectiblemonth() {
		return _se_effectiblemonth;
	}
	public void set_se_effectiblemonth(String _se_effectiblemonth) {
		this._se_effectiblemonth = _se_effectiblemonth;
	}
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
}
