/**
* auto-generated code
* Mon Sep 15 18:11:42 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rewardpoolyw;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywVO;

/**
 * <p>Title: RewardpoolywForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolywForm extends BaseActionForm {
    private String _ne_rewardtype;
    private String _se_region;
    private String _se_opnid;

		private Integer rewardtype;
		private String region;
		private String opnid;

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

		public  Integer getRewardtype() {
        return rewardtype;
    }
		public void setRewardtype(Integer rewardtype) {
        this.rewardtype=rewardtype;
    }
		public  String getRegion() {
        return region;
    }
		public void setRegion(String region) {
        this.region=region;
    }
		public  String getOpnid() {
        return opnid;
    }
		public void setOpnid(String opnid) {
        this.opnid=opnid;
    }

}
