package com.sunrise.boss.business.fee.billing.feenotifystate.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;


public class FeeNotifyStateListVO extends BaseListVO {

	private String _ne_validbillcyc;

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}
}