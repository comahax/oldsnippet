/**
* auto-generated code
* Mon Apr 01 16:53:28 CST 2013
*/
package com.sunrise.boss.business.cms.chadtrewardsyninfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoVO;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtRewardsyninfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChAdtRewardsyninfoControl extends AbstractControl {
    public ChAdtRewardsyninfoVO doCreate(ChAdtRewardsyninfoVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtRewardsyninfoVO vo, User user)
        throws Exception;

    public ChAdtRewardsyninfoVO doUpdate(ChAdtRewardsyninfoVO vo, User user)
        throws Exception;

    public ChAdtRewardsyninfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtRewardsyninfoListVO params, User user)
        throws Exception;

}
