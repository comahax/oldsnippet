package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef;

import com.sunrise.boss.ui.base.BaseActionForm;

public class ZjtyRewardcoefForm extends BaseActionForm {

	// ListVO
	private String _se_wayid;

	private String _se_cityid;

	private String _ne_coefid;

	private String _se_effectiblemonth;

	// VO
	private Short coefid;

	private String wayid;

	private String effectiblemonth;

	private String cityid;

	private Double providecoef;

	private String result;

	private Short ispass;

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

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Short getCoefid() {
		return coefid;
	}

	public void setCoefid(Short coefid) {
		this.coefid = coefid;
	}

	public String getEffectiblemonth() {
		return effectiblemonth;
	}

	public void setEffectiblemonth(String effectiblemonth) {
		this.effectiblemonth = effectiblemonth;
	}

	public Short getIspass() {
		return ispass;
	}

	public void setIspass(Short ispass) {
		this.ispass = ispass;
	}

	public Double getProvidecoef() {
		return providecoef;
	}

	public void setProvidecoef(Double providecoef) {
		this.providecoef = providecoef;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

}
