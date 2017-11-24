/**
* auto-generated code
* Mon Apr 30 16:49:59 CST 2007
*/
package com.sunrise.boss.ui.admin.logincase;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseVO;

/**
 * <p>Title: LogincaseForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class LogincaseForm extends BaseActionForm {
    private String _se_module;
    private String _sk_operid;
    private String _sk_wayid;
    private String _se_cityid;
    private String _se_roleid;

		private String module;
		private String operid;
		private String wayid;
		private String cityid;
		private java.util.Date createtime;
		private String roleid;

    public String get_se_module(){
        return _se_module;
    }

    public void set_se_module(String _se_module){
        this._se_module = _se_module;
    }
    public String get_sk_operid(){
        return _sk_operid;
    }

    public void set_sk_operid(String _sk_operid){
        this._sk_operid = _sk_operid;
    }
    public String get_sk_wayid(){
        return _sk_wayid;
    }

    public void set_sk_wayid(String _sk_wayid){
        this._sk_wayid = _sk_wayid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_se_roleid(){
        return _se_roleid;
    }

    public void set_se_roleid(String _se_roleid){
        this._se_roleid = _se_roleid;
    }

		public  String getModule() {
        return module;
    }
		public void setModule(String module) {
        this.module=module;
    }
		public  String getOperid() {
        return operid;
    }
		public void setOperid(String operid) {
        this.operid=operid;
    }
		public  String getWayid() {
        return wayid;
    }
		public void setWayid(String wayid) {
        this.wayid=wayid;
    }
		public  String getCityid() {
        return cityid;
    }
		public void setCityid(String cityid) {
        this.cityid=cityid;
    }
		public  java.util.Date getCreatetime() {
        return createtime;
    }
		public void setCreatetime(java.util.Date createtime) {
        this.createtime=createtime;
    }
		public  String getRoleid() {
        return roleid;
    }
		public void setRoleid(String roleid) {
        this.roleid=roleid;
    }

}
