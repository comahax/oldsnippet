/**
* auto-generated code
* Sun Feb 01 10:31:20 CST 2009
*/
package com.sunrise.boss.business.cms.cityrewardad.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CityrewardadListVO</p>
 * <p>Description: Query Params Object for CityrewardadDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class CityrewardadListVO extends BaseListVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _se_cityid;

	private String _se_wayid;
	
	private String _se_rewardtype;

	private String _se_paymonth;

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_paymonth() {
		return _se_paymonth;
	}

	public void set_se_paymonth(String _se_paymonth) {
		this._se_paymonth = _se_paymonth;
	}

	public String get_se_rewardtype() {
		return _se_rewardtype;
	}

	public void set_se_rewardtype(String _se_rewardtype) {
		this._se_rewardtype = _se_rewardtype;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
}
