/**
* auto-generated code
* Wed Nov 02 19:11:53 CST 2011
*/
package com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardslvlimitListVO</p>
 * <p>Description: Query Params Object for RewardslvlimitDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class RewardslvlimitListVO extends BaseListVO {
    private String _ne_rewardid;
    private String _se_region;
    private String _se_opnid;
    private String _ne_slv;

    public String get_ne_rewardid(){
        return _ne_rewardid;
    }

    public void set_ne_rewardid(String _ne_rewardid){
        this._ne_rewardid = _ne_rewardid;
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
    public String get_ne_slv(){
        return _ne_slv;
    }

    public void set_ne_slv(String _ne_slv){
        this._ne_slv = _ne_slv;
    }

}
