package com.sunrise.boss.business.fee.hangbill.persistent;

import java.util.Collection;

import com.sunrise.boss.common.base.db.BaseListVO;

public class UnwoffcustListVO extends BaseListVO {
	private String mobileno;
	private String   _ne_subsid;
	private String  _ne_acctid;
	private String  _ne_validbillcyc;
	private Collection _nnin_eboxid;
	private String _ne_eboxid;
	
	
	
	
	
	public String get_ne_eboxid() {
		return _ne_eboxid;
	}
	public void set_ne_eboxid(String _ne_eboxid) {
		this._ne_eboxid = _ne_eboxid;
	}
	public Collection get_nnin_eboxid() {
		return _nnin_eboxid;
	}
	public void set_nnin_eboxid(Collection _nnin_eboxid) {
		this._nnin_eboxid = _nnin_eboxid;
	}
	public String getMoblieno() {
        return mobileno;
    }
	public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
	public String get_ne_subsid() {
        return _ne_subsid;
    }
	public void set_ne_subsid(String feeid) {
        this._ne_subsid = feeid;
    }
	 
	public String get_ne_acctid() {
        return _ne_acctid;
    }
	public void set_ne_acctid(String feeid) {
        this._ne_acctid = feeid;
    }
	
	public String get_ne_validbillcyc() {
        return _ne_validbillcyc;
    }
	public void set_ne_validbillcyc(String billcyc) {
        this._ne_validbillcyc = billcyc;
    }
	
}