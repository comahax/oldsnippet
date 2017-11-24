/**
 * auto-generated code
 * Thu Feb 14 10:50:04 CST 2008
 */
package com.sunrise.boss.delegate.cms.stdrewardbs;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardbs.control.StdrewardbsControl;
import com.sunrise.boss.business.cms.stdrewardbs.control.StdrewardbsControlBean;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsListVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsdVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p> 
 * Title: StdrewardbsDelegate
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
public class StdrewardbsDelegate {

	private static StdrewardbsControl control;

	public StdrewardbsDelegate() throws Exception {
		control = (StdrewardbsControl) ControlFactory
				.build(StdrewardbsControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public StdrewardVO doCreate(StdrewardVO vo, List list, User user)
			throws Exception {
		return control.doCreate(vo, list, user);
	}

	public void doRemove(StdrewardVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public StdrewardVO doUpdate(StdrewardVO vo, List list, User user)
			throws Exception {
		return control.doUpdate(vo, list, user);
	}

	public StdrewardbsdVO doUpdatestar(StdrewardbsdVO vo, User user)
			throws Exception {
		return control.doUpdatestar(vo, user);
	}

	public StdrewardbsdVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (StdrewardbsdVO) control.doFindByPk(pk, user);
	}

	public StdrewardbsdVO doFindByPkcity(Serializable pk, User user)
			throws Exception {
		return (StdrewardbsdVO) control.doFindByPkcity(pk, user);
	}

	public StdrewardbsVO doCheck(Serializable pk, User user) throws Exception {
		return (StdrewardbsVO) control.doCheck(pk, user);
	}

	public DataPackage doQuery(StdrewardbsListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
