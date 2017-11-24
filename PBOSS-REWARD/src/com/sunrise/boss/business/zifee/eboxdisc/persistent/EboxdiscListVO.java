/**
 * auto-generated code
 * Mon Sep 04 20:34:08 CST 2006
 */
package com.sunrise.boss.business.zifee.eboxdisc.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: EboxdiscListVO
 * </p>
 * <p>
 * Description: Query Params Object for EboxdiscDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author eboxdisc
 * @version 1.0
 */
public class EboxdiscListVO extends BaseListVO {
	private String _ne_yxplanid;

	private String _sql_batchquery;

	private String _ne_eboxdiscid;

	private String _ne_eboxunitid;

	private String _se_disctype;

	private String _sk_remark;

	private String _se_presenttype; // 提供给优惠比列查询的

	private String _ne_ispresent;

	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}

	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	}

	public String get_se_disctype() {
		return _se_disctype;
	}

	public void set_se_disctype(String _se_disctype) {
		this._se_disctype = _se_disctype;
	}

	public String get_sk_remark() {
		return _sk_remark;
	}

	public void set_sk_remark(String _sk_remark) {
		this._sk_remark = _sk_remark;
	}

	public String get_ne_eboxdiscid() {
		return _ne_eboxdiscid;
	}

	public void set_ne_eboxdiscid(String _ne_eboxdiscid) {
		this._ne_eboxdiscid = _ne_eboxdiscid;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String get_ne_ispresent() {
		return _ne_ispresent;
	}

	public void set_ne_ispresent(String _ne_ispresent) {
		this._ne_ispresent = _ne_ispresent;
	}

	public String get_se_presenttype() {
		return _se_presenttype;
	}

	public void set_se_presenttype(String _se_presenttype) {
		this._se_presenttype = _se_presenttype;
	}

	public String get_sql_batchquery() {
		return _sql_batchquery;
	}

	public void set_sql_batchquery(String _sql_batchquery) {
		this._sql_batchquery = _sql_batchquery;
	}

}
