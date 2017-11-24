/**
 * auto-generated code
 * Tue Dec 26 19:35:31 CST 2006
 */
package com.sunrise.boss.delegate.cms.distribute.cooperator;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorListVO;
import com.sunrise.boss.business.cms.distribute.cooperator.control.CooperatorControlBean;
import com.sunrise.boss.business.cms.distribute.cooperator.control.CooperatorControl;

import java.io.Serializable;

/**
 * <p>
 * Title: CooperatorDelegate
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
 * @author
 * @version 1.0
 */
public class CooperatorDelegate {

	private static CooperatorControl control;

	public CooperatorDelegate() throws Exception {
		control = (CooperatorControl) ControlFactory
				.build(CooperatorControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public CooperatorVO doCreate(CooperatorVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public CooperatorVO doCreate1(CooperatorVO vo, User user) throws Exception {
		return control.doCreate1(vo, user);
	}

	public void doRemove(CooperatorVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public CooperatorVO doUpdate(CooperatorVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public CooperatorVO doUpdate1(CooperatorVO vo, User user) throws Exception {
		return control.doUpdate1(vo, user);
	}

	public CooperatorVO doFindByPk(Serializable pk, User user) throws Exception {
		return (CooperatorVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(CooperatorListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	// 与合作商权限表的关联
	public boolean doFindRelInCpright(Serializable coopID, User user)
			throws Exception {
		return control.doFindRelInCpright(coopID, user);
	}

	// 与合作商考核信息表的关联
	public boolean doFindRelInCpexam(Serializable coopID, User user)
			throws Exception {
		return control.doFindRelInCpexam(coopID, user);
	}

	// 与合作商商品销售规则表的关联
	public boolean doFindRelInCpcomsalerl(Serializable coopID, User user)
			throws Exception {
		return control.doFindRelInCpcomsalerl(coopID, user);
	}

	// 与合作商营收渠道表的关联
	public boolean doFindRelInCpbusfeeway(Serializable coopID, User user)
			throws Exception {
		return control.doFindRelInCpbusfeeway(coopID, user);
	}
}
