package com.gmcc.pboss.business.reward.payee;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: PayeeDBParam </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PayeeDBParam extends DBQueryParam {
    private String _sk_payee;
    private String _se_payee;
    private String _se_cityid;
    private String _se_pubpri;

    private String _ne_seq;
    
    
	public String get_ne_seq() {
		return _ne_seq;
	}
	public void set_ne_seq(String neSeq) {
		_ne_seq = neSeq;
	}
	public String get_se_pubpri() {
		return _se_pubpri;
	}
	public void set_se_pubpri(String sePubpri) {
		_se_pubpri = sePubpri;
	}
	
	public String get_se_payee() {
		return _se_payee;
	}
	public void set_se_payee(String sePayee) {
		_se_payee = sePayee;
	}
	/**
     * @return Returns the _sk_payee.
     */
    public String get_sk_payee() {
        return this._sk_payee;
    }
    /**
     * @param _sk_companyname The _sk_payee to set.
     */
    public void set_sk_payee(String _sk_payee) {
        this._sk_payee = _sk_payee;
    }

	/**
     * @return Returns the _se_cityid.
     */
    public String get_se_cityid() {
        return this._se_cityid;
    }
    /**
     * @param _sk_companyname The _se_cityid to set.
     */
    public void set_se_cityid(String _se_cityid) {
        this._se_cityid = _se_cityid;
    }

}
