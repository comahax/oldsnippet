/**
* auto-generated code
* Tue Jul 07 16:26:52 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyddtreward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardVO;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardListVO;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.control.ZjtyDdtrewardControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.control.ZjtyDdtrewardControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyDdtrewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDdtrewardDelegate {

    private static ZjtyDdtrewardControl control;

    public ZjtyDdtrewardDelegate() throws Exception {
        control = (ZjtyDdtrewardControl) ControlFactory.build(ZjtyDdtrewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyDdtrewardVO doCreate(ZjtyDdtrewardVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyDdtrewardVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyDdtrewardVO doUpdate(ZjtyDdtrewardVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyDdtrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyDdtrewardVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyDdtrewardListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
