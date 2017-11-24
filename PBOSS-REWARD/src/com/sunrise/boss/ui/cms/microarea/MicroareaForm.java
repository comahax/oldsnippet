/**
* auto-generated code
* Wed Apr 11 10:59:58 CST 2007
*/
package com.sunrise.boss.ui.cms.microarea;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO;

/**
 * <p>Title: MicroareaForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class MicroareaForm extends BaseActionForm {
    private String _se_macode;
    private String _se_svccode;
    private String _sk_maname;

		private String macode;
		private String svccode;
		private String maname;
		private Short matype;
		private String agent;
		private String billingcode;
		private String adacode;
		private String longitude;
		private String latitude;

    public String get_se_macode(){
        return _se_macode;
    }

    public void set_se_macode(String _se_macode){
        this._se_macode = _se_macode;
    }
    public String get_se_svccode(){
        return _se_svccode;
    }

    public void set_se_svccode(String _se_svccode){
        this._se_svccode = _se_svccode;
    }
    public String get_sk_maname(){
        return _sk_maname;
    }

    public void set_sk_maname(String _sk_maname){
        this._sk_maname = _sk_maname;
    }

		public  String getMacode() {
        return macode;
    }
		public void setMacode(String macode) {
        this.macode=macode;
    }
		public  String getSvccode() {
        return svccode;
    }
		public void setSvccode(String svccode) {
        this.svccode=svccode;
    }
		public  String getManame() {
        return maname;
    }
		public void setManame(String maname) {
        this.maname=maname;
    }
		public  Short getMatype() {
        return matype;
    }
		public void setMatype(Short matype) {
        this.matype=matype;
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
