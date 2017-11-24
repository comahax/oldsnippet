/**
* auto-generated code
* Tue Aug 21 12:28:54 CST 2012
*/
package com.sunrise.boss.business.cms.chadtdcordhis.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtDcordhisListVO</p>
 * <p>Description: Query Params Object for ChAdtDcordhisDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtDcordhisListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_opnid;
    private String _se_oprmonth;
    private String _ne_rewardtype;
    private String _se_rewardmonth;
    private String _ne_isflag; 
    private String _ne_systemflag;
    private String _se_mobile;
    private String sqlopnid;
    private String _sin_opnid;
    private String  _sql_oprtime;
    private String _sql_opnid;
    public String getSqlopnid() {
		return sqlopnid;
	}

	public void setSqlopnid(String sqlopnid) {
		this.sqlopnid = sqlopnid;
	}

	public String get_sin_opnid() {
		return _sin_opnid;
	}

	public void set_sin_opnid(String _sin_opnid) {
		this._sin_opnid = _sin_opnid;
	}

	public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_oprmonth(){
        return _se_oprmonth;
    }

    public void set_se_oprmonth(String _se_oprmonth){
        this._se_oprmonth = _se_oprmonth;
    }
    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_ne_isflag(){
        return _ne_isflag;
    }

    public void set_ne_isflag(String _ne_isflag){
        this._ne_isflag = _ne_isflag;
    }

	public String get_ne_systemflag() {
		return _ne_systemflag;
	}

	public void set_ne_systemflag(String _ne_systemflag) {
		this._ne_systemflag = _ne_systemflag;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_sql_oprtime() {
		return _sql_oprtime;
	}

	public void set_sql_oprtime(String _sql_oprtime) {
		this._sql_oprtime = _sql_oprtime;
	}

	public String get_sql_opnid() {
		return _sql_opnid;
	}

	public void set_sql_opnid(String _sql_opnid) {
		this._sql_opnid = _sql_opnid;
	}

}
