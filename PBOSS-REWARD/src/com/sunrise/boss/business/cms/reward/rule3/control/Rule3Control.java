/**
 * auto-generated code
 * Mon Feb 04 12:04:50 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rule3.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule3.persistent.Rule3VO;
import com.sunrise.boss.business.cms.reward.rule3.persistent.Rule3ListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: Rule3Control
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
public interface Rule3Control extends AbstractControl {

	public Rule3VO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(Rule3ListVO params, User user) throws Exception;

}
