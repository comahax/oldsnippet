/**
 * auto-generated code
 * Sun May 22 15:19:11 GMT 2011
 */
package com.gmcc.pboss.business.sales.stockalmfloat;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: StockalmfloatDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class StockalmfloatDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _se_brand;
    private String _ne_starlevel;
    

	public String get_ne_starlevel() {
		return _ne_starlevel;
	}
	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
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

}
