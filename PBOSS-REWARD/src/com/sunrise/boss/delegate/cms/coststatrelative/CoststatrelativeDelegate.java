/**
 * auto-generated code
 * Tue May 01 15:39:58 CST 2007
 */
package com.sunrise.boss.delegate.cms.coststatrelative;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.coststatrelative.control.CoststatrelativeControl;
import com.sunrise.boss.business.cms.coststatrelative.control.CoststatrelativeControlBean;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeVO;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Title: CoststatrelativeDelegate
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
 * @author Cai Jianhui
 * @version 1.0
 */
public class CoststatrelativeDelegate {

	private static CoststatrelativeControl control;

	public CoststatrelativeDelegate() throws Exception {
		control = (CoststatrelativeControl) ControlFactory
				.build(CoststatrelativeControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public CoststatrelativeVO doCreate(CoststatrelativeVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(CoststatrelativeVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public CoststatrelativeVO doUpdate(CoststatrelativeVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public CoststatrelativeVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (CoststatrelativeVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(CoststatrelativeListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public void doSave(List strtitem, List scaleitem, Long ID, User user) throws Exception {
		control.doSave(strtitem, scaleitem, ID, user);
	}
}
