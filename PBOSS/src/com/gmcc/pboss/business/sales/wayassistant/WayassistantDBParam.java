/**
 * auto-generated code
 * Tue Oct 13 14:18:20 CST 2009
 */
package com.gmcc.pboss.business.sales.wayassistant;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: WayassistantDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class WayassistantDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _ne_canorder;
    private String _ne_printinvoice;
    private String _se_paytype;
    private String _se_delitype;
    private String _ne_orderbetterno;
    
    private String _se_countyid;
    private String _se_svccode;
    private String _se_mareacode;
    private String _ne_waystate;

	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public String get_se_svccode() {
		return _se_svccode;
	}
	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}
	public String get_se_mareacode() {
		return _se_mareacode;
	}
	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}
	public String get_ne_waystate() {
		return _ne_waystate;
	}
	public void set_ne_waystate(String _ne_waystate) {
		this._ne_waystate = _ne_waystate;
	}
	/**
     * @return Returns the _se_wayid.
     */
    public String get_se_wayid() {
        return this._se_wayid;
    }
    /**
     * @param _sk_companyname The _se_wayid to set.
     */
    public void set_se_wayid(String _se_wayid) {
        this._se_wayid = _se_wayid;
    }

	/**
     * @return Returns the _ne_canorder.
     */
    public String get_ne_canorder() {
        return this._ne_canorder;
    }
    /**
     * @param _sk_companyname The _ne_canorder to set.
     */
    public void set_ne_canorder(String _ne_canorder) {
        this._ne_canorder = _ne_canorder;
    }

	/**
     * @return Returns the _ne_printinvoice.
     */
    public String get_ne_printinvoice() {
        return this._ne_printinvoice;
    }
    /**
     * @param _sk_companyname The _ne_printinvoice to set.
     */
    public void set_ne_printinvoice(String _ne_printinvoice) {
        this._ne_printinvoice = _ne_printinvoice;
    }

	/**
     * @return Returns the _se_paytype.
     */
    public String get_se_paytype() {
        return this._se_paytype;
    }
    /**
     * @param _sk_companyname The _se_paytype to set.
     */
    public void set_se_paytype(String _se_paytype) {
        this._se_paytype = _se_paytype;
    }

	/**
     * @return Returns the _se_delitype.
     */
    public String get_se_delitype() {
        return this._se_delitype;
    }
    /**
     * @param _sk_companyname The _se_delitype to set.
     */
    public void set_se_delitype(String _se_delitype) {
        this._se_delitype = _se_delitype;
    }

	/**
     * @return Returns the _ne_orderbetterno.
     */
    public String get_ne_orderbetterno() {
        return this._ne_orderbetterno;
    }
    /**
     * @param _sk_companyname The _ne_orderbetterno to set.
     */
    public void set_ne_orderbetterno(String _ne_orderbetterno) {
        this._ne_orderbetterno = _ne_orderbetterno;
    }

}
