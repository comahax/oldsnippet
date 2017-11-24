/**
 * auto-generated code
 * Fri Aug 25 11:23:52 CST 2006
 */
package com.sunrise.boss.business.cms.citycompany.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: CitycompanyListVO
 * </p>
 * <p>
 * Description: Query Params Object for CitycompanyDAO
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
public class CitycompanyListVO extends BaseListVO {
	private String _sk_citycompid;

	private String _se_centerid;

	private String _sk_citycompname;
	
	private String _ne_citycomptype;

	private String _sk_agent;

	private String _se_billingcode;
	
	private String _se_citycompid;

	public String get_se_billingcode() {
		return _se_billingcode;
	}

	public void set_se_billingcode(String _se_billingcode) {
		this._se_billingcode = _se_billingcode;
	}

	public String get_se_centerid() {
		return _se_centerid;
	}

	public void set_se_centerid(String _se_centerid) {
		this._se_centerid = _se_centerid;
	}

	public String get_sk_agent() {
		return _sk_agent;
	}

	public void set_sk_agent(String _sk_agent) {
		this._sk_agent = _sk_agent;
	}

	public String get_sk_citycompid() {
		return _sk_citycompid;
	}

	public void set_sk_citycompid(String _sk_citycompid) {
		this._sk_citycompid = _sk_citycompid;
	}

	public String get_sk_citycompname() {
		return _sk_citycompname;
	}

	public void set_sk_citycompname(String _sk_citycompname) {
		this._sk_citycompname = _sk_citycompname;
	}

	public String get_ne_citycomptype() {
		return _ne_citycomptype;
	}

	public void set_ne_citycomptype(String _ne_citycomptype) {
		this._ne_citycomptype = _ne_citycomptype;
	}

	public String get_se_citycompid() {
		return _se_citycompid;
	}

	public void set_se_citycompid(String _se_citycompid) {
		this._se_citycompid = _se_citycompid;
	}

}
