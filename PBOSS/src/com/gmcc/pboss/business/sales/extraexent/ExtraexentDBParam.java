/**
 * auto-generated code
 * Thu Jun 16 17:11:00 CST 2011
 */
package com.gmcc.pboss.business.sales.extraexent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ExtraexentDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ExtraexentDBParam extends DBQueryParam {
	
	private String _se_cityid;
	
    private String _se_countyid;
    private String _se_extraexent;

	/**
     * @return Returns the _se_countyid.
     */
    public String get_se_countyid() {
        return this._se_countyid;
    }
    /**
     * @param _sk_companyname The _se_countyid to set.
     */
    public void set_se_countyid(String _se_countyid) {
        this._se_countyid = _se_countyid;
    }

	/**
     * @return Returns the _se_extraexent.
     */
    public String get_se_extraexent() {
        return this._se_extraexent;
    }
    /**
     * @param _sk_companyname The _se_extraexent to set.
     */
    public void set_se_extraexent(String _se_extraexent) {
        this._se_extraexent = _se_extraexent;
    }
	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

}
