/**
* auto-generated code
* Sun Feb 1 10:32:23 CST 2009
*/
package com.sunrise.boss.ui.cms.cityrewardad;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: CityrewardadForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Li Zhaoliang
 * @version 1.0
 */
public class CityrewardadForm extends BaseActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ListVO
	private String _se_cityid;

	private String _se_wayid;
	
	private String _se_rewardtype;

	private String _se_paymonth;
	
	//VO
	private String cityid;

    private String paymonth;

    private Short rewardtype;

    private String wayid;

    private String amt;

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

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
