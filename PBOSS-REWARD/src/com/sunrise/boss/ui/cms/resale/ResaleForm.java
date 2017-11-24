/**
* auto-generated code
* Fri Jan 04 15:56:32 CST 2008
*/
package com.sunrise.boss.ui.cms.resale;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.resale.persistent.ResaleVO;

/**
 * <p>Title: ResaleForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ResaleForm extends BaseActionForm {
    private String _se_wayid;
    private String _se_mobile;
    private String _dnl_daytime;
    private String _dnm_daytime;

		private Long itemid;
		private String wayid;
		private String mobile;
		private String countyid;
		private Long brand;
		private java.util.Date daytime;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_dnl_daytime(){
        return _dnl_daytime;
    }

    public void set_dnl_daytime(String _dnl_daytime){
        this._dnl_daytime = _dnl_daytime;
    }
    public String get_dnm_daytime(){
        return _dnm_daytime;
    }

    public void set_dnm_daytime(String _dnm_daytime){
        this._dnm_daytime = _dnm_daytime;
    }

		public  Long getItemid() {
        return itemid;
    }
		public void setItemid(Long itemid) {
        this.itemid=itemid;
    }
		public  String getWayid() {
        return wayid;
    }
		public void setWayid(String wayid) {
        this.wayid=wayid;
    }
		public  String getMobile() {
        return mobile;
    }
		public void setMobile(String mobile) {
        this.mobile=mobile;
    }
		public  String getCountyid() {
        return countyid;
    }
		public void setCountyid(String countyid) {
        this.countyid=countyid;
    }
		public  Long getBrand() {
        return brand;
    }
		public void setBrand(Long brand) {
        this.brand=brand;
    }
		public  java.util.Date getDaytime() {
        return daytime;
    }
		public void setDaytime(java.util.Date daytime) {
        this.daytime=daytime;
    }

}
