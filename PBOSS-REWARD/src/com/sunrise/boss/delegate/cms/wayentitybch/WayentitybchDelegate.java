/**
* auto-generated code
* Sat Aug 26 11:34:28 CST 2006
*/
package com.sunrise.boss.delegate.cms.wayentitybch;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayentitybch.control.WayentitybchControl;
import com.sunrise.boss.business.cms.wayentitybch.control.WayentitybchControlBean;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchVO;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchListVO;

import java.io.Serializable;

/**
 * <p>Title: WayentitybchDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayentitybchDelegate {

    private static WayentitybchControl control;

    public WayentitybchDelegate() throws Exception {
        control = (WayentitybchControl) ControlFactory.build(WayentitybchControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WayentitybchVO doCreate(WayentitybchVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WayentitybchVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WayentitybchVO doUpdate(WayentitybchVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WayentitybchVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WayentitybchVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WayentitybchListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
