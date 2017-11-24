/**
* auto-generated code
* Mon Apr 16 17:13:59 CST 2007
*/
package com.sunrise.boss.ui.cms.adimarealog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogVO;

/**
 * <p>Title: AdimarealogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class AdimarealogForm extends BaseActionForm {
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
		private String adacode;
		private String adaname;
		private Short adatype;
		private Short adalevel;
		private String uppercode;
		private String datayear;
		private Byte status;
		private Long totalppn;
		private Long resippn;
		private Long nonresippn;
		private Long adarea;
		private Long avgincome;
		private Long gmccusers;
		private Long cucusers;
		private Long ctcusers;
		private Long handphones;
		private String orgcode;
		private Short orgtype;

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
		public  String getAdacode() {
        return adacode;
    }
		public void setAdacode(String adacode) {
        this.adacode=adacode;
    }
		public  String getAdaname() {
        return adaname;
    }
		public void setAdaname(String adaname) {
        this.adaname=adaname;
    }
		public  Short getAdatype() {
        return adatype;
    }
		public void setAdatype(Short adatype) {
        this.adatype=adatype;
    }
		public  Short getAdalevel() {
        return adalevel;
    }
		public void setAdalevel(Short adalevel) {
        this.adalevel=adalevel;
    }
		public  String getUppercode() {
        return uppercode;
    }
		public void setUppercode(String uppercode) {
        this.uppercode=uppercode;
    }
		public  String getDatayear() {
        return datayear;
    }
		public void setDatayear(String datayear) {
        this.datayear=datayear;
    }
		public  Byte getStatus() {
        return status;
    }
		public void setStatus(Byte status) {
        this.status=status;
    }
		public  Long getTotalppn() {
        return totalppn;
    }
		public void setTotalppn(Long totalppn) {
        this.totalppn=totalppn;
    }
		public  Long getResippn() {
        return resippn;
    }
		public void setResippn(Long resippn) {
        this.resippn=resippn;
    }
		public  Long getNonresippn() {
        return nonresippn;
    }
		public void setNonresippn(Long nonresippn) {
        this.nonresippn=nonresippn;
    }
		public  Long getAdarea() {
        return adarea;
    }
		public void setAdarea(Long adarea) {
        this.adarea=adarea;
    }
		public  Long getAvgincome() {
        return avgincome;
    }
		public void setAvgincome(Long avgincome) {
        this.avgincome=avgincome;
    }
		public  Long getGmccusers() {
        return gmccusers;
    }
		public void setGmccusers(Long gmccusers) {
        this.gmccusers=gmccusers;
    }
		public  Long getCucusers() {
        return cucusers;
    }
		public void setCucusers(Long cucusers) {
        this.cucusers=cucusers;
    }
		public  Long getCtcusers() {
        return ctcusers;
    }
		public void setCtcusers(Long ctcusers) {
        this.ctcusers=ctcusers;
    }
		public  Long getHandphones() {
        return handphones;
    }
		public void setHandphones(Long handphones) {
        this.handphones=handphones;
    }
		public  String getOrgcode() {
        return orgcode;
    }
		public void setOrgcode(String orgcode) {
        this.orgcode=orgcode;
    }

		public Short getOrgtype() {
			return orgtype;
		}

		public void setOrgtype(Short orgtype) {
			this.orgtype = orgtype;
		}
		

}
