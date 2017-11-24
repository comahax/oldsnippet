/**
* auto-generated code
* Sun Aug 13 17:25:29 CST 2006
*/
package com.sunrise.boss.business.fee.qsmanage.billacct.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BillAcctListVO</p>
 * <p>Description: Query Params Object for BillAcctDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public class BillAcctBakListVO extends BaseListVO {
	
	private String _ne_billitemid;

	private String _ne_acctid;

	public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}

	public String get_ne_billitemid() {
		return _ne_billitemid;
	}

	public void set_ne_billitemid(String _ne_billitemid) {
		this._ne_billitemid = _ne_billitemid;
	}



}
