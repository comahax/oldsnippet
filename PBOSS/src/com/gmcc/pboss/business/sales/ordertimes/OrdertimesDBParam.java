/**
 * auto-generated code
 * Fri May 07 16:29:05 CST 2010
 */
package com.gmcc.pboss.business.sales.ordertimes;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrdertimesDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class OrdertimesDBParam extends DBQueryParam {
    private String _ne_recid;
    private String _nne_recid;
    private String _se_objtype;
    private String _se_objectcode;
    private String _nnm_maxtimes;
    private String _ne_maxtimes;
    private String _nnl_maxtimes;
    private String _ne_isurgent;

	/**
     * @return Returns the _ne_recid.
     */
    public String get_ne_recid() {
        return this._ne_recid;
    }
    /**
     * @param _sk_companyname The _ne_recid to set.
     */
    public void set_ne_recid(String _ne_recid) {
        this._ne_recid = _ne_recid;
    }

	public String get_nne_recid() {
		return _nne_recid;
	}
	public void set_nne_recid(String _nne_recid) {
		this._nne_recid = _nne_recid;
	}
	/**
     * @return Returns the _se_objtype.
     */
    public String get_se_objtype() {
        return this._se_objtype;
    }
    /**
     * @param _sk_companyname The _se_objtype to set.
     */
    public void set_se_objtype(String _se_objtype) {
        this._se_objtype = _se_objtype;
    }

	/**
     * @return Returns the _se_objectcode.
     */
    public String get_se_objectcode() {
        return this._se_objectcode;
    }
    /**
     * @param _sk_companyname The _se_objectcode to set.
     */
    public void set_se_objectcode(String _se_objectcode) {
        this._se_objectcode = _se_objectcode;
    }

	/**
     * @return Returns the _nnm_maxtimes.
     */
    public String get_nnm_maxtimes() {
        return this._nnm_maxtimes;
    }
    /**
     * @param _sk_companyname The _nnm_maxtimes to set.
     */
    public void set_nnm_maxtimes(String _nnm_maxtimes) {
        this._nnm_maxtimes = _nnm_maxtimes;
    }

	/**
     * @return Returns the _ne_maxtimes.
     */
    public String get_ne_maxtimes() {
        return this._ne_maxtimes;
    }
    /**
     * @param _sk_companyname The _ne_maxtimes to set.
     */
    public void set_ne_maxtimes(String _ne_maxtimes) {
        this._ne_maxtimes = _ne_maxtimes;
    }

	/**
     * @return Returns the _nnl_maxtimes.
     */
    public String get_nnl_maxtimes() {
        return this._nnl_maxtimes;
    }
    /**
     * @param _sk_companyname The _nnl_maxtimes to set.
     */
    public void set_nnl_maxtimes(String _nnl_maxtimes) {
        this._nnl_maxtimes = _nnl_maxtimes;
    }
    
	public String get_ne_isurgent() {
		return _ne_isurgent;
	}
	public void set_ne_isurgent(String neIsurgent) {
		_ne_isurgent = neIsurgent;
	}

}
