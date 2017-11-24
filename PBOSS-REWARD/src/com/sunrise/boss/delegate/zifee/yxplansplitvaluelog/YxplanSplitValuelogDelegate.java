/**
* auto-generated code
* Thu Oct 26 17:37:18 CST 2006
*/
package com.sunrise.boss.delegate.zifee.yxplansplitvaluelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent.YxplanSplitValuelogVO;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent.YxplanSplitValuelogListVO;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.control.YxplanSplitValuelogControlBean;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.control.YxplanSplitValuelogControl;

import java.io.Serializable;

/**
 * <p>Title: YxplanSplitValuelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxplanSplitValuelogDelegate {

    private static YxplanSplitValuelogControl control;

    public YxplanSplitValuelogDelegate() throws Exception {
        control = (YxplanSplitValuelogControl) ControlFactory.build(YxplanSplitValuelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxplanSplitValuelogVO doCreate(YxplanSplitValuelogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxplanSplitValuelogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxplanSplitValuelogVO doUpdate(YxplanSplitValuelogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxplanSplitValuelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxplanSplitValuelogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxplanSplitValuelogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
