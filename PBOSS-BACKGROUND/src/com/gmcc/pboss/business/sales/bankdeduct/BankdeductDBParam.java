package com.gmcc.pboss.business.sales.bankdeduct;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: BankdeductDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BankdeductDBParam extends DBQueryParam {
	private String _se_orderid;

	private Long _ne_deductid;
	
	private String _se_state;

	public Long get_ne_deductid() {
		return _ne_deductid;
	}

	public void set_ne_deductid(Long _ne_deductid) {
		this._ne_deductid = _ne_deductid;
	}

	public String get_se_state() {
		return _se_state;
	}

	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}

	public String get_se_orderid() {
		return _se_orderid;
	}

	public void set_se_orderid(String _se_orderid) {
		this._se_orderid = _se_orderid;
	}
}
