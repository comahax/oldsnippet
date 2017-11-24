/**
 * auto-generated code
 * Fri Jul 11 10:08:49 CST 2008
 */
package com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent;

import java.util.Collection;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: ChgReqListVO
 * </p>
 * <p>
 * Description: Query Params Object for ChgReqDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class ChgReqListVO extends BaseListVO {
	private String _se_tabname;

	private String _ne_tabtype;

	private String _se_oprtype;
	
	private String _ne_matchid;
	
	private String _ne_oprstate;
	
	private String _ne_chgtype;
	
	private String _se_oprcode;
	
	private String _dnl_oprtime;
	
	private String _dnm_oprtime;
	
	private Collection _nin_oprstate;
	
	private String _sk_mainvalue;
	

	public String get_sk_mainvalue() {
		return _sk_mainvalue;
	}

	public void set_sk_mainvalue(String _sk_mainvalue) {
		this._sk_mainvalue = _sk_mainvalue;
	}

	public Collection get_nin_oprstate() {
		return _nin_oprstate;
	}

	public void set_nin_oprstate(Collection _nin_oprstate) {
		this._nin_oprstate = _nin_oprstate;
	}

	public String get_ne_oprstate() {
		return _ne_oprstate;
	}

	public void set_ne_oprstate(String _ne_oprstate) {
		this._ne_oprstate = _ne_oprstate;
	}

	public String get_ne_matchid() {
		return _ne_matchid;
	}

	public void set_ne_matchid(String _ne_matchid) {
		this._ne_matchid = _ne_matchid;
	}

	public String get_ne_tabtype() {
		return _ne_tabtype;
	}

	public void set_ne_tabtype(String _ne_tabtype) {
		this._ne_tabtype = _ne_tabtype;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_tabname() {
		return _se_tabname;
	}

	public void set_se_tabname(String _se_tabname) {
		this._se_tabname = _se_tabname;
	}

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

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_ne_chgtype() {
		return _ne_chgtype;
	}

	public void set_ne_chgtype(String _ne_chgtype) {
		this._ne_chgtype = _ne_chgtype;
	}

}
