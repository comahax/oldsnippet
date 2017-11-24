package com.gmcc.pboss.business.cms.examine.exmnaudit.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: ExmnauditListVO</p>
 * <p>Description: Query Params Object for ExmnauditDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditListVO extends DBQueryParam {
    private String _ne_seqid;
    private String _se_presenter;
    private String _dnm_submissiontime;
    private String _dnl_submissiontime;
    private String _se_auditor;
    private String _ne_itemgradedid;
    private String _se_state;

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

}
