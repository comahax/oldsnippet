/**
* auto-generated code
* Tue Jan 12 09:53:03 CST 2010
*/
package com.sunrise.boss.delegate.cms.zjty.zjtybusyxplanlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogListVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.control.ZjtyBusyxplanlogControlBean;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.control.ZjtyBusyxplanlogControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyBusyxplanlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyBusyxplanlogDelegate {

    private static ZjtyBusyxplanlogControl control;

    public ZjtyBusyxplanlogDelegate() throws Exception {
        control = (ZjtyBusyxplanlogControl) ControlFactory.build(ZjtyBusyxplanlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyBusyxplanlogVO doCreate(ZjtyBusyxplanlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyBusyxplanlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyBusyxplanlogVO doUpdate(ZjtyBusyxplanlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyBusyxplanlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyBusyxplanlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyBusyxplanlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
