/**
 * auto-generated code
 * Sat Jun 11 09:38:29 CST 2011
 */
package com.gmcc.pboss.business.chpwempsyn2crm.empsyn;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: EmpsynDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class EmpsynDBParam extends DBQueryParam {
    private String _ne_opract;
    private String _ne_isnet;

	/**
     * @return Returns the _se_opract.
     */
    public String get_ne_opract() {
        return this._ne_opract;
    }
    /**
     * @param _sk_companyname The _se_opract to set.
     */
    public void set_ne_opract(String _ne_opract) {
        this._ne_opract = _ne_opract;
    }
	public String get_ne_isnet() {
		return _ne_isnet;
	}
	public void set_ne_isnet(String _ne_isnet) {
		this._ne_isnet = _ne_isnet;
	}

}
