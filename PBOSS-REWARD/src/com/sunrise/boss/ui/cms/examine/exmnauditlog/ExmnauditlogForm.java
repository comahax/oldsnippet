/**
* auto-generated code
* Sat Nov 28 17:58:40 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnauditlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogVO;

/**
 * <p>Title: ExmnauditlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditlogForm extends BaseActionForm {

    private java.lang.Long logid;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.String oprtype;
    private java.lang.String success;
    private java.lang.Long seqid;
    private java.lang.String presenter;
    private java.util.Date submissiontime;
    private java.lang.String auditor;
    private java.lang.String auditopinion;
    private java.lang.Long itemgradedid;
    private java.lang.String state;
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
   
    public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
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
    public java.lang.String getPresenter(){
        return presenter;
    }

    public void setPresenter(java.lang.String presenter){
        this.presenter = presenter;
    }
    public java.util.Date getSubmissiontime(){
        return submissiontime;
    }

    public void setSubmissiontime(java.util.Date submissiontime){
        this.submissiontime = submissiontime;
    }
    public java.lang.String getAuditor(){
        return auditor;
    }

    public void setAuditor(java.lang.String auditor){
        this.auditor = auditor;
    }
    public java.lang.String getAuditopinion(){
        return auditopinion;
    }

    public void setAuditopinion(java.lang.String auditopinion){
        this.auditopinion = auditopinion;
    }
    public java.lang.Long getItemgradedid(){
        return itemgradedid;
    }

    public void setItemgradedid(java.lang.Long itemgradedid){
        this.itemgradedid = itemgradedid;
    }
    public java.lang.String getState(){
        return state;
    }

    public void setState(java.lang.String state){
        this.state = state;
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
