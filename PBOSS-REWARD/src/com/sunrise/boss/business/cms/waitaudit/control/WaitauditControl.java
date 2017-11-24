/**
* auto-generated code
* Fri Sep 12 10:00:32 CST 2008
*/
package com.sunrise.boss.business.cms.waitaudit.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditListVO;

import java.io.Serializable;

/**
 * <p>Title: WaitauditControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface WaitauditControl extends AbstractControl {
    public WaitauditVO doCreate(WaitauditVO vo, User user)
        throws Exception;

    public void doRemove(WaitauditVO vo, User user)
        throws Exception;

    public WaitauditVO doUpdate(WaitauditVO vo, User user)
        throws Exception;

    public WaitauditVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaitauditListVO params, User user)
        throws Exception;

}
