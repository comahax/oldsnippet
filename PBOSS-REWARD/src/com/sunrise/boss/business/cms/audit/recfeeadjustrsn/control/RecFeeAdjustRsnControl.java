/**
 * 
 */
package com.sunrise.boss.business.cms.audit.recfeeadjustrsn.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.audit.recfeeadjustrsn.persistent.RecFeeAdjustRsnListVO;
import com.sunrise.boss.business.cms.audit.recfeeadjustrsn.persistent.RecFeeAdjustRsnVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

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
public interface RecFeeAdjustRsnControl extends AbstractControl {
	public RecFeeAdjustRsnVO doCreate(RecFeeAdjustRsnVO vo, User user)
			throws Exception;

	public void doRemove(RecFeeAdjustRsnVO vo, User user) throws Exception;

	public RecFeeAdjustRsnVO doUpdate(RecFeeAdjustRsnVO vo, User user)
			throws Exception;

	public RecFeeAdjustRsnVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(RecFeeAdjustRsnListVO params, User user)
			throws Exception;

}
