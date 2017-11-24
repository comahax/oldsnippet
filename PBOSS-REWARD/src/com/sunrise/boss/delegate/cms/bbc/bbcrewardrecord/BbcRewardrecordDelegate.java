/**
 * auto-generated code
 * Mon Dec 08 10:37:24 CST 2008
 */
package com.sunrise.boss.delegate.cms.bbc.bbcrewardrecord;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.control.BbcRewardrecordControl;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.control.BbcRewardrecordControlBean;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordVO;
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
public class BbcRewardrecordDelegate {

	private static BbcRewardrecordControl control;

	public BbcRewardrecordDelegate() throws Exception {
		control = (BbcRewardrecordControl) ControlFactory
				.build(BbcRewardrecordControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BbcRewardrecordVO doCreate(BbcRewardrecordVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BbcRewardrecordVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public BbcRewardrecordVO doUpdate(BbcRewardrecordVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public BbcRewardrecordVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (BbcRewardrecordVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BbcRewardrecordListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
