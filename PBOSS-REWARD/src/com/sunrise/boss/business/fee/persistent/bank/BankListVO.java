package com.sunrise.boss.business.fee.persistent.bank;

import com.sunrise.boss.common.base.db.BaseListVO;

public class BankListVO extends BaseListVO{
	/* add by xiefufeng */
	private String _se_bankid; //支付渠道标识
	private String _se_parentid; //父支付渠道标识
	
	/* add by xiefufeng */
	
	private String  _sne_banktype;
	
	
	
	public String get_sne_banktype() {
		return _sne_banktype;
	}
	public void set_sne_banktype(String _sne_banktype) {
		this._sne_banktype = _sne_banktype;
	}
	public String get_se_bankid() {
		return _se_bankid;
	}
	public void set_se_bankid(String _se_bankid) {
		this._se_bankid = _se_bankid;
	}
	public String get_se_parentid() {
		return _se_parentid;
	}
	public void set_se_parentid(String _se_parentid) {
		this._se_parentid = _se_parentid;
	}
	
	
}
