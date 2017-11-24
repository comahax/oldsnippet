/**
* auto-generated code
* Thu Dec 24 16:14:35 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.zjtybusitosmplog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogListVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.control.ZjtyBusitosmplogControlBean;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.control.ZjtyBusitosmplogControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyBusitosmplogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyBusitosmplogDelegate {

    private static ZjtyBusitosmplogControl control;

    public ZjtyBusitosmplogDelegate() throws Exception {
        control = (ZjtyBusitosmplogControl) ControlFactory.build(ZjtyBusitosmplogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyBusitosmplogVO doCreate(ZjtyBusitosmplogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyBusitosmplogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyBusitosmplogVO doUpdate(ZjtyBusitosmplogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyBusitosmplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyBusitosmplogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyBusitosmplogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
