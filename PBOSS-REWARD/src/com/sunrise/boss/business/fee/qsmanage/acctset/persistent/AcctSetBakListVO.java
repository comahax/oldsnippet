package com.sunrise.boss.business.fee.qsmanage.acctset.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class AcctSetBakListVO extends BaseListVO{
	
    private String _ne_acctsetid;
    private String _ne_acctid;
    
	public String get_ne_acctid() {
		return _ne_acctid;
	}
	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}
	public String get_ne_acctsetid() {
		return _ne_acctsetid;
	}
	public void set_ne_acctsetid(String _ne_acctsetid) {
		this._ne_acctsetid = _ne_acctsetid;
	}
    
}
