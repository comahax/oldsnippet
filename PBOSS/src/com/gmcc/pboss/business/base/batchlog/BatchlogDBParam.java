/**
 * auto-generated code
 * Mon Sep 07 10:54:49 CST 2009
 */
package com.gmcc.pboss.business.base.batchlog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: BatchlogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class BatchlogDBParam extends DBQueryParam {
    private String _dnm_optime;
    private String _dnl_optime;
    private String _se_oprtype;
    private String _se_oprcode;
    private String _se_success;
    private String _se_oprwayid;
    private String _se_batchname;
    private String _sk_batchname;

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
	public String get_se_oprwayid() {
		return _se_oprwayid;
	}
	public void set_se_oprwayid(String _se_oprwayid) {
		this._se_oprwayid = _se_oprwayid;
	}
	public String get_se_batchname() {
		return _se_batchname;
	}
	public void set_se_batchname(String _se_batchname) {
		this._se_batchname = _se_batchname;
	}
	public String get_sk_batchname() {
		return _sk_batchname;
	}
	public void set_sk_batchname(String _sk_batchname) {
		this._sk_batchname = _sk_batchname;
	}

}
