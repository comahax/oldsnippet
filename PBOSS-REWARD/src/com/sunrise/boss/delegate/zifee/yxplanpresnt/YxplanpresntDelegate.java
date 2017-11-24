/**
 * auto-generated code
 * Tue Sep 18 15:52:13 CST 2007
 */
package com.sunrise.boss.delegate.zifee.yxplanpresnt;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplanpresnt.control.YxplanpresntControl;
import com.sunrise.boss.business.zifee.yxplanpresnt.control.YxplanpresntControlBean;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: YxplanpresntDelegate
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
public class YxplanpresntDelegate {

	private static YxplanpresntControl control;

	public YxplanpresntDelegate() throws Exception {
		control = (YxplanpresntControl) ControlFactory
				.build(YxplanpresntControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public YxplanpresntVO doCreate(YxplanpresntVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(YxplanpresntVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public YxplanpresntVO doUpdate(YxplanpresntVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public YxplanpresntVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (YxplanpresntVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(YxplanpresntListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

}
