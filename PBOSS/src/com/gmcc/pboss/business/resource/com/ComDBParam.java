/**
 * auto-generated code
 * Sat Sep 05 11:44:39 CST 2009
 */
package com.gmcc.pboss.business.resource.com;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ComDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComDBParam extends DBQueryParam {
    private String _ne_comid;
    private String _ne_comclassid;
    private String _ne_comtype;
    private String _sk_comname;
    private String _ne_comstate;

	/**
     * @return Returns the _ne_comid.
     */
    public String get_ne_comid() {
        return this._ne_comid;
    }
    /**
     * @param _sk_companyname The _ne_comid to set.
     */
    public void set_ne_comid(String _ne_comid) {
        this._ne_comid = _ne_comid;
    }

	/**
     * @return Returns the _ne_comclassid.
     */
    public String get_ne_comclassid() {
        return this._ne_comclassid;
    }
    /**
     * @param _sk_companyname The _ne_comclassid to set.
     */
    public void set_ne_comclassid(String _ne_comclassid) {
        this._ne_comclassid = _ne_comclassid;
    }

	/**
     * @return Returns the _ne_comtype.
     */
    public String get_ne_comtype() {
        return this._ne_comtype;
    }
    /**
     * @param _sk_companyname The _ne_comtype to set.
     */
    public void set_ne_comtype(String _ne_comtype) {
        this._ne_comtype = _ne_comtype;
    }

	public String get_sk_comname() {
		return _sk_comname;
	}
	public void set_sk_comname(String _sk_comname) {
		this._sk_comname = _sk_comname;
	}
	public String get_ne_comstate() {
		return _ne_comstate;
	}
	public void set_ne_comstate(String _ne_comstate) {
		this._ne_comstate = _ne_comstate;
	}

}
