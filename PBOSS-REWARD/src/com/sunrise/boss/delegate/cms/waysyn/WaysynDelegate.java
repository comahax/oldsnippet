/**
* auto-generated code
* Fri May 16 09:53:52 CST 2008
*/
package com.sunrise.boss.delegate.cms.waysyn;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waysyn.control.WaysynControl;
import com.sunrise.boss.business.cms.waysyn.control.WaysynControlBean;
import com.sunrise.boss.business.cms.waysyn.persistent.WaysynVO;

import java.io.Serializable;

/**
 * <p>Title: WaysynDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WaysynDelegate {

    private static WaysynControl control;

    public WaysynDelegate() throws Exception {
        control = (WaysynControl) ControlFactory.build(WaysynControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WaysynVO doCreate(WaysynVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WaysynVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WaysynVO doUpdate(WaysynVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WaysynVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WaysynVO) control.doFindByPk(pk, user);
    }
}
