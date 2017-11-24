/**
* auto-generated code
* Thu Oct 09 16:10:24 CST 2008
*/
package com.sunrise.boss.business.cms.mpsaudit.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditVO;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditListVO;

import java.io.Serializable;

/**
 * <p>Title: MpsauditControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface MpsauditControl extends AbstractControl {
    public MpsauditVO doCreate(MpsauditVO vo, User user)
        throws Exception;

    public void doRemove(MpsauditVO vo, User user)
        throws Exception;

    public MpsauditVO doUpdate(MpsauditVO vo, User user)
        throws Exception;

    public MpsauditVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MpsauditListVO params, User user)
        throws Exception;

}
