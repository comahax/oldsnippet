/**
 * 
 */
package com.sunrise.boss.business.fee.billing.bltouchrule.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * Title: CompanyDelegate
 * Description:
 * Copyright: Copyright (c) 2006
 * Company: sunrise Tech Ltd.
 * 
 * @author Hanny Yeung,mys
 * @version 1.0
 */
public class BlTouchRuleListVO extends BaseListVO {
	private String _ne_validbillcyc;

	private String _se_batchnum;

	public String get_se_batchnum() {
		return _se_batchnum;
	}

	public void set_se_batchnum(String _se_batchnum) {
		this._se_batchnum = _se_batchnum;
	}

	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}


}
