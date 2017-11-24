/**
 * auto-generated code
 * Sun Feb 03 10:40:37 CST 2008
 */
package com.sunrise.boss.business.cms.reward.citydata.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataVO;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: CitydataControl
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
 * @author Cai Jianhui
 * @version 1.0
 */
public interface CitydataControl extends AbstractControl {
	public CitydataVO doCreate(CitydataVO vo, User user) throws Exception;

	public void doRemove(CitydataVO vo, User user) throws Exception;

	public CitydataVO doUpdate(CitydataVO vo, User user) throws Exception;

	public CitydataVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(CitydataListVO params, User user)
			throws Exception;

	public void clearAll(User user) throws Exception;

}
