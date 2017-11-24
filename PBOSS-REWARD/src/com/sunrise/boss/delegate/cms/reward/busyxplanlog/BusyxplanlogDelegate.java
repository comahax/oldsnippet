/**
* auto-generated code
* Sat Feb 02 15:15:28 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.busyxplanlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busyxplanlog.control.BusyxplanlogControl;
import com.sunrise.boss.business.cms.reward.busyxplanlog.control.BusyxplanlogControlBean;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogVO;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BusyxplanlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanlogDelegate {

    private static BusyxplanlogControl control;

    public BusyxplanlogDelegate() throws Exception {
        control = (BusyxplanlogControl) ControlFactory.build(BusyxplanlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BusyxplanlogVO doCreate(BusyxplanlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BusyxplanlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BusyxplanlogVO doUpdate(BusyxplanlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BusyxplanlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BusyxplanlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BusyxplanlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
