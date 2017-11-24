/**
 * auto-generated code
 * Sun Jan 04 10:44:26 CST 2009
 */
package com.sunrise.boss.delegate.cms.reward.busiwayrel;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelVO;
import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelListVO;
import com.sunrise.boss.business.cms.reward.busiwayrel.control.BusiwayrelControlBean;
import com.sunrise.boss.business.cms.reward.busiwayrel.control.BusiwayrelControl;

import java.io.Serializable;

/**
 * <p>
 * Title: BusiwayrelDelegate
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
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BusiwayrelDelegate {

	private static BusiwayrelControl control;

	public BusiwayrelDelegate() throws Exception {
		control = (BusiwayrelControl) ControlFactory.build(BusiwayrelControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BusiwayrelVO doCreate(BusiwayrelVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BusiwayrelVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public BusiwayrelVO doUpdate(BusiwayrelVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public BusiwayrelVO doFindByPk(Serializable pk, User user) throws Exception {
		return (BusiwayrelVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BusiwayrelListVO params, User user) throws Exception {
		return control.doQuery(params, user);
	}

	public String doBatchRemove(BusiwayrelVO vo, User user) throws Exception {
		return control.doBatchRemove(vo, user);
	}

	public String doBatchCreate(BusiwayrelVO vo, User user) throws Exception {
		return control.doBatchCreate(vo, user);
	}

	public boolean checkIsLayer(String opnid, User user) throws Exception {
		return control.checkIsLayer(opnid, user);
	}
}
