/**
* auto-generated code
* Thu Oct 09 13:08:46 CST 2008
*/
package com.sunrise.boss.business.cms.iodaudit.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditVO;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditListVO;

import java.io.Serializable;

/**
 * <p>Title: IodauditControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface IodauditControl extends AbstractControl {
    public IodauditVO doCreate(IodauditVO vo, User user)
        throws Exception;

    public void doRemove(IodauditVO vo, User user)
        throws Exception;

    public IodauditVO doUpdate(IodauditVO vo, User user)
        throws Exception;

    public IodauditVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(IodauditListVO params, User user)
        throws Exception;

}
