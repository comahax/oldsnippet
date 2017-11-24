/**
* auto-generated code
* Tue Jan 05 15:32:41 CST 2010
*/
package com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyDataqueryListVO</p>
 * <p>Description: Query Params Object for ZjtyDataqueryDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDataqueryListVO extends BaseListVO {
	private String _ne_mobile;
	
	private String _se_wayid;
	
	private String _se_opnid;
	
	private String _dnl_oprtime;

	private String _dnm_oprtime;
	
	private String _se_oprcode;
	
	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}

	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}

	public String get_dnm_oprtime() {
		return _dnm_oprtime;
	}

	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}

	public String get_ne_mobile() {
		return _ne_mobile;
	}

	public void set_ne_mobile(String _ne_mobile) {
		this._ne_mobile = _ne_mobile;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
}
