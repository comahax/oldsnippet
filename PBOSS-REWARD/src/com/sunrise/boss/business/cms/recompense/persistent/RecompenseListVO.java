/**
 * auto-generated code
 * Thu Sep 14 14:35:53 CST 2006
 */
package com.sunrise.boss.business.cms.recompense.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: RecompenseListVO
 * </p>
 * <p>
 * Description: Query Params Object for RecompenseDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author wkx
 * @version 1.0
 */
public class RecompenseListVO extends BaseListVO {

	private static final long serialVersionUID = 5434473257056876417L;

	private String _ne_recid;

	private String _ne_target;

	private String _ne_quotiety;

	private String _ne_standard;

	private String _sk_balanceterm;

	private String _se_comtype;

	private String _se_bchlevel;

	public String get_ne_quotiety() {
		return _ne_quotiety;
	}

	public void set_ne_quotiety(String _ne_quotiety) {
		this._ne_quotiety = _ne_quotiety;
	}

	public String get_ne_recid() {
		return _ne_recid;
	}

	public void set_ne_recid(String _ne_recid) {
		this._ne_recid = _ne_recid;
	}

	public String get_ne_standard() {
		return _ne_standard;
	}

	public void set_ne_standard(String _ne_standard) {
		this._ne_standard = _ne_standard;
	}

	public String get_ne_target() {
		return _ne_target;
	}

	public void set_ne_target(String _ne_target) {
		this._ne_target = _ne_target;
	}

	public String get_se_bchlevel() {
		return _se_bchlevel;
	}

	public void set_se_bchlevel(String _se_bchlevel) {
		this._se_bchlevel = _se_bchlevel;
	}

	public String get_se_comtype() {
		return _se_comtype;
	}

	public void set_se_comtype(String _se_comtype) {
		this._se_comtype = _se_comtype;
	}

	public String get_sk_balanceterm() {
		return _sk_balanceterm;
	}

	public void set_sk_balanceterm(String _sk_balanceterm) {
		this._sk_balanceterm = _sk_balanceterm;
	}

}
