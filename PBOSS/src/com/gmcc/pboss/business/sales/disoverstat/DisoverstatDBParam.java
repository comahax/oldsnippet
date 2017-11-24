/**
 * auto-generated code
 * Mon Nov 14 15:52:02 CST 2011
 */
package com.gmcc.pboss.business.sales.disoverstat;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: DisoverstatDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DisoverstatDBParam extends DBQueryParam {
    private String _se_countyid;
    private String _se_mareacode;
    private String _de_statdate;
    private String _dnm_statdate;
    private String _dnl_statdate;

	/**
     * @return Returns the _se_countyid.
     */
    public String get_se_countyid() {
        return this._se_countyid;
    }
    /**
     * @param _sk_companyname The _se_countyid to set.
     */
    public void set_se_countyid(String _se_countyid) {
        this._se_countyid = _se_countyid;
    }

	/**
     * @return Returns the _se_mareacode.
     */
    public String get_se_mareacode() {
        return this._se_mareacode;
    }
    /**
     * @param _sk_companyname The _se_mareacode to set.
     */
    public void set_se_mareacode(String _se_mareacode) {
        this._se_mareacode = _se_mareacode;
    }

	/**
     * @return Returns the _de_statdate.
     */
    public String get_de_statdate() {
        return this._de_statdate;
    }
    /**
     * @param _sk_companyname The _de_statdate to set.
     */
    public void set_de_statdate(String _de_statdate) {
        this._de_statdate = _de_statdate;
    }
	public String get_dnm_statdate() {
		return _dnm_statdate;
	}
	public void set_dnm_statdate(String _dnm_statdate) {
		this._dnm_statdate = _dnm_statdate;
	}
	public String get_dnl_statdate() {
		return _dnl_statdate;
	}
	public void set_dnl_statdate(String _dnl_statdate) {
		this._dnl_statdate = _dnl_statdate;
	}

}
