/**
* auto-generated code
* Mon Aug 28 09:56:50 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplansplitscale;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleVO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleListVO;
import com.sunrise.boss.business.zifee.yxplansplitscale.control.YxPlanSplitScaleControl;
import com.sunrise.boss.business.zifee.yxplansplitscale.control.YxPlanSplitScaleControlBean;
import java.io.Serializable;
import com.sunrise.boss.ui.commons.User;
/**
 * <p>Title: YxPlanSplitScaleDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class YxPlanSplitScaleDelegate {

    private static YxPlanSplitScaleControl control;

    public YxPlanSplitScaleDelegate() throws Exception {
        control = (YxPlanSplitScaleControl) ControlFactory.build(YxPlanSplitScaleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanSplitScaleVO doCreate(YxPlanSplitScaleVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public YxPlanSplitScaleVO doUpdate(YxPlanSplitScaleVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanSplitScaleVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanSplitScaleVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxPlanSplitScaleListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public void doRemoveByPK(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPK(pk, user);
        }
    }
    public void doRemoveByVO(YxPlanSplitScaleVO vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVO(vo, user);
        }
    }
}
