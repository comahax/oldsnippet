/**
 * auto-generated code
 * Wed Sep 02 15:01:47 CST 2009
 */
package com.sunrise.boss.delegate.cms.bbc.unvrewardrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordVO;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordListVO;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.control.UnvRewardrecordControlBean;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.control.UnvRewardrecordControl;

import java.io.Serializable;

/**
 * <p>Title: UnvRewardrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvRewardrecordDelegate {

	private static UnvRewardrecordControl control;

	public UnvRewardrecordDelegate() throws Exception {
		control = (UnvRewardrecordControl) ControlFactory
				.build(UnvRewardrecordControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public UnvRewardrecordVO doCreate(UnvRewardrecordVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(UnvRewardrecordVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public UnvRewardrecordVO doUpdate(UnvRewardrecordVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public UnvRewardrecordVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (UnvRewardrecordVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(UnvRewardrecordListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage doQueryName(UnvRewardrecordListVO params, User user)
			throws Exception {
		return control.doQueryWayName(params, user);
	}

}
