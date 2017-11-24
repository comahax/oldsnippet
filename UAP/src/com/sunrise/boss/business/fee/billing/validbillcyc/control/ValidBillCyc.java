/**
 * 
 */
package com.sunrise.boss.business.fee.billing.validbillcyc.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDBParam;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

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
public interface ValidBillCyc extends AbstractControl {
	public ValidBillCycVO doCreate(ValidBillCycVO vo)
			throws Exception;

	public void doRemove(ValidBillCycVO vo)
	        throws Exception;

	public ValidBillCycVO doUpdate(ValidBillCycVO vo)
			throws Exception;

	public ValidBillCycVO doFindByPk(Serializable pk)
			throws Exception;

	public DataPackage doQuery(ValidBillCycDBParam params)
			throws Exception;

}
