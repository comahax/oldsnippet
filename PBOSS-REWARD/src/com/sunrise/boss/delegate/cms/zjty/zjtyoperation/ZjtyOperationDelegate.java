/**
 * auto-generated code
 * Thu Oct 23 11:41:56 CST 2008
 */
package com.sunrise.boss.delegate.cms.zjty.zjtyoperation;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationListVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.control.ZjtyOperationControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.control.ZjtyOperationControl;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Title: ZjtyOperationDelegate
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
 * @author Linli
 * @version 1.0
 */
public class ZjtyOperationDelegate {

	private static ZjtyOperationControl control;

	public ZjtyOperationDelegate() throws Exception {
		control = (ZjtyOperationControl) ControlFactory
				.build(ZjtyOperationControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public ZjtyOperationVO doCreate(ZjtyOperationVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(ZjtyOperationVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public ZjtyOperationVO doUpdate(ZjtyOperationVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public ZjtyOperationVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (ZjtyOperationVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(ZjtyOperationListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
	
	public List doQueryupper(ZjtyOperationListVO params, User user)
		throws Exception {
		return control.doQueryupper(params, user);
	}

	public DataPackage doQueryForTree(ZjtyOperationListVO params, User user)
			throws Exception {
		return control.doQueryForTree(params, user);
	}
}
