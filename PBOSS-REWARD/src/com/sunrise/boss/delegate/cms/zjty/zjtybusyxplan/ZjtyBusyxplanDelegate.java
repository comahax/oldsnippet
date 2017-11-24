/**
* auto-generated code
* Mon Dec 28 10:41:51 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.zjtybusyxplan;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanListVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.control.ZjtyBusyxplanControlBean;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.control.ZjtyBusyxplanControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyBusyxplanDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyBusyxplanDelegate {

    private static ZjtyBusyxplanControl control;

    public ZjtyBusyxplanDelegate() throws Exception {
        control = (ZjtyBusyxplanControl) ControlFactory.build(ZjtyBusyxplanControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyBusyxplanVO doCreate(ZjtyBusyxplanVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyBusyxplanVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyBusyxplanVO doUpdate(ZjtyBusyxplanVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyBusyxplanVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyBusyxplanVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyBusyxplanListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
