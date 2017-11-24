/**
 * auto-generated code
 * Mon Feb 04 12:03:22 CST 2008
 */
package com.sunrise.boss.delegate.cms.reward.rule2;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule2.control.Rule2Control;
import com.sunrise.boss.business.cms.reward.rule2.control.Rule2ControlBean;
import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2VO;
import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2ListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: Rule2Delegate
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
public class Rule2Delegate {

	private static Rule2Control control;

	public Rule2Delegate() throws Exception {
		control = (Rule2Control) ControlFactory.build(Rule2ControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public Rule2VO doFindByPk(Serializable pk, User user) throws Exception {
		return (Rule2VO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(Rule2ListVO params, User user) throws Exception {
		return control.doQuery(params, user);
	}
	
	public DataPackage getDistinctRule(Rule2ListVO listVO, User user)
			throws Exception {
		return control.getDistinctRule(listVO, user);
	}
	
	public DataPackage getDistinctBBCRule(Rule2ListVO listVO, User user)
			throws Exception {
		return control.getDistinctBBCRule(listVO, user);
	}
	
	public DataPackage getDistinctZjtyRule(Rule2ListVO listVO, User user)
			throws Exception {
		return control.getDistinctZjtyRule(listVO, user);
	}
}
