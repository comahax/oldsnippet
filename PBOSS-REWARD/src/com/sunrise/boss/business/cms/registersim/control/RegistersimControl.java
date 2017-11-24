/**
* auto-generated code
* Tue Jun 21 10:33:15 GMT 2011
*/
package com.sunrise.boss.business.cms.registersim.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimVO;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimListVO;

import java.io.Serializable;

/**
 * <p>Title: RegistersimControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface RegistersimControl extends AbstractControl {
    public RegistersimVO doCreate(RegistersimVO vo, User user)
        throws Exception;

    public void doRemove(RegistersimVO vo, User user)
        throws Exception;

    public RegistersimVO doUpdate(RegistersimVO vo, User user)
        throws Exception;

    public RegistersimVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RegistersimListVO params, User user)
        throws Exception;

}
