/**
* auto-generated code
* Wed Oct 18 14:48:22 CST 2006
*/
package com.sunrise.boss.delegate.cms.waylog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waylog.control.WaylogControl;
import com.sunrise.boss.business.cms.waylog.control.WaylogControlBean;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogVO;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogListVO;

import java.io.Serializable;

/**
 * <p>Title: WaylogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaylogDelegate {

    private static WaylogControl control;

    public WaylogDelegate() throws Exception {
        control = (WaylogControl) ControlFactory.build(WaylogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WaylogVO doCreate(WaylogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WaylogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WaylogVO doUpdate(WaylogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WaylogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WaylogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WaylogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
