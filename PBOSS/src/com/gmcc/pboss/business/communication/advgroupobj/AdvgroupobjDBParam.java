/**
 * auto-generated code
 * Tue Sep 29 10:22:17 CST 2009
 */
package com.gmcc.pboss.business.communication.advgroupobj;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: AdvgroupobjDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvgroupobjDBParam extends DBQueryParam {
    private String _ne_groupoid;
    private String _ne_groupid;
    private String _ne_oid;

    private List<String> _sin_groupid;
    private List<String> _sin_oid;
	/**
     * @return Returns the _ne_groupoid.
     */
	
	public String get_ne_groupoid() {
		return _ne_groupoid;
	}
	public void set_ne_groupoid(String _ne_groupoid) {
		this._ne_groupoid = _ne_groupoid;
	}
	public String get_ne_groupid() {
		return _ne_groupid;
	}
	public void set_ne_groupid(String _ne_groupid) {
		this._ne_groupid = _ne_groupid;
	}
	public String get_ne_oid() {
		return _ne_oid;
	}
	public void set_ne_oid(String _ne_oid) {
		this._ne_oid = _ne_oid;
	}
	public List<String> get_sin_oid() {
		return _sin_oid;
	}
	public void set_sin_oid(List<String> _sin_oid) {
		this._sin_oid = _sin_oid;
	}
	public List<String> get_sin_groupid() {
		return _sin_groupid;
	}
	public void set_sin_groupid(List<String> _sin_groupid) {
		this._sin_groupid = _sin_groupid;
	}

}
