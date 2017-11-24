/**
* auto-generated code
* Thu Oct 26 17:56:48 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplangrouplog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplangrouplog.persistent.YxPlanGrouplogVO;
import com.sunrise.boss.business.zifee.yxplangrouplog.persistent.YxPlanGrouplogListVO;
import com.sunrise.boss.business.zifee.yxplangrouplog.control.YxPlanGrouplogControlBean;
import com.sunrise.boss.business.zifee.yxplangrouplog.control.YxPlanGrouplogControl;

import java.io.Serializable;

/**
 * <p>Title: YxPlanGrouplogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanGrouplogDelegate {

    private static YxPlanGrouplogControl control;

    public YxPlanGrouplogDelegate() throws Exception {
        control = (YxPlanGrouplogControl) ControlFactory.build(YxPlanGrouplogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanGrouplogVO doCreate(YxPlanGrouplogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxPlanGrouplogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxPlanGrouplogVO doUpdate(YxPlanGrouplogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanGrouplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanGrouplogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxPlanGrouplogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
