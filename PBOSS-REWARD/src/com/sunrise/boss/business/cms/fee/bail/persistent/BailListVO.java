/**
* auto-generated code
* Fri Dec 08 17:16:19 CST 2006
*/
package com.sunrise.boss.business.cms.fee.bail.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BailListVO</p>
 * <p>Description: Query Params Object for BailDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class BailListVO extends BaseListVO {

	private String _sk_wayid;
	private String _se_bailtype;
	private String _se_opertype;
	private String _se_recvoprcode;
	private String _dnl_recvtime;
	private String _dnm_recvtime;

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}	

	public String get_se_bailtype() {
		return _se_bailtype;
	}

	public void set_se_bailtype(String _se_bailtype) {
		this._se_bailtype = _se_bailtype;
	}	

	public String get_se_opertype() {
		return _se_opertype;
	}

	public void set_se_opertype(String _se_opertype) {
		this._se_opertype = _se_opertype;
	}		

	public String get_se_recvoprcode() {
		return _se_recvoprcode;
	}

	public void set_se_recvoprcode(String _se_recvoprcode) {
		this._se_recvoprcode = _se_recvoprcode;
	}	
	
	public String get_dnl_recvtime() {
		return _dnl_recvtime;
	}

	public void set_dnl_recvtime(String _dnl_recvtime) {
		this._dnl_recvtime = _dnl_recvtime;
	}

	public String get_dnm_recvtime() {
		return _dnm_recvtime;
	}

	public void set_dnm_recvtime(String _dnm_recvtime) {
		this._dnm_recvtime = _dnm_recvtime;
	}
	
}
