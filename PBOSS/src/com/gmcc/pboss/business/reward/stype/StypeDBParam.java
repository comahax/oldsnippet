package com.gmcc.pboss.business.reward.stype;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: StypeDBParam
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public class StypeDBParam extends DBQueryParam {
	private String _se_stype;
	private String _sk_stype;
	private String _se_ltype;
	private String _sk_ltype;
	private String _se_cityid;
	private String _se_optype;
	private List _sin_cityid;

	private String _ne_seq;

	public String get_ne_seq() {
		return _ne_seq;
	}

	public void set_ne_seq(String neSeq) {
		_ne_seq = neSeq;
	}

	/**
	 * @return Returns the _se_stype.
	 */
	public String get_se_stype() {
		return this._se_stype;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_stype to set.
	 */
	public void set_se_stype(String _se_stype) {
		this._se_stype = _se_stype;
	}

	/**
	 * @return Returns the _sk_stype.
	 */
	public String get_sk_stype() {
		return this._sk_stype;
	}

	/**
	 * @param _sk_companyname
	 *            The _sk_stype to set.
	 */
	public void set_sk_stype(String _sk_stype) {
		this._sk_stype = _sk_stype;
	}

	/**
	 * @return Returns the _se_ltype.
	 */
	public String get_se_ltype() {
		return this._se_ltype;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_ltype to set.
	 */
	public void set_se_ltype(String _se_ltype) {
		this._se_ltype = _se_ltype;
	}

	/**
	 * @return Returns the _sk_ltype.
	 */
	public String get_sk_ltype() {
		return this._sk_ltype;
	}

	/**
	 * @param _sk_companyname
	 *            The _sk_ltype to set.
	 */
	public void set_sk_ltype(String _sk_ltype) {
		this._sk_ltype = _sk_ltype;
	}

	/**
	 * @return Returns the _se_cityid.
	 */
	public String get_se_cityid() {
		return this._se_cityid;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_cityid to set.
	 */
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_optype() {
		return _se_optype;
	}

	public void set_se_optype(String seOptype) {
		_se_optype = seOptype;
	}

	public List get_sin_cityid() {
		return _sin_cityid;
	}

	public void set_sin_cityid(List sinCityid) {
		_sin_cityid = sinCityid;
	}

}
