/**
* auto-generated code
* Tue Sep 12 17:06:59 CST 2006
*/
package com.sunrise.boss.ui.cms.wayhznx;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: WayhierarchyForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayhznxForm extends BaseActionForm {

	/** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short years;

    private String wayname;
    /** nullable persistent field */
    private java.util.Date yearstime;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private java.util.Date cleartime;
    
    private Short starlevel;
    
    private String _se_wayid;

    private String _ne_starlevel;
    

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public java.util.Date getCleartime() {
		return cleartime;
	}

	public void setCleartime(java.util.Date cleartime) {
		this.cleartime = cleartime;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Short getYears() {
		return years;
	}

	public void setYears(Short years) {
		this.years = years;
	}

	public java.util.Date getYearstime() {
		return yearstime;
	}

	public void setYearstime(java.util.Date yearstime) {
		this.yearstime = yearstime;
	}

	public String get_ne_starlevel() {
		return _ne_starlevel;
	}

	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}

	public Short getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Short starlevel) {
		this.starlevel = starlevel;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}
	
}
