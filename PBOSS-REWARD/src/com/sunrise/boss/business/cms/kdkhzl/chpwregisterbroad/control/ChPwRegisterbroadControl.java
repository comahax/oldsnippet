/**
* auto-generated code
* Tue Aug 21 10:43:23 CST 2012
*/
package com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwregisterbroad.persistent.ChPwRegisterbroadListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPwRegisterbroadControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public interface ChPwRegisterbroadControl extends AbstractControl {
    public ChPwRegisterbroadVO doCreate(ChPwRegisterbroadVO vo, User user)
        throws Exception;

    public void doRemove(ChPwRegisterbroadVO vo, User user)
        throws Exception;

    public ChPwRegisterbroadVO doUpdate(ChPwRegisterbroadVO vo, User user)
        throws Exception;

    public ChPwRegisterbroadVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwRegisterbroadListVO params, User user)
        throws Exception;

}
