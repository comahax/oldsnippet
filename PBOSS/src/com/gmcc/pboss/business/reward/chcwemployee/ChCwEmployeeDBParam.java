/**
 * auto-generated code
 * Tue Sep 15 10:34:49 CST 2015
 */
package com.gmcc.pboss.business.reward.chcwemployee;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ChCwEmployeeDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author ydr
 * @version 1.0
 */
public class ChCwEmployeeDBParam extends DBQueryParam {
    private String _se_employeeNum;
    private String _sk_employeeName;
    private String _ne_deptId;

	/**
     * @return Returns the _se_employeeNum.
     */
    public String get_se_employeeNum() {
        return this._se_employeeNum;
    }
    /**
     * @param _sk_companyname The _se_employeeNum to set.
     */
    public void set_se_employeeNum(String _se_employeeNum) {
        this._se_employeeNum = _se_employeeNum;
    }

	/**
     * @return Returns the _sk_employeeName.
     */
    public String get_sk_employeeName() {
        return this._sk_employeeName;
    }
    /**
     * @param _sk_companyname The _sk_employeeName to set.
     */
    public void set_sk_employeeName(String _sk_employeeName) {
        this._sk_employeeName = _sk_employeeName;
    }

	/**
     * @return Returns the _ne_deptId.
     */
    public String get_ne_deptId() {
        return this._ne_deptId;
    }
    /**
     * @param _sk_companyname The _ne_deptId to set.
     */
    public void set_ne_deptId(String _ne_deptId) {
        this._ne_deptId = _ne_deptId;
    }

}
