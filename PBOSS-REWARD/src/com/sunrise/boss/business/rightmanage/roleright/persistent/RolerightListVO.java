/**
 * auto-generated code
 * Thu Oct 19 17:09:08 CST 2006
 */
package com.sunrise.boss.business.rightmanage.roleright.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: RolerightListVO
 * </p>
 * <p>
 * Description: Query Params Object for RolerightDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class RolerightListVO extends BaseListVO {
	private String _se_itemid;

	private String _se_rightid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private Byte _ne_status;

	public String get_dnl_createdate() {
		return _dnl_createdate;
	}

	public void set_dnl_createdate(String _dnl_createdate) {
		this._dnl_createdate = _dnl_createdate;
	}

	public String get_dnm_createdate() {
		return _dnm_createdate;
	}

	public void set_dnm_createdate(String _dnm_createdate) {
		this._dnm_createdate = _dnm_createdate;
	}

	public Byte get_ne_status() {
		return _ne_status;
	}

	public void set_ne_status(Byte _ne_status) {
		this._ne_status = _ne_status;
	}

	public String get_se_itemid() {
		return _se_itemid;
	}

	public void set_se_itemid(String _se_itemid) {
		this._se_itemid = _se_itemid;
	}

	public String get_se_rightid() {
		return _se_rightid;
	}

	public void set_se_rightid(String _se_rightid) {
		this._se_rightid = _se_rightid;
	}

}
