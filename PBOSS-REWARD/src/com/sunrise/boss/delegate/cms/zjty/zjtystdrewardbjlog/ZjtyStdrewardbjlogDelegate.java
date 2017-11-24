/**
* auto-generated code
* Tue Oct 28 11:36:29 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtystdrewardbjlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.persistent.ZjtyStdrewardbjlogVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.persistent.ZjtyStdrewardbjlogListVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.control.ZjtyStdrewardbjlogControlBean;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.control.ZjtyStdrewardbjlogControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyStdrewardbjlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyStdrewardbjlogDelegate {

    private static ZjtyStdrewardbjlogControl control;

    public ZjtyStdrewardbjlogDelegate() throws Exception {
        control = (ZjtyStdrewardbjlogControl) ControlFactory.build(ZjtyStdrewardbjlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyStdrewardbjlogVO doCreate(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyStdrewardbjlogVO doUpdate(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyStdrewardbjlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyStdrewardbjlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyStdrewardbjlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
