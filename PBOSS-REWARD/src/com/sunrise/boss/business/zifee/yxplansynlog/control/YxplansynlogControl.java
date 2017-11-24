/**
 * auto-generated code
 * Thu Dec 11 16:31:58 CST 2008
 */
package com.sunrise.boss.business.zifee.yxplansynlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogVO;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: YxplansynlogControl
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
 * @author Jerimy
 * @version 1.0
 */
public interface YxplansynlogControl extends AbstractControl {
	public YxplansynlogVO doCreate(YxplansynlogVO vo, User user)
			throws Exception;

	public void doRemove(YxplansynlogVO vo, User user) throws Exception;

	public YxplansynlogVO doUpdate(YxplansynlogVO vo, User user)
			throws Exception;

	public YxplansynlogVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(YxplansynlogListVO params, User user)
			throws Exception;

	public YxplansynlogVO doCopysyn(String yxplanid, User user) throws Exception;
}
