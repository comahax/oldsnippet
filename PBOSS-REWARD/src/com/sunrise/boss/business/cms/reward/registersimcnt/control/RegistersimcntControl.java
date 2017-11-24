/**
* auto-generated code
* Mon Feb 21 10:37:21 CST 2011
*/
package com.sunrise.boss.business.cms.reward.registersimcnt.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntVO;
import com.sunrise.boss.business.cms.reward.registersimcnt.persistent.RegistersimcntListVO;

import java.io.Serializable;

/**
 * <p>Title: RegistersimcntControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface RegistersimcntControl extends AbstractControl {
    public RegistersimcntVO doCreate(RegistersimcntVO vo, User user)
        throws Exception;

    public void doRemove(RegistersimcntVO vo, User user)
        throws Exception;

    public RegistersimcntVO doUpdate(RegistersimcntVO vo, User user)
        throws Exception;

    public RegistersimcntVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RegistersimcntListVO params, User user)
        throws Exception;

}
