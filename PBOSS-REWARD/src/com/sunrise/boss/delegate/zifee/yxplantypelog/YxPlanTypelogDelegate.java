/**
* auto-generated code
* Thu Oct 26 21:47:46 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplantypelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplantypelog.persistent.YxPlanTypelogVO;
import com.sunrise.boss.business.zifee.yxplantypelog.persistent.YxPlanTypelogListVO;
import com.sunrise.boss.business.zifee.yxplantypelog.control.YxPlanTypelogControlBean;
import com.sunrise.boss.business.zifee.yxplantypelog.control.YxPlanTypelogControl;

import java.io.Serializable;

/**
 * <p>Title: YxPlanTypelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanTypelogDelegate {

    private static YxPlanTypelogControl control;

    public YxPlanTypelogDelegate() throws Exception {
        control = (YxPlanTypelogControl) ControlFactory.build(YxPlanTypelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanTypelogVO doCreate(YxPlanTypelogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxPlanTypelogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxPlanTypelogVO doUpdate(YxPlanTypelogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanTypelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanTypelogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxPlanTypelogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
