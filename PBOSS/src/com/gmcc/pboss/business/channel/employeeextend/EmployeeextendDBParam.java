/**
 * auto-generated code
 * Thu Feb 17 11:53:25 CST 2011
 */
package com.gmcc.pboss.business.channel.employeeextend;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: EmployeeextendDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmployeeextendDBParam extends DBQueryParam {
    private String _se_employeeid;
    private String _se_password;

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
     * @return Returns the _se_password.
     */
    public String get_se_password() {
        return this._se_password;
    }
    /**
     * @param _sk_companyname The _se_password to set.
     */
    public void set_se_password(String _se_password) {
        this._se_password = _se_password;
    }

}
