/**
 * auto-generated code
 * Thu Dec 29 17:51:44 CST 2011
 */
package com.gmcc.pboss.business.channel.bondaudit;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: BondauditDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class BondauditDBParam extends DBQueryParam {
    private String _dnm_smsntime;
    private String _dnl_smsntime;
    private String _se_state;

	/**
     * @return Returns the _dnm_smsntime.
     */
    public String get_dnm_smsntime() {
        return this._dnm_smsntime;
    }
    /**
     * @param _sk_companyname The _dnm_smsntime to set.
     */
    public void set_dnm_smsntime(String _dnm_smsntime) {
        this._dnm_smsntime = _dnm_smsntime;
    }

	/**
     * @return Returns the _dnl_smsntime.
     */
    public String get_dnl_smsntime() {
        return this._dnl_smsntime;
    }
    /**
     * @param _sk_companyname The _dnl_smsntime to set.
     */
    public void set_dnl_smsntime(String _dnl_smsntime) {
        this._dnl_smsntime = _dnl_smsntime;
    }

	/**
     * @return Returns the _se_state.
     */
    public String get_se_state() {
        return this._se_state;
    }
    /**
     * @param _sk_companyname The _se_state to set.
     */
    public void set_se_state(String _se_state) {
        this._se_state = _se_state;
    }

}
