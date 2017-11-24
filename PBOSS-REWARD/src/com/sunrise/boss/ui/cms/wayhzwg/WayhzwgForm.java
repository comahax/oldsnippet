/**
* auto-generated code
* Tue Sep 12 17:06:59 CST 2006
*/
package com.sunrise.boss.ui.cms.wayhzwg;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: WayhierarchyForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayhzwgForm extends BaseActionForm {
	/** identifier field */
    private String wayid;

    /** identifier field */
    private String wgmonth;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private String remark;
    
    private String calcmonth;

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getRemark() {
		return remark;
	}
	
	
	
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

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWgmonth() {
		return wgmonth;
	}

	public void setWgmonth(String wgmonth) {
		this.wgmonth = wgmonth;
	}
	
}
