/**
* auto-generated code
* Fri Feb 01 18:16:01 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpoolr.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardpoolrListVO</p>
 * <p>Description: Query Params Object for RewardpoolrDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolrListVO extends BaseListVO {
    private String _ne_rewardtype;
    private String _se_region;
    private String _dnl_startdate;
    private String _dnm_stopdate;

    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }
    public String get_se_region(){
        return _se_region;
    }

    public void set_se_region(String _se_region){
        this._se_region = _se_region;
    }
    public String get_dnl_startdate(){
        return _dnl_startdate;
    }

    public void set_dnl_startdate(String _dnl_startdate){
        this._dnl_startdate = _dnl_startdate;
    }
    public String get_dnm_stopdate(){
        return _dnm_stopdate;
    }

    public void set_dnm_stopdate(String _dnm_stopdate){
        this._dnm_stopdate = _dnm_stopdate;
    }

}
