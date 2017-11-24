package com.sunrise.boss.business.cms.reward.adtcode.persistent;

import java.io.Serializable;
import java.util.Date;

public class AdtcodeVO implements Serializable {
	private String adtcode;
	private String adtremark;
	private String adttype;
	private Short adtprio;
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
