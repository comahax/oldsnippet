/**
* auto-generated code
* Fri Aug 25 10:34:46 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplankind;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.zifee.yxplankind.persistent.YxPlanKindVO;
import com.sunrise.boss.business.zifee.yxplankind.persistent.YxPlanKindListVO;
import com.sunrise.boss.business.zifee.yxplankind.control.YxPlanKindControl;
import com.sunrise.boss.business.zifee.yxplankind.control.YxPlanKindControlBean;
import java.io.Serializable;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: YxPlanKindDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanKindDelegate {

    private static YxPlanKindControl control;

    public YxPlanKindDelegate() throws Exception {
        control = (YxPlanKindControl) ControlFactory.build(YxPlanKindControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanKindVO doCreate(YxPlanKindVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public YxPlanKindVO doUpdate(YxPlanKindVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanKindVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanKindVO) control.doFindByPk(pk, user);
    }
    public void doRemoveByPK(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPK(pk, user);
        }
    }

    public void doRemoveByVO(YxPlanKindVO vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVO(vo, user);
        }
    }
    public DataPackage doQuery(YxPlanKindListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
