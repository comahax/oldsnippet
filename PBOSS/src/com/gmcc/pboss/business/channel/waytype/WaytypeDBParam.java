/**
 * auto-generated code
 * Wed Jul 08 11:41:20 CST 2009
 */
package com.gmcc.pboss.business.channel.waytype;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: WaytypeDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WaytypeDBParam extends DBQueryParam {
    private String _se_waytypecode;
    private String _se_uppercode;

	/**
     * @return Returns the _se_waytypecode.
     */
    public String get_se_waytypecode() {
        return this._se_waytypecode;
    }
    /**
     * @param _sk_companyname The _se_waytypecode to set.
     */
    public void set_se_waytypecode(String _se_waytypecode) {
        this._se_waytypecode = _se_waytypecode;
    }
	public String get_se_uppercode() {
		return _se_uppercode;
	}
	public void set_se_uppercode(String _se_uppercode) {
		this._se_uppercode = _se_uppercode;
	}

}
