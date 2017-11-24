/**
 * auto-generated code
 * Fri Feb 01 18:09:59 CST 2008
 */
package com.sunrise.boss.delegate.cms.stdrewardbp;

import java.io.Serializable;

import com.sunrise.boss.business.cms.stdrewardbp.control.StdrewardbpControl;
import com.sunrise.boss.business.cms.stdrewardbp.control.StdrewardbpControlBean;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpListVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpdVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbpDelegate
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
public class StdrewardbpDelegate {

	private static StdrewardbpControl control;

	public StdrewardbpDelegate() throws Exception {
		control = (StdrewardbpControl) ControlFactory
				.build(StdrewardbpControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public StdrewardbpdVO doCreate(StdrewardbpdVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(StdrewardbpdVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public StdrewardbpdVO doUpdate(StdrewardbpdVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public StdrewardbpdVO doUpdate1(StdrewardbpdVO vo, User user)
			throws Exception {
		return control.doUpdate1(vo, user);
	}

	public StdrewardbpdVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (StdrewardbpdVO) control.doFindByPk(pk, user);
	}

	public StdrewardbpVO doFindByPkstar(Serializable pk, User user)
			throws Exception {
		return (StdrewardbpVO) control.doFindByPkstar(pk, user);
	}

	public DataPackage doQuery(StdrewardbpListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

}
