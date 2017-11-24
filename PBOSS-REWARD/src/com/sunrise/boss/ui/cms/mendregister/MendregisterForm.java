package com.sunrise.boss.ui.cms.mendregister;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChPwMendregisterForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class MendregisterForm extends BaseActionForm {

    private java.lang.Long seqid;
    private java.lang.String mobile;
    private java.lang.String officetel;
    private java.util.Date selltime;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.Short success;
    private java.lang.String adtremark;

    private String _se_mobile;
    private String _se_officetel;
    private String _de_selltime;
    private String _de_optime;
    private String _se_success;
    
    private String _dnl_selltime;
    private String _dnm_selltime;
    private String _dnl_optime;
    private String _dnm_optime;

    public java.lang.Long getSeqid(){
        return seqid;
    }

    public void setSeqid(java.lang.Long seqid){
        this.seqid = seqid;
    }
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }
    public java.lang.String getOfficetel(){
        return officetel;
    }

    public void setOfficetel(java.lang.String officetel){
        this.officetel = officetel;
    }
    public java.util.Date getSelltime(){
        return selltime;
    }

    public void setSelltime(java.util.Date selltime){
        this.selltime = selltime;
    }
    public java.util.Date getOptime(){
        return optime;
    }

    public void setOptime(java.util.Date optime){
        this.optime = optime;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.lang.Short getSuccess(){
        return success;
    }

    public void setSuccess(java.lang.Short success){
        this.success = success;
    }
    public java.lang.String getAdtremark(){
        return adtremark;
    }

    public void setAdtremark(java.lang.String adtremark){
        this.adtremark = adtremark;
    }

    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_se_officetel(){
        return _se_officetel;
    }

    public void set_se_officetel(String _se_officetel){
        this._se_officetel = _se_officetel;
    }
    public String get_de_selltime(){
        return _de_selltime;
    }

    public void set_de_selltime(String _de_selltime){
        this._de_selltime = _de_selltime;
    }
    public String get_de_optime(){
        return _de_optime;
    }

    public void set_de_optime(String _de_optime){
        this._de_optime = _de_optime;
    }
    public String get_se_success(){
        return _se_success;
    }

    public void set_se_success(String _se_success){
        this._se_success = _se_success;
    }

	public String get_dnl_selltime() {
		return _dnl_selltime;
	}

	public void set_dnl_selltime(String _dnl_selltime) {
		this._dnl_selltime = _dnl_selltime;
	}

	public String get_dnm_selltime() {
		return _dnm_selltime;
	}

	public void set_dnm_selltime(String _dnm_selltime) {
		this._dnm_selltime = _dnm_selltime;
	}

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		this._dnm_optime = _dnm_optime;
	}

}
