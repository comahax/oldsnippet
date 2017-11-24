/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.delegate.cms.reward.stdrewardbj;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.reward.stdrewardbj.control.StdrewardbjControl;
import com.sunrise.boss.business.cms.reward.stdrewardbj.control.StdrewardbjControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbjDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public class StdrewardbjDelegate {

	private static StdrewardbjControl control;

	public StdrewardbjDelegate() throws Exception {
		control = (StdrewardbjControl) ControlFactory
				.build(StdrewardbjControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public StdrewardbjVO doCreate(StdrewardbjVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(StdrewardbjVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public StdrewardbjVO doUpdate(StdrewardbjVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public StdrewardbjVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (StdrewardbjVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(StdrewardbjListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public void doSave(List list, User user) throws Exception {
		control.doSave(list, user);
	}

	public void doSavecity(List list, User user, List starList, List wayList) throws Exception {
		control.doSavecity(list, user, starList, wayList);
	}
}
