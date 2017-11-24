/**
* auto-generated code
* Sat Feb 02 15:13:27 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.disintegral;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: DisintegralForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class DisintegralForm extends BaseActionForm {

	 /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String calmonth;

    /** nullable persistent field */
    private Short integraltype;

    /** nullable persistent field */
    private Long integralnum;
    
	private String _se_wayid;
	
	private String _ne_integraltype;
	
	private String _dnl_calmonth;
	
	private String _dnm_calmonth;
	
	private String _nnl_calmonth;
	
	private String _nnm_calmonth;

	public String get_nnl_calmonth() {
		return _nnl_calmonth;
	}

	public void set_nnl_calmonth(String _nnl_calmonth) {
		this._nnl_calmonth = _nnl_calmonth;
	}

	public String get_nnm_calmonth() {
		return _nnm_calmonth;
	}

	public void set_nnm_calmonth(String _nnm_calmonth) {
		this._nnm_calmonth = _nnm_calmonth;
	}

	public String getCalmonth() {
		return calmonth;
	}

	public void setCalmonth(String calmonth) {
		this.calmonth = calmonth;
	}

	public Long getIntegralnum() {
		return integralnum;
	}

	public void setIntegralnum(Long integralnum) {
		this.integralnum = integralnum;
	}

	public Short getIntegraltype() {
		return integraltype;
	}

	public void setIntegraltype(Short integraltype) {
		this.integraltype = integraltype;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String get_dnl_calmonth() {
		return _dnl_calmonth;
	}

	public void set_dnl_calmonth(String _dnl_calmonth) {
		this._dnl_calmonth = _dnl_calmonth;
	}

	public String get_dnm_calmonth() {
		return _dnm_calmonth;
	}

	public void set_dnm_calmonth(String _dnm_calmonth) {
		this._dnm_calmonth = _dnm_calmonth;
	}

	public String get_ne_integraltype() {
		return _ne_integraltype;
	}

	public void set_ne_integraltype(String _ne_integraltype) {
		this._ne_integraltype = _ne_integraltype;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
	
}
