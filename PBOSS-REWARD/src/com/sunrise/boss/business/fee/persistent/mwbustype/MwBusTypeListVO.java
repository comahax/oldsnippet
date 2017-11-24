package com.sunrise.boss.business.fee.persistent.mwbustype;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: MwBusTypeListVO</p>
 * <p>Description: 梦网业务类型管理List VO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class MwBusTypeListVO extends BaseListVO{

	private String _ne_bustype;
	private String _sk_busname;
	private String _ne_state;
	
	public String get_ne_bustype() {
		return _ne_bustype;
	}

	public void set_ne_bustype(String _ne_bustype) {
		this._ne_bustype = _ne_bustype;
	}

	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}

	public String get_sk_busname() {
		return _sk_busname;
	}

	public void set_sk_busname(String _sk_busname) {
		this._sk_busname = _sk_busname;
	}
}
