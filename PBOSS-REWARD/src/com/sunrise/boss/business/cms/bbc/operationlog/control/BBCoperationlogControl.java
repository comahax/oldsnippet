/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.business.cms.bbc.operationlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.operationlog.persistent.BBCoperationlogListVO;
import com.sunrise.boss.business.cms.bbc.operationlog.persistent.BBCoperationlogVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: BBCoperationlogControl
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
public interface BBCoperationlogControl extends AbstractControl {
	
	public BBCoperationlogVO doCreate(BBCoperationlogVO vo, User user) throws Exception;

	public void doRemove(BBCoperationlogVO vo, User user) throws Exception;

	public BBCoperationlogVO doUpdate(BBCoperationlogVO vo, User user) throws Exception;

	public BBCoperationlogVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(BBCoperationlogListVO params, User user) throws Exception;
	
}
