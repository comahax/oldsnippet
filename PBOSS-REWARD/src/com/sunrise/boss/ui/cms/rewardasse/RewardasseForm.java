/**
* auto-generated code
* Thu Jan 31 15:08:13 CST 2008
*/
package com.sunrise.boss.ui.cms.rewardasse;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseVO;

/**
 * <p>Title: RewardasseForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
public class RewardasseForm extends BaseActionForm {
    private String _se_wayid;
    private String _snl_assemonth;
    private String _snm_assemonth;
    private String _ne_rewardtype;
    private String _sk_wayid;

		private String wayid;
		private String assemonth;
		private Integer rewardtype;
		private Float assegrade;
		private String memo;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_snl_assemonth(){
        return _snl_assemonth;
    }

    public void set_snl_assemonth(String _snl_assemonth){
        this._snl_assemonth = _snl_assemonth;
    }
    public String get_snm_assemonth(){
        return _snm_assemonth;
    }

    public void set_snm_assemonth(String _snm_assemonth){
        this._snm_assemonth = _snm_assemonth;
    }
    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }

		public  String getWayid() {
        return wayid;
    }
		public void setWayid(String wayid) {
        this.wayid=wayid;
    }
		public  String getAssemonth() {
        return assemonth;
    }
		public void setAssemonth(String assemonth) {
        this.assemonth=assemonth;
    }
		public  Integer getRewardtype() {
        return rewardtype;
    }
		public void setRewardtype(Integer rewardtype) {
        this.rewardtype=rewardtype;
    }
		public  Float getAssegrade() {
        return assegrade;
    }
		public void setAssegrade(Float assegrade) {
        this.assegrade=assegrade;
    }
		public  String getMemo() {
        return memo;
    }
		public void setMemo(String memo) {
        this.memo=memo;
    }

		public String get_sk_wayid() {
			return _sk_wayid;
		}

		public void set_sk_wayid(String _sk_wayid) {
			this._sk_wayid = _sk_wayid;
		}

}
