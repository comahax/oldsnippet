/**
* auto-generated code
* Wed Apr 29 14:17:22 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BbcFaildataqueryListVO</p>
 * <p>Description: Query Params Object for BbcFaildataqueryDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcFaildataqueryListVO extends BaseListVO {

	private String _se_rewardtype;

	private String _se_opnid;

	private String _se_wayid;

	private String _dnl_oprtime;

	private String _dnm_oprtime;

	private String _se_oprcode;
	
	private String _se_mobile;
	
	private String _sk_adtcode;
	
	private String _sk_adtremark;
	
	private String _se_ossrc;
	
	private String _sql_ossrc;
	
	private String _se_batchno;
	
	private List _sin_batchno;

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public List get_sin_batchno() {
		return _sin_batchno;
	}

	public void set_sin_batchno(List _sin_batchno) {
		this._sin_batchno = _sin_batchno;
	}

	public String get_sql_ossrc() {
		return _sql_ossrc;
	}

	public void set_sql_ossrc(String _sql_ossrc) {
		this._sql_ossrc = _sql_ossrc;
	}

	public String get_se_ossrc() {
		return _se_ossrc;
	}

	public void set_se_ossrc(String _se_ossrc) {
		this._se_ossrc = _se_ossrc;
	}

	public String get_sk_adtremark() {
		return _sk_adtremark;
	}

	public void set_sk_adtremark(String _sk_adtremark) {
		this._sk_adtremark = _sk_adtremark;
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

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
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

	public String get_se_rewardtype() {
		return _se_rewardtype;
	}

	public void set_se_rewardtype(String _se_rewardtype) {
		this._se_rewardtype = _se_rewardtype;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sk_adtcode() {
		return _sk_adtcode;
	}

	public void set_sk_adtcode(String _sk_adtcode) {
		this._sk_adtcode = _sk_adtcode;
	}
}
