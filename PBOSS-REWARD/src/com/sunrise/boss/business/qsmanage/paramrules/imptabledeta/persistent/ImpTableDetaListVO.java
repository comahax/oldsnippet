package com.sunrise.boss.business.qsmanage.paramrules.imptabledeta.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class ImpTableDetaListVO extends BaseListVO {
	
	private String _ne_ruleid;
	
	private String _se_tabcode;
	private String _se_entparam;

	public String get_se_entparam() {
		return _se_entparam;
	}

	public void set_se_entparam(String _se_entparam) {
		this._se_entparam = _se_entparam;
	}

	public String get_se_tabcode() {
		return _se_tabcode;
	}

	public void set_se_tabcode(String _se_tabcode) {
		this._se_tabcode = _se_tabcode;
	}

	public String get_ne_ruleid() {
		return _ne_ruleid;
	}

	public void set_ne_ruleid(String _ne_ruleid) {
		this._ne_ruleid = _ne_ruleid;
	}

}
