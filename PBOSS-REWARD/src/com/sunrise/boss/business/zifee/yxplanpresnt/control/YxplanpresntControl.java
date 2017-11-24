/**
 * auto-generated code
 * Tue Sep 18 15:52:13 CST 2007
 */
package com.sunrise.boss.business.zifee.yxplanpresnt.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: YxplanpresntControl
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
public interface YxplanpresntControl extends AbstractControl {
	public YxplanpresntVO doCreate(YxplanpresntVO vo, User user)
			throws Exception;

	public void doRemove(YxplanpresntVO vo, User user) throws Exception;

	public YxplanpresntVO doUpdate(YxplanpresntVO vo, User user)
			throws Exception;

	public YxplanpresntVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(YxplanpresntListVO params, User user)
			throws Exception;
}
