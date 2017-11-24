/**
 * auto-generated code
 * Wed Dec 27 14:23:06 CST 2006
 */
package com.sunrise.boss.business.cms.distribute.cpcomsalerl.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cpcomsalerl.persistent.CpcomsalerlVO;
import com.sunrise.boss.business.cms.distribute.cpcomsalerl.persistent.CpcomsalerlListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: CpcoFmsalerlControl
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
 * @author
 * @version 1.0
 */
public interface CpcomsalerlControl extends AbstractControl {
	public CpcomsalerlVO doCreate(CpcomsalerlVO vo, User user) throws Exception;

	public void doRemove(CpcomsalerlVO vo, User user) throws Exception;

	public CpcomsalerlVO doUpdate(CpcomsalerlVO vo, User user) throws Exception;

	public CpcomsalerlVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(CpcomsalerlListVO params, User user)
			throws Exception;

}
