/**
* auto-generated code
* Wed Sep 10 14:39:49 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rulerellog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogVO;

/**
 * <p>Title: RulerellogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulerellogForm extends BaseActionForm {
    private String _ne_logid;
    private String _de_optime;
    private String _se_oprcode;
    private String _se_oprtype;

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		private String ruleitemid;
		private String ruleid;
		private String cityid;
		private Short state;
		private Short isdefault;
		private String paramer;
		
		

    public String getParamer() {
			return paramer;
		}

		public void setParamer(String paramer) {
			this.paramer = paramer;
		}

	public String get_ne_logid(){
        return _ne_logid;
    }

    public void set_ne_logid(String _ne_logid){
        this._ne_logid = _ne_logid;
    }
    public String get_de_optime(){
        return _de_optime;
    }

    public void set_de_optime(String _de_optime){
        this._de_optime = _de_optime;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }

		public  Long getLogid() {
        return logid;
    }
		public void setLogid(Long logid) {
        this.logid=logid;
    }
		public  java.util.Date getOptime() {
        return optime;
    }
		public void setOptime(java.util.Date optime) {
        this.optime=optime;
    }
		public  String getOprcode() {
        return oprcode;
    }
		public void setOprcode(String oprcode) {
        this.oprcode=oprcode;
    }
		public  String getOprtype() {
        return oprtype;
    }
		public void setOprtype(String oprtype) {
        this.oprtype=oprtype;
    }
		public  String getSuccess() {
        return success;
    }
		public void setSuccess(String success) {
        this.success=success;
    }
		public  String getRuleitemid() {
        return ruleitemid;
    }
		public void setRuleitemid(String ruleitemid) {
        this.ruleitemid=ruleitemid;
    }
		public  String getRuleid() {
        return ruleid;
    }
		public void setRuleid(String ruleid) {
        this.ruleid=ruleid;
    }
		public  String getCityid() {
        return cityid;
    }
		public void setCityid(String cityid) {
        this.cityid=cityid;
    }
		public  Short getState() {
        return state;
    }
		public void setState(Short state) {
        this.state=state;
    }
		public  Short getIsdefault() {
        return isdefault;
    }
		public void setIsdefault(Short isdefault) {
        this.isdefault=isdefault;
    }

}
