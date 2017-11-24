/**
* auto-generated code
* Fri Jan 11 10:41:27 CST 2013
*/
package com.sunrise.boss.delegate.cms.chadtwaymodlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtwaymodlog.persistent.ChAdtWaymodlogVO;
import com.sunrise.boss.business.cms.chadtwaymodlog.persistent.ChAdtWaymodlogListVO;
import com.sunrise.boss.business.cms.chadtwaymodlog.control.ChAdtWaymodlogControlBean;
import com.sunrise.boss.business.cms.chadtwaymodlog.control.ChAdtWaymodlogControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtWaymodlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtWaymodlogDelegate {

    private static ChAdtWaymodlogControl control;

    public ChAdtWaymodlogDelegate() throws Exception {
        control = (ChAdtWaymodlogControl) ControlFactory.build(ChAdtWaymodlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtWaymodlogVO doCreate(ChAdtWaymodlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtWaymodlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtWaymodlogVO doUpdate(ChAdtWaymodlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtWaymodlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtWaymodlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtWaymodlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
