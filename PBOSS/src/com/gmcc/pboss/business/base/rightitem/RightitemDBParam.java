/**
 * auto-generated code
 * Mon Jul 13 10:27:28 CST 2009
 */
package com.gmcc.pboss.business.base.rightitem;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: RightitemDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public class RightitemDBParam extends DBQueryParam {
    private String _se_rightid;
    private String _se_rightgroup;
    private String _se_region;

	/**
     * @return Returns the _se_rightid.
     */
    public String get_se_rightid() {
        return this._se_rightid;
    }
    /**
     * @param _sk_companyname The _se_rightid to set.
     */
    public void set_se_rightid(String _se_rightid) {
        this._se_rightid = _se_rightid;
    }
	public String get_se_rightgroup() {
		return _se_rightgroup;
	}
	public void set_se_rightgroup(String _se_rightgroup) {
		this._se_rightgroup = _se_rightgroup;
	}
	public String get_se_region() {
		return _se_region;
	}
	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}

}
