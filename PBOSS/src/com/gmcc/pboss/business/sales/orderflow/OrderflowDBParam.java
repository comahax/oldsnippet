/**
 * auto-generated code
 * Wed Oct 14 10:59:52 CST 2009
 */
package com.gmcc.pboss.business.sales.orderflow;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderflowDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderflowDBParam extends DBQueryParam {
    private String _se_flowname;
    private String _se_cityid;
    private String _se_orderave;
    private String _se_paytype;
    private String _se_delitype;
    private String _ne_effective;
    private Long _nne_flowid;

	public Long get_nne_flowid() {
		return _nne_flowid;
	}
	public void set_nne_flowid(Long _nne_flowid) {
		this._nne_flowid = _nne_flowid;
	}
	/**
     * @return Returns the _se_flowname.
     */
    public String get_se_flowname() {
        return this._se_flowname;
    }
    /**
     * @param _sk_companyname The _se_flowname to set.
     */
    public void set_se_flowname(String _se_flowname) {
        this._se_flowname = _se_flowname;
    }

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
     * @return Returns the _se_orderave.
     */
    public String get_se_orderave() {
        return this._se_orderave;
    }
    /**
     * @param _sk_companyname The _se_orderave to set.
     */
    public void set_se_orderave(String _se_orderave) {
        this._se_orderave = _se_orderave;
    }

	/**
     * @return Returns the _se_paytype.
     */
    public String get_se_paytype() {
        return this._se_paytype;
    }
    /**
     * @param _sk_companyname The _se_paytype to set.
     */
    public void set_se_paytype(String _se_paytype) {
        this._se_paytype = _se_paytype;
    }

	/**
     * @return Returns the _se_delitype.
     */
    public String get_se_delitype() {
        return this._se_delitype;
    }
    /**
     * @param _sk_companyname The _se_delitype to set.
     */
    public void set_se_delitype(String _se_delitype) {
        this._se_delitype = _se_delitype;
    }

	/**
     * @return Returns the _ne_effective.
     */
    public String get_ne_effective() {
        return this._ne_effective;
    }
    /**
     * @param _sk_companyname The _ne_effective to set.
     */
    public void set_ne_effective(String _ne_effective) {
        this._ne_effective = _ne_effective;
    }

}
