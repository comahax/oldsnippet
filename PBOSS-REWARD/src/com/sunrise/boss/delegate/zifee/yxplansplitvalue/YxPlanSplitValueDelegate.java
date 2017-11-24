/**
* auto-generated code
* Thu Aug 31 16:01:07 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplansplitvalue;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueVO;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueListVO;
import com.sunrise.boss.business.zifee.yxplansplitvalue.control.YxPlanSplitValueControl;
import com.sunrise.boss.business.zifee.yxplansplitvalue.control.YxPlanSplitValueControlBean;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

/**
 * <p>Title: YxPlanSplitValueDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class YxPlanSplitValueDelegate {

    private static YxPlanSplitValueControl control;

    public YxPlanSplitValueDelegate() throws Exception {
        control = (YxPlanSplitValueControl) ControlFactory.build(YxPlanSplitValueControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanSplitValueVO doCreate(YxPlanSplitValueVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemoveByPK(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPK(pk, user);
        }
    }

    public void doRemoveByVO(YxPlanSplitValueVO vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVO(vo, user);
        }
    }
    public YxPlanSplitValueVO doUpdate(YxPlanSplitValueVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanSplitValueVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanSplitValueVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxPlanSplitValueListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
