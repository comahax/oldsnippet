/**
* auto-generated code
* Mon Apr 16 17:14:45 CST 2007
*/
package com.sunrise.boss.ui.cms.servcentlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogVO;

/**
 * <p>Title: ServcentlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class ServcentlogForm extends BaseActionForm {
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
		private String svccode;
		private String countyid;
		private String svcname;
		private Short svctype;
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
		public  String getSvccode() {
        return svccode;
    }
		public void setSvccode(String svccode) {
        this.svccode=svccode;
    }
		public  String getCountyid() {
        return countyid;
    }
		public void setCountyid(String countyid) {
        this.countyid=countyid;
    }
		public  String getSvcname() {
        return svcname;
    }
		public void setSvcname(String svcname) {
        this.svcname=svcname;
    }
		public  Short getSvctype() {
        return svctype;
    }
		public void setSvctype(Short svctype) {
        this.svctype=svctype;
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
		public  String getAdacode() {
        return adacode;
    }
		public void setAdacode(String adacode) {
        this.adacode=adacode;
    }
		public  String getLongitude() {
        return longitude;
    }
		public void setLongitude(String longitude) {
        this.longitude=longitude;
    }
		public  String getLatitude() {
        return latitude;
    }
		public void setLatitude(String latitude) {
        this.latitude=latitude;
    }

}
