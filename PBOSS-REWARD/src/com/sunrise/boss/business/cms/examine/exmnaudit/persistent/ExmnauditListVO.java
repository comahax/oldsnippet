/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnaudit.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ExmnauditListVO</p>
 * <p>Description: Query Params Object for ExmnauditDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditListVO extends BaseListVO {
    private String _ne_seqid;
    private String _se_presenter;
    private String _dnm_submissiontime;
    private String _dnl_submissiontime;
    private String _se_auditor;
    private String _ne_itemgradedid;
    private String _se_state;
    private String _snl_exmnperiod;
    private String _snm_exmnperiod;
    private String _se_wayid;
    private String _ne_exmnid;
    private String _ne_exmnstdid;
    private List _nin_itemgradedid;
    
    public List get_nin_itemgradedid() {
		return _nin_itemgradedid;
	}

	public void set_nin_itemgradedid(List _nin_itemgradedid) {
		this._nin_itemgradedid = _nin_itemgradedid;
	}

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

}
