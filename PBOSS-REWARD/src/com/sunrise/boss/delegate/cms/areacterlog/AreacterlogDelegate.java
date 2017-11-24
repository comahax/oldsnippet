/**
* auto-generated code
* Tue Oct 17 17:36:53 CST 2006
*/
package com.sunrise.boss.delegate.cms.areacterlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.areacterlog.control.AreacterlogControl;
import com.sunrise.boss.business.cms.areacterlog.control.AreacterlogControlBean;
import com.sunrise.boss.business.cms.areacterlog.persistent.AreacterlogVO;
import com.sunrise.boss.business.cms.areacterlog.persistent.AreacterlogListVO;

import java.io.Serializable;

/**
 * <p>Title: AreacterlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class AreacterlogDelegate {

    private static AreacterlogControl control;

    public AreacterlogDelegate() throws Exception {
        control = (AreacterlogControl) ControlFactory.build(AreacterlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public AreacterlogVO doCreate(AreacterlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(AreacterlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public AreacterlogVO doUpdate(AreacterlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public AreacterlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (AreacterlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(AreacterlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
