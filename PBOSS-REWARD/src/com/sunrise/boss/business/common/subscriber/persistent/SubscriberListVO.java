package com.sunrise.boss.business.common.subscriber.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

public class SubscriberListVO extends BaseListVO {

	private String _sk_servnumber;

	private String _sk_status;

	private String _ne_custid;

	private String _ne_userid;

	private String _ne_acctid;
	
	private String _se_servnumber;
	
	private String _se_status;
	
	private List _sin_status;
	
	/* add by xiefufeng */
	private String _ne_subsid;
	/* add by xiefufeng */
	
	
	public List get_sin_status() {
		return _sin_status;
	}

	public void set_sin_status(List _sin_status) {
		this._sin_status = _sin_status;
	}

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

	public String get_se_status() {
		return _se_status;
	}

	public void set_se_status(String _se_status) {
		this._se_status = _se_status;
	}

	public String get_ne_subsid() {
		return _ne_subsid;
	}

	public void set_ne_subsid(String _ne_subsid) {
		this._ne_subsid = _ne_subsid;
	}

}
