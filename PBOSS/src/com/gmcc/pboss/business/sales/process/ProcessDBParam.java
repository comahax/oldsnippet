/**
 * auto-generated code
 * Wed Oct 14 09:04:57 CST 2009
 */
package com.gmcc.pboss.business.sales.process;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ProcessDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ProcessDBParam extends DBQueryParam {
    private String _se_processname;
    private String _se_cityid;

	/**
     * @return Returns the _se_processname.
     */
    public String get_se_processname() {
        return this._se_processname;
    }
    /**
     * @param _sk_companyname The _se_processname to set.
     */
    public void set_se_processname(String _se_processname) {
        this._se_processname = _se_processname;
    }

	/**
     * @return Returns the _se_cityid.
     */
    public String get_se_cityid() {
        return this._se_cityid;
    }
    /**
     * @param _sk_companyname The _se_cityid to set.
     */
    public void set_se_cityid(String _se_cityid) {
        this._se_cityid = _se_cityid;
    }

}
