/**
 * auto-generated code
 * Fri Oct 20 20:01:29 CST 2006
 */
package com.sunrise.boss.business.rightmanage.operrole.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleListVO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleVO;

import java.io.Serializable;

/**
 * <p>
 * Title: Control
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
public interface OperroleControl extends AbstractControl {
	public OperroleVO doCreate(OperroleVO vo, User user) throws Exception;

	public void doRemove(OperroleVO vo, User user) throws Exception;

	public OperroleVO doUpdate(OperroleVO vo, User user) throws Exception;

	public OperroleVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(OperroleListVO params, User user)
			throws Exception;

	public void doBatchin(OperroleVO vo, User user) throws Exception;

}
