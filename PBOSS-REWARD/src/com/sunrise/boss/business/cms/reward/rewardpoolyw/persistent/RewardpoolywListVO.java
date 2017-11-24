/**
* auto-generated code
* Mon Sep 15 18:11:42 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardpoolywListVO</p>
 * <p>Description: Query Params Object for RewardpoolywDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolywListVO extends BaseListVO {
    private String _ne_rewardtype;
    private String _se_region;
    private String _se_opnid;

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
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }

}
