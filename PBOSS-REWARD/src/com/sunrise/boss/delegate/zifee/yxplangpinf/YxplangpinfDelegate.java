/**
* auto-generated code
* Sat Jan 13 14:53:14 CST 2007
*/
package com.sunrise.boss.delegate.zifee.yxplangpinf;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfVO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfListVO;
import com.sunrise.boss.business.zifee.yxplangpinf.control.YxplangpinfControlBean;
import com.sunrise.boss.business.zifee.yxplangpinf.control.YxplangpinfControl;

import java.io.Serializable;

/**
 * <p>Title: YxplangpinfDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxplangpinfDelegate {

    private static YxplangpinfControl control;

    public YxplangpinfDelegate() throws Exception {
        control = (YxplangpinfControl) ControlFactory.build(YxplangpinfControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxplangpinfVO doCreate(YxplangpinfVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxplangpinfVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxplangpinfVO doUpdate(YxplangpinfVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxplangpinfVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxplangpinfVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxplangpinfListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
