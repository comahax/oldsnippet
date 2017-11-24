/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rewardrulequery.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.rewardrulequery.persistent.RewardrulequeryListVO;
import com.sunrise.boss.business.cms.reward.rewardrulequery.persistent.RewardrulequeryVO;
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
 * @author linli
 * @version 1.0
 */
public interface RewardrulequeryControl extends AbstractControl {

	public DataPackage doQuery(RewardrulequeryListVO params, User user)
			throws Exception;

	public RewardrulequeryVO doCreate(RewardrulequeryVO vo, User user)
			throws Exception;

	public void doRemove(RewardrulequeryVO vo, User user) throws Exception;

	public RewardrulequeryVO doUpdate(RewardrulequeryVO vo, User user)
			throws Exception;

	public RewardrulequeryVO doFindByPk(Serializable pk, User user)
			throws Exception;

}
