/**
 * auto-generated code
 * Wed Jul 08 10:21:09 CST 2009
 */
package com.gmcc.pboss.business.channel.areacenter;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: AreacenterDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class AreacenterDBParam extends DBQueryParam {
    private String _se_centername;
    private String _ne_areatype;
    private String _se_agent;

	/**
     * @return Returns the _se_centername.
     */
    public String get_se_centername() {
        return this._se_centername;
    }
    /**
     * @param _sk_companyname The _se_centername to set.
     */
    public void set_se_centername(String _se_centername) {
        this._se_centername = _se_centername;
    }

	/**
     * @return Returns the _ne_areatype.
     */
    public String get_ne_areatype() {
        return this._ne_areatype;
    }
    /**
     * @param _sk_companyname The _ne_areatype to set.
     */
    public void set_ne_areatype(String _ne_areatype) {
        this._ne_areatype = _ne_areatype;
    }

	/**
     * @return Returns the _se_agent.
     */
    public String get_se_agent() {
        return this._se_agent;
    }
    /**
     * @param _sk_companyname The _se_agent to set.
     */
    public void set_se_agent(String _se_agent) {
        this._se_agent = _se_agent;
    }

}
