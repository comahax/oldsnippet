package com.sunrise.boss.business.resmanage.common.hlrinfo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class HlrinfoListVO extends BaseListVO{

	private String _ne_id;
	
	private String _sk_name;
	
	private String _ne_type;

	public String get_ne_type() {
		return _ne_type;
	}

	public void set_ne_type(String _ne_type) {
		this._ne_type = _ne_type;
	}

	public String get_ne_id() {
		return _ne_id;
	}

	public void set_ne_id(String _ne_id) {
		this._ne_id = _ne_id;
	}

	public String get_sk_name() {
		return _sk_name;
	}

	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}
}
