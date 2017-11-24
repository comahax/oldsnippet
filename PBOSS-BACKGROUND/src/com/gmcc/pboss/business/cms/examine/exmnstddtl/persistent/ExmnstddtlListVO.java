package com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ExmnstddtlDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ExmnstddtlListVO extends DBQueryParam {
    private String _se_wayid;
    private String _ne_exmnid;
    private String _sk_exmnname;
    private String _ne_exmnstdid;
    private String _sk_exmnstdname;
    private String _se_exmnperiod;
    private String _ne_exmnmark;

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
     * @return Returns the _ne_exmnid.
     */
    public String get_ne_exmnid() {
        return this._ne_exmnid;
    }
    /**
     * @param _sk_companyname The _ne_exmnid to set.
     */
    public void set_ne_exmnid(String _ne_exmnid) {
        this._ne_exmnid = _ne_exmnid;
    }

	/**
     * @return Returns the _sk_exmnname.
     */
    public String get_sk_exmnname() {
        return this._sk_exmnname;
    }
    /**
     * @param _sk_companyname The _sk_exmnname to set.
     */
    public void set_sk_exmnname(String _sk_exmnname) {
        this._sk_exmnname = _sk_exmnname;
    }

	/**
     * @return Returns the _ne_exmnstdid.
     */
    public String get_ne_exmnstdid() {
        return this._ne_exmnstdid;
    }
    /**
     * @param _sk_companyname The _ne_exmnstdid to set.
     */
    public void set_ne_exmnstdid(String _ne_exmnstdid) {
        this._ne_exmnstdid = _ne_exmnstdid;
    }

	/**
     * @return Returns the _sk_exmnstdname.
     */
    public String get_sk_exmnstdname() {
        return this._sk_exmnstdname;
    }
    /**
     * @param _sk_companyname The _sk_exmnstdname to set.
     */
    public void set_sk_exmnstdname(String _sk_exmnstdname) {
        this._sk_exmnstdname = _sk_exmnstdname;
    }

	/**
     * @return Returns the _se_exmnperiod.
     */
    public String get_se_exmnperiod() {
        return this._se_exmnperiod;
    }
    /**
     * @param _sk_companyname The _se_exmnperiod to set.
     */
    public void set_se_exmnperiod(String _se_exmnperiod) {
        this._se_exmnperiod = _se_exmnperiod;
    }

	/**
     * @return Returns the _ne_exmnmark.
     */
    public String get_ne_exmnmark() {
        return this._ne_exmnmark;
    }
    /**
     * @param _sk_companyname The _ne_exmnmark to set.
     */
    public void set_ne_exmnmark(String _ne_exmnmark) {
        this._ne_exmnmark = _ne_exmnmark;
    }

}
