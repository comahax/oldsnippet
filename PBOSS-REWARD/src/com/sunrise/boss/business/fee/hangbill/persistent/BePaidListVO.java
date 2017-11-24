package com.sunrise.boss.business.fee.hangbill.persistent;

import java.util.Collection;

import com.sunrise.boss.common.base.db.BaseListVO;

public class BePaidListVO extends BaseListVO {
	private String _ne_subsid;
	private Collection _nnin_eboxid;
	

	public Collection get_nnin_eboxid() {
		return _nnin_eboxid;
	}

	public void set_nnin_eboxid(Collection _nnin_eboxid) {
		this._nnin_eboxid = _nnin_eboxid;
	}

	public String get_ne_subsid() {
		return _ne_subsid;
	}

	public void set_ne_subsid(String _ne_subsid) {
		this._ne_subsid = _ne_subsid;
	}
}
