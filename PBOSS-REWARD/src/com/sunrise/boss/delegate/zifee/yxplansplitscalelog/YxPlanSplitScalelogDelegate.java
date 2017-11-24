/**
* auto-generated code
* Thu Oct 26 10:38:36 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplansplitscalelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent.YxPlanSplitScalelogVO;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent.YxPlanSplitScalelogListVO;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.control.YxPlanSplitScalelogControlBean;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.control.YxPlanSplitScalelogControl;

import java.io.Serializable;

/**
 * <p>Title: YxPlanSplitScalelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanSplitScalelogDelegate {

    private static YxPlanSplitScalelogControl control;

    public YxPlanSplitScalelogDelegate() throws Exception {
        control = (YxPlanSplitScalelogControl) ControlFactory.build(YxPlanSplitScalelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanSplitScalelogVO doCreate(YxPlanSplitScalelogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxPlanSplitScalelogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxPlanSplitScalelogVO doUpdate(YxPlanSplitScalelogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanSplitScalelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanSplitScalelogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxPlanSplitScalelogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
