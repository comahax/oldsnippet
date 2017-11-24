package com.sunrise.boss.business.resmanage.common.chkresduplicate.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * 2.2.3.17 资源批量调拨重复性检查模块
 * 
 * @author David
 * 
 */
public class ChkResDuplicateListVO extends BaseListVO {

	private String _snl_begno;

	private String _snm_endno;

	private String _ne_comid;

	private String _ne_resoprtype;

	private String _se_inwayid;

	private String _se_outwayid;
	
	private String _ne_oldstate;
	
	private String _ne_newstate;
	
	public String get_ne_newstate() {
		return _ne_newstate;
	}

	public void set_ne_newstate(String _ne_newstate) {
		this._ne_newstate = _ne_newstate;
	}

	public String get_ne_oldstate() {
		return _ne_oldstate;
	}

	public void set_ne_oldstate(String _ne_oldstate) {
		this._ne_oldstate = _ne_oldstate;
	}

	public String get_ne_comid() {
		return _ne_comid;
	}

	public void set_ne_comid(String _ne_comid) {
		this._ne_comid = _ne_comid;
	}

	public String get_ne_resoprtype() {
		return _ne_resoprtype;
	}

	public void set_ne_resoprtype(String _ne_resoprtype) {
		this._ne_resoprtype = _ne_resoprtype;
	}

	public String get_se_inwayid() {
		return _se_inwayid;
	}

	public void set_se_inwayid(String _se_inwayid) {
		this._se_inwayid = _se_inwayid;
	}

	public String get_se_outwayid() {
		return _se_outwayid;
	}

	public void set_se_outwayid(String _se_outwayid) {
		this._se_outwayid = _se_outwayid;
	}

	public String get_snl_begno() {
		return _snl_begno;
	}

	public void set_snl_begno(String _snl_begno) {
		this._snl_begno = _snl_begno;
	}

	public String get_snm_endno() {
		return _snm_endno;
	}

	public void set_snm_endno(String _snm_endno) {
		this._snm_endno = _snm_endno;
	}

}
