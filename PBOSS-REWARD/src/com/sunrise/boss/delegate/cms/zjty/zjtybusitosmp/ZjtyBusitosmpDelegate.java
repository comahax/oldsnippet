/**
* auto-generated code
* Thu Dec 24 16:13:49 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.zjtybusitosmp;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpListVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.control.ZjtyBusitosmpControlBean;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.control.ZjtyBusitosmpControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyBusitosmpDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyBusitosmpDelegate {

    private static ZjtyBusitosmpControl control;

    public ZjtyBusitosmpDelegate() throws Exception {
        control = (ZjtyBusitosmpControl) ControlFactory.build(ZjtyBusitosmpControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyBusitosmpVO doCreate(ZjtyBusitosmpVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyBusitosmpVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyBusitosmpVO doUpdate(ZjtyBusitosmpVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyBusitosmpVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyBusitosmpVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyBusitosmpListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
