/**
 * auto-generated code
 * Thu Sep 17 15:58:40 CST 2009
 */
package com.gmcc.pboss.business.promotion.daemonreg;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: DaemonregDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DaemonregDBParam extends DBQueryParam {
    private String _ne_processid;
    private String _se_processname;
    private String _se_processor;

	/**
     * @return Returns the _ne_processid.
     */
    public String get_ne_processid() {
        return this._ne_processid;
    }
    /**
     * @param _sk_companyname The _ne_processid to set.
     */
    public void set_ne_processid(String _ne_processid) {
        this._ne_processid = _ne_processid;
    }

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
     * @return Returns the _se_processor.
     */
    public String get_se_processor() {
        return this._se_processor;
    }
    /**
     * @param _sk_companyname The _se_processor to set.
     */
    public void set_se_processor(String _se_processor) {
        this._se_processor = _se_processor;
    }

}
