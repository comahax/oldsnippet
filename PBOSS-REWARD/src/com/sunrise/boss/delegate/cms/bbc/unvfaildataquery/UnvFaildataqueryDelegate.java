/**
 * auto-generated code
 * Wed Sep 02 16:37:07 CST 2009
 */
package com.sunrise.boss.delegate.cms.bbc.unvfaildataquery;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryVO;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryListVO;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.control.UnvFaildataqueryControlBean;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.control.UnvFaildataqueryControl;

import java.io.Serializable;

/**
 * <p>Title: UnvFaildataqueryDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvFaildataqueryDelegate {

	private static UnvFaildataqueryControl control;

	public UnvFaildataqueryDelegate() throws Exception {
		control = (UnvFaildataqueryControl) ControlFactory
				.build(UnvFaildataqueryControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public UnvFaildataqueryVO doCreate(UnvFaildataqueryVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(UnvFaildataqueryVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public UnvFaildataqueryVO doUpdate(UnvFaildataqueryVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public UnvFaildataqueryVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (UnvFaildataqueryVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(UnvFaildataqueryListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage doQueryName(UnvFaildataqueryListVO params, User user)
			throws Exception {
		return control.doQueryWayName(params, user);
	}

}
