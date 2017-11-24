/**
 * auto-generated code
 * Tue Oct 31 14:19:29 CST 2006
 */
package com.sunrise.boss.delegate.rightmanage.rightitem;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemVO;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemListVO;
import com.sunrise.boss.business.rightmanage.rightitem.control.RightitemControlBean;
import com.sunrise.boss.business.rightmanage.rightitem.control.RightitemControl;

import java.io.Serializable;

/**
 * <p>
 * Title: RightitemDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class RightitemDelegate {

	private static RightitemControl control;

	public RightitemDelegate() throws Exception {
		control = (RightitemControl) ControlFactory
				.build(RightitemControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public RightitemVO doCreate(RightitemVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(RightitemVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public RightitemVO doUpdate(RightitemVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public RightitemVO doFindByPk(Serializable pk, User user) throws Exception {
		return (RightitemVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(RightitemListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public void doBatchin(RightitemVO vo, User user) throws Exception {
		control.doBatchin(vo, user);
	}
}
