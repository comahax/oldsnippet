/**
* auto-generated code
* Sat Nov 28 17:50:09 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.mappinglog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogVO;

/**
 * <p>Title: MappinglogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappinglogForm extends BaseActionForm {

    private java.lang.Long logid;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.String oprtype;
    private java.lang.String success;
    private java.lang.Long seqid;
    private java.lang.Integer exmnid;
    private java.lang.String cityid;
    private java.lang.String mmode;
    private java.lang.Double markul;
    private java.lang.Double markll;
    private java.lang.Double coeforbase;
    private String _dnl_optime;
	private String _dnm_optime;
	private String _sk_oprcode;
	private String _se_oprtype;
	private String _se_success;

    public java.lang.Long getLogid(){
        return logid;
    }

    public void setLogid(java.lang.Long logid){
        this.logid = logid;
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
    public java.lang.String getOprtype(){
        return oprtype;
    }

    public void setOprtype(java.lang.String oprtype){
        this.oprtype = oprtype;
    }
    public java.lang.String getSuccess(){
        return success;
    }

    public void setSuccess(java.lang.String success){
        this.success = success;
    }
    public java.lang.Long getSeqid(){
        return seqid;
    }

    public void setSeqid(java.lang.Long seqid){
        this.seqid = seqid;
    }
    public java.lang.Integer getExmnid(){
        return exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid){
        this.exmnid = exmnid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getMmode(){
        return mmode;
    }

    public void setMmode(java.lang.String mmode){
        this.mmode = mmode;
    }
    public java.lang.Double getMarkul(){
        return markul;
    }

    public void setMarkul(java.lang.Double markul){
        this.markul = markul;
    }
    public java.lang.Double getMarkll(){
        return markll;
    }

    public void setMarkll(java.lang.Double markll){
        this.markll = markll;
    }
    public java.lang.Double getCoeforbase(){
        return coeforbase;
    }

    public void setCoeforbase(java.lang.Double coeforbase){
        this.coeforbase = coeforbase;
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

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_success() {
		return _se_success;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public String get_sk_oprcode() {
		return _sk_oprcode;
	}

	public void set_sk_oprcode(String _sk_oprcode) {
		this._sk_oprcode = _sk_oprcode;
	}


}
