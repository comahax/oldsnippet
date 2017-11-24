/**
 * auto-generated code
 * Wed Sep 02 16:37:07 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.unvfaildataquery.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryVO;
import com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent.UnvFaildataqueryListVO;

import java.io.Serializable;

/**
 * <p>Title: UnvFaildataqueryControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface UnvFaildataqueryControl extends AbstractControl {
	public UnvFaildataqueryVO doCreate(UnvFaildataqueryVO vo, User user)
			throws Exception;

	public void doRemove(UnvFaildataqueryVO vo, User user) throws Exception;

	public UnvFaildataqueryVO doUpdate(UnvFaildataqueryVO vo, User user)
			throws Exception;

	public UnvFaildataqueryVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(UnvFaildataqueryListVO params, User user)
			throws Exception;

	public DataPackage doQueryWayName(UnvFaildataqueryListVO params, User user)
			throws Exception;
}
