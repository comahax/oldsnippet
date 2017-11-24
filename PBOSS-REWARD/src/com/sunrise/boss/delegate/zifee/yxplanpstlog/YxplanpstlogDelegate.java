/**
* auto-generated code
* Tue Sep 18 16:17:01 CST 2007
*/
package com.sunrise.boss.delegate.zifee.yxplanpstlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplanpstlog.control.YxplanpstlogControl;
import com.sunrise.boss.business.zifee.yxplanpstlog.control.YxplanpstlogControlBean;
import com.sunrise.boss.business.zifee.yxplanpstlog.persistent.YxplanpstlogVO;
import com.sunrise.boss.business.zifee.yxplanpstlog.persistent.YxplanpstlogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplanpstlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class YxplanpstlogDelegate {

    private static YxplanpstlogControl control;

    public YxplanpstlogDelegate() throws Exception {
        control = (YxplanpstlogControl) ControlFactory.build(YxplanpstlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxplanpstlogVO doCreate(YxplanpstlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxplanpstlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxplanpstlogVO doUpdate(YxplanpstlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxplanpstlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (YxplanpstlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxplanpstlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
