/**
 * auto-generated code
 * Wed Dec 28 15:16:02 CST 2011
 */
package com.gmcc.pboss.business.examine.disexamine;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: DisexamineDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class DisexamineDBParam extends DBQueryParam {
    private String _se_discomcode;
    private String _se_exmnperiod;
    private String _se_memo;
    private String _ne_penalamt;
    private List  _nin_seqid;

	/**
     * @return Returns the _se_discomcode.
     */
    public String get_se_discomcode() {
        return this._se_discomcode;
    }
    /**
     * @param _sk_companyname The _se_discomcode to set.
     */
    public void set_se_discomcode(String _se_discomcode) {
        this._se_discomcode = _se_discomcode;
    }

	/**
     * @return Returns the _se_exmnperiod.
     */
    public String get_se_exmnperiod() {
        return this._se_exmnperiod;
    }
    /**
     * @param _sk_companyname The _se_exmnperiod to set.
     */
    public void set_se_exmnperiod(String _se_exmnperiod) {
        this._se_exmnperiod = _se_exmnperiod;
    }
	public String get_se_memo() {
		return _se_memo;
	}
	public void set_se_memo(String _se_memo) {
		this._se_memo = _se_memo;
	}
	public String get_ne_penalamt() {
		return _ne_penalamt;
	}
	public void set_ne_penalamt(String _ne_penalamt) {
		this._ne_penalamt = _ne_penalamt;
	}
	public List get_nin_seqid() {
		return _nin_seqid;
	}
	public void set_nin_seqid(List _nin_seqid) {
		this._nin_seqid = _nin_seqid;
	} 
}
