/**
* auto-generated code
* Tue Oct 24 14:18:05 CST 2006
*/
package com.sunrise.boss.ui.cms.cntycomlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.cntycomlog.persistent.CntycomlogVO;

/**
 * <p>Title: CntycomlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class CntycomlogForm extends BaseActionForm {
    private String _dnl_optime;
    private String _dnm_optime;
    private String _sk_oprcode;
    private String _se_oprtype;
    private String _se_success;

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		private String countycompid;
		private String citycompid;
		private String countycompname;
		private Short countycomptype;
		private String agent;
		private String billingcode;
		
		private String adacode;
		private String longitude;
		private String latitude;

    public String get_dnl_optime(){
        return _dnl_optime;
    }

    public void set_dnl_optime(String _dnl_optime){
        this._dnl_optime = _dnl_optime;
    }
    public String get_dnm_optime(){
        return _dnm_optime;
    }

    public void set_dnm_optime(String _dnm_optime){
        this._dnm_optime = _dnm_optime;
    }
    public String get_sk_oprcode(){
        return _sk_oprcode;
    }

    public void set_sk_oprcode(String _sk_oprcode){
        this._sk_oprcode = _sk_oprcode;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }
    public String get_se_success(){
        return _se_success;
    }

    public void set_se_success(String _se_success){
        this._se_success = _se_success;
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
		public  String getCountycompid() {
        return countycompid;
    }
		public void setCountycompid(String countycompid) {
        this.countycompid=countycompid;
    }
		public  String getCitycompid() {
        return citycompid;
    }
		public void setCitycompid(String citycompid) {
        this.citycompid=citycompid;
    }
		public  String getCountycompname() {
        return countycompname;
    }
		public void setCountycompname(String countycompname) {
        this.countycompname=countycompname;
    }
		public  Short getCountycomptype() {
        return countycomptype;
    }
		public void setCountycomptype(Short countycomptype) {
        this.countycomptype=countycomptype;
    }
		public  String getAgent() {
        return agent;
    }
		public void setAgent(String agent) {
        this.agent=agent;
    }
		public  String getBillingcode() {
        return billingcode;
    }
		public void setBillingcode(String billingcode) {
        this.billingcode=billingcode;
    }

		public String getAdacode() {
			return adacode;
		}

		public void setAdacode(String adacode) {
			this.adacode = adacode;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

}
