/**
 * auto-generated code
 * Thu Dec 29 08:58:06 CST 2011
 */
package com.gmcc.pboss.business.channel.bondform;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: BondformDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class BondformDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _se_bondtype;
    private String _se_countyid;
    private String _ne_state;
    private String _ne_boneobjtype;
    private String _se_formid;

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
     * @return Returns the _se_bondtype.
     */
    public String get_se_bondtype() {
        return this._se_bondtype;
    }
    /**
     * @param _sk_companyname The _se_bondtype to set.
     */
    public void set_se_bondtype(String _se_bondtype) {
        this._se_bondtype = _se_bondtype;
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
     * @return Returns the _ne_state.
     */
    public String get_ne_state() {
        return this._ne_state;
    }
    /**
     * @param _sk_companyname The _ne_state to set.
     */
    public void set_ne_state(String _ne_state) {
        this._ne_state = _ne_state;
    }

	/**
     * @return Returns the _ne_boneobjtype.
     */
    public String get_ne_boneobjtype() {
        return this._ne_boneobjtype;
    }
    /**
     * @param _sk_companyname The _ne_boneobjtype to set.
     */
    public void set_ne_boneobjtype(String _ne_boneobjtype) {
        this._ne_boneobjtype = _ne_boneobjtype;
    }
	public String get_se_formid() {
		return _se_formid;
	}
	public void set_se_formid(String _se_formid) {
		this._se_formid = _se_formid;
	}
	

}
