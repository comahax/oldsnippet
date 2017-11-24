/**
 * 
 */
package com.sunrise.boss.business.fee.billing.bltouchrule.control;

import java.io.Serializable;
import java.util.Map;

import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleListVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * Title: GDIBOSS
 * Description:
 * Copyright: Copyright (c) 2005
 * Company: sunrise Tech Ltd.
 * @author Hanny Yeung,mys
 * @version 1.0
 */
public interface BlTouchRuleControl extends AbstractControl {
	public BlTouchRuleVO doCreate(BlTouchRuleVO vo, User user)
			throws Exception;

	public void doRemove(BlTouchRuleVO vo, User user) throws Exception;

	public BlTouchRuleVO doUpdate(BlTouchRuleVO vo, User user)
			throws Exception;

	public BlTouchRuleVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(BlTouchRuleListVO params, User user)
			throws Exception;
	
	public Map doSupervise(BlTouchRuleListVO params, User user)
		throws Exception;

	public BlTouchRuleVO doStartUp(BlTouchRuleVO vo, User user) throws Exception;

	public void doGensms(Long validbillcyc, Long ruleid, User user) throws Exception;

	public void doSendsms(Long validbillcyc, Long ruleid, User user) throws Exception;

	public void doResetsms(Long validbillcyc, Long ruleid, User user) throws Exception;

}
