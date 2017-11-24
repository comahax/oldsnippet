/**
* auto-generated code
* Thu Sep 11 19:35:20 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.ruleitemrl;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlVO;

/**
 * <p>Title: RuleitemrlForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemrlForm extends BaseActionForm {
    private String _se_ruleid;
    private String _ne_groupid;
    private String _se_ruleitemid;

		private String ruleid;
		private Short groupid;
		private Short rltype;
		private String ruleitemid;
		private Short isleader;

    public String get_se_ruleid(){
        return _se_ruleid;
    }

    public void set_se_ruleid(String _se_ruleid){
        this._se_ruleid = _se_ruleid;
    }
    public String get_ne_groupid(){
        return _ne_groupid;
    }

    public void set_ne_groupid(String _ne_groupid){
        this._ne_groupid = _ne_groupid;
    }
    public String get_se_ruleitemid(){
        return _se_ruleitemid;
    }

    public void set_se_ruleitemid(String _se_ruleitemid){
        this._se_ruleitemid = _se_ruleitemid;
    }

		public  String getRuleid() {
        return ruleid;
    }
		public void setRuleid(String ruleid) {
        this.ruleid=ruleid;
    }
		public  Short getGroupid() {
        return groupid;
    }
		public void setGroupid(Short groupid) {
        this.groupid=groupid;
    }
		public  Short getRltype() {
        return rltype;
    }
		public void setRltype(Short rltype) {
        this.rltype=rltype;
    }
		public  String getRuleitemid() {
        return ruleitemid;
    }
		public void setRuleitemid(String ruleitemid) {
        this.ruleitemid=ruleitemid;
    }
		public  Short getIsleader() {
        return isleader;
    }
		public void setIsleader(Short isleader) {
        this.isleader=isleader;
    }

}
