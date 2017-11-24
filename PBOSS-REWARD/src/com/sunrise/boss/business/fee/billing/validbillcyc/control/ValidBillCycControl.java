/**
 * 
 */
package com.sunrise.boss.business.fee.billing.validbillcyc.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycListVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
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
public interface ValidBillCycControl extends AbstractControl {
	public ValidBillCycVO doCreate(ValidBillCycVO vo, User user)
			throws Exception;

	public void doRemove(ValidBillCycVO vo, User user) throws Exception;

	public ValidBillCycVO doUpdate(ValidBillCycVO vo, User user)
			throws Exception;

	public ValidBillCycVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(ValidBillCycListVO params, User user)
			throws Exception;

}
