/**
 * auto-generated code
 * Thu Jul 08 15:12:12 CST 2010
 */
package com.gmcc.pboss.business.sales.timesect;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: TimesectDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class TimesectDBParam extends DBQueryParam {
    private String _se_cityid;
    private String _se_countyid;
    private String _se_mareacode;
    private String _se_datetype;
    private String _nne_recid;
    private String _dnl_begindate;
    private String _dnm_begindate;
    private String _dnl_enddate;
    private String _dnm_enddate;
    private List _sin_mareacode;

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
     * @return Returns the _se_datetype.
     */
    public String get_se_datetype() {
        return this._se_datetype;
    }
    /**
     * @param _sk_companyname The _se_datetype to set.
     */
    public void set_se_datetype(String _se_datetype) {
        this._se_datetype = _se_datetype;
    }
	public String get_nne_recid() {
		return _nne_recid;
	}
	public void set_nne_recid(String _nne_recid) {
		this._nne_recid = _nne_recid;
	}
	public String get_dnl_begindate() {
		return _dnl_begindate;
	}
	public void set_dnl_begindate(String _dnl_begindate) {
		this._dnl_begindate = _dnl_begindate;
	}
	public String get_dnm_enddate() {
		return _dnm_enddate;
	}
	public void set_dnm_enddate(String _dnm_enddate) {
		this._dnm_enddate = _dnm_enddate;
	}
	public String get_dnm_begindate() {
		return _dnm_begindate;
	}
	public void set_dnm_begindate(String _dnm_begindate) {
		this._dnm_begindate = _dnm_begindate;
	}
	public String get_dnl_enddate() {
		return _dnl_enddate;
	}
	public void set_dnl_enddate(String _dnl_enddate) {
		this._dnl_enddate = _dnl_enddate;
	}
	public List get_sin_mareacode() {
		return _sin_mareacode;
	}
	public void set_sin_mareacode(List _sin_mareacode) {
		this._sin_mareacode = _sin_mareacode;
	}

}
