/**
 * auto-generated code
 * Wed Nov 18 17:19:05 CST 2009
 */
package com.gmcc.pboss.business.sales.orderreq;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderreqDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderreqDBParam extends DBQueryParam {
	private String _se_reqid;
	private String _se_cityid;
	private String _ne_state;
	private String _se_wayid;
	
	public String get_se_wayid() {
		return _se_wayid;
	}
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}
	public String get_ne_state() {
		return _ne_state;
	}
	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}
	public String get_se_reqid() {
		return _se_reqid;
	}
	public void set_se_reqid(String _se_reqid) {
		this._se_reqid = _se_reqid;
	}
}
