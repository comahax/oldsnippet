/**
* auto-generated code
* Thu Aug 21 11:49:13 CST 2008
*/
package com.sunrise.boss.business.fee.qsmanage.chgdeta.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;


/**
 * <p>Title: chgdetaListVO</p>
 * <p>Description: Query Params Object for chgdetaDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lmq
 * @version 1.0
 */
public class ChgDetaListVO extends BaseListVO {

	private String _se_paramtable;

	private String _ne_createdate;

	private String _ne_chgtype;

	public String get_ne_chgtype() {
		return _ne_chgtype;
	}

	public void set_ne_chgtype(String _ne_chgtype) {
		this._ne_chgtype = _ne_chgtype;
	}

	public String get_ne_createdate() {
		return _ne_createdate;
	}

	public void set_ne_createdate(String _ne_createdate) {
		this._ne_createdate = _ne_createdate;
	}

	public String get_se_paramtable() {
		return _se_paramtable;
	}

	public void set_se_paramtable(String _se_paramtable) {
		this._se_paramtable = _se_paramtable;
	}
}
