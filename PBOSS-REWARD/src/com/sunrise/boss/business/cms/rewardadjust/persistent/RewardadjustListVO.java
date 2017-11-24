/**
* auto-generated code
* Wed Dec 24 11:06:41 CST 2008
*/
package com.sunrise.boss.business.cms.rewardadjust.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardadjustListVO</p>
 * <p>Description: Query Params Object for RewardadjustDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardadjustListVO extends BaseListVO {
    private String _se_adjustkind;
    private String _se_wayid;
    private String _snl_eftmonth;
    private String _snm_eftmonth;
    private String _se_adjusttype;
    private String _sk_reasontype;
    private String _se_rewardtype;
    private String _ne_islock;
    private String _se_srcmonth;
    private String _ne_adjsrcseq;
    private String _se_adjsrc;
    private String _nne_islock;
    public String get_se_adjustkind(){
        return _se_adjustkind;
    }

    public void set_se_adjustkind(String _se_adjustkind){
        this._se_adjustkind = _se_adjustkind;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_snl_eftmonth(){
        return _snl_eftmonth;
    }

    public void set_snl_eftmonth(String _snl_eftmonth){
        this._snl_eftmonth = _snl_eftmonth;
    }
    public String get_snm_eftmonth(){
        return _snm_eftmonth;
    }

    public void set_snm_eftmonth(String _snm_eftmonth){
        this._snm_eftmonth = _snm_eftmonth;
    }
    public String get_se_adjusttype(){
        return _se_adjusttype;
    }

    public void set_se_adjusttype(String _se_adjusttype){
        this._se_adjusttype = _se_adjusttype;
    }
    public String get_sk_reasontype(){
        return _sk_reasontype;
    }

    public void set_sk_reasontype(String _sk_reasontype){
        this._sk_reasontype = _sk_reasontype;
    }
    public String get_se_rewardtype(){
        return _se_rewardtype;
    }

    public void set_se_rewardtype(String _se_rewardtype){
        this._se_rewardtype = _se_rewardtype;
    }
    public String get_ne_islock(){
        return _ne_islock;
    }

    public void set_ne_islock(String _ne_islock){
        this._ne_islock = _ne_islock;
    }

	public String get_se_srcmonth() {
		return _se_srcmonth;
	}

	public void set_se_srcmonth(String _se_srcmonth) {
		this._se_srcmonth = _se_srcmonth;
	}

	public String get_ne_adjsrcseq() {
		return _ne_adjsrcseq;
	}

	public void set_ne_adjsrcseq(String _ne_adjsrcseq) {
		this._ne_adjsrcseq = _ne_adjsrcseq;
	}

	public String get_se_adjsrc() {
		return _se_adjsrc;
	}

	public void set_se_adjsrc(String _se_adjsrc) {
		this._se_adjsrc = _se_adjsrc;
	}

	public String get_nne_islock() {
		return _nne_islock;
	}

	public void set_nne_islock(String _nne_islock) {
		this._nne_islock = _nne_islock;
	}

}
