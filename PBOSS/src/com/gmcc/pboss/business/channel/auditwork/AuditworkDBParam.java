/**
 * auto-generated code
 * Thu Oct 15 16:20:00 CST 2009
 */
package com.gmcc.pboss.business.channel.auditwork;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: AuditworkDBParam
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class AuditworkDBParam extends DBQueryParam {
	private String _ne_seqid;
	private String _se_worktype;
	private String _sk_worktype;
	private String _se_stepid;
	private String _dnm_createtime;
	private String _dnl_createtime;
	private String _se_oprcode;
	private String _ne_auditstatus;
	private String _ne_applyno;
	private String _pk2;

	/**
	 * @return Returns the _ne_seqid.
	 */
	public String get_ne_seqid() {
		return this._ne_seqid;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_seqid to set.
	 */
	public void set_ne_seqid(String _ne_seqid) {
		this._ne_seqid = _ne_seqid;
	}

	/**
	 * @return Returns the _se_worktype.
	 */
	public String get_se_worktype() {
		return this._se_worktype;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_worktype to set.
	 */
	public void set_se_worktype(String _se_worktype) {
		this._se_worktype = _se_worktype;
	}

	/**
	 * @return Returns the _sk_worktype.
	 */
	public String get_sk_worktype() {
		return this._sk_worktype;
	}

	/**
	 * @param _sk_companyname
	 *            The _sk_worktype to set.
	 */
	public void set_sk_worktype(String _sk_worktype) {
		this._sk_worktype = _sk_worktype;
	}

	/**
	 * @return Returns the _se_stepid.
	 */
	public String get_se_stepid() {
		return this._se_stepid;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_stepid to set.
	 */
	public void set_se_stepid(String _se_stepid) {
		this._se_stepid = _se_stepid;
	}

	/**
	 * @return Returns the _dnm_createtime.
	 */
	public String get_dnm_createtime() {
		return this._dnm_createtime;
	}

	/**
	 * @param _sk_companyname
	 *            The _dnm_createtime to set.
	 */
	public void set_dnm_createtime(String _dnm_createtime) {
		this._dnm_createtime = _dnm_createtime;
	}

	/**
	 * @return Returns the _dnl_createtime.
	 */
	public String get_dnl_createtime() {
		return this._dnl_createtime;
	}

	/**
	 * @param _sk_companyname
	 *            The _dnl_createtime to set.
	 */
	public void set_dnl_createtime(String _dnl_createtime) {
		this._dnl_createtime = _dnl_createtime;
	}

	/**
	 * @return Returns the _se_oprcode.
	 */
	public String get_se_oprcode() {
		return this._se_oprcode;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_oprcode to set.
	 */
	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	/**
	 * @return Returns the _ne_auditstatus.
	 */
	public String get_ne_auditstatus() {
		return this._ne_auditstatus;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_auditstatus to set.
	 */
	public void set_ne_auditstatus(String _ne_auditstatus) {
		this._ne_auditstatus = _ne_auditstatus;
	}

	public String get_ne_applyno() {
		return _ne_applyno;
	}

	public void set_ne_applyno(String _ne_applyno) {
		this._ne_applyno = _ne_applyno;
	}

	public String get_pk2() {
		return _pk2;
	}

	public void set_pk2(String _pk2) {
		this._pk2 = _pk2;
	}

}
