/**
 * auto-generated code
 * Tue Nov 08 11:17:26 CST 2011
 */
package com.gmcc.pboss.business.sales.saleplan;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: SaleplanDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SaleplanDBParam extends DBQueryParam {
    private String _se_plancode;
    private String _se_planname;
    private String _sk_plancode;
    private String _sk_planname;
    private String _dnm_begindate;//小于、等于
    private String _dnl_begindate;//大于、等于
    
    private String _dnm_enddate;//小于、等于
    private String _dnl_enddate;//大于、等于
    
    private String _sin_plancode;
    
    private String _se_cityid;


	/**
     * @return Returns the _se_plancode.
     */
    public String get_se_plancode() {
        return this._se_plancode;
    }
    /**
     * @param _sk_companyname The _se_plancode to set.
     */
    public void set_se_plancode(String _se_plancode) {
        this._se_plancode = _se_plancode;
    }

	/**
     * @return Returns the _se_planname.
     */
    public String get_se_planname() {
        return this._se_planname;
    }
    /**
     * @param _sk_companyname The _se_planname to set.
     */
    public void set_se_planname(String _se_planname) {
        this._se_planname = _se_planname;
    }

	/**
     * @return Returns the _dnm_begindate.
     */
    public String get_dnm_begindate() {
        return this._dnm_begindate;
    }
    /**
     * @param _sk_companyname The _dnm_begindate to set.
     */
    public void set_dnm_begindate(String _dnm_begindate) {
        this._dnm_begindate = _dnm_begindate;
    }

	/**
     * @return Returns the _dnl_begindate.
     */
    public String get_dnl_begindate() {
        return this._dnl_begindate;
    }
    /**
     * @param _sk_companyname The _dnl_begindate to set.
     */
    public void set_dnl_begindate(String _dnl_begindate) {
        this._dnl_begindate = _dnl_begindate;
    }

	public String get_dnm_enddate() {
		return _dnm_enddate;
	}
	public void set_dnm_enddate(String _dnm_enddate) {
		this._dnm_enddate = _dnm_enddate;
	}
	public String get_dnl_enddate() {
		return _dnl_enddate;
	}
	public void set_dnl_enddate(String _dnl_enddate) {
		this._dnl_enddate = _dnl_enddate;
	}

	public String get_sin_plancode() {
		return _sin_plancode;
	}
	public void set_sin_plancode(String _sin_plancode) {
		this._sin_plancode = _sin_plancode;
	}
	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}
	public String get_sk_plancode() {
		return _sk_plancode;
	}
	public void set_sk_plancode(String _sk_plancode) {
		this._sk_plancode = _sk_plancode;
	}
	public String get_sk_planname() {
		return _sk_planname;
	}
	public void set_sk_planname(String _sk_planname) {
		this._sk_planname = _sk_planname;
	}


}
