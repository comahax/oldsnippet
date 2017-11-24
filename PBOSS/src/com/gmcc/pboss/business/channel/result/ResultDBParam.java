/**
 * auto-generated code
 * Mon Mar 01 14:59:35 CST 2010
 */
package com.gmcc.pboss.business.channel.result;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ResultDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResultDBParam extends DBQueryParam {
    private String _ne_smstype;
    private String _se_sendno;
    private String _se_recno;
    private String _ne_issuccess;

	/**
     * @return Returns the _ne_smstype.
     */
    public String get_ne_smstype() {
        return this._ne_smstype;
    }
    /**
     * @param _sk_companyname The _ne_smstype to set.
     */
    public void set_ne_smstype(String _ne_smstype) {
        this._ne_smstype = _ne_smstype;
    }

	/**
     * @return Returns the _se_sendno.
     */
    public String get_se_sendno() {
        return this._se_sendno;
    }
    /**
     * @param _sk_companyname The _se_sendno to set.
     */
    public void set_se_sendno(String _se_sendno) {
        this._se_sendno = _se_sendno;
    }

	/**
     * @return Returns the _se_recno.
     */
    public String get_se_recno() {
        return this._se_recno;
    }
    /**
     * @param _sk_companyname The _se_recno to set.
     */
    public void set_se_recno(String _se_recno) {
        this._se_recno = _se_recno;
    }
	public String get_ne_issuccess() {
		return _ne_issuccess;
	}
	public void set_ne_issuccess(String neIssuccess) {
		_ne_issuccess = neIssuccess;
	}

}
