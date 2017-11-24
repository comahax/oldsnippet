/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent;

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
public class BbcRewardtotalListVO extends BaseListVO {
	private String _se_wayid;
    private String _ne_totalid;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _se_ossrc;
    private String _sql_ossrc;
    private String _se_batchno;
    private List _sin_batchno;
    
	public List get_sin_batchno() {
		return _sin_batchno;
	}
	public void set_sin_batchno(List _sin_batchno) {
		this._sin_batchno = _sin_batchno;
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
	public String get_sql_ossrc() {
		return _sql_ossrc;
	}
	public void set_sql_ossrc(String _sql_ossrc) {
		this._sql_ossrc = _sql_ossrc;
	}
	public String get_se_batchno() {
		return _se_batchno;
	}
	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

}
