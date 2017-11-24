/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.business.cms.bbc.operation.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationListVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: OperationControl
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
public interface BBCoperationControl extends AbstractControl {
	public BBCoperationVO doCreate(BBCoperationVO vo, User user) throws Exception;

	public void doRemove(BBCoperationVO vo, User user) throws Exception;

	public BBCoperationVO doUpdate(BBCoperationVO vo, User user) throws Exception;

	public BBCoperationVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(BBCoperationListVO params, User user)
			throws Exception;


}
