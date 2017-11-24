/**
 * auto-generated code
 * Wed Oct 14 13:53:36 CST 2009
 */
package com.gmcc.pboss.business.sales.orderproce;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderproceDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderproceDBParam extends DBQueryParam {
    private String _ne_flowid;
    private String _ne_processid;
    private String _se_dismode;
    private String _se_instate;
    private String _se_outstate;
    private String _nne_recid;

	public String get_nne_recid() {
		return _nne_recid;
	}
	public void set_nne_recid(String _nne_recid) {
		this._nne_recid = _nne_recid;
	}
	/**
     * @return Returns the _ne_flowid.
     */
    public String get_ne_flowid() {
        return this._ne_flowid;
    }
    /**
     * @param _sk_companyname The _ne_flowid to set.
     */
    public void set_ne_flowid(String _ne_flowid) {
        this._ne_flowid = _ne_flowid;
    }

	/**
     * @return Returns the _ne_processid.
     */
    public String get_ne_processid() {
        return this._ne_processid;
    }
    /**
     * @param _sk_companyname The _ne_processid to set.
     */
    public void set_ne_processid(String _ne_processid) {
        this._ne_processid = _ne_processid;
    }

	/**
     * @return Returns the _se_dismode.
     */
    public String get_se_dismode() {
        return this._se_dismode;
    }
    /**
     * @param _sk_companyname The _se_dismode to set.
     */
    public void set_se_dismode(String _se_dismode) {
        this._se_dismode = _se_dismode;
    }

	/**
     * @return Returns the _se_instate.
     */
    public String get_se_instate() {
        return this._se_instate;
    }
    /**
     * @param _sk_companyname The _se_instate to set.
     */
    public void set_se_instate(String _se_instate) {
        this._se_instate = _se_instate;
    }

	/**
     * @return Returns the _se_outstate.
     */
    public String get_se_outstate() {
        return this._se_outstate;
    }
    /**
     * @param _sk_companyname The _se_outstate to set.
     */
    public void set_se_outstate(String _se_outstate) {
        this._se_outstate = _se_outstate;
    }

}
