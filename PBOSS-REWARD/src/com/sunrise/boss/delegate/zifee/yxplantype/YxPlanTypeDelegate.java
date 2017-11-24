/**
* auto-generated code
* Fri Aug 25 10:29:42 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplantype;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeVO;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplantype.control.YxPlanTypeControl;
import com.sunrise.boss.business.zifee.yxplantype.control.YxPlanTypeControlBean;
import java.io.Serializable;

/**
 * <p>Title: YxPlanTypeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanTypeDelegate {

    private static YxPlanTypeControl control;

    public YxPlanTypeDelegate() throws Exception {
        control = (YxPlanTypeControl) ControlFactory.build(YxPlanTypeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanTypeVO doCreate(YxPlanTypeVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public YxPlanTypeVO doUpdate(YxPlanTypeVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanTypeVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanTypeVO) control.doFindByPk(pk, user);
    }
    public void doRemoveByPK(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPK(pk, user);
        }
    }

    public void doRemove(YxPlanTypeVO vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVO(vo, user);
        }
    }
    public DataPackage doQuery(YxPlanTypeListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
