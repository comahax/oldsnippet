package com.gmcc.pboss.business.reward.ltype;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: LtypeDBParam
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
public class LtypeDBParam extends DBQueryParam {

	private static final long serialVersionUID = -4832695396332601750L;

	private String _se_optype;
	private String _se_ltype;
	private String _se_cityid;
	private List<String> _sin_cityid;
	private String _se_stype;

	private String _ne_seq;

	/**
	 * @return Returns the _ne_seq.
	 */
	public String get_ne_seq() {
		return this._ne_seq;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_seq to set.
	 */
	public void set_ne_seq(String _ne_seq) {
		this._ne_seq = _ne_seq;
	}

	/**
	 * @return Returns the _se_optype.
	 */
	public String get_se_optype() {
		return this._se_optype;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_optype to set.
	 */
	public void set_se_optype(String _se_optype) {
		this._se_optype = _se_optype;
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

	public String get_se_stype() {
		return _se_stype;
	}

	public void set_se_stype(String seStype) {
		_se_stype = seStype;
	}

	public List<String> get_sin_cityid() {
		return _sin_cityid;
	}

	public void set_sin_cityid(List<String> sinCityid) {
		_sin_cityid = sinCityid;
	}

}
