/**
 * auto-generated code
 * Wed Jul 01 17:32:06 CST 2009
 */
package com.gmcc.pboss.business.channel.netsyn;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: NetsynDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class NetsynDBParam extends DBQueryParam {
    private String _ne_itemid;
    
    private String _se_mobile;
    
    private String _ne_opract;
	/**
     * @return Returns the _ne_itemid.
     */
    public String get_ne_itemid() {
        return this._ne_itemid;
    }
    /**
     * @param _sk_companyname The _ne_itemid to set.
     */
    public void set_ne_itemid(String _ne_itemid) {
        this._ne_itemid = _ne_itemid;
    }
	public String get_se_mobile() {
		return _se_mobile;
	}
	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}
	public String get_ne_opract() {
		return _ne_opract;
	}
	public void set_ne_opract(String _ne_opract) {
		this._ne_opract = _ne_opract;
	}

}
