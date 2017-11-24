/**
 * auto-generated code
 * Sat Nov 21 17:07:29 CST 2009
 */
package com.gmcc.pboss.business.channel.wayhierarchy;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: WayhierarchyDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class WayhierarchyDBParam extends DBQueryParam {
    private String _se_parwayid;
    private String _se_subwayid;

	/**
     * @return Returns the _se_parwayid.
     */
    public String get_se_parwayid() {
        return this._se_parwayid;
    }
    /**
     * @param _sk_companyname The _se_parwayid to set.
     */
    public void set_se_parwayid(String _se_parwayid) {
        this._se_parwayid = _se_parwayid;
    }

	/**
     * @return Returns the _se_subwayid.
     */
    public String get_se_subwayid() {
        return this._se_subwayid;
    }
    /**
     * @param _sk_companyname The _se_subwayid to set.
     */
    public void set_se_subwayid(String _se_subwayid) {
        this._se_subwayid = _se_subwayid;
    }

}
