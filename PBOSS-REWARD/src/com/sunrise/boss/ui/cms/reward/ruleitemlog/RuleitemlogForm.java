/**
* auto-generated code
* Wed Sep 10 14:41:39 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.ruleitemlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogVO;

/**
 * <p>Title: RuleitemlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemlogForm extends BaseActionForm {
    private String _ne_logid;
    private String _se_oprcode;
    private String _se_oprtype;
    private String _se_contype;

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		private String ruleitemid;
		private String ruleitemname;
		private String backruleitemid;
		private String contype;
		private Byte specflag;

    public String get_ne_logid(){
        return _ne_logid;
    }

    public void set_ne_logid(String _ne_logid){
        this._ne_logid = _ne_logid;
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
    public String get_se_contype(){
        return _se_contype;
    }

    public void set_se_contype(String _se_contype){
        this._se_contype = _se_contype;
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
