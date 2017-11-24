/**
* auto-generated code
* Tue Dec 29 15:07:40 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyrwddtllog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogVO;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogListVO;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.control.ZjtyRwddtllogControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.control.ZjtyRwddtllogControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRwddtllogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyRwddtllogDelegate {

    private static ZjtyRwddtllogControl control;

    public ZjtyRwddtllogDelegate() throws Exception {
        control = (ZjtyRwddtllogControl) ControlFactory.build(ZjtyRwddtllogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyRwddtllogVO doCreate(ZjtyRwddtllogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyRwddtllogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyRwddtllogVO doUpdate(ZjtyRwddtllogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyRwddtllogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyRwddtllogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyRwddtllogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
