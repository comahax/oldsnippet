/**
 * auto-generated code
 * Fri Aug 25 11:24:52 CST 2006
 */
package com.sunrise.boss.business.cms.waytype.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: WaytypeListVO
 * </p>
 * <p>
 * Description: Query Params Object for WaytypeDAO
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
public class WaytypeListVO extends BaseListVO {

	private String _se_waytypecode;

	private String _se_uppercode;

	private String _sql_waytypecode;

	public String get_sql_waytypecode() {
		return _sql_waytypecode;
	}

	public void set_sql_waytypecode(String _sql_waytypecode) {
		this._sql_waytypecode = _sql_waytypecode;
	}

	public String get_se_uppercode() {
		return _se_uppercode;
	}

	public void set_se_uppercode(String _se_uppercode) {
		this._se_uppercode = _se_uppercode;
	}

	public String get_se_waytypecode() {
		return _se_waytypecode;
	}

	public void set_se_waytypecode(String _se_waytypecode) {
		this._se_waytypecode = _se_waytypecode;
	}

}
