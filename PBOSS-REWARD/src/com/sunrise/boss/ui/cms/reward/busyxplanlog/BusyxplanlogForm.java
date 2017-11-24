/**
* auto-generated code
* Sat Feb 02 15:15:28 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.busyxplanlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogVO;

/**
 * <p>Title: BusyxplanlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanlogForm extends BaseActionForm {
    private String _se_opnid;
    private String _ne_yxplanid;

		private String opnid;
		private Long yxplanid;
		private Double wrapfee;
		private String cityid;
		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		 private Long noncyc ; //客户维系酬金发放期数

    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_ne_yxplanid(){
        return _ne_yxplanid;
    }

    public void set_ne_yxplanid(String _ne_yxplanid){
        this._ne_yxplanid = _ne_yxplanid;
    }

		public  String getOpnid() {
        return opnid;
    }
		public void setOpnid(String opnid) {
        this.opnid=opnid;
    }
		public  Long getYxplanid() {
        return yxplanid;
    }
		public void setYxplanid(Long yxplanid) {
        this.yxplanid=yxplanid;
    }
		public  Double getWrapfee() {
        return wrapfee;
    }
		public void setWrapfee(Double wrapfee) {
        this.wrapfee=wrapfee;
    }
		public  String getCityid() {
        return cityid;
    }
		public void setCityid(String cityid) {
        this.cityid=cityid;
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

		public Long getNoncyc() {
			return noncyc;
		}

		public void setNoncyc(Long noncyc) {
			this.noncyc = noncyc;
		}

}
