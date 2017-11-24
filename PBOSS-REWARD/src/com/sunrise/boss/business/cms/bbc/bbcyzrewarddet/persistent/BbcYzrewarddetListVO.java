/**
* auto-generated code
* Mon Nov 16 17:27:59 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BbcYzrewarddetListVO</p>
 * <p>Description: Query Params Object for BbcYzrewarddetDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcYzrewarddetListVO extends BaseListVO {

	private String _ne_batchno;
	
	private String _se_cityid;

    /** identifier field */
    private String _ne_rptmon;

    /** identifier field */
    private String _ne_tztype;

    /** identifier field */
    private String _se_wayid;

    /** nullable persistent field */
    private String _ne_num;

    /** nullable persistent field */
    private String _ne_yzreward;

    /** nullable persistent field */
    private String _ne_adjreward;
    
    private List _sin_batchno;
    
    private String _se_batchno;
    
    private String _sql_tztype;


	public String get_sql_tztype() {
		return _sql_tztype;
	}

	public void set_sql_tztype(String _sql_tztype) {
		this._sql_tztype = _sql_tztype;
	}

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

	public String get_ne_adjreward() {
		return _ne_adjreward;
	}

	public void set_ne_adjreward(String _ne_adjreward) {
		this._ne_adjreward = _ne_adjreward;
	}

	public String get_ne_batchno() {
		return _ne_batchno;
	}

	public void set_ne_batchno(String _ne_batchno) {
		this._ne_batchno = _ne_batchno;
	}

	public String get_ne_num() {
		return _ne_num;
	}

	public void set_ne_num(String _ne_num) {
		this._ne_num = _ne_num;
	}

	public String get_ne_rptmon() {
		return _ne_rptmon;
	}

	public void set_ne_rptmon(String _ne_rptmon) {
		this._ne_rptmon = _ne_rptmon;
	}

	public String get_ne_tztype() {
		return _ne_tztype;
	}

	public void set_ne_tztype(String _ne_tztype) {
		this._ne_tztype = _ne_tztype;
	}

	public String get_ne_yzreward() {
		return _ne_yzreward;
	}

	public void set_ne_yzreward(String _ne_yzreward) {
		this._ne_yzreward = _ne_yzreward;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
}
