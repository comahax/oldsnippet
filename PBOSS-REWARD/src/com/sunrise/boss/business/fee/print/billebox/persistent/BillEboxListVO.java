/**
* auto-generated code
* Tue Aug 15 14:11:03 CST 2006
*/
package com.sunrise.boss.business.fee.print.billebox.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BillEboxListVO</p>
 * <p>Description: Query Params Object for BillEboxDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public class BillEboxListVO extends BaseListVO {

	 private String _ne_billitemid;

	   
	 private String  _ne_eboxunitid;


	public String get_ne_billitemid() {
		return _ne_billitemid;
	}


	public void set_ne_billitemid(String _ne_billitemid) {
		this._ne_billitemid = _ne_billitemid;
	}


	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}


	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	}


}
