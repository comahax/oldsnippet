/**
 * auto-generated code
 * Tue Jun 29 12:02:04 CST 2010
 */
package com.gmcc.pboss.business.channel.empmodel;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: EmpmodelDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class EmpmodelDBParam extends DBQueryParam {
    private String _ne_empmodelid;
    private String _se_employeeid;
    private String _se_model;
    private String _ne_state;

	/**
     * @return Returns the _ne_empmodelid.
     */
    public String get_ne_empmodelid() {
        return this._ne_empmodelid;
    }
    /**
     * @param _sk_companyname The _ne_empmodelid to set.
     */
    public void set_ne_empmodelid(String _ne_empmodelid) {
        this._ne_empmodelid = _ne_empmodelid;
    }

	/**
     * @return Returns the _se_employeeid.
     */
    public String get_se_employeeid() {
        return this._se_employeeid;
    }
    /**
     * @param _sk_companyname The _se_employeeid to set.
     */
    public void set_se_employeeid(String _se_employeeid) {
        this._se_employeeid = _se_employeeid;
    }

	/**
     * @return Returns the _se_model.
     */
    public String get_se_model() {
        return this._se_model;
    }
    /**
     * @param _sk_companyname The _se_model to set.
     */
    public void set_se_model(String _se_model) {
        this._se_model = _se_model;
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

}
