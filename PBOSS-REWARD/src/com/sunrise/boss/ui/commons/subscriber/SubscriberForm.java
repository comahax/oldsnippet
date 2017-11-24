package com.sunrise.boss.ui.commons.subscriber;

import com.sunrise.boss.ui.base.BaseActionForm;

public class SubscriberForm extends BaseActionForm {

	private String _sk_servnumber;

	private String _sk_status;

	private String _ne_custid;

	private String _ne_userid;

	private String _ne_acctid;
	
	private String _se_servnumber;
	
	private String accounting;   /**全省的标识**/
	private String cityid;   /**全省的标识**/
	
	public String get_se_servnumber() {
		return _se_servnumber;
	}

	public void set_se_servnumber(String _se_servnumber) {
		this._se_servnumber = _se_servnumber;
	}

	public String get_sk_status() {
		return _sk_status;
	}

	public void set_sk_status(String _sk_status) {
		this._sk_status = _sk_status;
	}

	public String get_sk_servnumber() {
		return _sk_servnumber;
	}

	public void set_sk_servnumber(String _sk_servnumber) {
		this._sk_servnumber = _sk_servnumber;
	}

	public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}

	public String get_ne_custid() {
		return _ne_custid;
	}

	public void set_ne_custid(String _ne_custid) {
		this._ne_custid = _ne_custid;
	}

	public String get_ne_userid() {
		return _ne_userid;
	}

	public void set_ne_userid(String _ne_userid) {
		this._ne_userid = _ne_userid;
	}

	public String getAccounting() {
		return accounting;
	}

	public void setAccounting(String accounting) {
		this.accounting = accounting;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

}
