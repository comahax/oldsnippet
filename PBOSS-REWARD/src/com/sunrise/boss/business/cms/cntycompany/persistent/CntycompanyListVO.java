/**
 * auto-generated code
 * Fri Aug 25 11:16:40 CST 2006
 */
package com.sunrise.boss.business.cms.cntycompany.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: CntycompanyListVO
 * </p>
 * <p>
 * Description: Query Params Object for CntycompanyDAO
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
public class CntycompanyListVO extends BaseListVO {

	private String _sk_countycompid;
	
	private String _se_countycompid;

	private String _se_citycompid;

	private String _sk_countycompname;

	private String _sk_agent;

	private String _se_billingcode;
	
	private String _ne_countycomptype;


	public String get_ne_countycomptype() {
		return _ne_countycomptype;
	}

	public void set_ne_countycomptype(String _ne_countycomptype) {
		this._ne_countycomptype = _ne_countycomptype;
	}

	public String get_se_billingcode() {
		return _se_billingcode;
	}

	public void set_se_billingcode(String _se_billingcode) {
		this._se_billingcode = _se_billingcode;
	}

	public String get_se_citycompid() {
		return _se_citycompid;
	}

	public void set_se_citycompid(String _se_citycompid) {
		this._se_citycompid = _se_citycompid;
	}

	public String get_sk_agent() {
		return _sk_agent;
	}

	public void set_sk_agent(String _sk_agent) {
		this._sk_agent = _sk_agent;
	}

	public String get_sk_countycompid() {
		return _sk_countycompid;
	}

	public void set_sk_countycompid(String _sk_countycompid) {
		this._sk_countycompid = _sk_countycompid;
	}

	public String get_sk_countycompname() {
		return _sk_countycompname;
	}

	public void set_sk_countycompname(String _sk_countycompname) {
		this._sk_countycompname = _sk_countycompname;
	}

	public String get_se_countycompid() {
		return _se_countycompid;
	}

	public void set_se_countycompid(String _se_countycompid) {
		this._se_countycompid = _se_countycompid;
	}

}
