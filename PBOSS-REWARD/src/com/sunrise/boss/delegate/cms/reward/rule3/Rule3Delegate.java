/**
 * auto-generated code
 * Mon Feb 04 12:04:50 CST 2008
 */
package com.sunrise.boss.delegate.cms.reward.rule3;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule3.control.Rule3Control;
import com.sunrise.boss.business.cms.reward.rule3.control.Rule3ControlBean;
import com.sunrise.boss.business.cms.reward.rule3.persistent.Rule3VO;
import com.sunrise.boss.business.cms.reward.rule3.persistent.Rule3ListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: Rule3Delegate
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
public class Rule3Delegate {

	private static Rule3Control control;

	public Rule3Delegate() throws Exception {
		control = (Rule3Control) ControlFactory.build(Rule3ControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public Rule3VO doFindByPk(Serializable pk, User user) throws Exception {
		return (Rule3VO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(Rule3ListVO params, User user) throws Exception {
		return control.doQuery(params, user);
	}
}
