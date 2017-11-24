/**
 * auto-generated code
 * Sat Aug 12 14:48:47 CST 2006
 */
package com.sunrise.boss.business.resmanage.com.control;

import java.io.Serializable;

import com.sunrise.boss.business.resmanage.com.persistent.ComListVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: ComControl
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
 * @author Rodney
 * @version 1.0
 */
public interface ComControl extends AbstractControl {
	public ComVO doCreate(ComVO vo, User user) throws Exception;

	public void doRemove(ComVO vo, User user) throws Exception;

	public ComVO doUpdate(ComVO vo,User user) throws Exception;

	public ComVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(ComListVO params, User user)
			throws Exception;

	public int count(ComListVO params, User user) throws Exception;

}
