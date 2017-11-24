/**
* auto-generated code
* Sun Feb 03 10:16:15 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rulelog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogVO;

/**
 * <p>Title: RulelogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulelogForm extends BaseActionForm {

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		private String ruleid;
		private String rulename;
		private java.util.Date startdate;
		private java.util.Date enddate;
		private String remark;


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
		public  String getRuleid() {
        return ruleid;
    }
		public void setRuleid(String ruleid) {
        this.ruleid=ruleid;
    }
		public  String getRulename() {
        return rulename;
    }
		public void setRulename(String rulename) {
        this.rulename=rulename;
    }
		public  java.util.Date getStartdate() {
        return startdate;
    }
		public void setStartdate(java.util.Date startdate) {
        this.startdate=startdate;
    }
		public  java.util.Date getEnddate() {
        return enddate;
    }
		public void setEnddate(java.util.Date enddate) {
        this.enddate=enddate;
    }
		public  String getRemark() {
        return remark;
    }
		public void setRemark(String remark) {
        this.remark=remark;
    }

}
