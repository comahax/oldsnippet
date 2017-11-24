/**
* auto-generated code
* Mon Dec 28 10:41:51 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyBusyxplanListVO</p>
 * <p>Description: Query Params Object for ZjtyBusyxplanDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyBusyxplanListVO extends BaseListVO {

	private String _se_prodid;
	private String _se_opnid;
	private String _se_planbusitype;
	private String _se_cityid;

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_planbusitype() {
		return _se_planbusitype;
	}

	public void set_se_planbusitype(String _se_planbusitype) {
		this._se_planbusitype = _se_planbusitype;
	}

}
