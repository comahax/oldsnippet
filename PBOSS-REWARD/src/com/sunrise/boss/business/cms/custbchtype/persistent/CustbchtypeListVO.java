/**
 * auto-generated code
 * Fri Aug 25 11:26:23 CST 2006
 */
package com.sunrise.boss.business.cms.custbchtype.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: CustbchtypeListVO
 * </p>
 * <p>
 * Description: Query Params Object for CustbchtypeDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author yjr
 * @version 1.0
 */
public class CustbchtypeListVO extends BaseListVO {

	private String _sk_bchtypecode;

	private String _sk_bchtypename;
	
	private String _se_citycompid;

	public String get_sk_bchtypecode() {
		return _sk_bchtypecode;
	}

	public void set_sk_bchtypecode(String _sk_bchtypecode) {
		this._sk_bchtypecode = _sk_bchtypecode;
	}

	public String get_sk_bchtypename() {
		return _sk_bchtypename;
	}

	public void set_sk_bchtypename(String _sk_bchtypename) {
		this._sk_bchtypename = _sk_bchtypename;
	}

	public String get_se_citycompid() {
		return _se_citycompid;
	}

	public void set_se_citycompid(String _se_citycompid) {
		this._se_citycompid = _se_citycompid;
	}

}
