/**
* auto-generated code
* Thu May 27 10:43:08 CST 2010
*/
package com.sunrise.boss.business.cms.emprole.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.emprole.persistent.EmproleVO;
import com.sunrise.boss.business.cms.emprole.persistent.EmproleListVO;

import java.io.Serializable;

/**
 * <p>Title: EmproleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public interface EmproleControl extends AbstractControl {
    public EmproleVO doCreate(EmproleVO vo, User user)
        throws Exception;

    public void doRemove(EmproleVO vo, User user)
        throws Exception;

    public EmproleVO doUpdate(EmproleVO vo, User user)
        throws Exception;

    public EmproleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(EmproleListVO params, User user)
        throws Exception;

}
