/**
* auto-generated code
* Wed Nov 25 11:17:17 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnitemdtllog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogVO;

/**
 * <p>Title: ExmnitemdtllogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtllogForm extends BaseActionForm {

    private java.lang.Long logid;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.String oprtype;
    private java.lang.String success;
    private java.lang.Long seqid;
    private java.lang.Integer exmnid;
    private java.lang.Integer exmnstdid;
    private java.lang.String cityid;
    private java.lang.String marktype;
    private java.lang.Float basemk;
    private java.lang.Float dynamicmk;
    private java.lang.Float leastcrtcl;
    private java.lang.Float largestcrtcl;
    private java.lang.Long pseqid;
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
    public java.lang.Integer getExmnstdid(){
        return exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid){
        this.exmnstdid = exmnstdid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getMarktype(){
        return marktype;
    }

    public void setMarktype(java.lang.String marktype){
        this.marktype = marktype;
    }
    public java.lang.Float getBasemk(){
        return basemk;
    }

    public void setBasemk(java.lang.Float basemk){
        this.basemk = basemk;
    }
    public java.lang.Float getDynamicmk(){
        return dynamicmk;
    }

    public void setDynamicmk(java.lang.Float dynamicmk){
        this.dynamicmk = dynamicmk;
    }
    public java.lang.Float getLeastcrtcl(){
        return leastcrtcl;
    }

    public void setLeastcrtcl(java.lang.Float leastcrtcl){
        this.leastcrtcl = leastcrtcl;
    }
    public java.lang.Float getLargestcrtcl(){
        return largestcrtcl;
    }

    public void setLargestcrtcl(java.lang.Float largestcrtcl){
        this.largestcrtcl = largestcrtcl;
    }
    public java.lang.Long getPseqid(){
        return pseqid;
    }

    public void setPseqid(java.lang.Long pseqid){
        this.pseqid = pseqid;
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
