/**
* auto-generated code
* Tue Dec 20 12:00:28 CST 2011
*/
package com.sunrise.boss.delegate.cms.chadtbusitoapprove;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveVO;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveListVO;
import com.sunrise.boss.business.cms.chadtbusitoapprove.control.ChAdtBusitoapproveControlBean;
import com.sunrise.boss.business.cms.chadtbusitoapprove.control.ChAdtBusitoapproveControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtBusitoapproveDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtBusitoapproveDelegate {

    private static ChAdtBusitoapproveControl control;

    public ChAdtBusitoapproveDelegate() throws Exception {
        control = (ChAdtBusitoapproveControl) ControlFactory.build(ChAdtBusitoapproveControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtBusitoapproveVO doCreate(ChAdtBusitoapproveVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtBusitoapproveVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtBusitoapproveVO doUpdate(ChAdtBusitoapproveVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtBusitoapproveVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtBusitoapproveVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtBusitoapproveListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
