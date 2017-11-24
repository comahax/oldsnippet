package com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: IbDataBusiinfoDBParam
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author 赵武
 * @version 1.0
 */
public class IbDataBusiinfoDBParam extends DBQueryParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2369222994672201663L;
	private String _ne_billcycle;
	private String _se_filetype;
	private String _se_spCode;
	private String _se_opCode;
	private String _se_port;
	private String _ne_chargingtype;
	private String _ne_fee;
	private String _ne_acctitemIdlv1;
	private String _ne_acctitemIdlv2;

	private String _sew_port;
	
	private String startindex;
	private String endindex;
	private String propertys;

	/**
	 * @return Returns the _ne_billcycle.
	 */
	public String get_ne_billcycle() {
		return this._ne_billcycle;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_billcycle to set.
	 */
	public void set_ne_billcycle(String _ne_billcycle) {
		this._ne_billcycle = _ne_billcycle;
	}

	/**
	 * @return Returns the _se_filetype.
	 */
	public String get_se_filetype() {
		return this._se_filetype;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_filetype to set.
	 */
	public void set_se_filetype(String _se_filetype) {
		this._se_filetype = _se_filetype;
	}

	/**
	 * @return Returns the _se_spCode.
	 */
	public String get_se_spCode() {
		return this._se_spCode;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_spCode to set.
	 */
	public void set_se_spCode(String _se_spCode) {
		this._se_spCode = _se_spCode;
	}

	/**
	 * @return Returns the _se_opCode.
	 */
	public String get_se_opCode() {
		return this._se_opCode;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_opCode to set.
	 */
	public void set_se_opCode(String _se_opCode) {
		this._se_opCode = _se_opCode;
	}

	/**
	 * @return Returns the _se_port.
	 */
	public String get_se_port() {
		return this._se_port;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_port to set.
	 */
	public void set_se_port(String _se_port) {
		this._se_port = _se_port;
	}

	/**
	 * @return Returns the _ne_chargingtype.
	 */
	public String get_ne_chargingtype() {
		return this._ne_chargingtype;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_chargingtype to set.
	 */
	public void set_ne_chargingtype(String _ne_chargingtype) {
		this._ne_chargingtype = _ne_chargingtype;
	}

	/**
	 * @return Returns the _ne_fee.
	 */
	public String get_ne_fee() {
		return this._ne_fee;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_fee to set.
	 */
	public void set_ne_fee(String _ne_fee) {
		this._ne_fee = _ne_fee;
	}

	/**
	 * @return Returns the _ne_acctitemIdlv1.
	 */
	public String get_ne_acctitemIdlv1() {
		return this._ne_acctitemIdlv1;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_acctitemIdlv1 to set.
	 */
	public void set_ne_acctitemIdlv1(String _ne_acctitemIdlv1) {
		this._ne_acctitemIdlv1 = _ne_acctitemIdlv1;
	}

	/**
	 * @return Returns the _ne_acctitemIdlv2.
	 */
	public String get_ne_acctitemIdlv2() {
		return this._ne_acctitemIdlv2;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_acctitemIdlv2 to set.
	 */
	public void set_ne_acctitemIdlv2(String _ne_acctitemIdlv2) {
		this._ne_acctitemIdlv2 = _ne_acctitemIdlv2;
	}
	
	public String get_sew_port() {
		return _sew_port;
	}

	public void set_sew_port(String _sew_port) {
		this._sew_port = _sew_port;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}

	public String getPropertys() {
		return propertys;
	}

	public void setPropertys(String propertys) {
		this.propertys = propertys;
	}

}
