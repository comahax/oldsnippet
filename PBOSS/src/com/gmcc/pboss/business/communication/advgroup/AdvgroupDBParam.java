/**
 * auto-generated code
 * Tue Sep 29 10:21:01 CST 2009
 */
package com.gmcc.pboss.business.communication.advgroup;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: AdvgroupDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvgroupDBParam extends DBQueryParam {
    private String _ne_groupid;
    private String _nne_groupid;
    private String _se_groupname;
    private String _sk_groupname;
    
    private String groupoid;
	/**
     * @return Returns the _ne_groupid.
     */
    public String get_ne_groupid() {
        return this._ne_groupid;
    }
    /**
     * @param _sk_companyname The _ne_groupid to set.
     */
    public void set_ne_groupid(String _ne_groupid) {
        this._ne_groupid = _ne_groupid;
    }

	/**
     * @return Returns the _se_groupname.
     */
    public String get_se_groupname() {
        return this._se_groupname;
    }
    /**
     * @param _sk_companyname The _se_groupname to set.
     */
    public void set_se_groupname(String _se_groupname) {
        this._se_groupname = _se_groupname;
    }
    
	public String get_sk_groupname() {
		return _sk_groupname;
	}
	public void set_sk_groupname(String _sk_groupname) {
		this._sk_groupname = _sk_groupname;
	}
	public String get_nne_groupid() {
		return _nne_groupid;
	}
	public void set_nne_groupid(String _nne_groupid) {
		this._nne_groupid = _nne_groupid;
	}
	public String getGroupoid() {
		return groupoid;
	}
	public void setGroupoid(String groupoid) {
		this.groupoid = groupoid;
	}
	
}
