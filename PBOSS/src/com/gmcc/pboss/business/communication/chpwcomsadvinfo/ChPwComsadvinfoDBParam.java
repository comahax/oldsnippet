/**
 * auto-generated code
 * Mon Mar 23 12:58:46 CST 2015
 */
package com.gmcc.pboss.business.communication.chpwcomsadvinfo;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ChPwComsadvinfoDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwComsadvinfoDBParam extends DBQueryParam {
    private String _sk_title;
    private String _dnm_releasetime;
    private String _dnl_releasetime;
    private String _ne_state;

    private Long _rvcobjid;

    /**
     * @return Returns the _sk_title.
     */
    public String get_sk_title() {
        return this._sk_title;
    }
    /**
     * @param _sk_companyname The _sk_title to set.
     */
    public void set_sk_title(String _sk_title) {
        this._sk_title = _sk_title;
    }

    /**
     * @return Returns the _dnm_releasetime.
     */
    public String get_dnm_releasetime() {
        return this._dnm_releasetime;
    }
    /**
     * @param _sk_companyname The _dnm_releasetime to set.
     */
    public void set_dnm_releasetime(String _dnm_releasetime) {
        this._dnm_releasetime = _dnm_releasetime;
    }

    /**
     * @return Returns the _dnl_releasetime.
     */
    public String get_dnl_releasetime() {
        return this._dnl_releasetime;
    }
    /**
     * @param _sk_companyname The _dnl_releasetime to set.
     */
    public void set_dnl_releasetime(String _dnl_releasetime) {
        this._dnl_releasetime = _dnl_releasetime;
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

    public Long get_rvcobjid() {
        return _rvcobjid;
    }
    public void set_rvcobjid(Long _rvcobjid) {
        this._rvcobjid = _rvcobjid;
    }

}
