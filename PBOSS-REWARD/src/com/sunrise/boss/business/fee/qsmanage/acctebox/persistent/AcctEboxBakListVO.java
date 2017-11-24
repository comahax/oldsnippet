/**
* auto-generated code
* Wed Aug 16 14:03:04 CST 2006
*/
package com.sunrise.boss.business.fee.qsmanage.acctebox.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AcctEboxListVO</p>
 * <p>Description: Query Params Object for AcctEboxDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public class AcctEboxBakListVO extends BaseListVO {

	 /** identifier field */
    private String  _ne_acctid;

    /** identifier field */
    private String  _ne_eboxunitid;

	public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}

	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}

	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	}
    


}
