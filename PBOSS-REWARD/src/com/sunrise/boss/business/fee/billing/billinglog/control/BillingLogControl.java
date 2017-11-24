/**
 * 
 */
package com.sunrise.boss.business.fee.billing.billinglog.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogListVO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogVO;
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
public interface BillingLogControl extends AbstractControl {
	public BillingLogVO doCreate(BillingLogVO vo, User user)
			throws Exception;

	public void doRemove(BillingLogVO vo, User user) throws Exception;

	public BillingLogVO doUpdate(BillingLogVO vo, User user)
			throws Exception;

	public BillingLogVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(BillingLogListVO params, User user)
			throws Exception;

}
