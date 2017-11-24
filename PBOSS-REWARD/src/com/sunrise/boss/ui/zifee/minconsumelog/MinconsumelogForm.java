/**
* auto-generated code
* Fri Aug 08 15:19:25 CST 2008
*/
package com.sunrise.boss.ui.zifee.minconsumelog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogVO;

/**
 * <p>Title: MinconsumelogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MinconsumelogForm extends BaseActionForm {

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		private Long yxplanid;
		private Integer effectiveinterval;
		private Long consumecycle;
		private Integer cyclecount;
		private String effectivetype;
		private Double minconsume;


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
		public  Long getYxplanid() {
        return yxplanid;
    }
		public void setYxplanid(Long yxplanid) {
        this.yxplanid=yxplanid;
    }
		public  Integer getEffectiveinterval() {
        return effectiveinterval;
    }
		public void setEffectiveinterval(Integer effectiveinterval) {
        this.effectiveinterval=effectiveinterval;
    }
		public  Long getConsumecycle() {
        return consumecycle;
    }
		public void setConsumecycle(Long consumecycle) {
        this.consumecycle=consumecycle;
    }
		public  Integer getCyclecount() {
        return cyclecount;
    }
		public void setCyclecount(Integer cyclecount) {
        this.cyclecount=cyclecount;
    }
		public  String getEffectivetype() {
        return effectivetype;
    }
		public void setEffectivetype(String effectivetype) {
        this.effectivetype=effectivetype;
    }
		public  Double getMinconsume() {
        return minconsume;
    }
		public void setMinconsume(Double minconsume) {
        this.minconsume=minconsume;
    }

}
