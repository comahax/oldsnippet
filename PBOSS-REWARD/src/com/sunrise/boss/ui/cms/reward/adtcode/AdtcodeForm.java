package com.sunrise.boss.ui.cms.reward.adtcode;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: AdtcodeForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author 	Linli
 * @version 1.0
 */
public class AdtcodeForm extends BaseActionForm {
	private String adtcode;
	private String adtremark;
	private String adttype;
	private Short adtprio;
	private String _sk_adtcode;
	private String _sk_adtremark;
	public String get_sk_adtcode() {
		return _sk_adtcode;
	}
	public void set_sk_adtcode(String _sk_adtcode) {
		this._sk_adtcode = _sk_adtcode;
	}
	public String get_sk_adtremark() {
		return _sk_adtremark;
	}
	public void set_sk_adtremark(String _sk_adtremark) {
		this._sk_adtremark = _sk_adtremark;
	}
	public String getAdtcode() {
		return adtcode;
	}
	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}
	public Short getAdtprio() {
		return adtprio;
	}
	public void setAdtprio(Short adtprio) {
		this.adtprio = adtprio;
	}
	public String getAdtremark() {
		return adtremark;
	}
	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}
	public String getAdttype() {
		return adttype;
	}
	public void setAdttype(String adttype) {
		this.adttype = adttype;
	}
}
