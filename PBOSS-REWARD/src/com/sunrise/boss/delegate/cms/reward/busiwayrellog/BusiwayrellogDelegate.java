/**
 * auto-generated code
 * Mon Jan 05 11:36:43 CST 2009
 */
package com.sunrise.boss.delegate.cms.reward.busiwayrellog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogVO;
import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogListVO;
import com.sunrise.boss.business.cms.reward.busiwayrellog.control.BusiwayrellogControlBean;
import com.sunrise.boss.business.cms.reward.busiwayrellog.control.BusiwayrellogControl;

import java.io.Serializable;

/**
 * <p>Title: BusiwayrellogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BusiwayrellogDelegate {

	private static BusiwayrellogControl control;

	public BusiwayrellogDelegate() throws Exception {
		control = (BusiwayrellogControl) ControlFactory
				.build(BusiwayrellogControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BusiwayrellogVO doCreate(BusiwayrellogVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BusiwayrellogVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public BusiwayrellogVO doUpdate(BusiwayrellogVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public BusiwayrellogVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (BusiwayrellogVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BusiwayrellogListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
