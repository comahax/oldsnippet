/**
 * auto-generated code
 * Wed Aug 04 10:45:31 CST 2010
 */
package com.gmcc.pboss.business.sales.ordcomlog;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrdcomlogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrdcomlogDBParam extends DBQueryParam {
	private String _ne_ordcomid;
	private String _se_orderid;
	
	public String get_ne_ordcomid() {
		return _ne_ordcomid;
	}

	public void set_ne_ordcomid(String _ne_ordcomid) {
		this._ne_ordcomid = _ne_ordcomid;
	}

	public String get_se_orderid() {
		return _se_orderid;
	}

	public void set_se_orderid(String _se_orderid) {
		this._se_orderid = _se_orderid;
	}

}
