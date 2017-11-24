/**
* auto-generated code
* Mon Feb 21 10:20:06 CST 2011
*/
package com.sunrise.boss.business.cms.reward.registersimvw.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwVO;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwListVO;

import java.io.Serializable;

/**
 * <p>Title: RegistersimvwControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface RegistersimvwControl extends AbstractControl {
    public RegistersimvwVO doCreate(RegistersimvwVO vo, User user)
        throws Exception;

    public void doRemove(RegistersimvwVO vo, User user)
        throws Exception;

    public RegistersimvwVO doUpdate(RegistersimvwVO vo, User user)
        throws Exception;

    public RegistersimvwVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RegistersimvwListVO params, User user)
        throws Exception;

}
