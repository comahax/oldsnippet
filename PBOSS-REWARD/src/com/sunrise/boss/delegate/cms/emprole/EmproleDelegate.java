/**
* auto-generated code
* Thu May 27 10:43:08 CST 2010
*/
package com.sunrise.boss.delegate.cms.emprole;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.emprole.persistent.EmproleVO;
import com.sunrise.boss.business.cms.emprole.persistent.EmproleListVO;
import com.sunrise.boss.business.cms.emprole.control.EmproleControlBean;
import com.sunrise.boss.business.cms.emprole.control.EmproleControl;

import java.io.Serializable;

/**
 * <p>Title: EmproleDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class EmproleDelegate {

    private static EmproleControl control;

    public EmproleDelegate() throws Exception {
        control = (EmproleControl) ControlFactory.build(EmproleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public EmproleVO doCreate(EmproleVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(EmproleVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public EmproleVO doUpdate(EmproleVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public EmproleVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (EmproleVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(EmproleListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
