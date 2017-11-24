/**
 * 
 */
package com.sunrise.boss.business.fee.billing.billinglog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * Title: CompanyDelegate
 * Description:
 * Copyright: Copyright (c) 2006
 * Company: sunrise Tech Ltd.
 * @author Hanny Yeung
 * @version 1.0
 */
public class BillingLogListVO extends BaseListVO {
	private String _ne_validbillcyc;

	private String _se_batchnum;

	private String _se_subphase;

	private String _se_billingphase;

	public String get_se_billingphase() {
		return _se_billingphase;
	}

	public void set_se_billingphase(String _se_billingphase) {
		this._se_billingphase = _se_billingphase;
	}

	public String get_se_subphase() {
		return _se_subphase;
	}

	public void set_se_subphase(String _se_subphase) {
		this._se_subphase = _se_subphase;
	}



	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}

	public String get_se_batchnum() {
		return _se_batchnum;
	}

	public void set_se_batchnum(String _se_batchnum) {
		this._se_batchnum = _se_batchnum;
	}

}
