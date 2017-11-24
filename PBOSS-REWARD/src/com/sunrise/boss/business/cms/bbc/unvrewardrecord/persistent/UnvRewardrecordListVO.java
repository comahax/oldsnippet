/**
* auto-generated code
* Wed Sep 02 15:01:47 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: UnvRewardrecordListVO</p>
 * <p>Description: Query Params Object for UnvRewardrecordDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvRewardrecordListVO extends BaseListVO {

	private String _se_wayid;
    private String _ne_totalid;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _se_ossrc;
    private String _se_opnid;
    private String _se_wayoprcode;
    private String _sk_wayoprcode;
    private String _sk_employeename;
    private String _se_wayname;
    private String _se_batchno;
    private List _sin_batchno;
    private String _se_telephone;
    
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
	public String get_se_wayname() {
		return _se_wayname;
	}
	public void set_se_wayname(String _se_wayname) {
		this._se_wayname = _se_wayname;
	}
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
	public String get_ne_totalid() {
		return _ne_totalid;
	}
	public void set_ne_totalid(String _ne_totalid) {
		this._ne_totalid = _ne_totalid;
	}
	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}
	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}
	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}
	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}
	public String get_se_ossrc() {
		return _se_ossrc;
	}
	public void set_se_ossrc(String _se_ossrc) {
		this._se_ossrc = _se_ossrc;
	}
	public String get_se_opnid() {
		return _se_opnid;
	}
	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}
	public String get_se_wayoprcode() {
		return _se_wayoprcode;
	}
	public void set_se_wayoprcode(String _se_wayoprcode) {
		this._se_wayoprcode = _se_wayoprcode;
	}
	public String get_sk_wayoprcode() {
		return _sk_wayoprcode;
	}
	public void set_sk_wayoprcode(String _sk_wayoprcode) {
		this._sk_wayoprcode = _sk_wayoprcode;
	}
	public String get_sk_employeename() {
		return _sk_employeename;
	}
	public void set_sk_employeename(String _sk_employeename) {
		this._sk_employeename = _sk_employeename;
	}
	public String get_se_telephone() {
		return _se_telephone;
	}
	public void set_se_telephone(String _se_telephone) {
		this._se_telephone = _se_telephone;
	}
	
}
