/**
 * auto-generated code
 * Tue Oct 19 15:41:02 CST 2010
 */
package com.gmcc.pboss.business.sales.waystockrecord;

import java.util.List;
import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: WaystockrecordDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaystockrecordDBParam extends DBQueryParam {
    private String _se_countyid;
    private String _se_mareacode;
    private String _se_wayid;
    private List _sin_wayid;
    private String _se_wayname;
    private String _ne_starlevel;
    private String _se_brand;
    private String _se_comresid;
    private String _se_comcategory;
    private String _dnm_stocktime;
    private String _dnl_stocktime;
    
    private String _se_emptyno;
    private String _se_restype;
    private List _sin_comcategory;
    
	public String get_se_restype() {
		return _se_restype;
	}
	public void set_se_restype(String _se_restype) {
		this._se_restype = _se_restype;
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
     * @return Returns the _se_wayname.
     */
    public String get_se_wayname() {
        return this._se_wayname;
    }
    /**
     * @param _sk_companyname The _se_wayname to set.
     */
    public void set_se_wayname(String _se_wayname) {
        this._se_wayname = _se_wayname;
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

	/**
     * @return Returns the _se_comresid.
     */
    public String get_se_comresid() {
        return this._se_comresid;
    }
    /**
     * @param _sk_companyname The _se_comresid to set.
     */
    public void set_se_comresid(String _se_comresid) {
        this._se_comresid = _se_comresid;
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

	/**
     * @return Returns the _dnm_stocktime.
     */
    public String get_dnm_stocktime() {
        return this._dnm_stocktime;
    }
    /**
     * @param _sk_companyname The _dnm_stocktime to set.
     */
    public void set_dnm_stocktime(String _dnm_stocktime) {
        this._dnm_stocktime = _dnm_stocktime;
    }

	/**
     * @return Returns the _dnl_stocktime.
     */
    public String get_dnl_stocktime() {
        return this._dnl_stocktime;
    }
    /**
     * @param _sk_companyname The _dnl_stocktime to set.
     */
    public void set_dnl_stocktime(String _dnl_stocktime) {
        this._dnl_stocktime = _dnl_stocktime;
    }
	public String get_se_emptyno() {
		return _se_emptyno;
	}
	public void set_se_emptyno(String _se_emptyno) {
		this._se_emptyno = _se_emptyno;
	}
	public List get_sin_comcategory() {
		return _sin_comcategory;
	}
	public void set_sin_comcategory(List _sin_comcategory) {
		this._sin_comcategory = _sin_comcategory;
	}
	public List get_sin_wayid() {
		return _sin_wayid;
	}
	public void set_sin_wayid(List _sin_wayid) {
		this._sin_wayid = _sin_wayid;
	}

}
