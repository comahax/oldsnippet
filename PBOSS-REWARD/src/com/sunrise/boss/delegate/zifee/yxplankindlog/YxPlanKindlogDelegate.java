/**
* auto-generated code
* Thu Oct 26 21:50:00 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplankindlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplankindlog.persistent.YxPlanKindlogVO;
import com.sunrise.boss.business.zifee.yxplankindlog.persistent.YxPlanKindlogListVO;
import com.sunrise.boss.business.zifee.yxplankindlog.control.YxPlanKindlogControlBean;
import com.sunrise.boss.business.zifee.yxplankindlog.control.YxPlanKindlogControl;

import java.io.Serializable;

/**
 * <p>Title: YxPlanKindlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanKindlogDelegate {

    private static YxPlanKindlogControl control;

    public YxPlanKindlogDelegate() throws Exception {
        control = (YxPlanKindlogControl) ControlFactory.build(YxPlanKindlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanKindlogVO doCreate(YxPlanKindlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxPlanKindlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxPlanKindlogVO doUpdate(YxPlanKindlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanKindlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanKindlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxPlanKindlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
