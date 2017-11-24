/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.delegate.cms.bbc.operationlog;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.operationlog.control.BBCoperationlogControl;
import com.sunrise.boss.business.cms.bbc.operationlog.control.BBCoperationlogControlBean;
import com.sunrise.boss.business.cms.bbc.operationlog.persistent.BBCoperationlogListVO;
import com.sunrise.boss.business.cms.bbc.operationlog.persistent.BBCoperationlogVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: BBCoperationDelegate
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
public class BBCoperationlogDelegate {

	private static BBCoperationlogControl control;

	public BBCoperationlogDelegate() throws Exception {
		control = (BBCoperationlogControl) ControlFactory
				.build(BBCoperationlogControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BBCoperationlogVO doCreate(BBCoperationlogVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BBCoperationlogVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public BBCoperationlogVO doUpdate(BBCoperationlogVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public BBCoperationlogVO doFindByPk(Serializable pk, User user) throws Exception {
		return (BBCoperationlogVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BBCoperationlogListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
