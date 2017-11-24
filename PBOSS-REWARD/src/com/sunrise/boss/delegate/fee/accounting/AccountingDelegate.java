/**
 * 
 */
package com.sunrise.boss.delegate.fee.accounting;

import java.util.List;
import java.util.Map;

import com.sunrise.boss.business.fee.acccounting.control.AccountingControl;
import com.sunrise.boss.business.fee.acccounting.control.AccountingControlBean;
import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: CompanyDelegate
 * Description:
 * Copyright: Copyright (c) 2006
 * Company: sunrise Tech Ltd.
 * @author Hanny Yeung
 * @version 1.0
 */
public class AccountingDelegate {
	private AccountingControl control;

	public AccountingDelegate() throws Exception {
		control = (AccountingControl) ControlFactory
				.build(AccountingControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public List doAccounting(AccountingVO params, User user) throws Exception {
		return control.doAccounting(params, user);
	}

	public AccountingVO doStartUp(AccountingVO params, User user) throws Exception {
		return control.doStartUp(params, user);
	}
	
	public AccountingVO doBatchStartUp(AccountingVO params, User user) throws Exception {
		return control.doBatchStartUp(params, user);
	}
	
	public List doShowLog(AccountingVO params, User user) throws Exception {
		return control.doShowLog(params, user);
	}

	public List doTJAccounting(AccountingVO params, User user) throws Exception {
		return control.doTJAccounting(params, user);
	}
	
	public Map doAccBill(AccountingVO params, User user) throws Exception {
		return control.doAccBill(params, user);
	}

	public List doAccBilling(AccountingVO params, User user) throws Exception {
		return control.doAccBilling(params, user);
	}

	public Map doAccBillDet(AccountingVO params, User user) throws Exception {
		return control.doAccBillDet(params, user);
	}
	
}
