/**
 * auto-generated code
 * Tue Dec 26 19:35:31 CST 2006
 */
package com.sunrise.boss.business.cms.distribute.cooperator.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: CooperatorControl
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
public interface CooperatorControl extends AbstractControl {
	public CooperatorVO doCreate(CooperatorVO vo, User user) throws Exception;

	public CooperatorVO doCreate1(CooperatorVO vo, User user) throws Exception;

	public void doRemove(CooperatorVO vo, User user) throws Exception;

	public CooperatorVO doUpdate(CooperatorVO vo, User user) throws Exception;

	public CooperatorVO doUpdate1(CooperatorVO vo, User user) throws Exception;

	public CooperatorVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(CooperatorListVO params, User user)
			throws Exception;

	// �������Ȩ�ޱ�Ĺ���
	public boolean doFindRelInCpright(Serializable coopID, User user)
			throws Exception;

	// ������̿�����Ϣ��Ĺ���
	public boolean doFindRelInCpexam(Serializable coopID, User user)
			throws Exception;

	// ���������Ʒ���۹����Ĺ���
	public boolean doFindRelInCpcomsalerl(Serializable coopID, User user)
			throws Exception;

	// �������Ӫ��������Ĺ���
	public boolean doFindRelInCpbusfeeway(Serializable coopID, User user)
			throws Exception;
}
