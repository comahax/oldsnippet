/**
* auto-generated code
* Thu Mar 03 10:54:08 CST 2011
*/
package com.sunrise.boss.delegate.cms.waitreq;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqVO;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqListVO;
import com.sunrise.boss.business.cms.waitreq.control.WaitreqControlBean;
import com.sunrise.boss.business.cms.waitreq.control.WaitreqControl;

import java.io.Serializable;

/**
 * <p>Title: WaitreqDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class WaitreqDelegate {

    private static WaitreqControl control;

    public WaitreqDelegate() throws Exception {
        control = (WaitreqControl) ControlFactory.build(WaitreqControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public WaitreqVO doCreate(WaitreqVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(WaitreqVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public WaitreqVO doUpdate(WaitreqVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public WaitreqVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WaitreqVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(WaitreqListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
