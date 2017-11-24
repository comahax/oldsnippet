package com.gmcc.pboss.business.reward.payment;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class VUpoprcodeDBParam extends DBQueryParam {

	private static final long serialVersionUID = 4929969896391456312L;
	private String _se_upoprcode;

	public VUpoprcodeDBParam() {
		super();
		this.setQueryByNameSql(true);
		this.setNameSql("com.gmcc.pboss.business.reward.payment.doQueryOprcodeBySql");
	}

	public String get_se_upoprcode() {
		return _se_upoprcode;
	}

	public void set_se_upoprcode(String _se_upoprcode) {
		this._se_upoprcode = _se_upoprcode;
	}
}
