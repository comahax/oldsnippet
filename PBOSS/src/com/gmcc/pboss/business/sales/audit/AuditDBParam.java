/**
 * auto-generated code
 * Wed Jul 28 15:30:49 CST 2010
 */
package com.gmcc.pboss.business.sales.audit;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: AuditDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditDBParam extends DBQueryParam {
    private String _ne_seqid;
    private String _se_presenter;
    private String _se_auditor;
    private String _se_orderid;
    private String _se_state;
    private String _sk_orderid;
    private String _dnl_smsntime;
    private String _dnm_smsntime; 
    

	public String get_sk_orderid() {
		return _sk_orderid;
	}
	public void set_sk_orderid(String _sk_orderid) {
		this._sk_orderid = _sk_orderid;
	}
	public String get_dnl_smsntime() {
		return _dnl_smsntime;
	}
	public void set_dnl_smsntime(String _dnl_smsntime) {
		this._dnl_smsntime = _dnl_smsntime;
	}
	public String get_dnm_smsntime() {
		return _dnm_smsntime;
	}
	public void set_dnm_smsntime(String _dnm_smsntime) {
		this._dnm_smsntime = _dnm_smsntime;
	}
	/**
     * @return Returns the _ne_seqid.
     */
    public String get_ne_seqid() {
        return this._ne_seqid;
    }
    /**
     * @param _sk_companyname The _ne_seqid to set.
     */
    public void set_ne_seqid(String _ne_seqid) {
        this._ne_seqid = _ne_seqid;
    }

	/**
     * @return Returns the _se_presenter.
     */
    public String get_se_presenter() {
        return this._se_presenter;
    }
    /**
     * @param _sk_companyname The _se_presenter to set.
     */
    public void set_se_presenter(String _se_presenter) {
        this._se_presenter = _se_presenter;
    }

	/**
     * @return Returns the _se_auditor.
     */
    public String get_se_auditor() {
        return this._se_auditor;
    }
    /**
     * @param _sk_companyname The _se_auditor to set.
     */
    public void set_se_auditor(String _se_auditor) {
        this._se_auditor = _se_auditor;
    }

	/**
     * @return Returns the _se_orderid.
     */
    public String get_se_orderid() {
        return this._se_orderid;
    }
    /**
     * @param _sk_companyname The _se_orderid to set.
     */
    public void set_se_orderid(String _se_orderid) {
        this._se_orderid = _se_orderid;
    }

	/**
     * @return Returns the _se_state.
     */
    public String get_se_state() {
        return this._se_state;
    }
    /**
     * @param _sk_companyname The _se_state to set.
     */
    public void set_se_state(String _se_state) {
        this._se_state = _se_state;
    }

}
