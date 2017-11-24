/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnaudit;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;

/**
 * <p>Title: ExmnauditForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditForm extends BaseActionForm {

    private java.lang.Long seqid;
    private java.lang.String presenter;
    private java.util.Date submissiontime;
    private java.lang.String auditor;
    private java.lang.String auditopinion;
    private java.lang.Long itemgradedid;
    private java.lang.String state;

    private String _ne_seqid;
    private String _se_presenter;
    private String _dnm_submissiontime;
    private String _dnl_submissiontime;
    private String _se_auditor;
    private String _ne_itemgradedid;
    private String _se_state;
    
    private String operid;
    private String opername;
    
    private String _snl_exmnperiod;
    private String _snm_exmnperiod;
    private String _se_wayid;
    private String _ne_exmnid;
    private String _ne_exmnstdid;

    public String get_ne_exmnid() {
		return _ne_exmnid;
	}

	public void set_ne_exmnid(String _ne_exmnid) {
		this._ne_exmnid = _ne_exmnid;
	}

	public String get_ne_exmnstdid() {
		return _ne_exmnstdid;
	}

	public void set_ne_exmnstdid(String _ne_exmnstdid) {
		this._ne_exmnstdid = _ne_exmnstdid;
	}

	public String get_snl_exmnperiod() {
		return _snl_exmnperiod;
	}

	public void set_snl_exmnperiod(String _snl_exmnperiod) {
		this._snl_exmnperiod = _snl_exmnperiod;
	}

	public String get_snm_exmnperiod() {
		return _snm_exmnperiod;
	}

	public void set_snm_exmnperiod(String _snm_exmnperiod) {
		this._snm_exmnperiod = _snm_exmnperiod;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
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

    public String get_ne_seqid(){
        return _ne_seqid;
    }

    public void set_ne_seqid(String _ne_seqid){
        this._ne_seqid = _ne_seqid;
    }
    public String get_se_presenter(){
        return _se_presenter;
    }

    public void set_se_presenter(String _se_presenter){
        this._se_presenter = _se_presenter;
    }
    public String get_dnm_submissiontime(){
        return _dnm_submissiontime;
    }

    public void set_dnm_submissiontime(String _dnm_submissiontime){
        this._dnm_submissiontime = _dnm_submissiontime;
    }
    public String get_dnl_submissiontime(){
        return _dnl_submissiontime;
    }

    public void set_dnl_submissiontime(String _dnl_submissiontime){
        this._dnl_submissiontime = _dnl_submissiontime;
    }
    public String get_se_auditor(){
        return _se_auditor;
    }

    public void set_se_auditor(String _se_auditor){
        this._se_auditor = _se_auditor;
    }
    public String get_ne_itemgradedid(){
        return _ne_itemgradedid;
    }

    public void set_ne_itemgradedid(String _ne_itemgradedid){
        this._ne_itemgradedid = _ne_itemgradedid;
    }
    public String get_se_state(){
        return _se_state;
    }

    public void set_se_state(String _se_state){
        this._se_state = _se_state;
    }

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

}
