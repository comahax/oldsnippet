/**
* auto-generated code
* Tue Mar 13 17:29:11 CST 2012
*/
package com.sunrise.boss.business.cms.cityrecordtotal.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CityrecordtotalListVO</p>
 * <p>Description: Query Params Object for CityrecordtotalDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class CityrecordtotalListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_opnid;
    private String _se_rewardmonth;
    private String _ne_rewardtype;
    private String _ne_isflag;
    private String _ne_systemflag;
    private String sqlopnid;
    private String _se_chainhead;
    private String _se_approveid;
    private String _ne_taskid;
    private String _se_countyid;
    private String _sin_opnid;
    private String _se_mobile;
    
    
    public String get_sin_opnid() {
		return _sin_opnid;
	}

	public void set_sin_opnid(String _sin_opnid) {
		this._sin_opnid = _sin_opnid;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_ne_taskid() {
		return _ne_taskid;
	}

	public void set_ne_taskid(String _ne_taskid) {
		this._ne_taskid = _ne_taskid;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public String get_se_approveid() {
		return _se_approveid;
	}

	public void set_se_approveid(String _se_approveid) {
		this._se_approveid = _se_approveid;
	}

	public String getSqlopnid() {
		return sqlopnid;
	}

	public void setSqlopnid(String sqlopnid) {
		this.sqlopnid = sqlopnid;
	}

	public String get_ne_isflag() {
		return _ne_isflag;
	}

	public void set_ne_isflag(String _ne_isflag) {
		this._ne_isflag = _ne_isflag;
	}

	public String get_ne_systemflag() {
		return _ne_systemflag;
	}

	public void set_ne_systemflag(String _ne_systemflag) {
		this._ne_systemflag = _ne_systemflag;
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
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }

}
