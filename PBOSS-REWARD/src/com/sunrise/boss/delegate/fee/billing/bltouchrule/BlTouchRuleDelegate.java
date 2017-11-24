/**
 * 
 */
package com.sunrise.boss.delegate.fee.billing.bltouchrule;

import java.io.Serializable;
import java.util.Map;

import com.sunrise.boss.business.fee.billing.bltouchrule.control.BlTouchRuleControl;
import com.sunrise.boss.business.fee.billing.bltouchrule.control.BlTouchRuleControlBean;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleListVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.business.fee.billing.feenotifystate.persistent.FeeNotifyStateVO;
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
public class BlTouchRuleDelegate {
	private BlTouchRuleControl control;

	public BlTouchRuleDelegate() throws Exception {
		control = (BlTouchRuleControl) ControlFactory
				.build(BlTouchRuleControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BlTouchRuleVO doCreate(BlTouchRuleVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BlTouchRuleVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public BlTouchRuleVO doUpdate(BlTouchRuleVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public BlTouchRuleVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (BlTouchRuleVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BlTouchRuleListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
	
	public Map doSupervise(BlTouchRuleListVO params, User user)
		throws Exception{
		return control.doSupervise(params, user);
	}
	
	public BlTouchRuleVO doStartUp(BlTouchRuleVO vo, User user) throws Exception {
		return control.doStartUp(vo, user);
}

	public void doGensms(Long validbillcyc, Long ruleid, User user) throws Exception {
		control.doGensms(validbillcyc, ruleid, user);
	}

	public void doSendsms(Long validbillcyc, Long ruleid, User user) throws Exception {
		control.doSendsms(validbillcyc, ruleid, user);
	}

	public FeeNotifyStateVO doResetsms(Long validbillcyc, Long ruleid, User user) throws Exception  {
		control.doResetsms(validbillcyc, ruleid, user);
		return null;
	}
	
}
