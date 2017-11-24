/**
 * auto-generated code
 * Mon Dec 08 10:37:24 CST 2008
 */
package com.sunrise.boss.delegate.cms.bbc.bbcrewardtotal;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.control.BbcRewardtotalControl;
import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.control.BbcRewardtotalControlBean;
import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: WayinteaccountDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public class BbcRewardtotalDelegate {

	private static BbcRewardtotalControl control;

	public BbcRewardtotalDelegate() throws Exception {
		control = (BbcRewardtotalControl) ControlFactory
				.build(BbcRewardtotalControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BbcRewardtotalVO doCreate(BbcRewardtotalVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BbcRewardtotalVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public BbcRewardtotalVO doUpdate(BbcRewardtotalVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public BbcRewardtotalVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (BbcRewardtotalVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BbcRewardtotalListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
