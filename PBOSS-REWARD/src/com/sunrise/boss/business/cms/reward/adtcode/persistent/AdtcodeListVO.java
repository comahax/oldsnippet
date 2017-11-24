package com.sunrise.boss.business.cms.reward.adtcode.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class AdtcodeListVO extends BaseListVO {
	private String _sk_adtcode;
	private String _sk_adtremark;
	private java.util.ArrayList _sin_adttype;
	
	public java.util.ArrayList get_sin_adttype() {
		return _sin_adttype;
	}
	public void set_sin_adttype(java.util.ArrayList _sin_adttype) {
		this._sin_adttype = _sin_adttype;
	}
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
}
