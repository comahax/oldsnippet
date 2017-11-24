/**
 * auto-generated code
 * Wed Jul 08 11:40:54 CST 2009
 */
package com.gmcc.pboss.business.channel.svwaycnstr;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: SvwaycnstrDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class SvwaycnstrDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _de_runtime;
    private String _se_waytype;

	/**
     * @return Returns the _se_wayid.
     */
    public String get_se_wayid() {
        return this._se_wayid;
    }
    /**
     * @param _sk_companyname The _se_wayid to set.
     */
    public void set_se_wayid(String _se_wayid) {
        this._se_wayid = _se_wayid;
    }

	/**
     * @return Returns the _de_runtime.
     */
    public String get_de_runtime() {
        return this._de_runtime;
    }
    /**
     * @param _sk_companyname The _de_runtime to set.
     */
    public void set_de_runtime(String _de_runtime) {
        this._de_runtime = _de_runtime;
    }

	/**
     * @return Returns the _se_waytype.
     */
    public String get_se_waytype() {
        return this._se_waytype;
    }
    /**
     * @param _sk_companyname The _se_waytype to set.
     */
    public void set_se_waytype(String _se_waytype) {
        this._se_waytype = _se_waytype;
    }

}
