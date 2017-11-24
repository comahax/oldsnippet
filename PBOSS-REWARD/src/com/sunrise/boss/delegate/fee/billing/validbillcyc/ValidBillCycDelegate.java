/**
 * 
 */
package com.sunrise.boss.delegate.fee.billing.validbillcyc;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.validbillcyc.control.ValidBillCycControl;
import com.sunrise.boss.business.fee.billing.validbillcyc.control.ValidBillCycControlBean;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycListVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

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
public class ValidBillCycDelegate {
	private ValidBillCycControl control;

	public ValidBillCycDelegate() throws Exception {
		control = (ValidBillCycControl) ControlFactory
				.build(ValidBillCycControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public ValidBillCycVO doCreate(ValidBillCycVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(ValidBillCycVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public ValidBillCycVO doUpdate(ValidBillCycVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public ValidBillCycVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (ValidBillCycVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(ValidBillCycListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
