/**
 * auto-generated code
 * Mon Feb 04 12:03:22 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rule2.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2VO;
import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2ListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: Rule2Control
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public interface Rule2Control extends AbstractControl {

	public Rule2VO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(Rule2ListVO params, User user) throws Exception;
	
	public DataPackage getDistinctRule(Rule2ListVO listVO, User user) throws Exception;

	public DataPackage getDistinctBBCRule(Rule2ListVO listVO, User user) throws Exception;
	
	public DataPackage getDistinctZjtyRule(Rule2ListVO listVO, User user) throws Exception;
	
}
