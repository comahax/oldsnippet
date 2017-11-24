package com.sunrise.boss.business.cms.audit.jhsmsrule.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: CompanyDelegate
 * </p>
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
 * @author Hanny Yeung
 * @version 1.0
 */
public class JhSmsRuleListVO extends BaseListVO {
	private String _se_ruleid;

	private String _se_type;

	private String _se_valid;

	public String get_se_ruleid() {
		return _se_ruleid;
	}

	public String get_se_type() {
		return _se_type;
	}

	public String get_se_valid() {
		return _se_valid;
	}

	public void set_se_ruleid(String _se_ruleid) {
		this._se_ruleid = _se_ruleid;
	}

	public void set_se_type(String _se_type) {
		this._se_type = _se_type;
	}

	public void set_se_valid(String _se_valid) {
		this._se_valid = _se_valid;
	}

}
