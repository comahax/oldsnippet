/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.business.cms.reward.stdrewardbj.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbjControl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public interface StdrewardbjControl extends AbstractControl {
	public StdrewardbjVO doCreate(StdrewardbjVO vo, User user) throws Exception;

	public void doRemove(StdrewardbjVO vo, User user) throws Exception;

	public StdrewardbjVO doUpdate(StdrewardbjVO vo, User user) throws Exception;

	public StdrewardbjVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(StdrewardbjListVO params, User user)
			throws Exception;

	public void doSave(List list, User user) throws Exception;

	public void doSavecity(List list, User user, List starList, List wayList) throws Exception;

}
