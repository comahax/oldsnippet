/**
 * auto-generated code
 * Sun Feb 03 10:40:37 CST 2008
 */
package com.sunrise.boss.delegate.cms.reward.citydata;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.citydata.control.CitydataControl;
import com.sunrise.boss.business.cms.reward.citydata.control.CitydataControlBean;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataVO;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: CitydataDelegate
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
public class CitydataDelegate {

	private static CitydataControl control;

	public CitydataDelegate() throws Exception {
		control = (CitydataControl) ControlFactory
				.build(CitydataControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public CitydataVO doCreate(CitydataVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(CitydataVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public CitydataVO doUpdate(CitydataVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public CitydataVO doFindByPk(Serializable pk, User user) throws Exception {
		return (CitydataVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(CitydataListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public void clearAll(User user) throws Exception {
		control.clearAll(user);
	}
}
