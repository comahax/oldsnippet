/**
 * auto-generated code
 * Wed Sep 02 15:01:47 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.unvrewardrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordVO;
import com.sunrise.boss.business.cms.bbc.unvrewardrecord.persistent.UnvRewardrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: UnvRewardrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface UnvRewardrecordControl extends AbstractControl {
	public UnvRewardrecordVO doCreate(UnvRewardrecordVO vo, User user)
			throws Exception;

	public void doRemove(UnvRewardrecordVO vo, User user) throws Exception;

	public UnvRewardrecordVO doUpdate(UnvRewardrecordVO vo, User user)
			throws Exception;

	public UnvRewardrecordVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(UnvRewardrecordListVO params, User user)
			throws Exception;

	public DataPackage doQueryWayName(UnvRewardrecordListVO params, User user)
			throws Exception;

}
