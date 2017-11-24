/**
 * auto-generated code
 * Fri Jun 25 09:24:18 CST 2010
 */
package com.gmcc.pboss.business.sales.comdisscale;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ComdisscaleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class ComdisscaleDBParam extends DBQueryParam {
    private String _se_comcategory;
    private String _sne_comcategory;
    private String _se_brand;
    private String _sne_brand;
    private String _nnm_disscale;
    private String _ne_disscale;
    private String _nnl_disscale;
    private String _se_countyid;
    private String _se_mareacode;
    private String _ne_starlevel;

	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public String get_se_mareacode() {
		return _se_mareacode;
	}
	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}
	public String get_ne_starlevel() {
		return _ne_starlevel;
	}
	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}
	/**
     * @return Returns the _se_comcategory.
     */
    public String get_se_comcategory() {
        return this._se_comcategory;
    }
    /**
     * @param _sk_companyname The _se_comcategory to set.
     */
    public void set_se_comcategory(String _se_comcategory) {
        this._se_comcategory = _se_comcategory;
    }
    
	public String get_sne_comcategory() {
		return _sne_comcategory;
	}
	public void set_sne_comcategory(String _sne_comcategory) {
		this._sne_comcategory = _sne_comcategory;
	}
	/**
     * @return Returns the _se_brand.
     */
    public String get_se_brand() {
        return this._se_brand;
    }
    /**
     * @param _sk_companyname The _se_brand to set.
     */
    public void set_se_brand(String _se_brand) {
        this._se_brand = _se_brand;
    }

	/**
     * @return Returns the _sne_brand.
     */
    public String get_sne_brand() {
        return this._sne_brand;
    }
    /**
     * @param _sk_companyname The _sne_brand to set.
     */
    public void set_sne_brand(String _sne_brand) {
        this._sne_brand = _sne_brand;
    }

	/**
     * @return Returns the _nnm_disscale.
     */
    public String get_nnm_disscale() {
        return this._nnm_disscale;
    }
    /**
     * @param _sk_companyname The _nnm_disscale to set.
     */
    public void set_nnm_disscale(String _nnm_disscale) {
        this._nnm_disscale = _nnm_disscale;
    }

	/**
     * @return Returns the _ne_disscale.
     */
    public String get_ne_disscale() {
        return this._ne_disscale;
    }
    /**
     * @param _sk_companyname The _ne_disscale to set.
     */
    public void set_ne_disscale(String _ne_disscale) {
        this._ne_disscale = _ne_disscale;
    }

	/**
     * @return Returns the _nnl_disscale.
     */
    public String get_nnl_disscale() {
        return this._nnl_disscale;
    }
    /**
     * @param _sk_companyname The _nnl_disscale to set.
     */
    public void set_nnl_disscale(String _nnl_disscale) {
        this._nnl_disscale = _nnl_disscale;
    }

}
