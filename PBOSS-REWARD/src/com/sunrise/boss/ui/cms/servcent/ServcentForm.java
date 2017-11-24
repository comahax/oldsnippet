/**
* auto-generated code
* Wed Apr 11 11:02:17 CST 2007
*/
package com.sunrise.boss.ui.cms.servcent;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;

/**
 * <p>Title: ServcentForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class ServcentForm extends BaseActionForm {
    private String _se_svccode;
    private String _se_countyid;
    private String _sk_svcname;
    private String _se_adacode;

		private String svccode;
		private String countyid;
		private String svcname;
		private Short svctype;
		private String agent;
		private String billingcode;
		private String adacode;
		private String longitude;
		private String latitude;

    public String get_se_svccode(){
        return _se_svccode;
    }

    public void set_se_svccode(String _se_svccode){
        this._se_svccode = _se_svccode;
    }
    public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_sk_svcname(){
        return _sk_svcname;
    }

    public void set_sk_svcname(String _sk_svcname){
        this._sk_svcname = _sk_svcname;
    }
    public String get_se_adacode(){
        return _se_adacode;
    }

    public void set_se_adacode(String _se_adacode){
        this._se_adacode = _se_adacode;
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
