/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.delegate.cms.bbc.operation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.business.cms.bbc.operation.control.BBCoperationControl;
import com.sunrise.boss.business.cms.bbc.operation.control.BBCoperationControlBean;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationListVO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
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
public class BBCoperationDelegate {

	private static BBCoperationControl control;

	public BBCoperationDelegate() throws Exception {
		control = (BBCoperationControl) ControlFactory
				.build(BBCoperationControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BBCoperationVO doCreate(BBCoperationVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BBCoperationVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public BBCoperationVO doUpdate(BBCoperationVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public BBCoperationVO doFindByPk(Serializable pk, User user) throws Exception {
		return (BBCoperationVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BBCoperationListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
