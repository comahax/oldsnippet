/**
* auto-generated code
* Fri Dec 09 10:02:24 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.registersucc.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.registersucc.persistent.RegistersuccVO;
import com.sunrise.boss.business.cms.bbc.registersucc.persistent.RegistersuccListVO;

import java.io.Serializable;

/**
 * <p>Title: RegistersuccControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface RegistersuccControl extends AbstractControl {
    public RegistersuccVO doCreate(RegistersuccVO vo, User user)
        throws Exception;

    public void doRemove(RegistersuccVO vo, User user)
        throws Exception;

    public RegistersuccVO doUpdate(RegistersuccVO vo, User user)
        throws Exception;

    public RegistersuccVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RegistersuccListVO params, User user)
        throws Exception;

}
