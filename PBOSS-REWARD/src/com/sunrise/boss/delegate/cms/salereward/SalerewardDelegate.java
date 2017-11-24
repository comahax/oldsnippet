/**
* auto-generated code
* Fri Jul 08 09:50:15 CST 2011
*/
package com.sunrise.boss.delegate.cms.salereward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardVO;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardListVO;
import com.sunrise.boss.business.cms.salereward.control.SalerewardControlBean;
import com.sunrise.boss.business.cms.salereward.control.SalerewardControl;

import java.io.Serializable;

/**
 * <p>Title: SalerewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class SalerewardDelegate {

    private static SalerewardControl control;

    public SalerewardDelegate() throws Exception {
        control = (SalerewardControl) ControlFactory.build(SalerewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public SalerewardVO doCreate(SalerewardVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(SalerewardVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public SalerewardVO doUpdate(SalerewardVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public SalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (SalerewardVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(SalerewardListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
