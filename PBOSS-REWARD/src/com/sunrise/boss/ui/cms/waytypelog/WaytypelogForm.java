/**
* auto-generated code
* Tue Oct 17 17:31:29 CST 2006
*/
package com.sunrise.boss.ui.cms.waytypelog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.waytypelog.persistent.WaytypelogVO;

/**
 * <p>Title: WaytypelogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaytypelogForm extends BaseActionForm {
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
		private String waytypecode;
		private String waytypename;
		private String uppercode;
		private String desp;

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
		public  String getWaytypecode() {
        return waytypecode;
    }
		public void setWaytypecode(String waytypecode) {
        this.waytypecode=waytypecode;
    }
		public  String getWaytypename() {
        return waytypename;
    }
		public void setWaytypename(String waytypename) {
        this.waytypename=waytypename;
    }
		public  String getUppercode() {
        return uppercode;
    }
		public void setUppercode(String uppercode) {
        this.uppercode=uppercode;
    }
		public  String getDesp() {
        return desp;
    }
		public void setDesp(String desp) {
        this.desp=desp;
    }

}
