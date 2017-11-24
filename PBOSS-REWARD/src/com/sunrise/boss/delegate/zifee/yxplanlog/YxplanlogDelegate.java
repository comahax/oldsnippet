/**
* auto-generated code
* Fri Oct 20 10:53:27 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplanlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplanlog.control.YxplanlogControl;
import com.sunrise.boss.business.zifee.yxplanlog.control.YxplanlogControlBean;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogVO;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplanlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class YxplanlogDelegate {

    private static YxplanlogControl control;

    public YxplanlogDelegate() throws Exception {
        control = (YxplanlogControl) ControlFactory.build(YxplanlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxplanlogVO doCreate(YxplanlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxplanlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxplanlogVO doUpdate(YxplanlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxplanlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (YxplanlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxplanlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
