/**
 * auto-generated code
 * Fri Jul 10 14:35:20 CST 2009
 */
package com.gmcc.pboss.business.base.operrole;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OperroleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public class OperroleDBParam extends DBQueryParam {
    private String _se_operid;
    private String _se_roleid;
    private String _dnl_statusdate;
    private String _dnm_statusdate;
    private List _sin_roleid;
    private String _ne_status;

	/**
     * @return Returns the _se_operid.
     */
    public String get_se_operid() {
        return this._se_operid;
    }
    /**
     * @param _sk_companyname The _se_operid to set.
     */
    public void set_se_operid(String _se_operid) {
        this._se_operid = _se_operid;
    }

	/**
     * @return Returns the _se_roleid.
     */
    public String get_se_roleid() {
        return this._se_roleid;
    }
    /**
     * @param _sk_companyname The _se_roleid to set.
     */
    public void set_se_roleid(String _se_roleid) {
        this._se_roleid = _se_roleid;
    }
	public String get_dnl_statusdate() {
		return _dnl_statusdate;
	}
	public void set_dnl_statusdate(String _dnl_statusdate) {
		this._dnl_statusdate = _dnl_statusdate;
	}
	public String get_dnm_statusdate() {
		return _dnm_statusdate;
	}
	public void set_dnm_statusdate(String _dnm_statusdate) {
		this._dnm_statusdate = _dnm_statusdate;
	}
	public List get_sin_roleid() {
		return _sin_roleid;
	}
	public void set_sin_roleid(List _sin_roleid) {
		this._sin_roleid = _sin_roleid;
	}
	public String get_ne_status() {
		return _ne_status;
	}
	public void set_ne_status(String _ne_status) {
		this._ne_status = _ne_status;
	}
	
}
