package com.sunrise.boss.business.resmanage.simplebossconfig.simpleboss.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class SimpleBossListVO extends BaseListVO {
	
	private String _ne_cityid;
	private String _se_wayid;
	private String _se_oprcode;
	private String _ne_state;

	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_ne_cityid() {
		return _ne_cityid;
	}

	public void set_ne_cityid(String _ne_cityid) {
		this._ne_cityid = _ne_cityid;
	}
}
