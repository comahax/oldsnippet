/**
* auto-generated code
* Tue Oct 28 11:33:16 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtystdrewardlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.persistent.ZjtyStdrewardlogVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.persistent.ZjtyStdrewardlogListVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.control.ZjtyStdrewardlogControlBean;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.control.ZjtyStdrewardlogControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyStdrewardlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyStdrewardlogDelegate {

    private static ZjtyStdrewardlogControl control;

    public ZjtyStdrewardlogDelegate() throws Exception {
        control = (ZjtyStdrewardlogControl) ControlFactory.build(ZjtyStdrewardlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyStdrewardlogVO doCreate(ZjtyStdrewardlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyStdrewardlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyStdrewardlogVO doUpdate(ZjtyStdrewardlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyStdrewardlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyStdrewardlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyStdrewardlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
