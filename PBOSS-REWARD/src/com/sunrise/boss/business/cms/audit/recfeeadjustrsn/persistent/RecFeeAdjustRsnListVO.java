/**
 * 
 */
package com.sunrise.boss.business.cms.audit.recfeeadjustrsn.persistent;

import java.sql.Timestamp;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
public class RecFeeAdjustRsnListVO extends BaseListVO {
	private String _se_rsnid;

	public String get_se_rsnid() {
		return _se_rsnid;
	}

	public void set_se_rsnid(String _se_rsnid) {
		this._se_rsnid = _se_rsnid;
	}

}
