package com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class ImpFieldDetaListVO extends BaseListVO {
	
	private String _ne_ruleid;
	private String _se_tabcode;
	private String _nnl_fieldindex;

	public String get_nnl_fieldindex() {
		return _nnl_fieldindex;
	}

	public void set_nnl_fieldindex(String _nnl_fieldindex) {
		this._nnl_fieldindex = _nnl_fieldindex;
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
