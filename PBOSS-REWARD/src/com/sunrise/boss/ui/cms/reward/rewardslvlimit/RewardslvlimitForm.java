/**
* auto-generated code
* Wed Nov 02 19:11:53 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.rewardslvlimit;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitVO;

/**
 * <p>Title: RewardslvlimitForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class RewardslvlimitForm extends BaseActionForm {

    private java.lang.Long rewardid;
    private java.lang.String region;
    private java.lang.String opnid;
    private java.lang.Short slv;
    private java.lang.Double rewardlimit;

    private String _ne_rewardid;
    private String _se_region;
    private String _se_opnid;
    private String _ne_slv;

    public java.lang.Long getRewardid(){
        return rewardid;
    }

    public void setRewardid(java.lang.Long rewardid){
        this.rewardid = rewardid;
    }
    public java.lang.String getRegion(){
        return region;
    }

    public void setRegion(java.lang.String region){
        this.region = region;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.Short getSlv(){
        return slv;
    }

    public void setSlv(java.lang.Short slv){
        this.slv = slv;
    }
    public java.lang.Double getRewardlimit(){
        return rewardlimit;
    }

    public void setRewardlimit(java.lang.Double rewardlimit){
        this.rewardlimit = rewardlimit;
    }

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
