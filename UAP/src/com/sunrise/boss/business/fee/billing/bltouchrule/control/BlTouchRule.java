/**
 * 
 */
package com.sunrise.boss.business.fee.billing.bltouchrule.control;

import java.io.Serializable;
import java.util.Map;

import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleDBParam;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


/**
 * Title: GDIBOSS
 * Description:
 * Copyright: Copyright (c) 2005
 * Company: sunrise Tech Ltd.
 * @author Hanny Yeung,mys
 * @version 1.0
 */
public interface BlTouchRule extends AbstractControl {
	public BlTouchRuleVO doCreate(BlTouchRuleVO vo, User user)
			throws Exception;

	public void doRemove(BlTouchRuleVO vo, User user) throws Exception;

	public BlTouchRuleVO doUpdate(BlTouchRuleVO vo, User user)
			throws Exception;

	public BlTouchRuleVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(BlTouchRuleDBParam params, User user)
			throws Exception;
	
	public Map doSupervise(BlTouchRuleDBParam params, User user)
		throws Exception;

	public BlTouchRuleVO doStartUp(BlTouchRuleVO vo, User user) throws Exception;

	public void doGensms(String type, Long validbillcyc, Long ruleid, User user) throws Exception;

	public void doSendsms(String type, Long validbillcyc, Long ruleid, User user) throws Exception;

	public void doResetsms(Long validbillcyc, Long ruleid, User user) throws Exception;
	
	public void doResetfeelsms(Long validbillcyc, Long ruleid, User user) throws Exception;
	

}
