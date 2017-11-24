/**
 * auto-generated code
 * Fri Oct 02 10:44:18 CST 2009
 */
package com.gmcc.pboss.business.resource.discomres;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: DiscomresDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class DiscomresDBParam extends DBQueryParam {
    private String _se_disid;
    private String _se_discomcode;
    private String _snm_comresid;
    private String _snl_comresid;
    private String _dnm_issutime;
    private String _dnl_issutime;

	/**
     * @return Returns the _se_disid.
     */
    public String get_se_disid() {
        return this._se_disid;
    }
    /**
     * @param _sk_companyname The _se_disid to set.
     */
    public void set_se_disid(String _se_disid) {
        this._se_disid = _se_disid;
    }

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
	public String get_snm_comresid() {
		return _snm_comresid;
	}
	public void set_snm_comresid(String _snm_comresid) {
		this._snm_comresid = _snm_comresid;
	}
	public String get_snl_comresid() {
		return _snl_comresid;
	}
	public void set_snl_comresid(String _snl_comresid) {
		this._snl_comresid = _snl_comresid;
	}
	public String get_dnm_issutime() {
		return _dnm_issutime;
	}
	public void set_dnm_issutime(String _dnm_issutime) {
		this._dnm_issutime = _dnm_issutime;
	}
	public String get_dnl_issutime() {
		return _dnl_issutime;
	}
	public void set_dnl_issutime(String _dnl_issutime) {
		this._dnl_issutime = _dnl_issutime;
	}
    
}
