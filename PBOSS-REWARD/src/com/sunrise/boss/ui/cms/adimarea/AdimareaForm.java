/**
* auto-generated code
* Thu Apr 05 10:00:59 CST 2007
*/
package com.sunrise.boss.ui.cms.adimarea;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;

/**
 * <p>Title: AdimareaForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class AdimareaForm extends BaseActionForm {
    private String _se_adacode;
    private String _sk_adaname;
    private String _ne_adatype;
    private String _ne_adalevel;
    private String _se_datayear;
    private String _ne_status;
    private String _se_uppercode;

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

    public String get_se_adacode(){
        return _se_adacode;
    }

    public void set_se_adacode(String _se_adacode){
        this._se_adacode = _se_adacode;
    }
    public String get_sk_adaname(){
        return _sk_adaname;
    }

    public void set_sk_adaname(String _sk_adaname){
        this._sk_adaname = _sk_adaname;
    }
    public String get_ne_adatype(){
        return _ne_adatype;
    }

    public void set_ne_adatype(String _ne_adatype){
        this._ne_adatype = _ne_adatype;
    }
    public String get_ne_adalevel(){
        return _ne_adalevel;
    }

    public void set_ne_adalevel(String _ne_adalevel){
        this._ne_adalevel = _ne_adalevel;
    }
    public String get_se_datayear(){
        return _se_datayear;
    }

    public void set_se_datayear(String _se_datayear){
        this._se_datayear = _se_datayear;
    }
    public String get_ne_status(){
        return _ne_status;
    }

    public void set_ne_status(String _ne_status){
        this._ne_status = _ne_status;
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
		public String get_se_uppercode() {
			return _se_uppercode;
		}

		public void set_se_uppercode(String _se_uppercode) {
			this._se_uppercode = _se_uppercode;
		}

		public Short getOrgtype() {
			return orgtype;
		}

		public void setOrgtype(Short orgtype) {
			this.orgtype = orgtype;
		}
		

}
