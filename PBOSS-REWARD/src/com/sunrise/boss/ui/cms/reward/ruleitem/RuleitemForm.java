/**
* auto-generated code
* Wed Sep 10 11:29:44 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.ruleitem;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;

/**
 * <p>Title: RuleitemForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemForm extends BaseActionForm {
    private String _se_ruleitemid;
    private String _se_ruleitemname;

		private String ruleitemid;
		private String ruleitemname;
		private String backruleitemid;
		private String contype;
		private Byte specflag;

    public String get_se_ruleitemid(){
        return _se_ruleitemid;
    }

    public void set_se_ruleitemid(String _se_ruleitemid){
        this._se_ruleitemid = _se_ruleitemid;
    }
    public String get_se_ruleitemname(){
        return _se_ruleitemname;
    }

    public void set_se_ruleitemname(String _se_ruleitemname){
        this._se_ruleitemname = _se_ruleitemname;
    }

		public  String getRuleitemid() {
        return ruleitemid;
    }
		public void setRuleitemid(String ruleitemid) {
        this.ruleitemid=ruleitemid;
    }
		public  String getRuleitemname() {
        return ruleitemname;
    }
		public void setRuleitemname(String ruleitemname) {
        this.ruleitemname=ruleitemname;
    }
		public  String getBackruleitemid() {
        return backruleitemid;
    }
		public void setBackruleitemid(String backruleitemid) {
        this.backruleitemid=backruleitemid;
    }
		public  String getContype() {
        return contype;
    }
		public void setContype(String contype) {
        this.contype=contype;
    }
		public  Byte getSpecflag() {
        return specflag;
    }
		public void setSpecflag(Byte specflag) {
        this.specflag=specflag;
    }

}
