/**
* auto-generated code
* Mon Apr 01 16:53:28 CST 2013
*/
package com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtRewardsyninfoListVO</p>
 * <p>Description: Query Params Object for ChAdtRewardsyninfoDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtRewardsyninfoListVO extends BaseListVO {
    private String _se_rewardmonth;
    private String _ne_systemflag;
    private String _ne_taskstate;
    private String _sk_operid;
    private String _dnm_optime;
    private String _dnl_optime;

    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_ne_systemflag(){
        return _ne_systemflag;
    }

    public void set_ne_systemflag(String _ne_systemflag){
        this._ne_systemflag = _ne_systemflag;
    }
    public String get_ne_taskstate(){
        return _ne_taskstate;
    }

    public void set_ne_taskstate(String _ne_taskstate){
        this._ne_taskstate = _ne_taskstate;
    }
    public String get_sk_operid(){
        return _sk_operid;
    }

    public void set_sk_operid(String _sk_operid){
        this._sk_operid = _sk_operid;
    }
    public String get_dnm_optime(){
        return _dnm_optime;
    }

    public void set_dnm_optime(String _dnm_optime){
        this._dnm_optime = _dnm_optime;
    }
    public String get_dnl_optime(){
        return _dnl_optime;
    }

    public void set_dnl_optime(String _dnl_optime){
        this._dnl_optime = _dnl_optime;
    }

}
