/**
* auto-generated code
* Sat Jan 12 10:23:04 CST 2013
*/
package com.sunrise.boss.delegate.cms.chadtwaymod;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodVO;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodListVO;
import com.sunrise.boss.business.cms.chadtwaymod.control.ChAdtWaymodControlBean;
import com.sunrise.boss.business.cms.chadtwaymod.control.ChAdtWaymodControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtWaymodDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtWaymodDelegate {

    private static ChAdtWaymodControl control;

    public ChAdtWaymodDelegate() throws Exception {
        control = (ChAdtWaymodControl) ControlFactory.build(ChAdtWaymodControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtWaymodVO doCreate(ChAdtWaymodVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtWaymodVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtWaymodVO doUpdate(ChAdtWaymodVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtWaymodVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtWaymodVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtWaymodListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
