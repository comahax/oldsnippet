/**
* auto-generated code
* Thu Oct 23 12:58:00 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyoperationlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent.ZjtyOperationlogVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent.ZjtyOperationlogListVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.control.ZjtyOperationlogControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.control.ZjtyOperationlogControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyOperationlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyOperationlogDelegate {

    private static ZjtyOperationlogControl control;

    public ZjtyOperationlogDelegate() throws Exception {
        control = (ZjtyOperationlogControl) ControlFactory.build(ZjtyOperationlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyOperationlogVO doCreate(ZjtyOperationlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyOperationlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyOperationlogVO doUpdate(ZjtyOperationlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyOperationlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyOperationlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyOperationlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
