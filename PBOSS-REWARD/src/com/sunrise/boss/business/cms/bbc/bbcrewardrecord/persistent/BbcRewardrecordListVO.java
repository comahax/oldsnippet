/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WayintegraltransruleListVO</p>
 * <p>Description: Query Params Object for WayintegraltransruleDAO</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public class BbcRewardrecordListVO extends BaseListVO {
	
	
	private String _se_wayid;
    private String _ne_rewardid;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _se_wayoprcode;
    private String _se_opnid;
    private String _se_ossrc;
    private String _sql_ossrc;
    private String _se_batchno;
    private List _sin_batchno;
    private String _sql_rewardlistid;
    
    private String _se_mobile;
    private String _sin_opnid;
    private String _se_countyid;
    private String _se_chainhead;
        
    public String get_se_chainhead() {
		return _se_chainhead;
	}
	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public String get_se_mobile() {
		return _se_mobile;
	}
	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}
	
	public String get_sin_opnid() {
		return _sin_opnid;
	}
	public void set_sin_opnid(String _sin_opnid) {
		this._sin_opnid = _sin_opnid;
	}
	public String get_se_batchno() {
		return _se_batchno;
	}
	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
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
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
	public String get_ne_rewardid() {
		return _ne_rewardid;
	}
	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
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
	public String get_se_wayoprcode() {
		return _se_wayoprcode;
	}
	public void set_se_wayoprcode(String _se_wayoprcode) {
		this._se_wayoprcode = _se_wayoprcode;
	}
	public String get_se_opnid() {
		return _se_opnid;
	}
	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}
	public List get_sin_batchno() {
		return _sin_batchno;
	}
	public void set_sin_batchno(List _sin_batchno) {
		this._sin_batchno = _sin_batchno;
	}
	public String get_sql_rewardlistid() {
		return _sql_rewardlistid;
	}
	public void set_sql_rewardlistid(String _sql_rewardlistid) {
		this._sql_rewardlistid = _sql_rewardlistid;
	}
}
