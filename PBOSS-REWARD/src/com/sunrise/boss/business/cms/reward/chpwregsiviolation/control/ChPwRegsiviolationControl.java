/**
* auto-generated code
* Fri Oct 18 14:59:15 CST 2013
*/
package com.sunrise.boss.business.cms.reward.chpwregsiviolation.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationVO;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPwRegsiviolationControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChPwRegsiviolationControl extends AbstractControl {
    public ChPwRegsiviolationVO doCreate(ChPwRegsiviolationVO vo, User user)
        throws Exception;

    public void doRemove(ChPwRegsiviolationVO vo, User user)
        throws Exception;

    public ChPwRegsiviolationVO doUpdate(ChPwRegsiviolationVO vo, User user)
        throws Exception;

    public ChPwRegsiviolationVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwRegsiviolationListVO params, User user)
        throws Exception;

}
