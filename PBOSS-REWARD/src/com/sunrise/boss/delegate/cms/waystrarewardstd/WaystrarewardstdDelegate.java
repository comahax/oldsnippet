/**
* auto-generated code
* Fri Jul 08 11:36:28 CST 2011
*/
package com.sunrise.boss.delegate.cms.waystrarewardstd;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdListVO;
import com.sunrise.boss.business.cms.waystrarewardstd.control.WaystrarewardstdControlBean;
import com.sunrise.boss.business.cms.waystrarewardstd.control.WaystrarewardstdControl;

import java.io.Serializable;

/**
 * <p>Title: WaystrarewardstdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class WaystrarewardstdDelegate {

    private static WaystrarewardstdControl control;

    public WaystrarewardstdDelegate() throws Exception {
        control = (WaystrarewardstdControl) ControlFactory.build(WaystrarewardstdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public WaystrarewardstdVO doCreate(WaystrarewardstdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(WaystrarewardstdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public WaystrarewardstdVO doUpdate(WaystrarewardstdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public WaystrarewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WaystrarewardstdVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(WaystrarewardstdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
