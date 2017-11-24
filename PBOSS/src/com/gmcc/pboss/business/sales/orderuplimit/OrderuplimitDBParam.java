/**
 * auto-generated code
 * Tue Oct 13 14:30:52 CST 2009
 */
package com.gmcc.pboss.business.sales.orderuplimit;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderuplimitDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderuplimitDBParam extends DBQueryParam {
    private String _se_cityid;
    private String _se_countyid;
    private String _se_cooptype;
    private List<String> _sin_cooptype;
    private String _ne_starlevel;
    private String _se_brand;
    private String _nne_recid;
    private String _se_limitmode;
    private String _se_restype;
    private String _se_comcategory;
    private List<String> _sin_brand;
    
    private String _sk_brand;
    
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
     * @return Returns the _se_cooptype.
     */
    public String get_se_cooptype() {
        return this._se_cooptype;
    }
    /**
     * @param _sk_companyname The _se_cooptype to set.
     */
    public void set_se_cooptype(String _se_cooptype) {
        this._se_cooptype = _se_cooptype;
    }

	/**
     * @return Returns the _ne_starlevel.
     */
    public String get_ne_starlevel() {
        return this._ne_starlevel;
    }
    /**
     * @param _sk_companyname The _ne_starlevel to set.
     */
    public void set_ne_starlevel(String _ne_starlevel) {
        this._ne_starlevel = _ne_starlevel;
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
	public String get_nne_recid() {
		return _nne_recid;
	}
	public void set_nne_recid(String _nne_recid) {
		this._nne_recid = _nne_recid;
	}

	public List<String> get_sin_cooptype() {
		return _sin_cooptype;
	}
	public void set_sin_cooptype(List<String> _sin_cooptype) {
		this._sin_cooptype = _sin_cooptype;
	}

	public String get_se_limitmode() {
		return _se_limitmode;
	}
	public void set_se_limitmode(String seLimitmode) {
		_se_limitmode = seLimitmode;
	}
	public String get_se_restype() {
		return _se_restype;
	}
	public void set_se_restype(String _se_restype) {
		this._se_restype = _se_restype;
	}
	public String get_se_comcategory() {
		return _se_comcategory;
	}
	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}
	public String get_sk_brand() {
		return _sk_brand;
	}
	public void set_sk_brand(String _sk_brand) {
		this._sk_brand = _sk_brand;
	}
	public List<String> get_sin_brand() {
		return _sin_brand;
	}
	public void set_sin_brand(List<String> _sin_brand) {
		this._sin_brand = _sin_brand;
	}

}
