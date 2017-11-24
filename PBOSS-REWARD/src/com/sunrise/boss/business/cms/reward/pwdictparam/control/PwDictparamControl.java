/**
* auto-generated code
* Tue Apr 10 11:19:35 CST 2012
*/
package com.sunrise.boss.business.cms.reward.pwdictparam.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamVO;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamListVO;

import java.io.Serializable;

/**
 * <p>Title: PwDictparamControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface PwDictparamControl extends AbstractControl {
    public PwDictparamVO doCreate(PwDictparamVO vo, User user)
        throws Exception;

    public void doRemove(PwDictparamVO vo, User user)
        throws Exception;

    public PwDictparamVO doUpdate(PwDictparamVO vo, User user)
        throws Exception;

    public PwDictparamVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PwDictparamListVO params, User user)
        throws Exception;

}
