/**
 * auto-generated code
 * Fri Aug 25 11:25:35 CST 2006
 */
package com.sunrise.boss.business.cms.custwaytype.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: CustwaytypeListVO
 * </p>
 * <p>
 * Description: Query Params Object for CustwaytypeDAO
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
public class CustwaytypeListVO extends BaseListVO {

	private String _sk_custwaytypecode;

	private String _sk_custwaytypename;

	private String _se_citycompid;

	private String _se_custwaytypecode;

	public String get_se_custwaytypecode() {
		return _se_custwaytypecode;
	}

	public void set_se_custwaytypecode(String _se_custwaytypecode) {
		this._se_custwaytypecode = _se_custwaytypecode;
	}

	public String get_se_citycompid() {
		return _se_citycompid;
	}

	public void set_se_citycompid(String _se_citycompid) {
		this._se_citycompid = _se_citycompid;
	}

	public String get_sk_custwaytypecode() {
		return _sk_custwaytypecode;
	}

	public void set_sk_custwaytypecode(String _sk_custwaytypecode) {
		this._sk_custwaytypecode = _sk_custwaytypecode;
	}

	public String get_sk_custwaytypename() {
		return _sk_custwaytypename;
	}

	public void set_sk_custwaytypename(String _sk_custwaytypename) {
		this._sk_custwaytypename = _sk_custwaytypename;
	}

}
