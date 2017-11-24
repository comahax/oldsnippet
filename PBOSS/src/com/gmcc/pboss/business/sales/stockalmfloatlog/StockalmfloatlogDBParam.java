/**
 * auto-generated code
 * Sun May 22 15:20:29 GMT 2011
 */
package com.gmcc.pboss.business.sales.stockalmfloatlog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: StockalmfloatlogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class StockalmfloatlogDBParam extends DBQueryParam {
    private String _dnm_optime;
    private String _dnl_optime;
    private String _se_oprcode;
    private String _se_oprtype;
    private String _se_success;
    private String _ne_starlevel;
    

	public String get_ne_starlevel() {
		return _ne_starlevel;
	}
	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}
	/**
     * @return Returns the _dnm_optime.
     */
    public String get_dnm_optime() {
        return this._dnm_optime;
    }
    /**
     * @param _sk_companyname The _dnm_optime to set.
     */
    public void set_dnm_optime(String _dnm_optime) {
        this._dnm_optime = _dnm_optime;
    }

	/**
     * @return Returns the _dnl_optime.
     */
    public String get_dnl_optime() {
        return this._dnl_optime;
    }
    /**
     * @param _sk_companyname The _dnl_optime to set.
     */
    public void set_dnl_optime(String _dnl_optime) {
        this._dnl_optime = _dnl_optime;
    }

	/**
     * @return Returns the _se_oprcode.
     */
    public String get_se_oprcode() {
        return this._se_oprcode;
    }
    /**
     * @param _sk_companyname The _se_oprcode to set.
     */
    public void set_se_oprcode(String _se_oprcode) {
        this._se_oprcode = _se_oprcode;
    }

	/**
     * @return Returns the _se_oprtype.
     */
    public String get_se_oprtype() {
        return this._se_oprtype;
    }
    /**
     * @param _sk_companyname The _se_oprtype to set.
     */
    public void set_se_oprtype(String _se_oprtype) {
        this._se_oprtype = _se_oprtype;
    }

	/**
     * @return Returns the _se_success.
     */
    public String get_se_success() {
        return this._se_success;
    }
    /**
     * @param _sk_companyname The _se_success to set.
     */
    public void set_se_success(String _se_success) {
        this._se_success = _se_success;
    }

}
