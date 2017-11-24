/**
* auto-generated code
* Sat Jan 13 18:51:44 CST 2007
*/
package com.sunrise.boss.delegate.zifee.yxplancplog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplancplog.control.YxplancplogControl;
import com.sunrise.boss.business.zifee.yxplancplog.control.YxplancplogControlBean;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogVO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplancplogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public class YxplancplogDelegate {

    private static YxplancplogControl control;

    public YxplancplogDelegate() throws Exception {
        control = (YxplancplogControl) ControlFactory.build(YxplancplogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxplancplogVO doCreate(YxplancplogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxplancplogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxplancplogVO doUpdate(YxplancplogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxplancplogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (YxplancplogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxplancplogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
